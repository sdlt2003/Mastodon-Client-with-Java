package eus.ehu.socialnetwork.domain;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class  Utils {
    private static String id= "109897234224245358";

    static String request(String endpoint){
        String result = "";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://mastodon.social/api/v1/"+endpoint)
                .get()
                .addHeader("Authorization","Bearer" + System.getenv("TOKEN"))
                .build();
        try{
            Response response = client.newCall(request).execute();
            if (response.code() == 200){
                result = response.body().string();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public static String getAvatar(String id){
        String result = "";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://mastodon.social/api/v1/accounts/"+id)
                .get()
                .addHeader("Authorization","Bearer" + System.getenv("TOKEN"))
                .build();
        try{
            Response response = client.newCall(request).execute();
            if (response.code() == 200){
                result = response.body().string();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<?> MainProgram(String endpoint){
        String body = request(endpoint);

        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(body, JsonArray.class);
        if(endpoint.equals(statutesLink())){
            return convertStatus(gson, jsonArray);
        }
        if (endpoint.equals(followersLink()) || endpoint.equals(followingLink())){
            return convertAccount(gson, jsonArray);
        }
        return null;
    }

    private static List<Status> convertStatus(Gson gson, JsonArray jsonArray){
        Type statusList = new TypeToken<ArrayList<Status>>() {}.getType();
        List<Status> list = gson.fromJson(jsonArray.getAsJsonArray(), statusList);
        return list;
    }

    private static List<Status.Account> convertAccount(Gson gson, JsonArray jsonArray){
        Type accountList = new TypeToken<ArrayList<Status.Account>>() {}.getType();
        List<Status.Account> list = gson.fromJson(jsonArray.getAsJsonArray(), accountList);
        return list;
    }

    public static String followingLink(){
        return "accounts/" + id + "/following";

    }

    public static String followersLink(){
        return "accounts/" + id + "/followers";

    }

    public static String statutesLink(){
        return "accounts/" + id + "/statuses";
    }
}
