package programs;

public class MaxVowelsWords {
    public static void main(String[] args) {
        String input = "The quick brown foox jumaaaps right over the little lazy dog.";

        int maxVowelCount = 0;
        String[] words = input.split("\\s");
        StringBuilder maxVowelWords = new StringBuilder();

        for (String word : words) {
            int vowelCount = countVowels(word);
            if (vowelCount > maxVowelCount) {
                maxVowelCount = vowelCount;
                maxVowelWords = new StringBuilder(word);
            } else if (vowelCount == maxVowelCount) {
                maxVowelWords.append(", ").append(word);
            }
        }

        System.out.println("Maximum Number of Vowels: " + maxVowelCount);
        System.out.println("Words with maximum number of vowels: " + maxVowelWords);
    }

    private static int countVowels(String word) {
        word = word.toLowerCase();
        int vowelCount = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }
        return vowelCount;
    }
}

