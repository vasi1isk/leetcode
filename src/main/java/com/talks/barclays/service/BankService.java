package com.talks.barclays.service;

@Service
public class BankService {

    public BankJPA bankJPA;
    
    public void saveMessage(final Message msg){
        if (msg.message.length == 0) 
            return;
        return bankJPA.save())
    }
}
