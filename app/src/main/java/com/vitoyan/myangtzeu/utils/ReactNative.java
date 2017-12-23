package com.vitoyan.myangtzeu.utils;

import android.content.SharedPreferences;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Telephony.Carriers.PASSWORD;
import static org.apache.commons.lang3.SystemUtils.USER_NAME;

/**
 * 作者：Vito-Yan
 * 作用：发现页面
 */
public class ReactNative extends ReactContextBaseJavaModule {

    private SharedPreferences preferences;

    public ReactNative(ReactApplicationContext reactContext, SharedPreferences preferences) {
        super(reactContext);
        this.preferences = preferences;
    }

    @Override
    public String getName() {
        return "ReactNative";
    }

    @ReactMethod
    public void search(String userName, String password, Promise promise) {
        String storeUserName = preferences.getString(USER_NAME, "");
        String storePassword  = preferences.getString(PASSWORD, "");
//        if (!equalsString(userName, storeUserName)) {
//            promise.reject("0", "user name is wrong");
//            return;
//
//        }
//        if (!equalsString(password, storePassword)) {
//            promise.reject("1", "password is wrong");
//            return;
//
//        }
        List<String> list = new ArrayList<String>();
        new SpiderUtil().spiderCj(storeUserName,storePassword,list);
        WritableMap map = Arguments.createMap();
        map.putDouble("user_id", 1);
        promise.resolve(map);

    }
}
