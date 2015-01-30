package com.example.john.cman_login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
         EditText username=null;
         EditText  password=null;
         TextView attempts;
         Button login;
        int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);
        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setText(Integer.toString(counter));
        login = (Button)findViewById(R.id.button_login);


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {




                if(username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "Redirecting...",
                            Toast.LENGTH_SHORT).show();





                    //Start NewActivity.class
               Intent myIntent = new Intent(MainActivity.this,
                        Home_screen.class);
                startActivity(myIntent);



                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",
                            Toast.LENGTH_SHORT).show();
                    attempts.setBackgroundColor(Color.RED);
                    counter--;
                    attempts.setText(Integer.toString(counter));
                    if(counter==0){
                        login.setEnabled(false);
                    }

                }

            }
        });







        }

    public void login(View view){
        if(username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(), "Redirecting...",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",
                    Toast.LENGTH_SHORT).show();
            attempts.setBackgroundColor(Color.RED);
            counter--;
            attempts.setText(Integer.toString(counter));
            if(counter==0){
                login.setEnabled(false);
            }

        }

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
