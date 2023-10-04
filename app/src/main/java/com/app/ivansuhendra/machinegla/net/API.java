package com.app.ivansuhendra.machinegla.net;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.app.ivansuhendra.machinegla.utils.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    private static final String TAG = "FAPI";
    private static final String TOKEN = "TOKEN";
    private static final String RESET_PASS = "RESET_PASS";
    private static final String OTP_SUCESS = "OTP_SUCESS";
    private static final String WARGA = "WARGA";
    private static final String CASHIER_MODEL = "CASHIER_MODEL";
    private static APIService SERVICE;
    private static boolean sessionError = false;
    private static Converter<ResponseBody, BadRequest> ERROR_CONVERTER;
    private static boolean ignoreToken = false;

    public static APIService service() {
        ignoreToken = false;
        if (SERVICE == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            String token = "";
//                            String token = Hawk.get(TOKEN, "");

                            String bearer = "Bearer ";
                            if (token.isEmpty()) {
                                bearer = "";
                            }


                            Request original = chain.request();

                            try {
                                if (ignoreToken) {
                                    Request request = original.newBuilder()
                                            .addHeader("Content-Type", "application/json")
                                            .addHeader("Accept", "application/json")
                                            .method(original.method(), original.body())
                                            .build();
                                    return chain.proceed(request);
                                } else {
                                    Request request = original.newBuilder()
                                            .addHeader("Content-Type", "application/json")
                                            .addHeader("Accept", "application/json")
                                            .addHeader("User-Timezone", "GMT+7")
                                            .addHeader("Authorization", bearer + token)
                                            .method(original.method(), original.body())
                                            .build();
                                    return chain.proceed(request);
                                }
                            } catch (Exception exception) {
                                Request request = original.newBuilder()
                                        .addHeader("Content-Type", "application/json")
                                        .addHeader("Accept", "application/json")
                                        .addHeader("User-Timezone", "GMT+7")
                                        .addHeader("Authorization", bearer + token)
                                        .method(original.method(), original.body())
                                        .build();
                                return chain.proceed(request);
                            }
                        }
                    })
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .registerTypeAdapter(Date.class, new DateDeserializer())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl("http://192.168.5.120" + "/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            ERROR_CONVERTER = retrofit.responseBodyConverter(BadRequest.class, new Annotation[0]);
            SERVICE = retrofit.create(APIService.class);
        }
        return SERVICE;
    }

    static Converter<ResponseBody, BadRequest> getErrorConverter() {
        return ERROR_CONVERTER;
    }
}