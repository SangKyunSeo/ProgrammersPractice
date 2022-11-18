
import java.util.*;

import java.io.*;

class Node{
	char data;
	Node left;
	Node right;
	public Node(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class tree{
	Node root;
	
	public void createNode(char data,char left_data,char right_data) {
		if(root==null) {
			root = new Node(data);
			
			if(left_data!='.') {
				root.left = new Node(left_data);
			}
			if(right_data!='.') {
				root.right = new Node(right_data);
			}
		}else {
			searchNode(root, data, left_data, right_data);
		}
	}
	public void searchNode(Node node, char data,char left_data,char right_data ) {
		if(node==null)return;
		else if(node.data==data) {
			if(left_data!='.') {
				node.left=new Node(left_data);
			}
			if(right_data!='.') {
				node.right = new Node(right_data);
			}
		}else {
			searchNode(node.left,data,left_data,right_data);
			searchNode(node.right,data,left_data,right_data);
		}
	}
	public void preOrder(Node root) {
		System.out.print(root.data);
		if(root.left!=null)preOrder(root.left);
		if(root.right!=null)preOrder(root.right);
	}
	public void inOrder(Node root) {
		if(root.left!=null)inOrder(root.left);
		System.out.print(root.data);
		if(root.right!=null)inOrder(root.right);
	}
	public void postOrder(Node root) {
		if(root.left!=null)postOrder(root.left);
		if(root.right!=null)postOrder(root.right);
		System.out.print(root.data);
	}
}

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree t = new tree();
		
		for(int i =0;i<n;i++) {
			char[] data;
			data = br.readLine().replaceAll(" ","").toCharArray();
			t.createNode(data[0], data[1], data[2]);
			
		}
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
		
		
	}
}