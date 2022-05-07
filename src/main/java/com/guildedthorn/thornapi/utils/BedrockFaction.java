package com.guildedthorn.thornapi.utils;

public class BedrockFaction {
    
    private String id;
    private int level;
    private int xp;
    
    
    public BedrockFaction setID(String id) {
        this.id = id;
        return this;
    }
    
    public BedrockFaction setLevel(int level) {
        this.level = level;
        return this;
    }
    
    public BedrockFaction setXP(int xp) {
        this.xp = xp;
        return this;
    }
    
}
