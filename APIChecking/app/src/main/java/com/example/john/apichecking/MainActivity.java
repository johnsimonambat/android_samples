package com.example.john.apichecking;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    EditText UserID;
    EditText password;
    Button login;
    byte[] data;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    InputStream inputStream;

    List<NameValuePair> nameValuePairs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserID = (EditText) findViewById(R.id.UserID);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_button);


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String   userID = UserID.getText().toString();
                String  Password = password.getText().toString();



                if(userID.equals("") || Password.equals(""))
                {
                    System.out.println("check");
                    Toast.makeText(getApplicationContext(), "Blank Field..Please Enter", Toast.LENGTH_SHORT).show();

                }
                else{

                    try{
                        httpclient = new DefaultHttpClient();
                        httppost = new HttpPost("http://cman.avaninfotech.com/api/cman/v1/checkLogin/");

                        // Add your data
                        nameValuePairs = new ArrayList<>(2);
                        nameValuePairs.add(new BasicNameValuePair("loginID", userID.trim()));
                        nameValuePairs.add(new BasicNameValuePair("loginPass", Password.trim()));
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                        // Execute HTTP Post Request
                        response = httpclient.execute(httppost);

                        inputStream = response.getEntity().getContent();

                        data = new byte[256];

                        buffer = new StringBuffer();
                        int len = 0;
                        while (-1 != (len = inputStream.read(data)) )
                        {
                            buffer.append(new String(data, 0, len));
                        }

                        inputStream.close();


                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "error"+e.toString(), Toast.LENGTH_LONG).show();
                    }


                    if(buffer.charAt(0)=='Y')
                    {
                        Toast.makeText(getApplicationContext(), "login successfull", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Username or password", Toast.LENGTH_LONG).show();
                    }




                }





                //tryLogin(mUsername, mPassword);

            }
        });


    }



    /*protected void tryLogin(String mUsername, String mPassword)
    {
        Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
        HttpURLConnection connection;
        OutputStreamWriter request = null;

        URL url = null;
        String response = null;
        String parameters = "username="+mUsername+"&password="+mPassword;

        try
        {
            url = new URL("http://cman.avaninfotech.com/api/cman/v1/checkLogin/");
            connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");

            request = new OutputStreamWriter(connection.getOutputStream());
            request.write(parameters);
            request.flush();
            request.close();
            String line = "";
            InputStreamReader isr = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            // Response from server after login process will be stored in response variable.
            response = sb.toString();
            // You can perform UI operations here
            Toast.makeText(this, "Message from Server: \n" + response, 0).show();
            isr.close();
            reader.close();

        }
        catch(IOException e)
        {
            // Error
        }
    }
*/









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
