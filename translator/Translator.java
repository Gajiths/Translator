package translator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Translator {
	
	public static void main(String args[]){
		String keyPairs[];
		String keys[];
		HashTable tbl=new HashTable();
		
		long start=System.currentTimeMillis();

		BufferedReader br = null;
		BufferedReader br1 = null;
		try {
 
			String sCurrentLine;
			String inputLine ="";
			br = new BufferedReader(new FileReader("E:/Intern/Java/workspace/Translator/src/translator/first.txt"));
			br1 = new BufferedReader(new FileReader("E:/Intern/Java/workspace/Translator/src/translator/second.txt"));
			
			while (!((sCurrentLine = br.readLine()).equals(""))) {
				keyPairs =sCurrentLine.split(",");
				tbl.put(keyPairs[0], keyPairs[1]);
			}
			while ((sCurrentLine = br1.readLine()) != null) {
				
				inputLine+=sCurrentLine+" ";
				
			}
			System.out.println(inputLine);
			keys =inputLine.split(" ");
			int i=0;
			while(i<keys.length){
				if(tbl.get(keys[i])!=null){
					System.out.print(tbl.get(keys[i])+" ");
				}else{
					System.out.print("["+keys[i]+"]"+" ");
				}
				i++;
			}
			
			long end=System.currentTimeMillis();
			
			System.out.println("\n Runnig time"+(end-start));
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				br1.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	

}
