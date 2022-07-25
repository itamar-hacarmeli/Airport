package Plane;

public class Plane implements Runnable {
    private int id;
    public static Object kushKush = new Object();

    public Plane(int id) {
        this.id = id;
        System.out.println("plane #"+this.id+" is now in the air port");
    }

    @Override
    public void run() {
        System.out.println("plane #"+this.id+" wants to take off" );
        synchronized (kushKush) {
            takeOff();
        }
        System.out.println("plane #"+this.id+" is in the air");
        fly();
        synchronized (kushKush) {
            System.out.println("plane #"+this.id+"wants to land");
            land();
        }

    }

    public void takeOff() {
        System.out.println("plane #"+this.id+" is taking off");

    }

    public void fly() {
        int flyTime = (int)(Math.random()*2000)+2000;
        System.out.println("plane #"+this.id+" is flying"+(flyTime%1000)+" sec.");

        try {
            Thread.sleep(flyTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void land() {
        System.out.println("plane #"+this.id+" is landing");

    }
}
