package cisco.java.challenge.task1;

public interface GNode {
	
	String getName();

	GNode[] getChildren();
	
	boolean hasChild();
}
