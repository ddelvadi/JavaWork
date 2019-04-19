/*
 * This program demonstrates use of BufferedInputStream methods
 * It helps in improving performance by allowing Java to do I/O operations
 * on more than one byte at a time
 */
import java.io.*;

public class BufferedInputStreamDemo {
	public static void main(String args[]) {
		String s = "This is a &copy; copyright symbol " +
					"but this is &copy not";
		
		//Copyright reference begins with & and ends with ; with no space
		byte buf[] = s.getBytes();
		
		ByteArrayInputStream bin = new ByteArrayInputStream(buf);
		int c;
		boolean marked = false;
		int count = 0;
		
		/*
		 * Logic: Buffer is used to go over each byte then
		 * based on rules, if it is copyright then (c) is printed
		 * otherwise it resets the buffer and prints whole string
		 */
		try ( BufferedInputStream f = 
				new BufferedInputStream(bin)) {
			while((c = f.read()) != -1) {
				switch(c) {
				case '&':
					if(!marked) {
						f.mark(32);
						marked = true;
					} else {
						marked = false;
					}
					break;
				case ';':
					if(marked) {
						marked = false;
						System.out.print("(c)");
					} else {
						System.out.print((char) c);
					}
					break;
				case ' ':
					if(marked) {
						marked = false;
						f.reset();
						System.out.print("&");
					} else {
						System.out.print((char) c);
					}
					break;
				default:
					if(!marked) {
						System.out.print((char) c);
					}
					break;
				}
			}
		} catch(IOException e) {
			
		}
		System.out.println("\n" + count);
	}
}
