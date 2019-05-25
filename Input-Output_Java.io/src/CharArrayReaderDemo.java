/*
 * This program illustrates usage of CharArrayReader class
 */
import java.io.*;

public class CharArrayReaderDemo {
	public static void main(String args[]) {
		String tmp = "Thisisastring";
		char tmpArray[] = new char[tmp.length()];
		tmp.getChars(0, tmp.length(), tmpArray, 0);
		int i;
		try (CharArrayReader input = new CharArrayReader(tmpArray) )
		{
			while((i = input.read()) != -1) {
				System.out.print((char) i);
			}
		} catch(IOException e) {
			System.out.println("I/O Error");
		}
	}
}
