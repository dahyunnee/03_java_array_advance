package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;

/*
 * # 1부터 5사이의 랜덤 숫자를 2개씩 arr 배열에 저장하기
 * 예) 1 3 2 1 4 4 5 2 3 5
 * 
 *  - 1부터 5까지 숫자를 2개씩 넣고 셔플로 이용해서 섞지 말것
 * 
 */

public class ArrayEx46_테스트문제정답 {

	public static void main(String[] args) {

		Random rand = new Random();
		
		int[] arr = new int[10];
	
		
		for (int i = 0; i < 2; i++) {
			
			for (int j = 1; j < 6; j++) {
				
				int randomNumber = rand.nextInt(arr.length);
				
				if (arr[randomNumber] == 0) arr[randomNumber] = j;
				else j --;
				
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		
		
		

		
		
		
	}

}
