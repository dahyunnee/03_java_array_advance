package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Scanner;

/*
 * # 숫자이동[2단계]
 * 
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 */


//2021.02.24 21:37 ~ 22:00
public class ArrayEx27_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] game = {0,0,1,0,2,0,0,1,0};
		int currentIndex = -1;
		
		
		
		for (int i = 0; i < game.length; i++) {		//현재 위치 찾기
			
			if (game[i] == 2) currentIndex = i;
		}
		
		
		while(true) {
			
			System.out.println(Arrays.toString(game));
			System.out.print("왼쪽(1) 또는 오른쪽(2)를 입력하세요 => ");
			int inputNumber = scan.nextInt();
			
			int previousIndex = currentIndex; 	//바뀌기 전에 현재 위치 저장
			
			if (inputNumber == 1) currentIndex --;
			else currentIndex ++;
				
			
			if (currentIndex < 0 || currentIndex > game.length - 1) {
				
				currentIndex = previousIndex;
				game[currentIndex] = 2;
				continue; 	//양 끝 도달
			}

			if (game[currentIndex] == 1 ) {		//벽 만난 경우
					
				System.out.print("벽을 격파하시려면 3을 입력하세요 => ");
				int answer = scan.nextInt();
					
				if (answer == 3 && currentIndex == 2) game[currentIndex] = 0; 	// 벽 격파
				else if(answer == 3 && currentIndex == 7) game[currentIndex] = 0;
				else {	
					currentIndex = previousIndex;
					continue;
				}
					
			}
			
			
				
			
			
			for (int i = 0; i < game.length; i++) {
				
				if (i == currentIndex) game[i] = 2;
			}
		
			game[previousIndex] = 0;	// 전의 위치 0으로 바꿔주기
			
		}
		
	}
	
}
