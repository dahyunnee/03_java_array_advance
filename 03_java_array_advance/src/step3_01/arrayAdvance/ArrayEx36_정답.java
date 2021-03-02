package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 *	# 2차원배열 기본문제[2단계]
*/

//2021. 02. 27 21: 00 ~ 21:16
public class ArrayEx36_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] arr = new int[3][3];
		
		int k = 1;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
		//		   값 출력 : 60 
		System.out.print("인덱스1 입력 : ");
		int inputIndex1 = scan.nextInt();
		
		System.out.print("인덱스2 입력 : ");
		int inputIndex2 = scan.nextInt();
		
		System.out.println(arr[inputIndex1][inputIndex2]);
		
		
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예    2) 값 입력 : 60
		//		   인덱스1 출력 : 1	인덱스2 출력 : 2
		
		System.out.print("값 입력 : ");
		int inputValue = scan.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				
				if ( arr[i][j] == inputValue ) {
					
					System.out.println("인덱스 1 : " + i + ", 인덱스 2 : " + j);
				}
			}
		}
	
		// 문제 3) 가장 큰 값의 인덱스 2개 출력
		// 정답 3) 2 2
		
		int maxNum = arr[0][0];
		int maxI = 0;
		int maxJ = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 1; j < arr.length; j++) {
				
				if ( maxNum < arr[i][j]) {
					
					maxNum = arr[i][j];
					maxI = i;
					maxJ = j;
					
				}
			}
		}
		
		System.out.println("인덱스 1 : " + maxI + ", 인덱스 2 : " + maxJ);
		
		// 문제 4) 값 2개를 입력받아 값 교체

		System.out.print("값1 입력 : ");
		int inputValue1 = scan.nextInt();
		
		System.out.print("값2 입력 : ");
		int inputValue2 = scan.nextInt();

		int i1 = -1; 
		int i2 = -1;
		
		int j1 = -1;
		int j2 = -1;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				
				if ( arr[i][j] == inputValue1 ) {
					
					i1 = i;
					i2 = j;
					
				}
				else if ( arr[i][j] == inputValue2 ) {
					
				
					j1 = i;
					j2 = j;
				}
			}
		}
		
		int temp = arr[i1][i2];
		arr[i1][i2] = arr[j1][j2];
		arr[j1][j2] = temp;
		
		System.out.println("값1 " + arr[i1][i2]);
		System.out.println("값2 " + arr[j1][j2]);

	}

}
