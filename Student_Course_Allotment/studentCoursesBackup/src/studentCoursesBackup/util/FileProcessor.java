package studentCoursesBackup.util;

/**
 * This class implements all methods for driver code to
 * access the inputs from file properly
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	
	private String filename;
	private BufferedReader bufferedReader;
	
	/**
	 * Empty constructor which sets the default value to
	 * its data members
	 */
	public FileProcessor() {
		// TODO Auto-generated constructor stub
		filename = "input.txt";
		initialize_reader();
	}

	/**
	 * Constructor accepts following parameters and assigns
	 * to the filename parameter
	 * @param fileIn
	 */
	public FileProcessor(String fileIn) {
		// TODO Auto-generated constructor stub
		filename = fileIn;
		initialize_reader();
	}

	/**
	 * This method initializes the BufferedReader
	 */
	private void initialize_reader() {
		String filepath = filename;
		File file = new File(filepath);		
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.err.println("FileNotFoundException caught for file " + "\n" + e.getMessage());
			System.exit(1);
		}
	}
	
	/**
	 * This is helper method which returns single line from file
	 * @return String
	 */
	public String readLine() {
		
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("Error while reading the line " + "\n" + e.getMessage());
			System.exit(1);
		}
		return null;	
	}
	
	/**
	 * This method is overridden from superclass [Object] which displays the filename being read
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return filename + "being read";
	}
	 
	
}
