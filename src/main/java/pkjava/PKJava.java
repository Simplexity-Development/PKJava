package pkjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpClient;
import java.time.Duration;

@SuppressWarnings("unused") /*Library, this is being used externally*/
public class PKJava {
    
    private static PKJava instance;
    
    private PKJava() {
    }
    
    public static PKJava getInstance() {
        if (instance == null) instance = new PKJava();
        return instance;
    }
    
    private HttpClient pkJavaClient;
    private String userAgent;
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setLenient()
            .create();
    
    public HttpClient getPKJavaClient() {
        return pkJavaClient;
    }
    
    public void setPkJavaClient(HttpClient httpClient) {
        pkJavaClient = httpClient;
    }
    
    public void initializeDefaultPKJavaClient() {
        HttpClient pkClient = java.net.http.HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        setPkJavaClient(pkClient);
        setUserAgent("PKJava Library - Contact at https://github.com/Simplexity-Development/PKJava/issues");
    }
    
    public Gson getGson() {
        return gson;
    }
    
    public String getUserAgent() {
        return userAgent;
    }
    
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
