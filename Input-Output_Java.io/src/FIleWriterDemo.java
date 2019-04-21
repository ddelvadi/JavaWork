/*
 * THis program illustrates FileWriter class methods which creates a Writer class (Character Stream)
 */
import java.io.*;

public class FIleWriterDemo {
	public static void main(String args[]) {
		String source = "Since one of the main purpose of java is\n" +
						"to support the 'Write once, run anywhere' philosophy,\n" +
						"it was necessary to include direct I/O support for characters";
		//Get characters of string into array
		char buffer[] = new char[source.length()];
		source.getChars(0, source.length(), buffer, 0);
		
		try ( FileWriter f0 = new FileWriter("file1.txt");
			  FileWriter f1 = new FileWriter("file2.txt");
			  FileWriter f2 = new FileWriter("file3.txt") )
		{
			//Write to files
			for (int i = 0; i < buffer.length; i+=2) {
				f0.write(buffer[i]);
			}
			
			f1.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
