import java.lang.*;
import java.io.*;
import java.util.*;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

class Prime extends Thread {
    public void run() {
        int isPrime;
        for (int i = 2; i <= 20; i++) {
            isPrime = 0;
            for (int j = 2; j <= sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = 1;
                    break;
                }
            }
            if (isPrime == 0 && i != 1)
                System.out.println("Prime- " + i);
        }
    }
}
class NonPrime extends Thread
{
    public void run()
    { int isPrime;
        for(int i = 2; i <= 20; i++){
            isPrime = 0;
            for(int j = 2; j <= sqrt(i); j++){
                if(i % j == 0){
                    isPrime = 1;
                    break;
                }
            }
            if(isPrime==1 || i==1)
                System.out.println("NonPrime- "+ i);;
        }
    }

}

public class Q2 {
    public static void main(String args[]) throws InterruptedException {
        Prime t1 = new Prime();
        NonPrime t2 = new NonPrime();
        t1.start();
        t2.start();

    }
}