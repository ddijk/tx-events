package com.airhacks;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalTime;

@Path("tx")
public class TxResource {

    @Inject
    TXTracker txTracker;

    @GET
    @Path("ok")
    public String success() {
        txTracker.success();
        return "OK @ "+ LocalTime.now();
    }

    @GET
    @Path("nok")
    public String nok() {
        txTracker.failure();
        return "NOK @ "+ LocalTime.now();
    }
}
