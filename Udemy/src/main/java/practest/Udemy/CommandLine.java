package practest.Udemy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CommandLine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*List<String> commands = new ArrayList<String>();                
        commands.add("cmd.exe");
		commands.add("/c");
		commands.add("Start");
		commands.add("hello.bat");
		ProcessBuilder pb = new ProcessBuilder(commands);
		pb.directory(new File("C:\\Users\\Nidhi Gupta"));
		pb.start();*/
		
		Map<Integer,String> m= new HashMap<Integer,String>();
		m.put(1, "akku");
		m.put(2, "telus");
		m.put(3, "5162");
		System.out.println("Map Id:" + m.get(1) );
		Set<Integer> sKeySet=m.keySet();
		Set<Map.Entry<Integer, String>> set=m.entrySet();
		Iterator<Map.Entry<Integer, String>> i = set.iterator();
		while (i.hasNext())
		{
			Map.Entry<Integer, String> mapEntry= (Map.Entry)i.next();
			System.out.println("MapEntry:" + mapEntry.getValue());
		}
	}

}
