package com.fruitstactoe.play;

import android.app.Application;
import android.util.Log;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.push.YandexMetricaPush;


public class AppMetrica extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Creating an extended library configuration.                      //37435a5c-bb6a-441a-93d0-203574a86c68
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder("37435a5c-bb6a-441a-93d0-203574a86c68").build();
        // Initializing the AppMetrica SDK.
        YandexMetrica.activate(getApplicationContext(), config);
        Log.d("YandexMetrica", "YandexMetricaYandexMetricaYandexMetrica");
        // Automatic tracking of user activity.
        YandexMetrica.enableActivityAutoTracking(this);

        YandexMetricaPush.init(getApplicationContext());

    }
}