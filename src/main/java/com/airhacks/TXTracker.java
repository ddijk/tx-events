package com.airhacks;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
public class TXTracker {

    @Inject
    Event<String> stringEvent;

    @Resource
    SessionContext sc;

    public void success(){
        stringEvent.fire("[Event] succcess");
    }

    public void failure(){
        stringEvent.fire("[Event] rollback");
        sc.setRollbackOnly();
    }
}