package com.example.john.cman_login;

/**
 * Created by john on 28/1/15.
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;

public class UserFunctions {

    private JSONParser jsonParser;


    private static String loginURL = "http://cman.avaninfotech.com/api/cman/v1/checkLogin/";


    private static String login_tag = "login";
    private static String register_tag = "register";

    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }


    public JSONObject loginUser(String UserID, String Password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("email", UserID));
        params.add(new BasicNameValuePair("password", Password));
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
        // return json
        // Log.e("JSON", json.toString());
        return json;
    }





}
