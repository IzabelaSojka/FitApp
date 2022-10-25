package com.example.function;

import com.example.apiBmi.BmiData;
import com.example.apiBmi.Data;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class GetBmi {

    public static Data calculateBMI(Integer weight, Integer height){
        Data data = null;
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://fitness-calculator.p.rapidapi.com/bmi?age=25&weight="+weight+"&height="+height))
                    .header("X-RapidAPI-Key", "b06dbe6838mshdaa20fa90b0b9d9p1855fbjsn2b3785d2ba26")
                    .header("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            CompletableFuture<HttpResponse<String>> respTmp= HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> response = respTmp.join();
            BmiData bmiData = new Gson().fromJson(response.body(),BmiData.class);
            data = bmiData.getData();
            return data;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
