import java.util.*;
public class JNews {
	
	public static void main(String[] args) {
		
		Hashtable<Integer, String> 					htLinks = new Hashtable<Integer, String>();					//[ID][hostname]
		Hashtable<String, ArrayList<String>> 		htSources = new Hashtable<String, ArrayList<String>>();		//[hostname][list:<source url>] 
		Hashtable<String, ArrayList<String>>		htContent = new Hashtable<String, ArrayList<String>>();		//[source url][list:<raw html/xml>] 
		
		FeedDriver Feeds = FeedDriver.getRef();
		DataDriver Data = DataDriver.getRef();
		//int Response = 0;
		//String strResponse = "";

		try {
			
			Data.dbSetName("hostname.oto");
			htLinks = Data.dbPull();
			Data.dbSetName("sources.otm");
			htSources = Data.dbPull();
			
			System.out.println("htLinks:" + htLinks);
			System.out.println("htSources:" + htSources);
			System.out.println("htContent:" + htContent);
			//Response = Feeds.getResponseCode("http://www.google.com","GET");
			//System.out.println("Trying connect to " + Feeds.getInfo() + " method...");
			//strResponse = Feeds.getResponse(Response);
			//System.out.println("Response from URL: " + Response + " - " + strResponse);
        } catch (Throwable e) {
			System.out.println("E: " + e);
		}
		
		

	}
	
}
