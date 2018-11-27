package com.milagrado.cs.baybayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class menuScreen extends AppCompatActivity {
    String character_key = "";
    Toolbar toolbar;
    CardView cardA, cardBa, cardDa, cardGa, cardHa, cardKa, cardLa, cardMa, cardNa, cardNga, cardPa, cardSa, cardTa, cardWa, cardYa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        cardA = (CardView) findViewById(R.id.cardA);
        cardBa = (CardView) findViewById(R.id.cardBa);
        cardDa = (CardView) findViewById(R.id.cardDa);
        cardGa = (CardView) findViewById(R.id.cardGa);
        cardHa = (CardView) findViewById(R.id.cardHa);
        cardKa = (CardView) findViewById(R.id.cardKa);
        cardLa = (CardView) findViewById(R.id.cardLa);
        cardMa = (CardView) findViewById(R.id.cardMa);
        cardNa = (CardView) findViewById(R.id.cardNa);
        cardNga = (CardView) findViewById(R.id.cardNga);
        cardPa = (CardView) findViewById(R.id.cardPa);
        cardSa = (CardView) findViewById(R.id.cardSa);
        cardTa = (CardView) findViewById(R.id.cardTa);
        cardWa = (CardView) findViewById(R.id.cardWa);
        cardYa = (CardView) findViewById(R.id.cardYa);

        cardA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "1";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "2";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardDa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "3";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardGa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "4";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardHa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "5";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardKa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "6";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "7";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "8";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "9";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardNga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "10";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "11";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "12";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardTa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "13";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "14";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

        cardYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character_key = "15";
                Intent i = new Intent(menuScreen.this, ModuleMenuActivity.class);
                i.putExtra("char_key", character_key);
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenus, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if(id ==  R.id.mnuHist){
            startActivity(new Intent(menuScreen.this, practice_activity.class));

        }
        return  super.onOptionsItemSelected(menuItem);
    }

}
