package com.guildedthorn.thornapi;

public final class ThornAPI {
    
    public static String ENDPOINT_URL = "https://api.guildedthorn.com/";
    
    private final String token;
    
    public ThornAPI(String token) {
        this.token = token;
    }
    
    public String getBearerToken() {
        return this.token;
    }
}