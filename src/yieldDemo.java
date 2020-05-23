// Java program to illustrate yield() method
// in Java
import java.lang.*;

// MyThread extending Thread
class DemoThread extends Thread
{
    public void run()
    {
        for (int i=0; i<5 ; i++)
            System.out.println(Thread.currentThread().getName()
                    + " in control");
    }
}

// Driver Class
public class yieldDemo//暂停当前线程or进程 运行更重要的进程 运行完后 继续
    //表示线程没有做任何特别重要的事情，如果需要运行任何其他线程或进程，它们可以。否则，当前线程将继续运行。
{
    public static void main(String[]args)
    {
        DemoThread t = new DemoThread();
        t.start();

        for (int i=0; i<5; i++)
        {
            // Control passes to child thread
            Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName()
                    + " in control");
        }
    }
}