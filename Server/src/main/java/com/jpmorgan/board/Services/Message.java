package com.jpmorgan.board.Services;

public class Message {
    private String email;
    private String message;
    private String key;


    public Message(String email, String message, String key){
        this.email = email;
        this.message = message;
        this.key = key;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
