package programs;

import java.util.HashMap;
import java.util.Map;

public class CharacterOccurrences {
    public static void main(String[] args) {
        String word = "organization";
        Map<Character, Integer> occurrences = countCharacterOccurrences(word);

        System.out.println("Character Occurrences:");
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static Map<Character, Integer> countCharacterOccurrences(String word) {
        Map<Character, Integer> occurrences = new HashMap<>();

        for (char ch : word.toCharArray()) {
            occurrences.put(ch, occurrences.getOrDefault(ch, 0) + 1);
        }

        return occurrences;
    }
}
