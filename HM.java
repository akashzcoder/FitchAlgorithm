package Fitch;

import Fitch.Node; 
import java.util.Stack;
import java.util.Hashtable;

public class HM {
	
	public static void fitch(Hashtable ht, String tree){
		Stack stk = new Stack();
		Stack ances = new Stack();
		String speciesName="";
		String s1[]=null;
		String[] s2=null;
		Stack<String> compAnc=new Stack<String>();
		Node obj3=null;
		int tmpScore= 0;
		ancestorGen obj2 =  new ancestorGen();
		for(int i=1;i<tree.length();i++){
			if(tree.charAt(i) != '(' && tree.charAt(i) != ','&& tree.charAt(i) != ')'){
				speciesName = speciesName + tree.charAt(i);
			}
			if((tree.charAt(i) == ',' && tree.charAt(i-1)!=')') || (tree.charAt(i) == ')' && tree.charAt(i-1) != ')')){
				if(tree.charAt(i) == ',' && tree.charAt(i-1)!=')'){
					
					Node obj = new Node(speciesName, (String)ht.get(speciesName), null, null,null,null);
					stk.push(obj);
				}
				
				if(tree.charAt(i) == ')' && tree.charAt(i-1) != ')'){
					
					Node obj = new Node(speciesName, (String)ht.get(speciesName), null, null,null,null);
					stk.push(obj);
					Node a = (Node) stk.pop();
					Node b = (Node) stk.pop();
					if(a.data != null && b.data!=null){
						s1= new String[a.data.length()];
						for(int d=0;d<a.data.length();d++){
							s1[d] = Character.toString(a.data.charAt(d));
						}
						s2= new String[b.data.length()];
						for(int d=0;d<b.data.length();d++){
							s2[d] = Character.toString(b.data.charAt(d));
						}
					} else {
						if(a.data == null && b.data!=null){
							s1 = a.ancestorSet;
							s2= new String[b.data.length()];
							for(int d=0;d<b.data.length();d++){
								s2[d] = Character.toString(b.data.charAt(d));
							}
							
						} else{
							if(a.data != null && b.data==null){
								s2 = b.ancestorSet;
								s1= new String[a.data.length()];
								for(int d=0;d<a.data.length();d++){
									s1[d] = Character.toString(a.data.charAt(d));
							}
						} else {
							s1 =a.ancestorSet;
							s2 =b.ancestorSet;
							}
						}
					}
					
					String[] s3= obj2.ancestorF(s1, s2);
					obj3 = new Node(null, null, a, b, s3,null);
					stk.push(obj3);
				}
				speciesName = "";
				
			}// end of if
		}// end of for loop
		compAnc = obj2.ancestorB(obj3);
		System.out.println(compAnc.size());
		
	}// end of method
}// end of class