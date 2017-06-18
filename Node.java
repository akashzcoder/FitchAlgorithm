package Fitch;
class Node
{
	public String key;
	public String data = null;
	public String ancestor = null;
	public String[] ancestorSet = null;
	public Node lc =null;
	public Node rc = null;
	Node(String key, String s, Node a, Node b, String[] ancestorSet,String ancestor){
		this.key = key;
		this.data =s;
		this.lc = a;
		this.rc = b;
		this.ancestorSet=ancestorSet;
		this.ancestor=ancestor;
	}
}
