package cisco.java.challenge.task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {

	private static List<String> pathes;
	private static String parent = "";
	
	public List<String> paths(GNodeImpl node) {
		pathes = new ArrayList<String>();
		walkGraph(node, new StringBuilder(""));
		return pathes;
	}
	
	public StringBuilder walkGraph(GNode GNode, StringBuilder path) {
		path.append(GNode.getName());
		parent = path.toString();
		if(!GNode.hasChild()) {
			pathes.add(path.toString());
			parent = path.toString().substring(0, path.length()-1);
			return null;
				}else {
					for(GNode node : ((GNodeImpl) GNode).getList()) {
						walkGraph(node,  new StringBuilder(parent));
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

	}
}
