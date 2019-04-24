/*
	DataBase type - standart filesystem.
	* I want use filename like a SQL table_name and filecontent like a HashTable
	* Because i think this project not need SQL data engine for normal working
	* But i think use minimal RAM size for dynamic objects 
	* if we need read 1 key-value then we read file until found key, then push value in new object
	* if we need write new key-value then we read all file in Map structure, then replace key-value, then write all file back and delete Map structure
	 
	File DataBase structure:
	* [table_name].[type]
	* * [key][~][value]
	* * [key][~][value`value`value...]
	* * [key`key`key...][~][value`value`value...]
	
	Types of files:
	* [table_name].oto - have one-to-one key-value architecture
	* [table_name].otm - have one-to-many key-value architecture
	* [table_name].mtm - have many-to-many key-value architecture
	
*/
import java.io.*;
import java.util.*;

public final class DataDriver {
	// private vars
	private static final DataDriver ref = new DataDriver();
	private static final String SLASH = "/";
	private static final File ROOT = new File("Data");
	private FileReader fr;
	private FileWriter fw;
	private static String TableName , AbsolutePath;
	
	//public vars
	public static Hashtable<String, String> Table = new Hashtable<String, String>(); 
	
	//private methods
	private DataDriver(){
		TableName = null;
		System.out.println("DataDriver construct.");
	}
	
	private void dbGetRecursiveTable(String s) {
		int matchIs = -1;
		String key = null, value = null;
		s.trim();
		if( s.indexOf('=') != -1 ) {
			matchIs = s.indexOf('=');
			key = s.substring(0,matchIs).trim();
			s=s.substring(matchIs+1,s.length());	
		}
		if( s.indexOf(',') != -1 ){
			matchIs = s.indexOf(',');
			value = s.substring(0,matchIs).trim();
			s=s.substring(matchIs+1,s.length());
			Table.put(key,value);
			dbGetRecursiveTable(s);
		}else{
			value = s;
			s = null;
			Table.put(key,value);
		}
	}
	
	//public methods
	public static DataDriver getRef(){
		return ref;
	}
	
/*	public void dbCreateTable() throws Exception {
		if( TableName != null ){
			File file = new File(ROOT , TableName);
			file.createNewFile();
		}else{
			System.out.println("Wrong DataBase name -> " + TableName);
		}
	}*/	
	
	public void dbSetName(String filename) {
		if(filename != null && 
			filename != "" && (
			filename.contains(".oto") || 
			filename.contains(".otm") ||
			filename.contains(".mtm") ) ) {
			TableName = filename;
			AbsolutePath = ROOT.getAbsolutePath() + SLASH + TableName;
		}else{
			System.out.println("Wrong DataBase name -> " + filename);
		}
	}
	
	public void dbPull() throws Exception {
		String s = "";
		fr = new FileReader(AbsolutePath);
		Scanner scan = new Scanner(fr);
		while(scan.hasNextLine()){
			s += scan.nextLine();
		}
		s = s.substring(1, s.length()-1);
		dbGetRecursiveTable(s);
		fr.close();
	}
	
	public void dbPush() throws Exception {
		fw = new FileWriter(AbsolutePath);
		String s = Table.toString();
		
		fw.write(s);
		fw.flush();
		fw.close(); 
	}
	
	public void dbSetValue(String k, String v) {
		Table.put(k,v);
	}
}

