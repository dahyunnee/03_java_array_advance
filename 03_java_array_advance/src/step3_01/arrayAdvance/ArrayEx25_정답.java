package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * # 최대값 구하기[3단계]
 * 
 * 1. 가장 큰 값을 찾아 입력한다.
 * 2. 정답이면 해당 값을 0으로 변경한다.
 * 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
 * 예)
 * 11, 87, 42, 100, 24
 * 입력 : 100
 * 
 * 11, 87, 42, 0, 24
 * 입력 : 87
 * 
 * 11, 0, 42, 0, 24
 * 
 */

//2021.02.24 20:08 ~ 20:13
public class ArrayEx25_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {11, 87, 42, 100, 24};
		
		int numberofCorrection = 0;
		
		
		while (true) {
			
			System.out.println("현재 배열 : " + Arrays.toString(arr));
			
			if (numberofCorrection >= arr.length) {
				
				System.out.println("끝");
				break;
			}
			System.out.print("최대값을 입력하세요 => ");
			
			int inputMax = scan.nextInt();
			
			//배열에서 최댓값 찾기
			int maxnuminArray = arr[0];
			int maxindexinArray = 0;
			
			for (int i = 1; i < arr.length; i++) {
				
				if (arr[i] > maxnuminArray) {
					
					maxnuminArray = arr[i];
					maxindexinArray = i;
				}
			}
			
			//입력받은 값과 실제 최댓값 비교
			if (maxnuminArray == inputMax) { 		//정답이면 0으로바꿈
				
				arr[maxindexinArray] = 0;
				numberofCorrection ++;
			}
			else System.out.println("최댓값이 아닙니다. ");
			
			System.out.println();
	
		}
		
		
		scan.close();
		
	
	}
}
