// Demonstrate File methods
import java.io.File;

public class FileDemo {
	static void printStr(String s) {
		System.out.println(s);
	}
	
	public static void main(String args[]) {
		File f1 = new File("/java/COPYRIGHT");
		
		printStr("File Name : " + f1.getName());
		printStr("Absolute Path : " + f1.getAbsolutePath());
		printStr("Parent : " + f1.getParent());
		printStr(f1.exists() ? "File Exists" : "Does not exist");
		printStr("File Size : " + f1.length() + "Bytes");
	}
}
