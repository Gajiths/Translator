package translator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TanslatorProcess {
	
	public String keyPairs[];
	public String keys[];
	public HashTable tbl=new HashTable();
	Object lock1=new Object();
	Object lock2=new Object();
	boolean waitCheck=false;
	boolean isReadOver=false;
	public static void main(String[] args){
		 TanslatorProcess trnslator=new TanslatorProcess();
		 trnslator.Process();
	}


	public   void readFirst(){
		
		synchronized (lock1) {
			String sCurrentLine;
			 
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("E:/Intern/Java/workspace/Translator/src/translator/first.txt"));
				while (!((sCurrentLine = br.readLine()).equals(""))) {
					//System.out.println(sCurrentLine);
					keyPairs =sCurrentLine.split(",");
					if(isReadOver==false){
						
						tbl.put(keyPairs[0], keyPairs[1]);
					//System.out.println(tbl.get(keyPairs[0]));
					}else{
						Thread.sleep(10);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public  void readSecond(){
		String sCurrentLine;
		String inputLine="";
		synchronized (lock2) {
			BufferedReader br1 = null;
			try {
				br1 = new BufferedReader(new FileReader("E:/Intern/Java/workspace/Translator/src/translator/second.txt"));
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
					
					
					if(i==keys.length-1){
							isReadOver=true;
					}
					
					i++;
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	private void Process() {
		long start=System.currentTimeMillis();
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				readFirst();
				readSecond();
			}
		});
		
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				readFirst();
				readSecond();
				
				
			}
		});
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end=System.currentTimeMillis();
		
		System.out.println("\n Runnig time"+(end-start));
		
	}

}
