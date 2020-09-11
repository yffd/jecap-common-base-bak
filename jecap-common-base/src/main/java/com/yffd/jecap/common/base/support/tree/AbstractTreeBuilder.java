package com.yffd.jecap.common.base.support.tree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTreeBuilder<T, N extends Treeable<N>> {

	public abstract N convert(T obj);
	
	public N buildTree(T root, List<T> nodeList) {
		N parentNode = this.convert(root);
		this.getChildrenByRecursive(parentNode, nodeList);
		return parentNode;
		
//		return this.buildTreeByIter(root, nodeList);
	}
	
	// 遍历方式
	protected N buildTreeByIter(T parent, List<T> nodeList) {
		List<N> children = new ArrayList<>();
		N parentNode = this.convert(parent);
		for (T obj : nodeList) {
			N node = this.convert(obj);
			if (parentNode.getIdValue().equals(node.getIdValue())) continue;
			if (parentNode.getIdValue().equals(node.getPidValue())) {
				this.afterFilterNode(node, parentNode);
				children.add(node);
			}
		}
		parentNode.setChildren(children);
		
		while (children.size() > 0) {
			List<N> tmpList = new ArrayList<>();
			for (N nextParent : children) {
				List<N> nextChildren = new ArrayList<>();
				for (T obj : nodeList) {
					N node = this.convert(obj);
					if (nextParent.getIdValue().equals(node.getIdValue())) continue;
					if (nextParent.getIdValue().equals(node.getPidValue())) {
						this.afterFilterNode(node, nextParent);
						nextChildren.add(node);
						tmpList.add(node);
					}
				}
				nextParent.setChildren(nextChildren);
			}
			children = tmpList;
		}
		return parentNode;
	}
	
	// 递归方式
	protected List<N> getChildrenByRecursive(N parent, List<T> nodeList) {
		List<N> children = new ArrayList<>();
		for (T obj : nodeList) {
			N node = this.convert(obj);
			if (parent.getIdValue().equals(node.getIdValue())) continue;
			if (parent.getIdValue().equals(node.getPidValue())) {
				this.afterFilterNode(node, parent);
				List<N> nextChildren = this.getChildrenByRecursive(node, nodeList);
				if (nextChildren.size() > 0) node.setChildren(nextChildren);
				children.add(node);
			}
		}
		if (children.size() > 0) parent.setChildren(children);
		return children;
	}
	
	protected void afterFilterNode(N child, N parent) {
		
	}
}
