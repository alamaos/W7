package com.example.w7;

import androidx.appcompat.app.AppCompatActivity;

import java.io.*;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Context context = null;

    EditText tiedosto;
    EditText syote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        System.out.println("Tiedoston sijainti: " + context.getFilesDir());
        tiedosto = findViewById(R.id.tiedosto);
        syote = findViewById(R.id.syote);
    }
    public void FileRead(View v){
        try {
            InputStream is = openFileInput(String.valueOf(tiedosto.getText()));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String a = "";
            String data = "";
            while ((a = br.readLine()) != null) {
                data = data + a;
            }
            syote.setText(data);
            is.close();
        } catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        } finally {
            System.out.println("Luettu");
        }
    }
    public void FileWrite(View v){
        try {
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(String.valueOf(tiedosto.getText()), Context.MODE_PRIVATE));
            String abc = "";
            abc = String.valueOf(syote.getText());
            osw.write(abc);
            osw.close();
        }catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        }finally {
            System.out.println("Kirjoitettu");
        }
    }

}