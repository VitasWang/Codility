package DynamicPrograming;

public class MakeChange {
	public static void dpMakeChange(int[] coinValueList, int change, int[] minCoins, int[] coinsUsed){
		for(int cents = 1; cents < change+1; cents++){
			int coinCount = cents;
			int lastCoin = coinValueList[0];
			int i = 0;
			while(i < coinValueList.length && coinValueList[i] <= cents){
				if(minCoins[cents-coinValueList[i]] + 1 < coinCount){
					coinCount = minCoins[cents-coinValueList[i]] + 1;
					lastCoin = coinValueList[i];
				}
				i++;
			}
			minCoins[cents] = coinCount;
			coinsUsed[cents] = lastCoin;
		}
		
		System.out.println(minCoins[change]);
	}
	public static void printCoins(int[] coinsUsed, int change){
		while (change > 0){
			int thisCoin = coinsUsed[change];
			System.out.print(thisCoin + " ");
			change -= thisCoin;
		}
	}
	public static void main(String[] args){
		int[] minCoins = new int[64];
		int[] coinsUsed = new int[64];
		for(int i = 0; i < minCoins.length; i++){
			minCoins[i] = 0;
			coinsUsed[i] = 0;
		}
		dpMakeChange(new int[]{1, 5, 10, 25}, 63, minCoins, coinsUsed);
		printCoins(coinsUsed, 63);
	}
}


