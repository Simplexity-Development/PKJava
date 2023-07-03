package pkjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpClient;
import java.time.Duration;

public class PKJava {
    private static PKJava instance;
    
    private PKJava() {
    }
    
    public static PKJava getInstance() {
        if (instance == null) instance = new PKJava();
        return instance;
    }
    
    private HttpClient pkJavaClient;
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setLenient()
            .create();
    
    public HttpClient getPKJavaClient() {
        return pkJavaClient;
    }
    
    public void initializePKJavaClient(){
        pkJavaClient = java.net.http.HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }
    
    public Gson getGson() {
        return gson;
    }
}
