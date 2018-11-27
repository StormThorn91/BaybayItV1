package com.milagrado.cs.baybayit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.milagrado.cs.baybayit.models.Classification;
import com.milagrado.cs.baybayit.models.Classifier;
import com.milagrado.cs.baybayit.models.TensorFlowClassifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class practice_activity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    MyCanvas myCanvas;
    RelativeLayout rlCanvas;
    TextView lblChar, lblRes;
    Button btnClear, btnNext;
    ImageView btnSound;
    MediaPlayer mp;

    private static final int PIXEL_WIDTH = 28;
    List<Classifier> mClassifiers = new ArrayList<>();

    //Views
    DrawView drawView;
    DrawModel drawModel;

    private PointF mTmpPiont = new PointF();

    private float mLastX;
    private float mLastY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_activity);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnNext = (Button) findViewById(R.id.btnSave);
        btnSound = (ImageView) findViewById(R.id.btnSound);
        lblChar = (TextView) findViewById(R.id.lblChar);
        lblRes = (TextView) findViewById(R.id.lblResult);
        drawView = (DrawView) findViewById(R.id.draw);

        btnNext.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        try {
            mp = MediaPlayer.create(practice_activity.this, R.raw.b);
        }
        catch (NullPointerException e){
            System.out.print("No mp3 files found");
        }

        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        drawModel = new DrawModel(PIXEL_WIDTH, PIXEL_WIDTH);

        drawView.setModel(drawModel);
        drawView.setOnTouchListener(this);
        loadModel();



    }

    public void Clear(View v) {
//        myCanvas = new MyCanvas(this, null);

//        rlCanvas = (RelativeLayout) findViewById(R.id.rlCanvas);
//        rlCanvas.removeAllViews();
//        rlCanvas.addView(myCanvas);
//        myCanvas.invalidate();

    }



    public void Save (View v){
//        myCanvas = new MyCanvas(this, null);
//        rlCanvas = (RelativeLayout) findViewById(R.id.rlCanvas);
//        rlCanvas.setDrawingCacheEnabled(true);
//        Bitmap bitmap = rlCanvas.getDrawingCache();
//        FileOutputStream fileOutputStream = null;
//        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmsshhmmss");
//        String date = simpleDateFormat.format(new Date());
//        String name = "Img"+date+".jpg";
//        String file_name = file.getAbsolutePath()+"/"+name;
//        File new_file = new File(file_name);
//
//        try{
//            fileOutputStream = new FileOutputStream(new_file);
//            Bitmap bitmap2 = viewToBitmap(rlCanvas, bitmap.getWidth(), bitmap.getHeight());
//            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
//            Toast.makeText(this, "File Save Successful", Toast.LENGTH_LONG).show();
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    public Bitmap viewToBitmap (View view, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    @Override
    //OnResume() is called when the user resumes his Activity which he left a while ago,
    // //say he presses home button and then comes back to app, onResume() is called.
    protected void onResume() {
        drawView.onResume();
        super.onResume();
    }

    @Override
    //OnPause() is called when the user receives an event like a call or a text message,
    // //when onPause() is called the Activity may be partially or completely hidden.
    protected void onPause() {
        drawView.onPause();
        super.onPause();
    }

    private void loadModel(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mClassifiers.add(
                            TensorFlowClassifier.create(getAssets(), "Keras", "baymodel.pb", "labels.txt", PIXEL_WIDTH, "input_1", "dense_1/Softmax", true));
                } catch (IOException e) {
                    throw new RuntimeException("Error initializing models");
                }

            }
        }).start();
    }

    @Override
    public void onClick(View view) {
        //when the user clicks something
        if (view.getId() == R.id.btnClear) {
            //if its the clear button
            //clear the drawing
            drawModel.clear();
            drawView.reset();
            drawView.invalidate();
            //empty the text view
            lblChar.setText("");
        } else if (view.getId() == R.id.btnSave) {
            //if the user clicks the classify button
            //get the pixel data and store it in an array
            float pixels[] = drawView.getPixelData();

            //init an empty string to fill with the classification output
            String text = "";
            //for each classifier in our array
            for (Classifier classifier : mClassifiers) {
                //perform classification on the image
                final Classification res = classifier.recognize(pixels);
                //if it can't classify, output a question mark
                if (res.getLabel() == null) {
                    text += classifier.name() + ": ?\n";
                } else {
                    //else output its name
                    text += String.format("%s, %f\n", res.getLabel(),
                            res.getConf());
                }
            }
            lblRes.setText(text);
            System.out.print(lblRes.getText().toString());
        }
    }

    @Override
    //this method detects which direction a user is moving
    //their finger and draws a line accordingly in that
    //direction
    public boolean onTouch(View v, MotionEvent event) {
        //get the action and store it as an int
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        //actions have predefined ints, lets match
        //to detect, if the user has touched, which direction the users finger is
        //moving, and if they've stopped moving

        //if touched
        if (action == MotionEvent.ACTION_DOWN) {
            //begin drawing line
            processTouchDown(event);
            return true;
            //draw line in every direction the user moves
        } else if (action == MotionEvent.ACTION_MOVE) {
            processTouchMove(event);
            return true;
            //if finger is lifted, stop drawing
        } else if (action == MotionEvent.ACTION_UP) {
            processTouchUp();
            return true;
        }
        return false;
    }

    //draw line down

    private void processTouchDown(MotionEvent event) {
        //calculate the x, y coordinates where the user has touched
        mLastX = event.getX();
        mLastY = event.getY();
        //user them to calcualte the position
        drawView.calcPos(mLastX, mLastY, mTmpPiont);
        //store them in memory to draw a line between the
        //difference in positions
        float lastConvX = mTmpPiont.x;
        float lastConvY = mTmpPiont.y;
        //and begin the line drawing
        drawModel.startLine(lastConvX, lastConvY);
    }

    //the main drawing function
    //it actually stores all the drawing positions
    //into the drawmodel object
    //we actually render the drawing from that object
    //in the drawrenderer class
    private void processTouchMove(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        drawView.calcPos(x, y, mTmpPiont);
        float newConvX = mTmpPiont.x;
        float newConvY = mTmpPiont.y;
        drawModel.addLineElem(newConvX, newConvY);

        mLastX = x;
        mLastY = y;
        drawView.invalidate();
    }

    private void processTouchUp() {
        drawModel.endLine();
    }
}
