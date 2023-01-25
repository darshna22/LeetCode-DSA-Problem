package java_problem.multi_threading.parallel;

public class ParallelNumberGeneratorTask {
    private int number = 1;
    private final int totalNumberInSequence;
    private final int noOfThread;

    ParallelNumberGeneratorTask(int noOfThread, int totalNumberInSequence) {
        this.noOfThread = noOfThread;
        this.totalNumberInSequence = totalNumberInSequence;
    }

    public void printNumber(int result) {
        synchronized (this) {
            while (number < totalNumberInSequence-1) {
                while (number % noOfThread != result) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //thread get cpu to perform his operation
                System.out.print(Thread.currentThread().getName()+" ");
                System.out.print(""+number+" ");
                //increase no and print same if matches to specific thread
                number++;
                //Wakes up all threads that are waiting on this object's monitor.
                // A thread waits on an object's monitor by calling one of the wait methods.
                notifyAll();
            }
        }
    }
}
