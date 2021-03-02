package step3_01.arrayAdvance;

import java.util.Arrays;

/*
 * # 정렬하기
 * 
 * 1. 인덱스 0번이 나머지를 검사한다.
 * 2. 제일 큰 값을 찾아 교환한다.
 * 3. 인덱스 1증가한다.
 * 4. [1~3]을 끝까지 반복한다.
 * 예)
 * 10, 50, 30, 40, 80, 7
 * 80, 50, 30, 40, 10, 7
 * 80, 50, 30, 40, 10, 7
 * 80, 50, 40, 30, 10, 7
 */

//2021.02.27 20:17 ~ 20:31
public class ArrayEx31_정답 {

	public static void main(String[] args) {
		
		int[] scores = {10, 50, 30, 40, 80, 7};

		
		for (int i = 0; i < scores.length - 1; i++) {	//5번 반복
			
			int maxNum = scores[i];
			int maxIndex = i;
			
			for (int j = i+1; j < scores.length ; j++) {
				
				if ( scores[j] > maxNum) {
					
					maxNum = scores[j];
					maxIndex = j;
					
				}
			}
			
			if (maxIndex != i) {		//수 교환
				
				int temp = scores[i];
				scores[i] = maxNum;
				scores[maxIndex] = temp;
				
			}
			
			
			System.out.println(Arrays.toString(scores));
		}
		
	}

}
