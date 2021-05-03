package com.pagination.webservice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.widget.TextView;


public class NetworkHelper {

    public static boolean isConnected(Context context) {
        boolean NetworkState = false;

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                if (networkInfo.isRoaming()) {
                    // Roaming
                }
                int netType = networkInfo.getType();
                if (netType == ConnectivityManager.TYPE_WIFI) {
                    NetworkState = networkInfo.isConnected();
                } else if (netType == ConnectivityManager.TYPE_MOBILE) {
                    NetworkState = networkInfo.isConnected();
                } else {
                    NetworkState = false;
                }
            } else {
                NetworkState = false;
            }
        } catch (Exception e) {
            NetworkState = true;
        }
        return NetworkState;
    }

}
