package util;
import java.util.*; 

public interface ResponseCodes { // just for fun
	
    final Map<Integer, String> states = new HashMap<Integer, String>();
    final boolean canUseIt = ResponseCodes();
	static boolean ResponseCodes(){
		states.put(100, "Continue");
		states.put(101, "Switching Protocol");
		states.put(102, "Processing (WebDAV)");
		states.put(103, "Early Hints");
		states.put(200, "OK");
		states.put(201, "Created");
		states.put(202, "Accepted");
		states.put(203, "Non-Authoritative Information");
		states.put(204, "No Content");
		states.put(205, "Reset Content");
		states.put(206, "Partial Content");
		states.put(207, "Multi-Status (WebDAV)");
		states.put(208, "Multi-Status (WebDAV)");
		states.put(226, "IM Used (HTTP Delta encoding)");
		states.put(300, "Multiple Choice");
		states.put(301, "Moved Permanently");
		states.put(302, "Found");
		states.put(303, "See Other");
		states.put(304, "Not Modified");
		states.put(305, "Use Proxy ");
		states.put(306, "unused");
		states.put(307, "Temporary Redirect");
		states.put(308, "Permanent Redirect");
		states.put(400, "Bad Request");
		states.put(401, "Unauthorized");
		states.put(402, "Payment Required");
		states.put(403, "Forbidden");
		states.put(404, "Not Found");
		states.put(405, "Method Not Allowed");
		states.put(406, "Not Acceptable");
		states.put(407, "Proxy Authentication Required");
		states.put(408, "Request Timeout");
		states.put(409, "Conflict");
		states.put(410, "Gone");
		states.put(411, "Length Required");
		states.put(412, "Precondition Failed");
		states.put(413, "Payload Too Large");
		states.put(414, "URI Too Long");
		states.put(415, "Unsupported Media Type");
		states.put(416, "Requested Range Not Satisfiable");
		states.put(417, "Expectation Failed");
		states.put(418, "I'm a teapot");
		states.put(421, "Misdirected Request");
		states.put(422, "Unprocessable Entity (WebDAV)");
		states.put(423, "Locked (WebDAV)");
		states.put(424, "Failed Dependency (WebDAV)");
		states.put(425, "Too Early");
		states.put(426, "Upgrade Required");
		states.put(428, "Precondition Required");
		states.put(429, "Too Many Requests");
		states.put(431, "Request Header Fields Too Large");
		states.put(451, "Unavailable For Legal Reasons");
		states.put(500, "Internal Server Error");
		states.put(501, "Not Implemented");
		states.put(502, "Bad Gateway");
		states.put(503, "Service Unavailable");
		states.put(504, "Gateway Timeout");
		states.put(505, "HTTP Version Not Supported");
		states.put(506, "Variant Also Negotiates");
		states.put(507, "Insufficient Storage");
		states.put(508, "Loop Detected (WebDAV)");
		states.put(510, "Not Extended");
		states.put(511, "Network Authentication Required");
		return true;
	}
	
}
