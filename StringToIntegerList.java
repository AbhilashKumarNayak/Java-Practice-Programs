package programs;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerList {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("as");
        ls.add("123");
        ls.add("32");
        ls.add("2as");

        List<Integer> iList = new ArrayList<>();

        for (String str : ls) {
            try {
                int num = Integer.parseInt(str);
                iList.add(num);
            } catch (NumberFormatException e) {
                // Ignore if the string is not a valid integer
            }
        }

        System.out.println("Original List: " + ls);
        System.out.println("Integer List: " + iList);
    }
}

