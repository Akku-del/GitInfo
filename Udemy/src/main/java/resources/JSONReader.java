package resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class JSONReader {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception 
	{
		 JSONParser parser = new JSONParser();
		 JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\Nidhi Gupta\\git\\flash\\Udemy\\resources\\JSONExample.json"));
		 System.out.println("" + jsonObject.get("firstname").toString());
		 Map m=(Map) jsonObject.get("address");
		 Iterator i =m.entrySet().iterator();
		 while(i.hasNext())
		 {
		   Map.Entry mark= (Map.Entry) i.next(); 
		   mark.getKey().toString();
		   mark.getValue().toString();
		   System.out.println("" + mark.getKey().toString() + mark.getValue().toString());
		 }
		 JSONArray ja=(JSONArray) jsonObject.get("phone");
		 
		 Iterator iphone = ja.iterator(); 
	        while (iphone.hasNext())  
	        { 
	            i = ((Map) iphone.next()).entrySet().iterator(); 
	            while (i.hasNext()) { 
	                Map.Entry pair = (Map.Entry) i.next(); 
	                System.out.println(pair.getKey() + " :: " + pair.getValue()); 
	            } 
	        } 
	}
	
	
}
