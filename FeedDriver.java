import util.*;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

public final class FeedDriver implements ResponseCodes {
	
	private static final FeedDriver ref = new FeedDriver();
	public static String Destination, Method;	
	
	private static void setInnerData(String d, String m){
		Destination = d;
		Method = m;
	}
	
	public int getResponseCode(String destination, String method) throws IOException {
		setInnerData(destination,method);
		URL url = new URL(destination);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod(method);
		connection.connect();
		return connection.getResponseCode();
	}
	
	public String getResponse(int k){
		if(states.containsKey(k))
			return states.get(k);
		return "Wrong key!";
	}
	
	public boolean hasResponseTable(){
		return canUseIt;
	}
	
	public static FeedDriver getRef(){
		return ref;
	}
	
	private FeedDriver(){
		
	}
}
