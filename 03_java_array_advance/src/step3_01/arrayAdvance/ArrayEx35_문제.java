package step3_01.arrayAdvance;

/*
 *	# 2차원배열 기본문제[1단계]
*/

public class ArrayEx35_문제 {

	public static void main(String[] args) {

		int[][] arr = new int[3][3];
		
		int k = 1;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		
		//arr[0][0] = 10, [0][1] = 20, [0][2] = 30, 
		//arr[1][0] = 40, [1][1] = 50, [1][2] = 60, 
		//arr[2][0] = 70, [2][1] = 80, [2][2] = 90
		
		
		
		// 문제 1) 전체 합 출력
		// 정답 1) 450
		
		int sumofArray = 0;
		
		for ( int i = 0; i< 3 ; ++i) {
			for ( int j = 0; j < 3; ++j ) {
				
				sumofArray += arr[i][j];
			}
		}
		
		System.out.println(sumofArray);
		
		// 문제 2) 4의 배수만 출력
		// 정답 2) 20 40 60 80 
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr.length; j++) {
				
				if ( arr[i][j] % 4 == 0) System.out.print(arr[i][j] + " ");
			}
		}
		
		System.out.println();
		
		// 문제 3) 4의 배수의 합 출력
		// 정답 3) 200
		
		int sumof4multipleArray = 0; 
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr.length; j++) {
				
				if ( arr[i][j] % 4 == 0) sumof4multipleArray += arr[i][j];
			}
		}
		
		System.out.println(sumof4multipleArray);
		
		// 문제 4) 4의 배수의 개수 출력
		// 정답 4) 4

		int numberof4multipleArray = 0; 
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr.length; j++) {
				
				if ( arr[i][j] % 4 == 0) numberof4multipleArray ++;
			}
		}

		System.out.println(numberof4multipleArray);

	}

}
