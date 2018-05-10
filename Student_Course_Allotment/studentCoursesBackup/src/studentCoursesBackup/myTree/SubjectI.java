package studentCoursesBackup.myTree;


public interface SubjectI {
	
	public void registerObserver(ObserverI o);
	public void removeObserver(ObserverI o);
	public void notifyAll(String course);
}
