import java.util.HashMap;
import java.util.Map;

//Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
//This is a famous Google interview question, also being asked by many other companies now a days.
//
//Consider the following dictionary 
//{ i, like, sam, sung, samsung, mobile, ice, 
//  cream, icecream, man, go, mango}
//
//Input:  ilike
//Output: Yes 
//The string can be segmented as "i like".
//
//Input:  ilikesamsung
//Output: Yes
//The string can be segmented as "i like samsung" or "i like sam sung".

public class WordBreakProblem {

	public static void main(String[] args) {
//		wordBreakProblem("ilike");
//		wordBreakProblem("ilikesamsung");
//		wordBreakProblem("iliksam");
		
		wordBreakProblem("ilikesamsung");
		wordBreakProblem("iiiiiiii");
		wordBreakProblem("");
		wordBreakProblem("ilikelikeimangoiii");
		wordBreakProblem("samsungandmango");
		wordBreakProblem("samsungandmangok");
	}

	public static void wordBreakProblem(String sentence) {
		if (sentence == null || sentence.length() == 0) {
			System.out.println("Yes");
			return;
		}

		Integer[] dp = new Integer[sentence.length()];
		for (int i = 0; i < sentence.length(); i++) {
			dp[i] = -1;
		}

		if (doesDictContain(sentence.charAt(0) + "")) {
			dp[0] = 1;
		} else {
			dp[0] = 0;
		}

		for (int i = 1; i < sentence.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] == 1) {
					String rightWord = sentence.substring(j + 1, i + 1);
					if (doesDictContain(rightWord)) {
						dp[i] = 1;
					}
				}
			}
			if (dp[i] == -1) {
				dp[i] = 0;
			}
		}
		if(dp[sentence.length() - 1] == 1){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}

	private static boolean doesDictContain(String word) {
		Map<String, Boolean> dict = new HashMap<String, Boolean>();
		dict.put("i", true);
		dict.put("like", true);
		dict.put("sam", true);
		dict.put("sung", true);
		dict.put("samsung", true);
		dict.put("mobile", true);
		dict.put("ice", true);
		dict.put("cream", true);
		dict.put("icecream", true);
		dict.put("man", true);
		dict.put("go", true);
		dict.put("mango", true);

		if (dict.containsKey(word) && dict.get(word)) {
			return true;
		}
		return false;
	}
}
