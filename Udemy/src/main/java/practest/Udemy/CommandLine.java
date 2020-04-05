package practest.Udemy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CommandLine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		List<String> commands = new ArrayList<String>();                
        commands.add("cmd.exe");
		commands.add("/c");
		commands.add("Start");
		commands.add("hello.bat");
		ProcessBuilder pb = new ProcessBuilder(commands);
		pb.directory(new File("C:\\Users\\Nidhi Gupta"));
		pb.start();

	}

}
