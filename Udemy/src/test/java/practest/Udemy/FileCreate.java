package practest.Udemy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class FileCreate {

	@Test(groups= {"TC_02","smoke"})
	public void fileCreationMethod() throws IOException {
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
