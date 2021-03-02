package step3_01.arrayAdvance;

import java.util.Arrays;

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


//2021.03.02 18:26 ~ 18:44
public class ArrayEx39_정답 {

	public static void main(String[] args) {
		
		int[] test1  = {1,2,3,2,1};
		int[] test2  = {1,3,4,4,2};
		int[] test3  = {1,1,1,2,1};
		int[] result = new int[5];
		

		int indexofTest1 = 0;
		int indexofTest2 = 0;
		int indexofTest3 = 0;
		
		for (int i = 0; i < test1.length; i++) {
		
			
			for (int j = 0; j < result.length; j++) {
				
				if ( i == j ) continue;
				
				if (test1[i] == test1[j]) {
					
					result[indexofTest1 ++] = test1[i];
					break;
				}
			}
		}
		
		
		int[] result1_1 = new int[indexofTest1 --];
		
		for (int i = 0; i < result.length; i++) {
			
			if(result[i] != 0 ) {
				
				result1_1[i] = result[i];
			}
			else break;
		}
		
		test1 = result1_1;
		
		System.out.println(Arrays.toString(test1));
		
		result = new int[5];
		
		
		for (int i = 0; i < test2.length; i++) {
			
			
			for (int j = 0; j < result.length; j++) {
				
				if ( i == j ) continue;
				
				if (test2[i] == test2[j]) {
					
					result[indexofTest2 ++] = test2[i];
					break;
				}
			}
		}
		
		
		int[] result2_2 = new int[indexofTest2 --];
		
		for (int i = 0; i < result.length; i++) {
			
			if(result[i] != 0 ) {
				
				result2_2[i] = result[i];
			}
			else break;
		}
		
		test2 = result2_2;
		
		System.out.println(Arrays.toString(test2));
		
		
		
		result = new int[5];
		
		for (int i = 0; i < test3.length; i++) {
			
			
			for (int j = 0; j < result.length; j++) {
				
				if ( i == j ) continue;
				
				if (test3[i] == test3[j]) {
					
					result[indexofTest3 ++] = test3[i];
					break;
				}
			}
		}
		
		
		int[] result3_3 = new int[indexofTest3 --];
		
		for (int i = 0; i < result.length; i++) {
			
			if(result[i] != 0 ) {
				
				result3_3[i] = result[i];
			}
			else break;
		}
		
		test3 = result3_3;
		
		System.out.println(Arrays.toString(test3));
		
		
		
		
	}

}
