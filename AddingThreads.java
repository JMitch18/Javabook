/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addingthreads;

import java.util.*;
import java.util.concurrent.*;
public class AddingThreads {

    
    public static void main(String[] args) {
        
        
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for(int i = 0; i < 1000; i++){
            int n = (int)(Math.random() * 10000000) + 1;
            SumTask task = new SumTask(i,n);
            
            threadPool.execute(task);
            //Thread thread = new Thread(task);
           // thread.start();
        }
        threadPool.shutdown();
    }
    
    static class SumTask implements Runnable{
    
        private long sum;
        private int id, n;
        
        public SumTask(int newId, int newN){
        
            id = newId;
            n = newN;
        }
        @Override
        public void run(){
            for(int i = 1; i <= n; i++){
                sum = sum + i;
            }
            System.out.println("Thread " + id + " added up to " + n + " and got: " + sum);
        }
    }
    
}
