<h1>Application Quarkus Cache Apache Camel</h1>
<img src="https://github.com/neogiciel/quarkus-cache-cafeine/assets/123723616/c56eb91d-dfb8-49a1-98b8-0da983bb9476" height=160px>
<p>
Mise en place d'un cache Apache Camel
</p>
<h2>Mise en place</h2><br>
Ajout des dépendences<br>
<h2>Pom.xml</h2><br>
<p>
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-cache</artifactId>
</dependency>
<h2>application.properties</h2><br>
#Configuration Apache Camel<br>
quarkus.cache.caffeine.initial-capacity=10<br>
quarkus.cache.caffeine.maximum-size=20<br>
quarkus.cache.caffeine.expire-after-write=60S<br>
quarkus.cache.caffeine.maximum-size=1000<br>
</p>
<h2>Controller ApiController.java</h2><br>
<p>
@Path("/api")
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

 
}
<p>

<h1>Compilation et Lancement</h1>
<p>
Clear: <b>mvn clean</b><br>
Mise à jour des dependences: <b>mvn dependency:resolve</b><br>
Compilation et Lancement: <b>mvn quarkus:dev</b><br>
Url du service: http://localhost:8080<br>  
</p>
