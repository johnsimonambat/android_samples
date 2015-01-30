package com.example.john.cman_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by john on 15/1/15.
 */
public class Home_screen extends Activity {
    Button post_ticket_Button;
    Button view_ticket_button;
    Button account_manage_button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        post_ticket_Button = (Button) findViewById(R.id.post_ticket_button);
        view_ticket_button = (Button) findViewById(R.id.view_ticket_button);
        post_ticket_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Home_screen.this,
                        Post_tickets.class);
                startActivity(myIntent);

            }
        });


        view_ticket_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Home_screen.this,
                        View_tickets.class);
                startActivity(myIntent);

            }
        });

    }
}
