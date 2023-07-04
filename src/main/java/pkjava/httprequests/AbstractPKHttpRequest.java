package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.utils.RequestUtils;

import java.net.http.HttpClient;

public abstract class AbstractPKHttpRequest {
    public static final HttpClient pkClient = PKJava.getInstance().getPKJavaClient();
    public static final String userAgent = PKJava.getInstance().getUserAgent();
    
    public static HttpClient getPkClient() {
        return pkClient;
    }
    
    public static String getUserAgent() {
        return RequestUtils.userAgent;
    }
}
