package Synchoronization;

public class Synchronization {

    private int count = 0;

//    public synchronized void increment() {
//        synchronized(this) {
//            count++;
//        }
//    }
    public synchronized void increment() {
        // synchronized method already locks on "this"
        count++;
    }

    public int getCount() {
        return count;
    }
}