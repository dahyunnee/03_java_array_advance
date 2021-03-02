package step3_01.arrayAdvance;

import java.util.Arrays;

/*
 * # 석차 출력
 * 
 * . 성적 순으로 이름 출력
 */

//2021.02.27 20:50 ~ 20:59
public class ArrayEx32_정답 {
	public static void main(String[] args) {

		String[] names = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
		int[] scores   = {    87,    42,    100,     11,     98};
		
	
		for (int i = 0; i < scores.length - 1; i++) {	//5번 반복
			
			int maxNum = scores[i];
			int maxIndex = i;
			String maxName = names[i];
			
			for (int j = i+1; j < scores.length ; j++) {
				
				if ( scores[j] > maxNum) {
					
					maxNum = scores[j];
					maxName = names[j];
					
					maxIndex = j;
			
				}
			}
			
			if (maxIndex != i) {		//수 교환
				
				int temp = scores[i];
				String temp2 = names[i];
				
				scores[i] = maxNum;
				names[i] = maxName;
						
				scores[maxIndex] = temp;
				names[maxIndex] = temp2;
				
				
				
			}
			
			
		
		
	}
		System.out.println(Arrays.toString(names));

	}
}
