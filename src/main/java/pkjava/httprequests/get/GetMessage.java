package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.messages.MessageInfo;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetMessage extends AbstractPKHttpRequest {
    
    public static MessageInfo requestMessageInfo(String messageID) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.messages + "/" + messageID))
                .GET()
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return PKJava.getInstance().getGson().fromJson(responseBody, MessageInfo.class);
    }
    
}
