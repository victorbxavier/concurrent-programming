package com.imd.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.imd.models.Consumer;
import com.imd.models.Producer;

public class Main {

	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new ArrayList<String>()); // Sem problemas com acessos indevidos
		Producer p1 = new Producer(list);
		Consumer c1 = new Consumer(list);
		
		p1.start();
		c1.start();
		
		try {
			p1.join();
			c1.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
