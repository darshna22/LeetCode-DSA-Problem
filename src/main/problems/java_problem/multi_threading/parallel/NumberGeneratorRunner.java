package java_problem.multi_threading.parallel;

public class NumberGeneratorRunner {
    public static void main(String[] args) {
        int noOfThread = 3;
        int totalNumberInSequence = 10;
        ParallelNumberGeneratorTask parallelNumberGeneratorTask = new ParallelNumberGeneratorTask(noOfThread, totalNumberInSequence);

        //thread-1 should print number that has reminder 1
        Thread t1 = new Thread(new NumberGeneratorHandler(parallelNumberGeneratorTask, 1), "Thread-1");
        //thread-2 should print number that has reminder 2
        Thread t2 = new Thread(new NumberGeneratorHandler(parallelNumberGeneratorTask, 2), "Thread-2");
        //thread-3 should print number that has reminder 0
        Thread t3 = new Thread(new NumberGeneratorHandler(parallelNumberGeneratorTask, 0), "Thread-3");

        t1.start();
        t2.start();
        t3.start();


    }
}
