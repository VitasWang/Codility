//topic:
//In a given array, find the subset of maxmal sum in which the distance 
//between consecutive elements is at most 6

public class NumberSolitaire {
	public int solution(int[] A){
		int[] dp = new int[A.length];
		for(int i = 0; i < A.length; i++){
			dp[i] = Integer.MIN_VALUE;
		}
		
		dp[0] = A[0];
		for(int i = 1; i < A.length; i++){
			int max = dp[i-1];
			int loop = 1;
			while(loop <= 6 && i - loop >= 0){
				max = Math.max(dp[i - loop], max);
				loop++;
			}
			dp[i] = max + A[i];
		}
		return dp[A.length -1];
	}
}
