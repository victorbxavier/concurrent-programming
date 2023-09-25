package com.imd.models;

import java.util.List;

public class Producer extends Thread{
	private List<String> list;
	
	public Producer(List<String> list2) {
		this.list = list2;
		setPriority(Thread.NORM_PRIORITY);
	}
	
	public void run() {
		for(int i = 0; i < 60; i++) {
			list.add("E"+i);
			System.out.println("Adicionou E"+i+" ");
			try {
				Thread.sleep(500);
					
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#Producer Finished");
	}
}
