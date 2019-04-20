import java.io.*;
import java.util.*;

/*
 * This program has two classes InputStreamEnumerator and SequenceInputStreamDemo
 * First class gets filenames from vector into Enum 
 * Main class takes object of first class and pass it to SequenceInputStream constructor to have files in required stream
 */
class InputStreamEnumerator implements Enumeration<FileInputStream> {
	private Enumeration<String> fileNames;
	
	public InputStreamEnumerator(Vector<String> files) {
		this.fileNames = files.elements();
	}
	// Overriding methods
	@Override
	public boolean hasMoreElements() {
		return fileNames.hasMoreElements();
	}

	@Override
	public FileInputStream nextElement() {
		try {
			//Converting to FileInputStream because SequenceInputStream constructor only accepts InputStrem Enum
			return new FileInputStream(fileNames.nextElement().toString());
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	
}

public class SequenceInputStreamDemo {
	public static void main(String args[]) {
		int c;
		Vector<String> files = new Vector<String> ();
		//Add filenames to vector
		files.addElement("file1.txt");
		files.addElement("file2.txt");
		files.addElement("file3.txt");
		
		InputStreamEnumerator ise = new InputStreamEnumerator(files);
		
		try(InputStream input = new SequenceInputStream(ise)) {
			while((c = input.read()) != -1) {
				System.out.print((char) c);
			} 
		} catch(NullPointerException e) {
			System.out.println("Please check filename or path");
		} catch(IOException e) {
			System.out.println("I/O Error!");
		}
	}
}