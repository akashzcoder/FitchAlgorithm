import ParScore.Node; 
import ParScore.ancestorGen;
import ParScore.Score;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class HM {
    
		public static void fitch(Hashtable ht, String tree){
		Stack stk = new Stack();
		
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

					String dd=(String)ht.get(speciesName);
                // 25 is the length of the sequence, make it dynamic if u have to
					for(int i2=dd.length();i2<25;i2++){
						dd=dd+'-';
					}
					Node obj = new Node(speciesName, dd, null, null,null,null,null);
					stk.push(obj);
					speciesName = "";

			}
				if(tree.charAt(i) == ')' ){
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
					obj3 = new Node(null, null, a, b,null, s3,null);
					a.prev=obj3;
					b.prev=obj3;
					stk.push(obj3);
				}

		}// end of for loop
		ancestorGen ancestorSeq = new ancestorGen();
		Stack ances = new Stack();
		ances = ancestorSeq.ancestorB(obj3,obj3);
		//parScore(ht, tree, ances); 
		ances.clear();
		
	}// end of method
	}// end of class
