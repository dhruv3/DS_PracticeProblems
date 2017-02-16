package hashing;

//Check if 2 Arrays have same elements
public class P7 {

	public static void main(String[] args) {
		int[] arrOne = {1, 2, 2, 2, 5, 2, 5};
		int[] arrTwo = {1, 2, 2, 2, 2, 5};
		
		Boolean ans = checkArr(arrOne, arrTwo);
		
		if(ans)
			System.out.println("Arrays are same");
		else
			System.out.println("Arrays are different");		
	}

	private static Boolean checkArr(int[] arrOne, int[] arrTwo) {
		
		Map<Integer, Integer> intCounter = new Map<>();
		for(int i=0;i<arrOne.length;i++){
			if(intCounter.get(arrOne[i]) == null){
				intCounter.add(arrOne[i], 1);
			}
			else{
				int val = intCounter.get(arrOne[i]);
				intCounter.add(arrOne[i], ++val);
			}
		}
         
		
		for(int i=0;i<arrTwo.length;i++){
			if(intCounter.get(arrTwo[i]) == null){
				return false;
			}
			else{
				int val = intCounter.get(arrTwo[i]);
				intCounter.add(arrTwo[i], --val);
			}
		}
		
		for(int i=0;i<arrTwo.length;i++){
			if(intCounter.get(arrTwo[i]) != 0){
				return false;
			}
		}
		
		return true;
	}

}
