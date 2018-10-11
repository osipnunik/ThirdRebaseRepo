package cisco.java.challenge.task1;

import cisco.java.challenge.task1.Tree;
import cisco.java.challenge.task1.Tree.GNodeImpl;
public class Application {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		GNodeImpl nodeA = tree.new GNodeImpl("A");
		GNodeImpl nodeB = tree.new GNodeImpl("B");
		GNodeImpl nodeC = tree.new GNodeImpl("C");
		GNodeImpl nodeD = tree.new GNodeImpl("D");
		GNodeImpl nodeE = tree.new GNodeImpl("E");
		GNodeImpl nodeF = tree.new GNodeImpl("F");
		GNodeImpl nodeG = tree.new GNodeImpl("G");
		GNodeImpl nodeH = tree.new GNodeImpl("H");
		GNodeImpl nodeI = tree.new GNodeImpl("I");
		
		nodeA.addChild(nodeB);
		nodeA.addChild(nodeC);
		nodeA.addChild(nodeD);
		nodeB.addChild(nodeE);
		nodeB.addChild(nodeF);
		nodeC.addChild(nodeG);
		nodeC.addChild(nodeH);
		nodeC.addChild(nodeI);
		
		System.out.println(tree.paths(nodeA).toString());
	}

}
