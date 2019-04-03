public class FeedDriver {
	
	private String src = null;
	private News[] CollectionFeed;
	private int FeedCount;
	
	public void init(String url) {
		// connect to url
		// get News array to ar;
		//this.CollectionFeed = arr;
		//this.FeedCount = arr.length;
	}
	
	public News[] getCollect() {
		return CollectionFeed;
	}

	public void prAllFeed() {
		for(int i=0; i<this.FeedCount; i++){
			System.out.println("_mx " + i);
			System.out.println("Header: " + CollectionFeed[i].getHeader());
			System.out.println("Body: " + CollectionFeed[i].getBody());
			System.out.println("Footer: " + CollectionFeed[i].getFooter());
			System.out.println("");
		}
	}
	public void prNumFeed(int n) {
		System.out.println("_mx");
		System.out.println("Header: " + CollectionFeed[n].getHeader());
		System.out.println("Body: " + CollectionFeed[n].getBody());
		System.out.println("Footer: " + CollectionFeed[n].getFooter());
		System.out.println("");
	}
}

