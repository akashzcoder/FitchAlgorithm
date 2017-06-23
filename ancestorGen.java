import java.util.Stack;

public class ancestorGen {

	public static Stack<String> ancestor = new Stack<String>();

// Forward Pass
public static String[] ancestorF(String[] a, String[] b){

String seq2[] = a;
String seq1[] = b;
//forward pass 
int count=0;
String[] setAncestor=null;
if(a.length>=b.length){
	setAncestor = new String[25];
	count=b.length;
}
else{
	setAncestor = new String[25];
	count=a.length;
}

for(int i = 0;i<setAncestor.length;i++){
setAncestor[i] = "";
}
for(int i= 0;i <count; i++){ 
 
	for(int k=0;k<seq1[i].length();k++){  
	   for(int j=0;j<seq2[i].length();j++){  
	       if(seq1[i].charAt(k)==seq2[i].charAt(j)){  
	           setAncestor[i] += seq1[i].charAt(k);  
	       }  
	   }  
	}
if(setAncestor[i] == "")
setAncestor[i]= seq1[i] + seq2[i];

}
for(int i=setAncestor.length;i<25; i++){
	setAncestor[i] = "-";
}
return setAncestor;
}

public Stack ancestorB(Node node, Node node2){

	String anc="";

	if(node!=null){
		ancestorB(node.rc,node2);
		ancestorB(node.lc,node2);
		if(node.data==null && node.prev!=null){
			
			anc = ancestorSeqGen(node.ancestorSet, node.prev.ancestorSet);
			System.out.println(anc);
			node.data = anc;
			ancestor.push(anc);
		}
		
	}
	return ancestor;
}
// 'a' is the child sequence of 'b'
public static String ancestorSeqGen(String[] a, String[] b){
	String ancestor="";
	for(int i=0;i<25;i++){
		if(a[i].contains("A") && b[i].contains("A") ){
			ancestor = ancestor + 'A';
		} else{
			if(a[i].contains("C") && b[i].contains("C") ){
				ancestor = ancestor + 'C';
			}else{
				if(a[i].contains("G") && b[i].contains("G") ){
					ancestor = ancestor + 'G';
			} else {
				if(a[i].contains("T") && b[i].contains("T") ){
					ancestor = ancestor + 'T';
					} else{
						ancestor = ancestor + getSeq(a[i], b[i]);
							
					}
				}
			}
		}
	}
			
	
	return ancestor;
}
static char getSeq(String a, String b){
	if(a.contains("A")||a.contains("C")||a.contains("G")||a.contains("T")){
		if(a.charAt(0)!='-')
			return a.charAt(0);
		else
			return a.charAt(1);
	} else {
		if(b.contains("A")||b.contains("C")||b.contains("G")||b.contains("T")){
			if(b.charAt(0)!='-')
				return b.charAt(0);
			else
				return b.charAt(1);
		} else 
			return '-';
	} 

}
}


