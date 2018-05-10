package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
public class TreeBuilder {

	private BinarySearchTree subject, observer1, observer2;
	
	public TreeBuilder(BinarySearchTree tree, BinarySearchTree tree_backup_1, BinarySearchTree tree_backup_2) {
		// TODO Auto-generated constructor stub
		subject = tree;
		observer1 = tree_backup_1;
		observer2 = tree_backup_2;
	}

	/**
	 * takes following parameters and inserts data node into tree instances
	 * @param bNumberIn
	 * @param courseIn
	 */
	public void insertNode(int bNumberIn, String courseIn) {
		try {
			Node node = new Node();
			ArrayList<String> courses = new ArrayList<String>();
			if (node.validateCourse(courseIn)) {
				courses.add(courseIn);
			} else {
				return;
			}
			node.setB_number(bNumberIn);
			node.setCourses(courses);
			
			Node node_back_up1 = (Node) node.clone();
			Node node_back_up2 = (Node) node.clone();
			node.registerObserver(node_back_up1);
			node.registerObserver(node_back_up2);
			
			subject.insertNode(node);
			observer1.insertNode(node_back_up1);
			observer2.insertNode(node_back_up2);
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			System.err.println("Clone not supported");
			System.exit(1);
		}
	}

	/**
	 * takes following parameters and deletes the course from tree 
	 * @param bNumber
	 * @param course
	 */
	public void deleteNode(int bNumber, String course) {
		// TODO Auto-generated method stub
		try {
			subject.deleteNode(bNumber, course);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}
