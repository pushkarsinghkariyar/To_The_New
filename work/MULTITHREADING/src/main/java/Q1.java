class Runnable1 implements Runnable{
    public void run(){
        for(int i=0;i<=20;i++) {
            if(i%2!=0)
                System.out.println("Odd :"+i);
        }
    }
}

class Runnable2 implements Runnable{
    public void run(){
        for(int i=0;i<=20;i++) {
            if (i%2==0)
                System.out.println("Even : "+i);
        }
    }
}

class Q1 {

    public static void main(String[] args) throws InterruptedException {
        //Runnable r1 = new Runnable1();
        Thread t1 = new Thread(new Runnable1());
        //Runnable r2 = new Runnable2();
        Thread t2 = new Thread(new Runnable2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}