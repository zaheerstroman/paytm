package com.example.myapplication.ariqtpaytmallinonesdkkamalbunakrrahulbhardwajapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

comment 
public class AppSharedpref {

    private SharedPreferences preferences, servicePreference, loginpreference, paymenturlresponse;
    private SharedPreferences sessionPreferences;
    private Context context;
    private String SCANURL = "scanurl";
    private String PASSWORD = "password";
    private String SEARCHTECT = "searchvalue";
    private String MOBILENUMBER = "mobilenumber";
    private String CATEGORIES = "categories";

    public AppSharedpref(Context context) {
        String APP_PREF_NAME = "My_Pref";
        String SELECTED_SERVICES = "SELECTEDSERVICE";
        String LOGINRESPONSE = "loginresponse";
        String PAYMENTURLRESPONSE = "paymenturlresponse";
        String sessionPref = "sessionPreference";
        int PRIVATE_MODE = 0;
        this.context = context;
        preferences = context.getSharedPreferences(APP_PREF_NAME, PRIVATE_MODE);
        servicePreference = context.getSharedPreferences(SELECTED_SERVICES, PRIVATE_MODE);
        loginpreference = context.getSharedPreferences(LOGINRESPONSE, PRIVATE_MODE);
        paymenturlresponse = context.getSharedPreferences(PAYMENTURLRESPONSE, PRIVATE_MODE);
        sessionPreferences = context.getSharedPreferences(sessionPref, PRIVATE_MODE);
    }

    //MyBillsActivity
    public List<TxnToken_OrderId> getlistofBillsprofiledataurl() {
        List<TxnToken_OrderId> servicesList = null;
        try {
            if (preferences.contains(CATEGORIES)) {
                String jsonFavorites = preferences.getString(CATEGORIES, null);
                Gson gson = new Gson();
                TxnToken_OrderId[] favoriteItems = gson.fromJson(jsonFavorites,
                        TxnToken_OrderId[].class);
                servicesList = Arrays.asList(favoriteItems);
//               servicesList = new ArrayList<>(servicesList);
            } else {
                servicesList = new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return servicesList;
    }


    //MyBillsActivity:-Zaheer
    public void setlistbilldataurl(List<TxnToken_OrderId> restaurentArrayList) {
        SharedPreferences.Editor editor;
        editor = preferences.edit();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
        Gson gson = gsonBuilder.create();
        String adjn = gson.toJson(restaurentArrayList);
//        Gson gson = new Gson();
//        String cartList = gson.toJson(productsInCartList);
        editor.putString(CATEGORIES, adjn);
        editor.apply();
        editor.commit();
    }


}
