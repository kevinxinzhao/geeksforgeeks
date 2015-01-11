//Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. 
//X is the summation of values on each face when all the dice are thrown.
//
//The Naive approach is to find all the possible combinations of values from n dice and keep on counting the results that sum to X.

// 3 dice, 6 face, SUM X = 8
public class DiceThrow {

	public static void main(String[] args) {
		System.out.println(getNumberOfWays(2, 4, 1));
		System.out.println(getNumberOfWays(2, 2, 3));
		System.out.println(getNumberOfWays(3, 6, 8));
		System.out.println(getNumberOfWays(2, 4, 5));
		System.out.println(getNumberOfWays(3, 4, 5));
	}

	public static int getNumberOfWays(int numberOfDices, int numberOfFaces, int SUM) {
		if (numberOfDices * numberOfFaces < SUM) {
			return 0;
		}
		if (numberOfDices * 1 > SUM) {
			return 0;
		}

		// row 0 and column 0 are never used
		int[][] dp = new int[numberOfDices + 1][SUM + 1];

		for (int j = 1; j <= numberOfFaces && j < SUM; j++) {
			dp[1][j] = 1;
		}
		for (int row = 2; row <= numberOfDices; row++) {
			for (int column = 1; column <= SUM; column++) {
				for (int k = 1; k <= column && k < SUM; k++) {
					dp[row][column] += dp[row - 1][SUM - k];
				}
			}
		}
		return dp[numberOfDices][SUM];
	}
}
