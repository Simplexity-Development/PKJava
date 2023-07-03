package pkjava.httprequests;

import pkjava.PKJava;

import java.net.http.HttpClient;

public abstract class AbstractPKHttpRequest {
    private final HttpClient pkClient = PKJava.getInstance().getPKJavaClient();
    private final String userAgent = PKJava.getInstance().getUserAgent();
    
    public HttpClient getPkClient() {
        return pkClient;
    }
    
    public String getUserAgent() {
        return userAgent;
    }
}
