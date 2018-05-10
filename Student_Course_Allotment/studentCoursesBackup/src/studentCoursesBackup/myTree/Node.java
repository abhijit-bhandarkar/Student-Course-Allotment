package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Node class implements both ObserverI and SubjectI as well as Cloneable interface
 */
public class Node implements ObserverI, SubjectI, Cloneable{
	private int b_number;
	private ArrayList<String> courses;
	private Node left_child;
	private Node right_child;
	private ArrayList<ObserverI> observers;
	
	
	/**
	 * Empty constructor which sets the private data members to default values
	 */
	public Node() {
		// TODO Auto-generated constructor stub
		courses = new ArrayList<String>();
		observers = new ArrayList<ObserverI>();
	}
	
	public int getB_number() {
		return b_number;
	}
	
	public void setB_number(int b_number_in) {
		b_number = b_number_in;
	}
	
	public ArrayList<String> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<String> courses_in) {
		courses = courses_in;
	}
	
	public Node getLeft_child() {
		return left_child;
	}
	
	public void setLeft_child(Node left_child_in) {
		this.left_child = left_child_in;
	}
	
	public Node getRight_child() {
		return right_child;
	}
	
	public void setRight_child(Node right_child_in) {
		right_child = right_child_in;
	}
	
	/**
	 * This function registers observer
	 */
	@Override
	public void registerObserver(ObserverI o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	
	/**
	 * This function removes registered observer
	 */
	@Override
	public void removeObserver(ObserverI o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}
	
	/**
	 * notifyObservers takes courseIn parameter and notify all observers
	 * of the change in courses list
	 */
	@Override
	public void notifyAll(String courseIn) {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			ObserverI observerI = observers.get(i);
			observerI.update(courseIn);
		}
	}
	
	/**
	 * removes course from course list
	 */
	@Override
	public void update(String course) {
		// TODO Auto-generated method stub
		this.getCourses().remove(course);
	}

	/**
	 * takes following parameters and add coursesIn into course list of Node temp
	 * @param coursesIn
	 * @param temp
	 */
	public void addCourse(ArrayList<String> coursesIn, Node temp) {
		// TODO Auto-generated method stub
		temp.getCourses().addAll(coursesIn);
	}
	
	/**
	 * This function validates the course and returns boolean
	 * @param courseIn
	 * @return
	 */
	public boolean validateCourse(String courseIn){
		boolean flag = true;
		ArrayList<String> courses = new ArrayList<>
			(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"));
		if (!courses.contains(courseIn)) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * This function uses prototype pattern to clone the node using deep copy
	 */
	@Override
	public Object clone () throws CloneNotSupportedException{
		Node node = new Node();
		node.setB_number(b_number);
		node.setCourses(new ArrayList<>(courses));
		return node;
	}
	
	/**
	 * This method is overridden from superclass [Object] which displays the node details/data
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return b_number + ":" + courses.toString();
	}
}
