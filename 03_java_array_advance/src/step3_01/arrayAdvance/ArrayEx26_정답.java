package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* 
 * # 1 to 50[3단계] : 1 to 18
 * 
 * 1. 구글에서 1 to 50 이라고 검색한다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */

//2021.02.24 20:17 ~ 21:36
public class ArrayEx26_정답 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];		// 1 ~ 9
		int[] back  = new int[SIZE];		// 10 ~ 18
		
		int numberofAnswer = 0;
		

		for (int i = 0; i < SIZE; i++) {		//배열에 값 저장
			
			int randomIndex = rand.nextInt(9) ; // 0~8 랜덤 인덱스  
			
			if (front[randomIndex] != 0) {	//중복 값 나온 경우 제외
				
				i--;
				continue;
			}
			
			front[randomIndex] = i + 1;		//front배열의 랜덤인덱스에 1~9각각 저장
			back[randomIndex] = i + SIZE + 1; //같은 랜덤인덱스에 size만큼 차이나는 값 저장
			
		}
		
		
		
		int currentNumber = 1;		//인덱스 맞춰야하는 숫자
		
		while(true) {
										
	
			if (numberofAnswer == 2 * SIZE) break;
			
			//처음 그림판 출력 (즉, 1~9까지 숫자만 존재하는 그림판)
		
			
			for (int i = 0; i < SIZE; i++) {
					
				 
				if (back[i] <= currentNumber - 1) {
					if (i % 3 == 2) System.out.print("x"+ "\n");	
					else System.out.print("x" + "\t");
					
				}
				else if ( front[i] < currentNumber  ) { // 현재 맞춰야 할 값보다 front[i]의 수가 더 작아서 back배열에서 가져와야 하는 경우
					
					if (i % 3 == 2) System.out.print(back[i] + "\n");	
					else System.out.print(back[i] + "\t");
				}
				else {
						
					if (i % 3 == 2) System.out.print(front[i] + "\n");	
					else System.out.print(front[i] + "\t");
				}
					
			}
				
			
			//입력받기
			System.out.println();
			System.out.print(currentNumber + "의 인덱스를 고르세요 => ");
			int inputIndex = scan.nextInt();
			
			//정답이면
			if (front[inputIndex] == currentNumber || back[inputIndex] == currentNumber) {
				
				//isAnswer = true;
				numberofAnswer ++;
				currentNumber ++;
			}
			// else continue;
			
			
		}
		
		
		
	}
	
}
