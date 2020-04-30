package com.airhacks;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

public class TXStatusListener {

    public void onInProgress(@Observes String msg){
        System.out.println("In progress: " + msg);
    }

    public void onSuccess(@Observes(during= TransactionPhase.AFTER_SUCCESS) String msg){
        System.out.println("After success: " + msg);
    }

    public void onFailure(@Observes(during= TransactionPhase.AFTER_FAILURE) String msg){
        System.out.println("After failure: " + msg);
    }

}