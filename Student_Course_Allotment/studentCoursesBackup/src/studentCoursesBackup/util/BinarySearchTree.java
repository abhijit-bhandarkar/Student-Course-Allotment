package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class BinarySearchTree {
	private Node root;
	private Results results;
	private boolean flag;
	
	/**
	 * Empty constructor which sets the private data members to default values
	 */
	public BinarySearchTree() {
		root = null;
		flag = true;
		setResults(null);
	}

	/**
	 * constructor takes resultsIn which sets it to private data member results
	 */
	public BinarySearchTree(Results resultsIn) {
		// TODO Auto-generated constructor stub
		root = null;
		flag = true;
		setResults(resultsIn);
	}

	public Node getNood() {
		return root;
	}

	public void setNood(Node node) {
		this.root = node;
	}
	
	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}
	
	/**
	 * takes nodeIn as a parameter and insert into the tree
	 * @param nodeIn
	 */
	public void insertNode(Node nodeIn) {
		if (root==null) {
			root = nodeIn;
			return;
		}
		Node temp = root;
		while (temp != null) {
			if (temp.getB_number() > nodeIn.getB_number()) {
				if (temp.getLeft_child()!=null) {
					temp = temp.getLeft_child();
				} else {
					temp.setLeft_child(nodeIn);
					break;
				}
			} else if (temp.getB_number() < nodeIn.getB_number()){
				if (temp.getRight_child()!=null) {
					temp = temp.getRight_child();
				} else {
					temp.setRight_child(nodeIn);
					break;
				}
			} else {
				if(!temp.getCourses().contains(nodeIn.getCourses().get(0))){
					temp.addCourse(nodeIn.getCourses(), temp);
				}
				break;
			}
		}
		return;
	}

	
	/**
	 * takes following parameters and search bNumber in tree if found
	 * deletes the course from the list of that particular bNumber also implements observer patterns and 
	 * deletes the course from its observers also
	 * @param bNumber
	 * @param course
	 */
	public void deleteNode(int bNumber, String course) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		Node temp = root;
		while (temp != null) {
			if(temp.getB_number() > bNumber){
				temp = temp.getLeft_child();
			}else if(temp.getB_number() < bNumber){
				temp = temp.getRight_child();
			}else{
				temp.update(course);
				temp.notifyAll(course);
				break;
			}
		}
		return;
	}
	
	/**
	 * takes resultsIn as a parameter and stores the result of tree into it
	 * @param resultsIn
	 */
	public void printNodes(Results resultsIn) {
		// TODO Auto-generated method stub
		Node storeResultsOfNode = root;
		printNodes(resultsIn, storeResultsOfNode);
	}

	/**
	 * printNodes method accepts following parameters and store the results of node into output array of results 
	 * @param resultsIn
	 * @param storeResultsOfNode
	 */
	private void printNodes(Results resultsIn, Node storeResultsOfNode) {
		// TODO Auto-generated method stub
		if(storeResultsOfNode!=null){
			String courses = storeResultsOfNode.getCourses().toString();
			courses = courses.replaceAll("\\[", "");
			courses = courses.replaceAll("\\]", "");
			courses = courses.replaceAll(",", "");
			resultsIn.storeNewResult(storeResultsOfNode.getB_number() + " : " + courses);
			printNodes(resultsIn, storeResultsOfNode.getLeft_child());
			printNodes(resultsIn, storeResultsOfNode.getRight_child());
		}
	}


}
