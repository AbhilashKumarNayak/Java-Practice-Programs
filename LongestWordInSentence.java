package programs;

public class LongestWordInSentence {
    public static void main(String[] args) {
        String sentence = "I am interested to grow in my organization";
        String longestWord = findLongestWord(sentence);
        System.out.println("Longest word: " + longestWord);
    }

    private static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}

