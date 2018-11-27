package com.milagrado.cs.baybayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

public class ModuleMenuActivity extends AppCompatActivity {
    String char_key = "";
    String character = "";
    RelativeLayout rlChar1, rlChar2;
    Button btnStart, btnTest;
    TextView lblModuleName, lblModuleDesc;
    ImageView ivChar1, ivChar2, ivChar3, ivChar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_menu);

        rlChar1 = (RelativeLayout) findViewById(R.id.rlChar1);
        rlChar2 = (RelativeLayout) findViewById(R.id.rlChar2);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnTest = (Button) findViewById(R.id.btnTest);
        lblModuleName = (TextView) findViewById(R.id.lblModuleName);
        lblModuleDesc = (TextView) findViewById(R.id.lblModuleDesc);
        ivChar1 = (ImageView) findViewById(R.id.ivChar1);
        ivChar2 = (ImageView) findViewById(R.id.ivChar2);
        ivChar3 = (ImageView) findViewById(R.id.ivChar3);
        ivChar4 = (ImageView) findViewById(R.id.ivChar4);

        //Getting character_key value from menu
        character = getIntent().getStringExtra("char_key");

        //Setting Labels and Character Line Up Images
        if(character.equals("1")){
            lblModuleName.setText("Module 1");
            lblModuleDesc.setText("Ang mga Patinig");
            rlChar1.setVisibility(View.VISIBLE);
            rlChar2.setVisibility(View.GONE);
        }

        else if(character.equals("2")){
            lblModuleName.setText("Module 2");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.ba);
            ivChar2.setImageResource(R.drawable.be);
            ivChar3.setImageResource(R.drawable.bo);
            ivChar4.setImageResource(R.drawable.b);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("3")){
            lblModuleName.setText("Module 3");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.da);
            ivChar2.setImageResource(R.drawable.de);
            ivChar3.setImageResource(R.drawable.doy);
            ivChar4.setImageResource(R.drawable.d);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("4")){
            lblModuleName.setText("Module 4");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.ga);
            ivChar2.setImageResource(R.drawable.ge);
            ivChar3.setImageResource(R.drawable.go);
            ivChar4.setImageResource(R.drawable.g);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("5")){
            lblModuleName.setText("Module 5");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.ha);
            ivChar2.setImageResource(R.drawable.he);
            ivChar3.setImageResource(R.drawable.ho);
            ivChar4.setImageResource(R.drawable.h);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("6")){
            lblModuleName.setText("Module 6");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.ka);
            ivChar2.setImageResource(R.drawable.ke);
            ivChar3.setImageResource(R.drawable.ko);
            ivChar4.setImageResource(R.drawable.k);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);

        }

        else if(character.equals("7")){
            lblModuleName.setText("Module 7");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.la);
            ivChar2.setImageResource(R.drawable.le);
            ivChar3.setImageResource(R.drawable.lo);
            ivChar4.setImageResource(R.drawable.l);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("8")){
            lblModuleName.setText("Module 8");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.ma);
            ivChar2.setImageResource(R.drawable.me);
            ivChar3.setImageResource(R.drawable.mo);
            ivChar4.setImageResource(R.drawable.m);
        }

        else if(character.equals("9")){
            lblModuleName.setText("Module 9");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.na);
            ivChar2.setImageResource(R.drawable.ne);
            ivChar3.setImageResource(R.drawable.no);
            ivChar4.setImageResource(R.drawable.n);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("10")){
            lblModuleName.setText("Module 10");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.nga);
            ivChar2.setImageResource(R.drawable.nge);
            ivChar3.setImageResource(R.drawable.ngo);
            ivChar4.setImageResource(R.drawable.ng);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("11")){
            lblModuleName.setText("Module 11");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.pa);
            ivChar2.setImageResource(R.drawable.pe);
            ivChar3.setImageResource(R.drawable.po);
            ivChar4.setImageResource(R.drawable.p);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("12")){
            lblModuleName.setText("Module 12");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.sa);
            ivChar2.setImageResource(R.drawable.se);
            ivChar3.setImageResource(R.drawable.so);
            ivChar4.setImageResource(R.drawable.s);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("13")){
            lblModuleName.setText("Module 13");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.ta);
            ivChar2.setImageResource(R.drawable.te);
            ivChar3.setImageResource(R.drawable.to);
            ivChar4.setImageResource(R.drawable.t);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("14")){
            lblModuleName.setText("Module 14");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.wa);
            ivChar2.setImageResource(R.drawable.we);
            ivChar3.setImageResource(R.drawable.wo);
            ivChar4.setImageResource(R.drawable.w);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        else if(character.equals("15")){
            lblModuleName.setText("Module 15");
            lblModuleDesc.setText("");
            ivChar1.setImageResource(R.drawable.ya);
            ivChar2.setImageResource(R.drawable.ye);
            ivChar3.setImageResource(R.drawable.yo);
            ivChar4.setImageResource(R.drawable.y);
            rlChar1.setVisibility(View.GONE);
            rlChar2.setVisibility(View.VISIBLE);
        }

        //Onclick Listeners
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char_key = "1";
                startActivity(new Intent(ModuleMenuActivity.this, practice_activity.class));
            }
        });
    }
}
