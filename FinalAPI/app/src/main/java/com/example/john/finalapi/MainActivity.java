package com.example.john.finalapi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText UserID;
    EditText password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserID = (EditText) findViewById(R.id.UserID);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_button);





        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                ArrayList<NameValuePair> postParameters = new ArrayList<>();

               /* ArrayList<NameValuePair> postParameters = new ArrayList<>(); */
                 postParameters.add(new BasicNameValuePair("loginID", UserID
                        .getText().toString()));
                postParameters.add(new BasicNameValuePair("loginPass", password
                        .getText().toString()));

                String response = null;
                try{

                    response = CustomHttpClient
                            .executeHttpPost(
                                    "http://cman.avaninfotech.com/api/cman/v1/checkLogin/",
                                    postParameters);
// now in result you will have the response from php file either 0 or 1.
                    String result = response.toString();
                    // res = res.trim();
                    result = result.replaceAll("\\s+", "");
                    // error.setText(res);

                    if (!result.equals("0")) {

                        // Intent in = new Intent(Login.this, MainScreen.class);

                        // LoadPreferences();
                        Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_SHORT).show();
                        //error.setText("");

                        // startActivity(in);
                    }

                    else
                        // error.setText("Incorrect Username or Password");
                        Toast.makeText(getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){

                }







            }
        });












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
