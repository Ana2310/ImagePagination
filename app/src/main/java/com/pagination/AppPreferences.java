package com.pagination;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    public static final String PREFERENCE_KEY = "SERVICE_MANAGEMENT_@_2017";

    public static void setStringValue(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringValue(Context ctx, String key) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    public static void setIntValue(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getIntValue(Context ctx, String key) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    public static void setBooleanValue(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBooleanValue(Context ctx, String key) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public static void clearPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

}
