package com.example.myapplication.ariqtpaytmallinonesdkkamalbunakrrahulbhardwajapp;

import com.android.volley.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceWrapper {

    private ServiceInterface mServiceInterface;

    public ServiceWrapper(Interceptor mInterceptorheader) {
        mServiceInterface = getRetrofit(mInterceptorheader).create(ServiceInterface.class);
    }

    public Retrofit getRetrofit(Interceptor mInterceptorheader) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = null;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(1201, TimeUnit.SECONDS);
        builder.readTimeout(901, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        mOkHttpClient = builder.build();
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://androidtutorial.blueappsoftware.com/")
//                .baseUrl("https://www.ariqt.com/")
                .baseUrl(ServiceInterface.BASE_URL)
//                .baseUrl("http://10.11.2.122/paytm-all-in-one-completecode/paytmallinone_init_transaction/paytmallinone/")
//                .baseUrl("http://10.11.2.122/paytm-all-in-one-completecode/paytmallinone_init_transaction/paytmallinone/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(mOkHttpClient)
                .build();
        return retrofit;
    }

//    public Call<Token_Res> getTokenCall(String code, String mid, String order_id, String amount) {
//        return mServiceInterface.generateTokenCall();
//    }

    public Call<TxnToken_OrderId> getTokenCall(String code, String mid, String order_id, String amount) {
        return mServiceInterface.generateTokenCall(
                convertPlainString(code), convertPlainString(mid), convertPlainString(order_id)
                , convertPlainString(amount));
    }

    // convert aa param into plain text
    public RequestBody convertPlainString(String data) {
        RequestBody plainString = RequestBody.create(MediaType.parse("text/plain"), data);
        return plainString;
    }

}
