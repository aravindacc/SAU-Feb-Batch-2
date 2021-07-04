import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Count {
    static List<StringBuilder> string;

    public static int count_words(List<StringBuilder> string) {
        int word_count = 0;
        for(StringBuilder s: string) {
            String[] words = s.toString().split("\\s+");
            word_count += words.length;
        }
        return word_count;
    }

    public static void twoThreads() throws InterruptedException {
        Thread thread1 = new Thread1(string);
        Thread thread2 = new Thread2(string);

        long start_time = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("------------------------");
        System.out.println("With 2 Threads");
        System.out.println("Time: " + (System.currentTimeMillis()-start_time) + " ms");
        System.out.println("------------------------");
    }

    public static void threeThreads() throws InterruptedException {
        Thread thread1 = new Thread1(string);
        Thread thread2 = new Thread2(string);
        Thread thread3 = new Thread3(string);

        long start_time = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("------------------------");
        System.out.println("With 3 Threads");
        System.out.println("Time: " + (System.currentTimeMillis()-start_time) + " ms");
        System.out.println("------------------------");
    }

    public static void fourThreads() throws InterruptedException {
        Thread thread1 = new Thread1(string);
        Thread thread2 = new Thread2(string);
        Thread thread3 = new Thread3(string);
        Thread thread4 = new Thread4(string);

        long start_time = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("------------------------");
        System.out.println("With 4 Threads");
        System.out.println("Time: " + (System.currentTimeMillis()-start_time) + " ms");
        System.out.println("------------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        string = new ArrayList<>();
        for(int i=0;i<1000;i++) {
            int words_in_sentence = (int)(Math.random()*(15-5+1)+5);
            StringBuilder curr_sentence = new StringBuilder();
            for (int j=0;j<words_in_sentence;j++) {
                int word_length = (int)(Math.random()*(10)+1);
                StringBuilder curr_word = new StringBuilder();
                for(int k=0;k<word_length;k++) {
                    curr_word.append((char) (r.nextInt(26) + 'a'));
                }
                curr_word.append(" ");
                curr_sentence.append(curr_word);
            }
            string.add(curr_sentence);
        }

        long start_time = System.currentTimeMillis();
        int word_count = count_words(string);

        System.out.println("Words counted by " + Thread.currentThread().getName() + " are " + word_count);
        System.out.println("------------------------");
        System.out.println("With Only Main Thread");
        System.out.println("Time: " + (System.currentTimeMillis()-start_time) + " ms");
        System.out.println("------------------------");

        twoThreads();
        threeThreads();
        fourThreads();

//        for(StringBuilder s: string) {
//            System.out.println(s);
//        }
    }
}

class Thread1 extends Thread {
    List<StringBuilder> arr;

    public Thread1(List<StringBuilder> arr) {
        this.arr = arr;
    }

    public void run() {
        int word_count = Count.count_words(this.arr);
        System.out.println("Words counted by " + currentThread().getName() + " are " + word_count);
    }
}

class Thread2 extends Thread {
    List<StringBuilder> arr;

    public Thread2(List<StringBuilder> arr) {
        this.arr = arr;
    }

    public void run() {
        int word_count = Count.count_words(this.arr);
        System.out.println("Words counted by " + currentThread().getName() + " are " + word_count);
    }
}

class Thread3 extends Thread {
    List<StringBuilder> arr;

    public Thread3(List<StringBuilder> arr) {
        this.arr = arr;
    }

    public void run() {
        int word_count = Count.count_words(this.arr);
        System.out.println("Words counted by " + currentThread().getName() + " are " + word_count);
    }
}

class Thread4 extends Thread {
    List<StringBuilder> arr;

    public Thread4(List<StringBuilder> arr) {
        this.arr = arr;
    }

    public void run() {
        int word_count = Count.count_words(this.arr);
        System.out.println("Words counted by " + currentThread().getName() + " are " + word_count);
    }
}
