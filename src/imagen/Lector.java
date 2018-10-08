package imagen;

import java.io.File;
import java.io.PrintWriter;
public class Lector {
	public static void main(String[] args) {
		String input_file="scr.jpg";
		String output_file="scr";	
		String tesseract_install_path="C:\\Tesseract-OCR";
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("cd " + tesseract_install_path);
	                stdin.println("tesseract " + System.getProperty("user.dir") + "\\" +  input_file + " " + System.getProperty("user.dir") + "\\" + output_file + " " + "-l spa");
	        	    stdin.close();
	                p.waitFor();
	                System.out.println();
	                System.out.println();
	                System.out.println();
	                System.out.println();
	                System.out.println(Read_File.read_a_file(new File(output_file+".txt")));
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
	}	
}	
