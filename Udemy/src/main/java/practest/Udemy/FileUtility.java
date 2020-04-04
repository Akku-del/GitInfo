package practest.Udemy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {
public void fileCreation(String textToAppend) {
		// TODO Auto-generated method stub
	
	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(
			                            new FileWriter("C:\\Users\\Nidhi Gupta\\newfile.txt", false)  //Set true for append mode
			                        );
			 writer.newLine();   //Add new line
			    writer.write(textToAppend);
			    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	   
	}
}
