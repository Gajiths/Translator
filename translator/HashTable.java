package translator;

public class HashTable {
	
	private static int M=8191; 
	private Node[] hashList;
	public HashTable(){
		
		this.hashList=new Node[M];
		
	}
	
	public int hasCode(Object key){
		return ((key.hashCode()& 0x7fffffff)%M );
	}
	
	public void put(Object key,Object val){
		
		try{
			int hashVal=hasCode(key);
			
			if(hashList[hashVal]==null){
				hashList[hashVal]=new Node(key,val,null);
			}else{
				for(Node x=hashList[hashVal];x!=null;x=x.next){
					
					if(key.equals(x.key)){
						x.value=val;
					}else{
						x.next=new Node(key,val,null);
					}
				}
			
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("arayyy");
		}
		
		
	}
	
	public Object get(Object key){
		int hashVal=hasCode(key);
		Object findVal = null;
		for(Node x=hashList[hashVal];x!=null;x=x.next){
			
			if(key.equals(x.key)){
				findVal= x.value;
				
			}else{
				return null;
			}
		}
		return findVal;
	}
	
	
	public void printTable(){
		
		for(Node x:hashList){
			System.out.println("Values are :" +x.value);
		}
	}
	
	

}
