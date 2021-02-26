package Task2;

public class WithoutThread {
    public static void main(String args[]) {
        ParagraphBuilder pb = new ParagraphBuilder();
        StringBuilder para = pb.getPara1();

        WordCounter wordCounter = new WordCounter(para);
        long start = System.nanoTime();
        int totalWordsCount = wordCounter.totalWordCounter();
        long end = System.nanoTime();
        System.out.println("Number of words in the given paragraph are: " + totalWordsCount);
        System.out.println("Execution Time Taken: " + (end - start) + " nanoseconds");
    }
}
