package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * 
 * # 나만의 마블
 * 
 * P □ □ □ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ □ □ □ □
 * 
 * 
 * 정답의 소스를 컴파일 해보고 동작을 파악하여 코드를 작성하기.
 * 
 */

//2021.03.19 19:20 ~ 19:25
public class ArrayEx49_정답 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[][] map = {
				{0,   1,  2,  3, 4},	
				{15, 20, 20, 20, 5},
				{14, 20, 20, 20, 6},
				{13, 20, 20, 20, 7},
				{12, 11, 10,  9, 8}
			};
			
			int player = 0;
			
			
			while(true) {
				
				if (player > 15) {
					
					player -= 16;
				}
				
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						
						if (map[i][j] == player) {
							System.out.print("P ");
							continue;
						}
						
						if (map[i][j] != 20) System.out.print("□ ");
						else System.out.print("■ ");
					}
					
					System.out.println();
				}
				
				System.out.print("(1~3) : ");
				int getNumber = scan.nextInt();
				
				player += getNumber;
				
				
			}

	}

}
