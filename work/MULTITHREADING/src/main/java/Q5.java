import java.util.Scanner;

class Mythread extends Thread
{

    private int start,end, sum=0;
    private int arr[]={1,2,3,4,5,6,7,8,9,10,11,12};

    Mythread(int start ,int end)
    {
        this.start = start;
        this.end = end;
        sum = 0;
    }


    public void run( )
    {
        for(int i = start; i <= end; i++)
        {

            sum +=arr[i];
        }
    }

    public int getSum( )
    {

        return sum;
    }


}


public class Question5 {
    public static void main(String args[]) {


        Mythread t1 = new Mythread(0,2);
        Mythread t2 = new Mythread(3,5);
        Mythread t3 = new Mythread(6,8);
        Mythread t4 = new Mythread(9,12);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch(InterruptedException e) {
            System.out.println("Interrupt Encountered");
        }


        int sum =t1.getSum( ) + t2.getSum( ) +t3.getSum()+t4.getSum();

        System.out.printf("The sum of array is %d.\n", sum);
    }
}
