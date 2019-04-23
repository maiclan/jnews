import util.*;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

public final class FeedDriver implements ResponseCodes {
	
	private static final FeedDriver ref = new FeedDriver();
	private static String iDestination, iMethod; // ----------- just informational variables
	
	private static void setInnerData(String d, String m){
		iDestination = d;
		iMethod = m;
	}
	
	public static String getInfo(){
		return iDestination + " by " + iMethod;
	}
	
	public static int getResponseCode(String destination, String method) throws IOException {
		setInnerData(destination,method);
		URL url = new URL(destination);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod(method);
		connection.connect();
		return connection.getResponseCode();
	}
	
	public static String getResponse(int k){
		if(states.containsKey(k))
			return states.get(k);
		return "Wrong key!";
	}
	
	public static boolean hasResponseTable(){
		return canUseIt;
	}
	
	public static FeedDriver getRef(){
		return ref;
	}
	
	private FeedDriver(){
		
	}
}
