package step3_01.arrayAdvance;


/*
 *	# 2차원배열 기본문제[3단계]
*/

//2021.03.02 16:15 ~ 16:21
public class ArrayEx37_정답 {

	public static void main(String[] args) {
		
		int[][] arr = {
			{101, 102, 103, 104},
			{201, 202, 203, 204},
			{301, 302, 303, 304}
		}; 
		
		int[] garo = new int[3];
		int[] sero = new int[4];
		
		// 문제 1) 가로 합 출력
		// 정답 1) 410, 810, 1210
		
		for (int i = 0; i < arr.length; i++) {
			
			int sumofRow = 0;
			
			for (int j = 0; j < arr[i].length; j++) {
			
				sumofRow += arr[i][j];
				
				
			}
			
			System.out.print(sumofRow + " ");
		}
		
		System.out.println();
		
		// 문제 2) 세로 합 출력
		// 정답 2) 603, 606, 609, 612


		for (int i = 0; i < sero.length; i++) {
			
			int sumofColumn = 0;
			
			for (int j = 0; j < garo.length; j++) {
				
				sumofColumn += arr[j][i];
			}
		
			System.out.print(sumofColumn +" ");
		}

	}

}
