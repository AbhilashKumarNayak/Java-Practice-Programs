package programs;

public class ReverseStringWithSpecialChars {
    public static void main(String[] args) {
        String input = "Swa$pn&il";
        String reversed = reverseStringWithSpecialChars(input);
        System.out.println("Reversed String: " + reversed);
    }

    private static String reverseStringWithSpecialChars(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return String.valueOf(chars);
    }
}

