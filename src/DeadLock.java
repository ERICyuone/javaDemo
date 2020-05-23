public class DeadLock {
    private static Object resurce1= new Object();;
    private static Object resurce2= new Object();;

    public static void main(String arg[]){
        new Thread(()->{

            synchronized(resurce1){
                System.out.println(Thread.currentThread()+"get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(resurce2){
                    System.out.println(Thread.currentThread()+"get resource2");
                }
            }

        },"t1").start();

        new Thread(()->{
            synchronized(resurce2){
                System.out.println(Thread.currentThread()+"get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(resurce1){
                    System.out.println(Thread.currentThread()+"get resource1");
                }
            }

        },"t2").start();
    }

}
