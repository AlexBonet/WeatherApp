package com.dam.proyectodamdaw.api;
import com.dam.proyectodamdaw.Parameters;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;


public class Connector{

    private static Connector connector;
    private static Conversor conversor;
    private static CallMethods callMethodsObject;

    public static Connector getConector(){
        if(connector == null){
            connector = new Connector();
            conversor = Conversor.getConversor();
            callMethodsObject = CallMethods.getCallMethodsObject();
        }
        return connector;
    }

    public <T> List<T> getAsList(Class<T> clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.get(url);
        if(jsonResponse != null)
            return conversor.fromJsonList(jsonResponse, clazz);
        return null;
    }

    public <T> List<T> getAsListDB(Class<T> clazz, String path){
        String url = API.Routes.URL + path;
        String jsonResponse = callMethodsObject.getDB(url);
        if(jsonResponse != null)
            return conversor.fromJsonList(jsonResponse, clazz);
        return null;
    }

    public <T> T get(Class<T> clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.get(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> Result<T> getDB(Class<T> clazz, String path) {
        try {
            String url = API.Routes.URL + path;
            Response<ResponseBody> jsonResponse = callMethodsObject.getResult(url);
            if (jsonResponse != null && jsonResponse.code() == 200)
                return conversor.fromJSonToSuccess(jsonResponse.body().string(), clazz);
            else if (jsonResponse != null)

                return conversor.getError(jsonResponse.errorBody().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T post(Class<T> clazz, T data, String path){
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.post(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> Result<T> postDB(Class<T> clazz, T data, String path) {
        try {
            String url = API.Routes.URL + path;
            String jsonObject = conversor.toJson(data);
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
            Response<ResponseBody> jsonResponse = callMethodsObject.postResult(url, body);

            if (jsonResponse != null && jsonResponse.code() == 200)
                return conversor.fromJSonToSuccess(jsonResponse.body().string(), clazz);
            else if (jsonResponse != null)
                return conversor.getError(jsonResponse.errorBody().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T put(Class<T> clazz, T data, String path){
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.put(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> T delete(Class<T> clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.delete(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

}

