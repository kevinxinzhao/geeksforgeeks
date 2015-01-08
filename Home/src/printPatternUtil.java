
//Print all possible strings that can be made by placing spaces
//
//Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.
//
//Input:  str[] = "ABC"
//Output: ABC
//        AB C
//        A BC
//        A B C

public class printPatternUtil {
	
	public static void printAllPossibleCombination(String input){
		if(input == null || input.length() == 0){
			return;
		}
		printAllPossibleCombinationHelper(input.substring(0, 1), input.substring(1));
	}
	
	public static void printAllPossibleCombinationHelper(String prefix, String suffix){
		if(suffix.isEmpty()){
			System.out.println(prefix);
		}else{
			String firstChar = suffix.substring(0, 1);
			printAllPossibleCombinationHelper(prefix + firstChar, suffix.substring(1));
			printAllPossibleCombinationHelper(prefix + " " + firstChar, suffix.substring(1));
		}
	}
	
	public static void main(String[] args){
		printAllPossibleCombination("abcd");
	}
}
