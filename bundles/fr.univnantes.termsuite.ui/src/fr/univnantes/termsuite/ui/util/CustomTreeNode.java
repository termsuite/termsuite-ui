package fr.univnantes.termsuite.ui.util;

public class CustomTreeNode {
	private Object parent;
	private int nodeType;
	
	CustomTreeNode(Object parent, int nodeType) {
		this.parent = parent;
		this.nodeType = nodeType;
	}
	public Object getParent() {
		return parent;
	}
	public int getNodeType() {
		return nodeType;
	}
	
}
