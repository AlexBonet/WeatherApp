package com.dam.proyectodamdaw.api;
import com.dam.proyectodamdaw.Parameters;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;


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


    public <T> Object get(Class clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.get(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> Object post(Class clazz, T data, String path){
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.post(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> Object put(Class clazz, T data, String path){
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.put(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> Object delete(Class clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.delete(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

}

