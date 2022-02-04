package android.com.jumpco.io.superheroapi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utilities {



    //check internet connection for both MOBILE and WIFI
    public static boolean checkInternetConnectivity(Context context){
        boolean haveConnectionWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm =((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();

        for (NetworkInfo in : networkInfos){
            if(in.getTypeName().equalsIgnoreCase("WIFI"))
                if(in.isConnected())
                    haveConnectionWifi = true;
            if(in.getTypeName().equalsIgnoreCase("MOBILE"))
                if(in.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectionWifi || haveConnectedMobile;
    }
}
