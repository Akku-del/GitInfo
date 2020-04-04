package resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 	
		String textToAppend = "Happy Learning !!";
	     
	    BufferedWriter writer = new BufferedWriter(
	                                new FileWriter("C:\\Users\\Nidhi Gupta\\newfile.txt", false)  //Set true for append mode
	                            );  
	    writer.newLine();   //Add new line
	    writer.write(textToAppend);
	    writer.close();
	}
}
