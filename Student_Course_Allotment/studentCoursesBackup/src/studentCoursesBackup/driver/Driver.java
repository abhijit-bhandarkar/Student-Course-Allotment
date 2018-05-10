package studentCoursesBackup.driver;

import java.io.FileNotFoundException;

import studentCoursesBackup.util.BinarySearchTree;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;


/**
 * studentCoursesBackup program implements an application that implements
 * observer pattern as well as prototype pattern for student courses 
 * management system.
 *
 */

public class Driver {
	
	/**
	 * 
	 * @param args main method takes five command line arguments
	 * @throws FileNotFoundException
	 */
	public static void main(String [] args){
		
		FileProcessor fileProcessor=null;
		TreeBuilder treeBuilder;
		String readLine= null, course=null;
		int bNumber;
		
		/**
		 * This check validates the arguments
		 */
		if (args.length!=5) {
			String errmsg = "usage: java %s <input_file> <delete_file> <output1_file> "
					+ "<output2_file> <output3_file>";
			System.err.format(errmsg + "\n", Driver.class.getName());
			System.exit(1);
		}
		
		/**
		 * checking if input file is empty
		 */
		fileProcessor = new FileProcessor(args[0]);
		fileCheck(readLine, fileProcessor, args[0]);
		
		/**
		 * initializing the required instances of Results and BinarySearchTree classes
		 */
		Results results= new Results(args[2]);
		Results results_backup_1= new Results(args[3]);
		Results results_backup_2= new Results(args[4]);
		BinarySearchTree tree = new BinarySearchTree(results);
		BinarySearchTree tree_backup_1 = new BinarySearchTree(results_backup_1);
		BinarySearchTree tree_backup_2 = new BinarySearchTree(results_backup_2);
		
		/**
		 * Reading from input.txt and building the tree and backup trees
		 */
		fileProcessor = new FileProcessor(args[0]);
		treeBuilder = new TreeBuilder(tree, tree_backup_1, tree_backup_2);
		
		while((readLine = fileProcessor.readLine()) != null){
			readLine = readLine.replaceAll(" ", "");
			String [] data = readLine.split(":");
			try {
				bNumber = Integer.parseInt(data[0]);
				course = data[1];
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.err.println("NumberFormatException caught" + e.getMessage());
				continue;
			} 
			treeBuilder.insertNode(bNumber, course);
		}
		
		/**
		 * Reading from delete.txt and building the tree 
		 */
		fileProcessor = new FileProcessor(args[1]);
		
		while((readLine = fileProcessor.readLine()) != null){
			readLine = readLine.replaceAll(" ", "");
			String [] data = readLine.split(":");
			try {
				bNumber = Integer.parseInt(data[0]);
				course = data[1];	
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.err.println("NumberFormatException caught" + e.getMessage());
				continue;
			} 
			treeBuilder.deleteNode(bNumber, course);
		}
		
		/**
		 * Logic for writing results to output files
		 */
		tree.printNodes(results);
		results.writeToFile();
		tree_backup_1.printNodes(results_backup_1);
		results_backup_1.writeToFile();
		tree_backup_2.printNodes(results_backup_2);
		results_backup_2.writeToFile();
	}

	/**
	 * takes following parameters and check if input file is empty if yes exits the 
	 * programs with proper error message
	 * @param readLine
	 * @param fileProcessor
	 * @param args
	 */
	private static void fileCheck(String readLine, FileProcessor fileProcessor, String args) {
		// TODO Auto-generated method stub
		while ((readLine = fileProcessor.readLine()) == null) {
			System.err.println("File " + args + " is emmpty");
			System.exit(1);
		}
	}

}
