package cisco.java.challenge.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tree {
	
	private static List<String> pathes;
	private static String parent = "";
	
	public ArrayList<GNode> walkGraph(GNode node, ArrayList<GNode> list){
		if(!list.contains(node))list.add(node);
		//list.addAll(Arrays.asList(node.getChildren()));
		GNode[] nodes = node.getChildren();
		for (int i = 0; i < nodes.length; i++) {
			walkGraph(nodes[i], list);
		}
		return list;
	}
	
	public List<String> paths(GNodeImpl node) {
		pathes = new ArrayList<String>();
		walkGraph(node, new StringBuilder(""));
		return pathes;
	}
	
	public StringBuilder walkGraph(GNode node, StringBuilder path) {
		path.append(node.getName());
		parent = path.toString();
		if(!node.hasChild()) {
			pathes.add(path.toString());
			parent = path.toString().substring(0, path.length()-1);
			return null;
				}else {
					for(GNode nodeEl : ((GNodeImpl) node).getList()) {
						walkGraph(nodeEl,  new StringBuilder(parent));
					}
					parent = path.toString().substring(0, path.length()-1);
				}
		return null;
	}

	 class GNodeImpl implements GNode {
		private String name;
		List<GNode> list;
					
		public GNodeImpl(String name) {
			super();
			this.name = name;
			list = new LinkedList<GNode>();
		}

		public void addChild(GNodeImpl node) {
			list.add(node);
		}
		
		public List<GNode> getList() {
			return list;
		}
		
		public void setList(List<GNode> list) {
			this.list = list;
		}

		@Override
		public String getName() {
			return name;
		}

		public boolean hasChild() {
			return list.size()>0;
		}

		@Override
		public GNode[] getChildren() {
			GNode[] arr = new GNodeImpl[list.size()];
			arr = list.toArray(arr);
			return arr;
		}

		@Override
		public String toString() {
			
			return this.name + " ";
		}
		
		

	}

	public List walkGraph(GNodeImpl node) {
		ArrayList<GNode> list = new ArrayList<>();
		return walkGraph(node, list);
	}
}
