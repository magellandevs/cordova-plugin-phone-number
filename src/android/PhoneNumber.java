package com.example.phonenumber;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class PhoneNumber extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("getPhoneNumber".equals(action)) {
            Context context = this.cordova.getActivity().getApplicationContext();
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                callbackContext.error("Permission denied");
                return true;
            }

            String number = tm.getLine1Number();
            callbackContext.success(number != null ? number : "");
            return true;
        }
        return false;
    }
}
