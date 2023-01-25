package java_problem.multi_threading.parallel;

public class NumberGeneratorHandler implements Runnable {
    private ParallelNumberGeneratorTask parallelNumberGeneratorTask;
    private int result;

    public NumberGeneratorHandler(ParallelNumberGeneratorTask parallelNumberGeneratorTask, int result) {
        this.parallelNumberGeneratorTask = parallelNumberGeneratorTask;
        this.result = result;
    }

    @Override
    public void run() {
        parallelNumberGeneratorTask.printNumber(result);
    }
}
