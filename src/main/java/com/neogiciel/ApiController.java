package com.neogiciel;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.Cache;
import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


//import com.neogiciel.service.BddManager;
import com.neogiciel.util.Trace;

import io.quarkus.cache.CacheResult;




@Path("/")
public class ApiController {

    /*
     * test
     */
   @CacheResult(cacheName = "test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/api/test")
    public String test()  throws InterruptedException  {
        Trace.info("Applel REST : /api/test");        
    
         //the current time in milliseconds
         long start = System.currentTimeMillis();
         // stop the main thread of the program for 5000 milliseconds (5 seconds)
         Thread.sleep(5000);
         
         Trace.info("The thread is paused for " + (System.currentTimeMillis() - start) + " milliseconds");

    
        return getJSON("test", "test").toString();

     }

     /*
     * liste
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/api/liste")
    public String liste() throws InterruptedException  {
        Trace.info("Applel REST : /api/liste");        

          //the current time in milliseconds
         long start = System.currentTimeMillis();
         Thread.sleep(5000);
         Trace.info("The thread is paused for " + (System.currentTimeMillis() - start) + " milliseconds");
        
            
         
        return getJSON("test","liste").toString();

     }

     /*
     * liste
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/api/map")
    public String map() {
        Trace.info("Applel REST : /api/map");        
                
        return getJSON("test","map").toString();

     }



     /*
      * getJSON
      */
     public JSONObject getJSON(String value,String key){
        JSONObject obj = new JSONObject();
        obj.put(value, key);
        return obj;
     }



}
