package com.example.function;

import com.example.apiCalorie.BmiData;
import com.example.apiCalorie.Data;
import com.example.apiCalorie.Goals;
import com.example.apiCalorie.MildWeightLoss;
import com.example.profile.Profile;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class GetCalories {
    public static com.example.apiCalorie.Data calculateDailyCaloriesRequirements(Profile profile){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://fitness-calculator.p.rapidapi.com/dailycalorie?age="+profile.getAge()+"&gender="+profile.getGender()+"&height="+profile.getHeight()+"&weight="+profile.getWeight()+"&activitylevel="+profile.getActivityLevel()))
                    .header("X-RapidAPI-Key", "b06dbe6838mshdaa20fa90b0b9d9p1855fbjsn2b3785d2ba26")
                    .header("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            CompletableFuture<HttpResponse<String>> respTmp= HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> response = respTmp.join();
            BmiData bmi = new Gson().fromJson(response.body(),BmiData.class);
            Data data = bmi.getData();
            return data;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
