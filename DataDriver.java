/*
	DataBase type - standart filesystem.
	* I want use filename like a SQL table_name and filecontent like a HashTable
	* Because i think this project not need SQL data engine for normal working
	* But i think use minimal RAM size for dynamic objects 
	 
	File DataBase structure:
	* [table_name].[type]
	* * {Hashtable serialized String}
	
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
	private final String SLASH = "/";
	private final File ROOT = new File("Data");
	private FileReader fr;
	private FileWriter fw;
	private String TableName , AbsolutePath, FileContent;
	
	//public vars
	 
	
	//private methods
	private void p(String s){System.out.println(s);}
	private void p(String[] s){System.out.println("String Array["+s.length+"]:");for(String S:s) System.out.println(S);}
	private void p(Hashtable s){System.out.println(s);}
	private void p(Object s){System.out.println(s);}
	
	private DataDriver(){
		TableName = null;
		FileContent = null;
		System.out.println("DataDriver construct.");
	}
	
	private String readFileContent() throws Exception {
		String s = "";
		fr = new FileReader(AbsolutePath);
		Scanner scan = new Scanner(fr);
		
		while(scan.hasNextLine()){
			s += scan.nextLine();
		}
		
		fr.close();
		return s;
	}

	private void writeFileContent(Hashtable tbl) throws Exception {
		fw = new FileWriter(AbsolutePath);
		String s = tbl.toString();
		fw.write(s);
		fw.flush();
		fw.close(); 
	}
	
	private String[] getSplittedArrayFromString(String str, String separator){
		return str.split(separator);
	}
	
	private String getNormalString(String str){
		return str.substring(1,str.length()-1); // trimmed '{}' and '[]' symbols
	}

	private String[] getCorrectLines(String[] lines){
		for(int i=0; i<lines.length; i++){
			if(lines[i].indexOf(",") == 0){
				lines[i] = lines[i].substring(1,lines[i].length()).trim();
				
			}
			if(lines[i].indexOf("]") == -1){
				lines[i]+="]";
			}
		}
		return lines;
	}
	
	private Hashtable getTable(String STR, String TYPE) {
		String s = STR;
		s = getNormalString(s);
		Hashtable ht;
		String[] lines;
		
		switch(TYPE){
			case "oto":
				
				ht = new Hashtable<String, String>();
				
				lines = getSplittedArrayFromString(s,",");
				
				for(String S:lines){
					String[] kv = getSplittedArrayFromString(S,"=");
					ht.put( kv[0].trim() , kv[1].trim() );
				}
				
				return ht;

			case "otm":
			
				ht = new Hashtable<String, ArrayList<String>>();

				lines = getSplittedArrayFromString(s,"]");
				lines = getCorrectLines(lines);
				
				for(String line:lines){
					String key = getSplittedArrayFromString(line,"=")[0];
					String value = getSplittedArrayFromString(line,"=")[1];
					value = getNormalString(value);
					String[] values = getSplittedArrayFromString(value,",");
					
					ArrayList<String> list = new ArrayList<String>();
					for(String v:values){
						list.add(v.trim());
					}
					
					ht.put(key,list);
				}
					
				return ht;
				
			case "mtm":
				break;
			}
		return null;
	}
	






	//public methods
	public static DataDriver getRef(){
		return ref;
	}
	
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
	
	public Hashtable dbPull() throws Exception {
		FileContent = readFileContent();
		String DBTYPE = AbsolutePath.substring( AbsolutePath.length()-3 , AbsolutePath.length() );
		
		return getTable(FileContent, DBTYPE);
	}
	

	public void dbPush(Hashtable tbl) throws Exception {
		writeFileContent(tbl);
	}
	
}

