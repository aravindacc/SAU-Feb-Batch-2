package Task2;

public class MultipleThreads {
    public static void main(String args[]) throws Exception{
        ParagraphBuilder pb = new ParagraphBuilder();
        StringBuilder para1 = pb.getPara2();
        StringBuilder para2 = pb.getPara3();

        // Starting 2 threads
        WordCounter wordCounter1 = new WordCounter(para1);
        WordCounter wordCounter2 = new WordCounter(para2);

        long start = System.nanoTime();

        wordCounter1.start();
        wordCounter2.start();

        long end = System.nanoTime();
        System.out.println("Execution Time Taken: " + (end - start) + " nanoseconds");
    }
}