package Plane;

public class Tester {
    public static void main(String[] args) {
        Runnable[] airPort = new Plane[10];
        Thread[] planes = new Thread[10];

        System.out.println("air port is open");

        //create the planes in the air port
        for (int index=0;index<airPort.length;index+=1){
            airPort[index] = new Plane(index+1);
            planes[index] = new Thread(airPort[index]);

        }
        //start the threads
        for (Thread item:planes){
            item.start();
        }
        //wait until all the planes are take of and laded..
        for (Thread item:planes){
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("air port is closed");
    }
}
