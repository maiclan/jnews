public class News {
	private String header = null;
	private String body = null;
	private String footer = null;
	
	public void setHeader(String str) { header = str; }
	public void setBody(String str) { header = str; }
	public void setFooter(String str) { header = str; }
	
	public String getHeader() { return header; }
	public String getBody() { return body; }
	public String getFooter() { return footer; }	
	
	public void News(){
			this.setHeader("");
			this.setBody("");
			this.setFooter("");
	}	
}
