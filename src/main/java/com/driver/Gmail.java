package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    private MailList inbox;

    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private MailList trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        inbox = new MailList(inboxCapacity);
        trash = new MailList(inboxCapacity);
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Mail mail = new Mail(date,sender,message);

        Mail trashMail = inbox.add(mail);
        if(trashMail != null){
            trash.add(trashMail);
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        Mail trashMail = inbox.delete(message);
        if(trashMail != null){
            trash.add(trashMail);
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        Mail mail = inbox.peek();
        return mail == null ? null : mail.message;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        Mail mail = inbox.last();
        return mail == null ? null : mail.message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        return inbox.NumberOfNodes(start, end);
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.currentSize;
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.currentSize;
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inbox.size;
    }
}
