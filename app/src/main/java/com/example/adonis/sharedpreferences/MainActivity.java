package com.example.adonis.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPwd;
    private TextView tvDsplInf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText)findViewById(R.id.etUserName);
        etPwd = (EditText)findViewById(R.id.etPwd);
        tvDsplInf = (TextView)findViewById(R.id.tvDsplInfo);
    }

    //Saves the user login info
    public void SaveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", etUserName.getText().toString());
        editor.putString("password", etPwd.getText().toString());
        editor.apply();

        Toast.makeText(this, "Info saved!", Toast.LENGTH_SHORT).show();
    }

    //Print out saved data
    public void DisplayInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("username", "");
        String pwd = sharedPref.getString("password", "");

        StringBuilder output = new StringBuilder();
        output.append(name);
        output.append("\n");
        output.append(pwd);

        tvDsplInf.setText(output);
    }

}
