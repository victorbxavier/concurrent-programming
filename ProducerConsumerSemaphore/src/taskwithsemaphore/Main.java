package taskwithsemaphore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Semaphore semaphore = new Semaphore(1, true);
       // List<String> list = new ArrayList<String>();

        Producer p1 = new Producer(list,60,50,Thread.MAX_PRIORITY, semaphore);
        //Producer p2 = new Producer(list,30,50,Thread.MAX_PRIORITY);
        Consumer c1 = new Consumer(list,30,50,Thread.MIN_PRIORITY, semaphore);
        Consumer c2 = new Consumer(list,30,50,Thread.MIN_PRIORITY, semaphore);

        p1.start();
        //p2.start();
        c1.start();
        c2.start();

        p1.join();
        //p2.join();
        c1.join();
        c2.join();


        System.out.println("Final List=>"+list.toString());

     }
}