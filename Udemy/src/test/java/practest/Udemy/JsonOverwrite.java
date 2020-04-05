package practest.Udemy;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonOverwrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JSONObject js=new JSONObject();
		js.put("firstname", "akku");
		js.put("lastname", "agarwal");
		js.put("age", 31);
		Map<String,String> imap= new LinkedHashMap<String,String>();
		imap.put("Street Address", "Baker's Street");
		imap.put("State", "Maharashtra");
		imap.put("City", "Navi Mumbai");
		imap.put("Postal Code", "110023");
		js.put("address", imap);
		LinkedHashMap<String, String> pmap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> lmap = new LinkedHashMap<String, String>(); 
		JSONArray ja = new JSONArray();
		lmap.put("type", "home");
		lmap.put("number", "1234567189");
		ja.add(lmap);
		
		pmap.put("type", "fax");
		pmap.put("number", "456789123");
		ja.add(pmap);
	
		js.put("phone", ja);
		PrintWriter pw;
		try {
			pw = new PrintWriter("C:\\Users\\Nidhi Gupta\\git\\flash\\Udemy\\resources\\JSONExample.json");
			 pw.write(js.toJSONString()); 
	          
		        pw.flush(); 
		        pw.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		} 
       
		
		
	}

}
