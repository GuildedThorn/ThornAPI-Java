package com.guildedthorn.thornapi.responses;

import com.guildedthorn.thornapi.ThornAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Response {
    
    private final int code;
    
    private String response;
    
    public Response(ThornAPI api, InputStream inputStream, int code) {
        this.code = code;
        
        if (inputStream == null) {
            this.response = "";
            return;
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream)
        );
        this.read(reader);
    }
    
    
    private void read(BufferedReader reader) {
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {e.printStackTrace();}
        this.response = builder.toString();
    }
    
    public String getResponse() {
        return this.response;
    }
    
    public int getResponseCode() {
        return this.code;
    }
}
