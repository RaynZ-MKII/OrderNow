package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordernow.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class FinalActivity extends AppCompatActivity {

    public TextView txt_realizado, txt_pedido, txt_cod, txt_cod2, txt_cod3, txt_cod4, txt_cod5, txt_cod6;
           ImageView fundo_final, waiter_fundo, logo_final;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorRegistro));


        txt_realizado = findViewById(R.id.txt_realizado);
        txt_pedido = findViewById(R.id.txt_pedido);
        fundo_final = findViewById(R.id.fundo_final);
        waiter_fundo = findViewById(R.id.waiter_fundo);
        logo_final = findViewById(R.id.logo_final);
        // txt_cod = findViewById(R.id.txt_cod);
        //txt_cod2 = findViewById(R.id.txt_cod2);
       // txt_cod3 = findViewById(R.id.txt_cod3);
        //txt_cod4 = findViewById(R.id.txt_cod4);
        //txt_cod5 = findViewById(R.id.txt_cod5);
       // txt_cod6 = findViewById(R.id.txt_cod6);

        Random rand = new Random();
        int number = rand.nextInt(6)+1;
        int number2 = rand.nextInt(2)+3;
        int number3 = rand.nextInt(8)+6;
        int number4 = rand.nextInt(10)+1;
        int number5 = rand.nextInt(3)+8;
        int number6 = rand.nextInt(2)+1;

        TextView mytext = (TextView)findViewById(R.id.txt_cod);
        String myString = String.valueOf(number);
        mytext.setText(myString);
        TextView mytext2 = (TextView)findViewById(R.id.txt_cod2);
        String myString2 = String.valueOf(number2);
        mytext2.setText(myString2);
        TextView mytext3 = (TextView)findViewById(R.id.txt_cod3);
        String myString3 = String.valueOf(number3);
        mytext3.setText(myString3);
        TextView mytext4 = (TextView)findViewById(R.id.txt_cod4);
        String myString4 = String.valueOf(number4);
        mytext4.setText(myString4);
        TextView mytext5 = (TextView)findViewById(R.id.txt_cod5);
        String myString5 = String.valueOf(number5);
        mytext5.setText(myString5);
        TextView mytext6 = (TextView)findViewById(R.id.txt_cod6);
        String myString6 = String.valueOf(number6);
        mytext6.setText(myString6);


    }



}
