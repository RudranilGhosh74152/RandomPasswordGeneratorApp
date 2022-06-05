package com.example.android.passwordgenerator;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int passwordLength=4;

    public void add(View view){
        if(passwordLength<8){
            passwordLength+=2;
            display(passwordLength);
        }
        else return;
    }

    public void minus(View view){
        if(passwordLength>4){
            passwordLength-=2;
            display(passwordLength);
        }
        else return;
    }

    private void display(int number) {
        TextView length = (TextView) findViewById(R.id.lengthOutput);
        length.setText("" + number);
    }


    public void passwordGenerate(View view){
        get_password(passwordLength);
    }


    // This our Password generating method

    private void get_password(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder password = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            password.append(chars.charAt(rnd.nextInt(chars.length())));
        TextView passwordTextView = (TextView) findViewById(R.id.password_here);
        passwordTextView.setText(password);
    }


}