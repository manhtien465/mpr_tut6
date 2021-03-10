package com.example.tut6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static  final String P_lang="lang";
    private  SharedPreferences sharedPreferences;
    private TextView lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          TextView lang=findViewById(R.id.lang);
         sharedPreferences=getSharedPreferences( getPackageName(), Context.MODE_PRIVATE);
     String language =  sharedPreferences.getString(P_lang,null);

        if(language!=null){

            lang.setText(language);
        }else{
                selectLanguage();
        }
    }
    public  void selectLanguage(){
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_btn_speak_now)
                .setTitle("choose a language")
                .setMessage("Which language do you like")
                        .setPositiveButton("VIET NAME ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setLanguage("VIETNAMESES");
                            }
                        })
                        .setNegativeButton("ENGLISH", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setLanguage("ENGLISH");
                            }
                        })
                        .show();

    }
    public void setLanguage(String language){
      sharedPreferences.edit().putString(P_lang,language).apply();
      lang.setText(language);
}


}