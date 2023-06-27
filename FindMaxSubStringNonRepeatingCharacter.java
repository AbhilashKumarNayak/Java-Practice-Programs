package programs;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSubStringNonRepeatingCharacter {

	public static void main(String[] args) {

		String input = "sampathy";
		int maxLength = Integer.MIN_VALUE;
		// int minLength=0;

		char[] charArray = input.toCharArray();
		String maxSub = "";

		Map<String, Integer> map1 = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {

			if (maxSub.contains(Character.toString(charArray[i]))) {
				map1.put(maxSub, maxLength = maxSub.length());
				i = input.indexOf(charArray[i]);
				maxSub = "";
			} else
				maxSub = maxSub + charArray[i];

		}
		map1.put(maxSub, maxLength = maxSub.length());

		map1.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(entry -> {
			System.out.println(entry.getKey());
		});

	}

}
