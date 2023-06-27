package programs;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Permutations:");
        generatePermutations(input);
    }

    private static void generatePermutations(String str) {
        generatePermutationsHelper(str, 0, str.length() - 1);
    }

    private static void generatePermutationsHelper(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                generatePermutationsHelper(str, left + 1, right);
                str = swap(str, left, i); // backtrack to restore the original order
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

