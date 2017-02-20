package hashing;

//Find number repeated thrice
public class P10 {

	public static void main(String[] args) {
		int[] myArr = createSplArray();
		int ans = repeatedInt(myArr);
		System.out.println("Integer repeated thrice is: " + ans);
	}

	private static int repeatedInt(int[] myArr) {
		Map<Integer, Integer> intTable = new Map<>();
		for(int i = 0; i < myArr.length; i++){
			int key = myArr[i];
			if(intTable.get(key) == null){
				intTable.add(key, 1);
			}
			else{
				int value = intTable.get(key);
				intTable.add(key, ++value);
				if(value == 3)
					return key;
			}
		}
		return -1;
	}

	private static int[] createSplArray() {
		int[] myArr = new int[101];
		int i;
		
		//50 distinct
		for(i = 0; i < 50; i++){
			myArr[i] = i;
		}
		int counter = 24;
		int val = 50;
		
		//24 twice repeated
		while(counter > 0){
			myArr[i] = val;
			i++;
			myArr[i] = val;
			i++;
			val++;
			counter--;
		}
		
		//1 thrice repeated
		myArr[100] = 100;
		myArr[99] = 100;
		myArr[98] = 100;
		return myArr;
	}
}
