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

    //The min password length is initialised to 4
    int passwordLength=4;


    //Function for increasing the password length upon pressing + button
    public void add(View view){
        //For setting max length of password as 8
        if(passwordLength<8){
            passwordLength+=2;
            display(passwordLength);
        }
        else return; //upon exceeding max length on clicking the button doesn't perform any actions
    }

    //Function for decreasing the password length upon pressing - button
    public void minus(View view){
        //For setting min length of password as 4
        if(passwordLength>4){
            passwordLength-=2;
            display(passwordLength);
        }
        else return;//The button doesn't perform any action when the password length is already at 4
    }

    //Method to display password length to the use on lengthOutput view
    private void display(int number) {
        TextView length = (TextView) findViewById(R.id.lengthOutput);
        length.setText("" + number);
    }

    //Method called while Generate Password button is clicked
    public void passwordGenerate(View view){
        get_password(passwordLength);
    }


    // Method to generate random password
    private void get_password(int len) {
        //All allowed numbers,alphabets and symbols are specified so that this function
        // generates random passwords but according to the norms
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder password = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            password.append(chars.charAt(rnd.nextInt(chars.length())));
        TextView passwordTextView = (TextView) findViewById(R.id.password_here);
        passwordTextView.setText(password);//this tells on which view the password will be displayed
    }


}