package step3_01.arrayAdvance;

import java.util.Scanner;

/*
문제1) 숫자 0이 플레이어이다. 
	    
	    1) left 2)right 3)up 4)down 5)되감기
		번호를 입력받고 해당위치로 이동 ==> 이동할때 값을 서로 교환한다. 
		 예) 1 ==> 
		
	    {1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,0,15}		
		 
		
문제2) 심화  ==> 한칸한칸이동할때마다 yx 에 배열에 이동한경로를 저장했다가 
 	5번입력시 ==> 왔던길로 되돌아가기 한다.
 	
*/

public class ArrayEx47_테스트문제정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int game[][] = {
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,0}
				};
		
		int yx [][] = new int[10000][2];
		
		//현재 위치
		int currentRow = game.length - 1;
		int currentCol = game[0].length - 1;
		
		int firstcurrentRow2 = -1;
		int firstcurrentCol2 = -1;
		
		
		int movetoValue = -1;
		
		int count = 0;
		
		int[] movingValue = new int[5];
		
		//1번
		System.out.println("[ 1번 ]");
		while(true) {

			System.out.println(count);
			System.out.println();
			for (int i = 0; i < game.length; i++) {
				
				for (int j = 0; j < game[i].length; j++) {
					
					if ( count % 5 == 0  && game[i][j] == 0) {	//5번 기준 처음위치 저장
						
						yx[count][0] = i;
						yx[count++][1] = j;
						
					}
					
					System.out.print(game[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			int prevCol = currentCol;
			int prevRow = currentRow;
			
			
			
			//2번과 결합 
			if ( (count-2) % 5 == 0 && count != 2) {
				
				System.out.println("5번 입력해서 왔던 길로 되돌아 갑니다. ");
				
				//돌아가기
				// i = count - 5 ~ count - 1
				for (int i = count - 3 ; i > count - 8; i--) {
					
					System.out.println("i = " + i);
					//현재위치 찾기
				
					int currentRow2 = -1;
					int currentCol2 = -1;
					
					for (int j = 0; j < game.length; j++) {
						for (int j2 = 0; j2 < game.length; j2++) {
							
							if ( game[j][j2] == 0) {
								
								currentRow2 = j;
								currentCol2 = j2;
							}
						}
					}
					
					
					//위치바꾸기
					
					int movetoRow = yx[i][0];
					int movetoCol = yx[i][1];
					
					int tempNumber = game[movetoRow][movetoCol];
					
					game[movetoRow][movetoCol] = 0;
					game[currentRow2][currentCol2] = tempNumber; 
					
					
					for (int j = 0; j < game.length; j++) {
						
						for (int j2 = 0; j2 < game[j].length; j2++) {
							
							System.out.print(game[j][j2] + " ");
						}
						System.out.println();
					}
					System.out.println();
					
					currentRow = movetoRow;
					currentCol = movetoCol;
					
					System.out.println(currentRow + "/" + currentCol);
						
				}
				
				

				
			}
			
			System.out.print("1) left 2)right 3)up 4)down 5)되감기 6) 종료    => ");
			int getNumber = scan.nextInt();
			
			if (getNumber <= 0 || getNumber > 6) {
				
				System.out.println("다시 선택해주세요 (1 ~ 6 )");
				System.out.println();
				continue;
			}
			
			
			if (getNumber == 1 || getNumber == 2 ) {
				
				
				if ( getNumber == 1 ) {
					
					if ( currentCol != 0 ) currentCol --;
					
					 
				}
			
				
				else {
					
					if ( currentCol != game.length - 1) currentCol ++;
				}
				
				movetoValue = game[currentRow][currentCol]; 
				game[currentRow][currentCol] = 0;
				game[currentRow][prevCol] = movetoValue;
				
				
				yx[count][0] = currentRow;
				yx[count ++][1] = currentCol; 

				continue;
			}
			
			if (getNumber == 3 || getNumber == 4 ) {
			
				if ( getNumber == 3 ) {
					
					if ( currentRow != 0 ) currentRow --;
				}
				
				else {
					
					if ( currentRow != game.length - 1) currentRow ++;
				}
				
				movetoValue = game[currentRow][currentCol]; 
				game[currentRow][currentCol] = 0;
				game[prevRow][currentCol] = movetoValue;
				
				yx[count][0] = currentRow;
				yx[count++][1] = currentCol;
				
				continue;
			}
			
	
			if ( getNumber == 5 ) {
				
				if ( currentRow != game.length - 1 && currentCol != game[0].length - 1) {
					
					
					for (int i = 0; i < game.length; i++) {
						for (int j = 0; j < game[i].length; j++) {
							
							if (game[i][j] == movetoValue) game[i][j] = 0;
						}
					}
					
					game[currentRow][currentCol] = movetoValue;	
					
				}
				
				yx[count][0] = currentRow;
				yx[count ++][1] = currentCol;
				
				continue;
			}
			
			if (getNumber == 6) break;
			
			
			
			
		}
		
		
		
	
		

	}

}
