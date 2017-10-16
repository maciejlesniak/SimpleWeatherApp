package pl.sparkidea.simpleweatherapp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class HttpRequestHelper {

    public JsonNode getJson(URL url) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();

        if (response.code() != 200) {
            throw new IOException(String.format(Locale.ENGLISH, "http response code %d", response.code()));
        }

        if(response.body() == null) {
            throw new IOException("no body");
        }

        String dataStr = response.body().string();
        return new ObjectMapper().readTree(dataStr);
    }

    public <T> T getObject(URL url, Class<T> clazz) throws IOException {
        JsonNode jsonNode = getJson(url);
        return new ObjectMapper().convertValue(jsonNode, clazz);
    }

}
