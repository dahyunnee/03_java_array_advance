package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;

/*
 * # 중복숫자 금지[2단계]
 * 
 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
 * 2. 단 중복되는 숫자가 없어야 한다.
 */


//2021.02.25 21:10 ~ 21:17

public class ArrayEx28_정답 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		int[] arr = new int[5];
		int indexofArr = 0;
		
		while(true) {
			
			boolean isExist = false;
			if (indexofArr == arr.length) break;	//종료조건
			
			int randomNumber = rand.nextInt(10) + 1;
			
			for (int i = 0; i < arr.length; i++) {	//중복숫자 있는지 확인하기
				
				if (randomNumber == arr[i]) {
					
					isExist = true;		//중복 숫자 존재
					break;
				}
			}
			
			if (!isExist) arr[indexofArr ++] = randomNumber;		
			

		}
		
		System.out.println(Arrays.toString(arr));
	}
	
}
