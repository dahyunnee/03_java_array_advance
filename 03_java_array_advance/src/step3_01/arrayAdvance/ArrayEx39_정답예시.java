package step3_01.arrayAdvance;
/*
 
 	# 중복 안된 숫자 제거
 	
	int[] test1 = {1,2,3,2,1};		
	int[] test2 = {1,3,4,4,2};
	int[] test3 = {1,1,1,2,1};
	// 위 배열에서 중복안된숫자를 제거하시요 
	// 1) {1,2,1,2}
	// 2) {4,4}
	// 3) {1,1,1,1}
	 
 */

public class ArrayEx39_정답예시 {

	public static void main(String[] args) {
		
		int[] test1  = {1,2,3,2,1};		
		int[] test2  = {1,3,4,4,2};
		int[] test3  = {1,1,1,2,1};
		int[] result = new int[5];
		int count = 0;
		
		for (int i=0; i<5; i++) {
			
			result[count] = test1[i];
			int check = 0;
			
			for (int n=0; n<5; n++) {				
				if ( i != n && result[count] == test1[n] ) {
					check = 1;				
				}
			}
			
			if (check == 1)	count++;
		
		}
		
		for (int i = 0 ; i < count ; i++ ) {
			System.out.println(result[i]);
		}

	}

}
