package imagen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Read_File {
	public static String read_a_file(File file) {
		BufferedReader br = null; 
		String read_string="";
		try {
		String sCurrentLine;
		br = new BufferedReader(new FileReader(file));
		while ((sCurrentLine = br.readLine()) != null) {
		read_string=read_string+sCurrentLine;
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		try {
			if (br != null)br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
		return read_string;
	}
}