/*
 * This program shows usage of DataOutputStream and DataInputStream that allows to
 * write or read primitive data to or from a stream
 */
import java.io.*;

public interface DataIODemo {
	public static void main(String args[]) {
		// First, write the data.
	    try ( DataOutputStream dout =
	            new DataOutputStream(new FileOutputStream("Test.dat")) )
	    {
	      dout.writeDouble(98.6);
	      dout.writeInt(1000);
	      dout.writeBoolean(true);
	    } catch(FileNotFoundException e) {
	    	  System.out.println("Cannot Open Output File");
	    	  return;
	    	} catch(IOException e) {
	    	  System.out.println("I/O Error: " + e);
	    	}
	    	// Now, read the data back.
	    	try ( DataInputStream din =
	    	new DataInputStream(new FileInputStream("Test.dat")) )
	    	{
	    		double d = din.readDouble();
	    		int i = din.readInt();
	    		boolean b = din.readBoolean();
	    		System.out.println("Here are the values: " +
	    							d + " " + i + " " + b);
	    	} catch(FileNotFoundException e) {
	    	      System.out.println("Cannot Open Input File");
	    	      return;
	    	    } catch(IOException e) {
	    	      System.out.println("I/O Error: " + e);
	    	} 
	}
}
