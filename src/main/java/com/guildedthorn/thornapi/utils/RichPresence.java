package com.guildedthorn.thornapi.utils;

public class RichPresence {
    
    private String state;
    private String details;
    private String b1label;
    private String b1url;
    private String b2label;
    private String b2url;
    
    public RichPresence setState(String state) {
        this.state = state;
        return this;
    }
    
    public RichPresence setDetails(String details) {
        this.details = details;
        return this;
    }
    
    public RichPresence setButton1(String label, String url) {
        this.b1label = label;
        this.b1url = url;
        return this;
    }
    
    public RichPresence setButton2(String label, String url) {
        this.b2label = label;
        this.b2url = url;
        return this;
    }
    
    public String getState() {
        return this.state;
    }
    
    public String getDetails() {
        return this.details;
    }
    
    public String getButton1Label() {
        return this.b1label;
    }
    
    public String getButton1Url() {
        return this.b1url;
    }

    public String getButton2Label() {
        return this.b2label;
    }

    public String getButton2Url() {
        return this.b2url;
    }
}
