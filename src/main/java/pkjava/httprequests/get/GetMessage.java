package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.messages.MessageInfo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@SuppressWarnings("unused") //Library, this is being used externally
public class GetMessage extends AbstractPKHttpRequest {
    
    public static MessageInfo requestMessageInfo(String messageID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + messages + "/"
                        + messageID))
                .GET()
                .header(userAgentHeader, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return PKJava.getInstance().getGson().fromJson(responseBody, MessageInfo.class);
    }
    
}
