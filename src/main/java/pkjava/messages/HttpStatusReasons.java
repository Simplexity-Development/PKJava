package pkjava.messages;

// Modified from https://stackoverflow.com/a/68074951
import java.util.HashMap;
import java.util.Map;

public class HttpStatusReasons {

    private static final String UNKNOWN_STATUS = "Unknown Status";

    private static final Map<Integer, String> REASONS = new HashMap<>();

    public static String getReasonForStatus(int status) {
        if (REASONS.size() == 0) populateEntries();
        return REASONS.getOrDefault(status, UNKNOWN_STATUS);
    }

    public static void populateEntries() {
        // informational
        REASONS.put(100, "Continue");
        REASONS.put(101, "Switching Protocol");
        REASONS.put(102, "Processing");
        REASONS.put(103, "Early Hints");

        // successful
        REASONS.put(200, "OK");
        REASONS.put(201, "Created");
        REASONS.put(202, "Accepted");
        REASONS.put(203, "Non-Authoritative Information");
        REASONS.put(204, "No Content");
        REASONS.put(205, "Reset Content");
        REASONS.put(206, "Partial Content");
        REASONS.put(207, "Multi Status");
        REASONS.put(208, "Already Reported");
        REASONS.put(226, "IM Used");

        // redirection
        REASONS.put(300, "Multiple Choice");
        REASONS.put(301, "Moved Permanently");
        REASONS.put(302, "Found");
        REASONS.put(303, "See Other");
        REASONS.put(304, "Not Modified");
        REASONS.put(305, "Use Proxy"); // deprecated
        REASONS.put(307, "Temporary Redirect");
        REASONS.put(308, "Permanent Redirect");

        // client error
        REASONS.put(400, "Bad Request");
        REASONS.put(401, "Unauthorized");
        REASONS.put(402, "Payment Required");
        REASONS.put(403, "Forbidden");
        REASONS.put(404, "Not Found");
        REASONS.put(405, "Method Not Allowed");
        REASONS.put(406, "Not Acceptable");
        REASONS.put(407, "Proxy Authentication Required");
        REASONS.put(408, "Request Timeout");
        REASONS.put(409, "Conflict");
        REASONS.put(410, "Gone");
        REASONS.put(411, "Length Required");
        REASONS.put(412, "Precondition Failed");
        REASONS.put(413, "Payload Too Long");
        REASONS.put(414, "URI Too Long");
        REASONS.put(415, "Unsupported Media Type");
        REASONS.put(416, "Range Not Satisfiable");
        REASONS.put(417, "Expectation Failed");
        REASONS.put(418, "I'm a Teapot");
        REASONS.put(421, "Misdirected Request");
        REASONS.put(422, "Unprocessable Entity");
        REASONS.put(423, "Locked");
        REASONS.put(424, "Failed Dependency");
        REASONS.put(425, "Too Early");
        REASONS.put(426, "Upgrade Required");
        REASONS.put(428, "Precondition Required");
        REASONS.put(429, "Too Many Requests");
        REASONS.put(431, "Request Header Fields Too Large");
        REASONS.put(451, "Unavailable for Legal Reasons");

        // server error
        REASONS.put(500, "Internal Server Error");
        REASONS.put(501, "Not Implemented");
        REASONS.put(502, "Bad Gateway");
        REASONS.put(503, "Service Unavailable");
        REASONS.put(504, "Gateway Timeout");
        REASONS.put(505, "HTTP Version Not Supported");
        REASONS.put(506, "Variant Also Negotiates");
        REASONS.put(507, "Insufficient Storage");
        REASONS.put(508, "Loop Detected");
        REASONS.put(510, "Not Extended");
        REASONS.put(511, "Network Authentication Required");
    }
}