package com.ypy.mallweb;

import com.google.gson.Gson;
import com.ypy.mallweb.bean.Response;
import org.springframework.web.client.RestTemplate;

public class App {

    private static String BASE_URL = "http://127.0.0.1:8080";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.getForObject(BASE_URL + "/get/1" ,String.class);
        Response response = new Gson().fromJson(body, Response.class);
        System.out.println(response);

    }

}
