package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Scanner;
/*
 * # 숫자 야구 게임
 * 
 * 1. me에 1~9 사이의 숫자 3개를 저장
 *    (단, 중복되는 숫자는 저장 불가)
 * 2. com과 me를 비교해 정답을 맞출 때까지 반복
 * 3. 숫자와 자리가 같으면 		    strike += 1
 *    숫자만 같고 자리가 틀리면 	ball += 1
 * 예)
 * 정답 : 1 7 3
 * 3 1 5		: 2b
 * 7 5 1        : 1b
 * 1 5 6		: 1s
 * 1 7 3        : 1s 2b
 * 2 4 9        : 없음
 * 1 7 3        : 3s  > 게임종료
 */

//2021.02.25 21:18 ~ 21:44
public class ArrayEx29_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] com = {1,7,3};
		
		
		while(true) {		
			
			int[] me  = new int[3];
			
			int numberofStrike = 0;
			int numberofBall = 0;
			
			int indexofMe = 0;
			
		
			// 숫자 입력받아서 me 배열 만들기
			while(true) {
				
				
				boolean isExist = false;
				
				if (indexofMe == me.length ) break;
				
				System.out.print("1~9 사이의 숫자를 하나 입력하세요 => ");
				int inputNumber = scan.nextInt();
				
				for (int i = 0; i < me.length; i++) {		//중복숫자 있는지 확인
					
					if (inputNumber == me[i]) {
						
						isExist = true;
						System.out.println("중복되는 숫자는 불가능합니다.");
						System.out.println();
						break;
					}
				}
				
				if (isExist) continue;
				else me[indexofMe ++] = inputNumber;
				
			}
	
			System.out.println();
			
			// com과 비교하기
			
			for (int i = 0; i < me.length; i++) {		
				
				for (int j = 0; j < com.length; j++) {
					
					if (me[i] == com[j]) {
						
						if ( i == j) numberofStrike ++;
						else numberofBall ++;
					}
	
				}

			}
			
			if (numberofBall == 0 && numberofStrike == 0) System.out.println("없음");
			else {
				System.out.println(numberofBall + "볼, " + numberofStrike +"스트라이크");
			}
		
			if (numberofStrike == 3) {
				
				System.out.println("정답");
				break;
			}
			
			
			System.out.println();
		}
		
		
		
		
		
	}
	
}
