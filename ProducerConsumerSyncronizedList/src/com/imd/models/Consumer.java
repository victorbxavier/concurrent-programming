package com.imd.models;

import java.util.List;

public class Consumer extends Thread{
	private List<String> list;
	
	public Consumer(List<String> list2) {
		this.list = list2;
		setPriority(Thread.MIN_PRIORITY);
	}
	
	
	public void run() {
		for(int count=0; count < 60;) {
		
			if(!(list.isEmpty())) {
				String removed = list.remove(0);
				count++;
				System.out.println("Removeu "+removed+" ");
			}
			
			try {
				Thread.sleep(500);
					
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#Consumer finished");
	}
}
