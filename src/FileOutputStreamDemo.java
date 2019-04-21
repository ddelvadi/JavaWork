/*
 * This program demonstrates the usage of FileOutputStream
 * It creates 3 files and based on some conditions bytes are written to files
 * It doesn't make use of try-with-resources
 */
import java.io.*;

public class FileOutputStreamDemo {
	public static void main(String args[]) {
		String src = "FileOutputStream creates an OutputStream\n" +
					 "that you can use to write bytes to a file\n" +
					 "Creation of it is not dependent on the file already existing";
		byte bufSrc[] = src.getBytes();
		FileOutputStream f0 = null;
		FileOutputStream f1 = null;
		FileOutputStream f2 = null;
		
		// Traditional try block where files are closed explicitly
		try {
			f0 = new FileOutputStream("file1.txt");
			f1 = new FileOutputStream("file2.txt");
			f2 = new FileOutputStream("file3.txt");
			
			//Write to files
			for (int i = 0; i < bufSrc.length; i += 2) {
				f0.write(bufSrc[i]);
			}
			
			f1.write(bufSrc);
			
			f2.write(bufSrc, bufSrc.length/4, bufSrc.length/4);
		} catch(IOException e) {
			System.out.println("An I/O Error!!");
		} finally {
			//Close the streams
			try {
				if(f0 != null) {
					f0.close();
				} 
			} catch(IOException e) {
				System.out.println("Error while closing file1");
			}
			
			try {
				if(f1 != null) {
					f1.close();
				} 
			} catch(IOException e) {
				System.out.println("Error while closing file2");
			}
			
			try {
				if(f2 != null) {
					f2.close();
				} 
			} catch(IOException e) {
				System.out.println("Error while closing file3");
			} 
		}
	}
}
