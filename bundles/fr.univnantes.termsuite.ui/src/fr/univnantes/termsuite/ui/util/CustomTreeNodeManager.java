package fr.univnantes.termsuite.ui.util;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class CustomTreeNodeManager {

	private Multimap<Object, CustomTreeNode> children = HashMultimap.create();

	public CustomTreeNode get(Object obj, int nodeType) {
		for(CustomTreeNode customNode:children.get(obj))
			if(customNode.getNodeType() == nodeType)
				return customNode;
		CustomTreeNode customNode = new CustomTreeNode(obj, nodeType);
		children.put(obj, customNode);
		return customNode;
	}

	public void clear() {
		children = HashMultimap.create();
	}

}
