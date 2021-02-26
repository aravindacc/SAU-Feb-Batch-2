package Task2;

public class WordCounter extends Thread{
    private StringBuilder para;

    WordCounter(StringBuilder para){
        this.para = para;
    }

    public int totalWordCounter(){
        int totalWordCount = 0;
        String arr[]= para.toString().split(" ");
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i].compareTo(" ") == 0 || arr[i].compareTo(".") == 0 || arr[i].compareTo(",") == 0 || arr[i].compareTo("!") == 0){
                continue;
            }
            totalWordCount += 1;
            //System.out.println(arr[i]);
        }
        return totalWordCount;
    }

    public void run()
    {
        System.out.println("Number of words in the given paragraph are: " + this.totalWordCounter());
    }
}