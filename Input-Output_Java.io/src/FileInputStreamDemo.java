/*
 * This program illustrates use of FileInputSream and its methods
 * Also it shows try-with-resources which requires JDK 7.0 or later
 */

import java.io.*;

public class FileInputStreamDemo {
	public static void main(String args[]) {
		int size;
		// Using try-with-resources that closes file object automatically 
		try ( FileInputStream f = 
				new FileInputStream("/FileInputStreamDemo.java") ) {
			System.out.println("Total available bytes: " +
								(size = f.available()));
			// Randomly selecting some number to show number of bytes
			int n = 50;
			System.out.println("First " +  " bytes of the file one" +
					 " read() at a time");
			// Reading 50 bytes of data
			for (int i = 0; i < n; i++) {
				System.out.print((char) f.read());
			}
			
			// Count remaining data bytes
			System.out.println("\nStill Available: " + f.available());
			
			System.out.println("Reading next " + n + 
					" bytes of the file one read(bytes[])");
			byte b[] = new byte[n];
			if(f.read(b) != n) {
				System.err.println("Couldn't read" + n + " bytes");
			}
			System.out.println(new String(b, 0 ,b.length));
		} 
		 catch (IOException e) {
			System.out.println("I/O Error! " + e);
		}
	}
}
