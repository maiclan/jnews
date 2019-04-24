
public class JNews {
	
	public static void main(String[] args) {
		
		FeedDriver Feeds = FeedDriver.getRef();
		DataDriver Data = DataDriver.getRef();
		int Response = 0;
		String strResponse = "";

		try {
			
			Data.dbSetName("links.oto");
			Data.dbPull();
			Data.dbSetName("test.oto");
			Data.dbPush();


			
			//Response = Feeds.getResponseCode("http://www.google.com","GET");
			//System.out.println("Trying connect to " + Feeds.getInfo() + " method...");
			//strResponse = Feeds.getResponse(Response);
			//System.out.println("Response from URL: " + Response + " - " + strResponse);
        } catch (Throwable t) {
			System.out.println("E: " + t);
		}
		
		

	}
	
}
