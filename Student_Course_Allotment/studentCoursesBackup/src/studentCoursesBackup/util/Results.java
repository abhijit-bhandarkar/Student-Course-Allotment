package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Class Results implements FileDisplayInterface, StdoutDisplayInterface and
 * provide implementation for all of its methods
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private String filename;
	private File file;
	private BufferedWriter bufferedWriter;
	private String[] output;
	private int size;
	
	public String[] getOutput() {
		return output;
	}

	public void setOutput(String[] output) {
		this.output = output;
	}

	/**
	 * Results constructor which takes following parameters and assigns it to
	 * filename and also initializes all other of its private data members
	 * which also generates the file if does not exist with file name passed to it
	 * @param resultsIn
	 */
	public Results(String resultsIn) {
		// TODO Auto-generated constructor stub
		filename = resultsIn;
		output = new String[50];
		size=0;
		try {
			String filepath = filename;
			file = new File(filepath);
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.close();
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.err.println("FileNotFoundException caught for file " + "\n" + e.getMessage());
			System.exit(1);
		}catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * This is the implementation for the method form StdoutDisplayInterface
	 * which prints the output to console 
	 * @param output is a input parameter to this method
	 */
	@Override
	public void writeToStdout(String output) {
		// TODO Auto-generated method stub
		System.out.println(output);
	}

	/**
	 * This is the implementation for the method form FileDisplayInterface
	 * which writes the results to result file
	 * @param resultsIn is a input parameter to this method
	 */
	@Override
	public void writeToFile(String resultsIn) {
		// TODO Auto-generated method stub
		String filepath = filename;
		file = new File(filepath);
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.write(resultsIn);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error while writimg results to : " + filename);
			System.err.println(e.getMessage());
			System.exit(1);
		}	
	}
	
	/**
	 * This method stores all the results in an array
	 * @param outputIn
	 */
	public void storeNewResult(String outputIn){
		if(size == output.length){
			resizeOutputArray(output);
		}
		output[size] = outputIn + '\n';
		size++;
		Arrays.sort(output, 0, size);
	}
	
	/**
	 * This method resizes the output array if it reaches to its maximum limit
	 * with the same logic used to resize the myArrayList
	 * @param outputIn
	 */
	public void resizeOutputArray(String [] outputIn){
		int nextSize = outputIn.length + (int) Math.floor(outputIn.length * 0.5);
		String[] temp = new String[nextSize];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = outputIn[i];
		}
		output = temp;
	}
	
	/**
	 * This method is overridden from superclass [Object]
	 * returns the string representation of the output array
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String[] temp = new String[output.length];
		temp = output;
		return Arrays.toString(temp);
	}

	/**
	 * This is the implementation for the method form StdoutDisplayInterface
	 * which prints the output to console 
	 */
	@Override
	public void writeToStdout() {
		// TODO Auto-generated method stub
		System.out.println(output.toString());
	}

	/**
	 * /**
	 * This is the implementation for the method form FileDisplayInterface
	 * which writes the results to result file
	 */
	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		String filepath = filename;
		file = new File(filepath);
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			for (int i = 0; i < output.length && output[i]!=null; i++) {
				bufferedWriter.write(output[i]);
			}
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error while writimg results to : " + filename);
			System.err.println(e.getMessage());
			System.exit(1);
		}	
	}

}
