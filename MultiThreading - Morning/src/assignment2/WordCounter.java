package assignment2;

public class WordCounter {
    String str;
    int lengthOfString = 0;
    WordCounter(String str) {
        this.str = str;
        this.lengthOfString = str.length();
    }
    int countNoofWords()
    {
        int cnt = 0;
        if (str == null || str.length() == 0 || str.isEmpty())
        {
            return cnt;
        }
        // Using regular expression to count number of words in a string.
        String[] words = str.split("\\s+");
        cnt = words.length;
        return  cnt;
    }
}