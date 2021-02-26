package Task2;

public class SingleThread {
    public static void main(String args[]) throws Exception{
        ParagraphBuilder pb = new ParagraphBuilder();
        StringBuilder para = pb.getPara1();

        // Starting Thread
        WordCounter wordCounter = new WordCounter(para);
        long start = System.nanoTime();
        wordCounter.start();
        long end = System.nanoTime();
        System.out.println("Execution Time Taken: " + (end - start) + " nanoseconds");
    }
}