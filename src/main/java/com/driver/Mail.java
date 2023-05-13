package com.driver;

import java.util.Date;

public class Mail {
    Date date;
    private String sender;
    String message;
    Mail next;

    public Mail(Date date,String sender,String message){
        this.date = date;
        this.sender = sender;
        this.message = message;
    }

}
