package com.driver;

import java.util.Date;

public class MailList {
    private Mail head,tail;
    int size,currentSize;

    public MailList(int size){
        this.size = size;
        currentSize = 0;
    }
    public Mail add(Mail mail){
        if(head==null){
            head = mail;
            tail = mail;
            currentSize=1;
            return null;
        }
        Mail trash=null;
        if(size == currentSize){
            trash = head;
            head = head.next;
            trash.next=null;
            currentSize--;
        }
        tail.next = mail;
        tail = mail;
        currentSize++;
        return trash;
    }

    public Mail delete(String message){
        Mail temp = head;

        if(head==null)return null;

        if(temp.message.equals(message)){
            head = head.next;
            temp.next = null;
            currentSize--;
            return temp;
        }

        while(temp.next != null){
            if(temp.next.message.equals(message)){
                Mail trash = temp.next;
                if(tail == trash){
                    tail = temp;
                }
                temp.next = temp.next.next;
                trash.next = null;
                currentSize--;
                return trash;
            }
            temp = temp.next;
        }
        return null;
    }

    public Mail peek(){
        if(currentSize == 0)return null;
        return tail;
    }

    public Mail last(){
        if(currentSize == 0)return null;
        return head;
    }

    public int NumberOfNodes(Date d1, Date d2){
        Mail temp = head;
        int count = 0;
        while(temp != null){
            Date d = temp.date;
            if(d1.compareTo(d) <= 0 && d.compareTo(d2)<=0){
                count++;
            }
            temp = temp.next;
        }
        return count;
    }
    public void clear(){
        Mail temp = head;
        while(temp != null){
            Mail curr = temp;
            temp = temp.next;
            curr.next = null;
        }
        head = null;
        tail = null;
        currentSize = 0;
    }

}
