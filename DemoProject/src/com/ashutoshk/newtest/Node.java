package com.ashutoshk.newtest;

public class Node {

	private Integer data;
	private Node next;

	public void add(Integer data) {

		// for first element only
		if (this.data == null && this.next == null) {
			this.data = data;
			return;
		}

		// create new node to be added at the end
		Node lastNode = new Node();
		lastNode.data = data;

		Node nextNode = this.next;
		Node current = this;
		for (;;) {
			if (nextNode == null) {
				current.next = lastNode;
				break;
			} else {
				nextNode = nextNode.next;
			}
			current = current.next;
		}
	}

	public static void printNodeData(Node node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node list = new Node();
		list.add(2);
		list.add(3);
		list.add(null);

		printNodeData(list);

	}

}
