package dynamicProgramming;

//https://www.youtube.com/watch?v=3hcaVyX00_4
//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EggDropping.java
public class EggDroppingProblem {

	public static void main(String[] args) {
		int floors = 10;
		int eggs = 2;
		
		int T[][] = new int[eggs+1][floors+1];
        int c =0;
        for(int i=0; i <= floors; i++){
            T[1][i] = i;
        }
        
        for(int e = 2; e <= eggs; e++){
            for(int f = 1; f <=floors; f++){
            	//default set to highest
                T[e][f] = Integer.MAX_VALUE;
                for(int k = 1; k <=f ; k++){
                	//arg 1 : in case the egg breaks; then we need to search for the floors less than current floor
                	//arg 2 : eggs doesn't break; so we look at floors remaining
                    c = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    //get the minimum for all the cases regarding a single cell in the matrix
                    if(c < T[e][f]){
                        T[e][f] = c;
                    }
                }
            }
        }
        
        System.out.println("Trails required is " + T[eggs][floors]);
		
	}

}
