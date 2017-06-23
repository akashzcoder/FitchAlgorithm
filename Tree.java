import java.util.*;
class Node
{
	public String key;
	public String data = null;
	public String ancestor = null;
	public String[] ancestorSet = null;
	int score=0;
	public Node lc =null;
	public Node rc = null;
	public Node prev=null;
	Node(String key, String s, Node a, Node b,Node prev, String[] ancestorSet,String ancestor){
		this.key = key;
		this.data =s;
		this.lc = a;
		this.rc = b;
		this.prev=prev;
		this.ancestorSet=ancestorSet;
		this.ancestor=ancestor;
	}
	void Node(int s){
		this.score = s;
	}
	public void display(){
		System.out.print("{"+ key+"->" + data + "}");
	}
}
