package com.example.john.cman_api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by john on 30/1/15.
 */
public class HomePage extends Activity{

    Button post_ticket_button;
    Button view_ticket_button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        post_ticket_button = (Button)findViewById(R.id.post_ticket_button);
        post_ticket_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(HomePage.this,
                        Post_ticket.class);
                startActivity(myIntent);

            }
        });


    }


}
