package step3_01.arrayAdvance;

import java.util.Scanner;

// #오목


//2021.02.25 19:10 ~ 19:50
public class ArrayEx42_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int size = 10;
		int[][] omok = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0}
		};

		int p1Y = 0;
		int p1X = 0;
		int p2Y = 0;
		int p2X = 0;
		int turn = 0;		// 0->P1턴, 1->P2턴
		int win = 0;		// 1-> P1승리, 2 -> P2승리
		
		
		
		while (true) {
				
			//게임판 출력
			System.out.println(" ===== 오목게임 =====");
			System.out.print("  ");
			for (int i = 0; i < omok.length; i++) {
				
				System.out.print(i + " ");
			}
			
			System.out.println();
			
			for (int i = 0; i < omok.length; i++) {
				
				System.out.print(i + " ");
				for (int j = 0; j < omok.length; j++) {
					
					System.out.print(omok[i][j] + " ");
				}
				System.out.println();
			}
			
			//승자 있는지 확인
			if (win == 1) {
				
				System.out.println("[P1] 승리");
				break;
			}
			else if (win == 2) {
				
				System.out.println("[P2] 승리");
				break;
			}
			
			//p1 좌표 입력받기
			if (turn == 0) {
				
				System.out.println("[P1]");
				System.out.print("[P1] X좌표 => ");
				p1X = scan.nextInt();
				
				if (p1X < 0 || p1X >= omok.length) {
					
					System.out.println("잘못된 좌표. 다시 입력해주세요");
					continue;
				}
				
				System.out.print("[P1] Y좌표 => ");
				p1Y = scan.nextInt();
				
				if (p1Y < 0 || p1Y >= omok.length) {
					
					System.out.println("잘못된 좌표. 다시 입력해주세요");
					continue;
				}
				
				if ( omok[p1X][p1Y] == 0) {		//가능한 곳인 경우
					
					omok[p1X][p1Y] = 1;
					turn = 1;
				}
				else {
					System.out.println("불가능한 곳");
					
				}
			}
			
			else {
				
				//p2 좌표 입력받기
				
				System.out.println("[P2]");
				System.out.print("[P2] X좌표 => ");
				p2X = scan.nextInt();
				if (p2X < 0 || p2X >= omok.length) {
					
					System.out.println("잘못된 좌표. 다시 입력해주세요");
					continue;
				}
				
				System.out.print("[P2] Y좌표 => ");
				p2Y = scan.nextInt();
				
				if (p2Y < 0 || p2Y >= omok.length) {
					
					System.out.println("잘못된 좌표. 다시 입력해주세요");
					continue;
				}
				
				if ( omok[p2X][p2Y] == 0) {		//가능한 곳인 경우 
					
					omok[p2X][p2Y] = 2;
					turn = 0;
				}
				else {
					System.out.println("불가능한 곳");
					
				}
			}
			
			//승자 있는지 확인.
			
			for (int i = 0; i < omok.length; i++) {				//가로 확인
				for (int j = 0; j < omok.length - 4; j++) {
					
					if (omok[i][j] == 1 && omok[i][j + 1] == 1 && omok[i][j + 2] == 1 && omok[i][j + 3] == 1 && omok[i][j+4] == 1) win = 1;
					else if (omok[i][j] == 2 && omok[i][j + 1] == 2 && omok[i][j + 2] == 2 && omok[i][j + 3] == 2 && omok[i][j+4] == 2) win = 2;
				} 
			}
			
			for (int i = 0; i < omok.length; i++) {				//세로 확인
				for (int j = 0; j < omok.length - 4; j++) {
					
					if (omok[j][i] == 1 && omok[j+1][i] == 1 && omok[j+2][i] == 1 && omok[j+3][i] == 1 && omok[j+4][i] == 1) win = 1;
					else if (omok[j][i] == 2 && omok[j+1][i] == 2 && omok[j+2][i] == 2 && omok[j+3][i] == 2 && omok[j+4][i] == 2) win = 2;
				}
			}
			
//			  0 1 2 3 4 5 6 7 8 9			
//			0{0,0,0,0,0,0,0,0,0,0},
//			1{0,0,0,0,0,0,0,0,0,0},
//			2{0,0,0,0,0,0,0,0,0,0},
//			3{0,0,0,0,0,0,0,0,0,0},
//			4{0,0,0,0,0,0,0,0,0,0},
//			5{0,0,0,0,0,0,0,0,0,0},
//			6{0,0,0,0,0,0,0,0,0,0},
//			7{0,0,0,0,0,0,0,0,0,0},
//			8{0,0,0,0,0,0,0,0,0,0},
//			9{0,0,0,0,0,0,0,0,0,0}
			
			// (0,0 1,1 2,2 3,3 4,4) ~ (5,5 6,6 7,7, 8,8 9,9)
			// (0,9 ~ 4,5 ) ~ ( 5,4 ~ 9,0)
			
			for (int i = 0; i < omok.length - 4; i++) {				//대각선 확인 (왼 -> 오)
				for (int j = 0; j < omok.length - 4; j++) {
					// i = 0 ~ 5 / j = 0 ~ 5 
					if ( omok[i][j] == 1 && omok[i+1][j+1] == 1 && omok[i+2][j+2] == 1 && omok[i+3][j+3] == 1 & omok[i+4][j+4] == 1) win = 1;
					else if ( omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 & omok[i+4][j+4] == 2) win = 2;
				}
			}
			
			for (int i = 0; i < omok.length - 4; i++) {				//대각선 확인 (오 -> 왼)
				for (int j = omok.length - 1; j >= omok.length - 4; j--) {
					
					// i = 0~5 j = 9 ~5
					if ( omok[i][j] == 1 && omok[i+1][j-1] == 1 && omok[i+2][j-2] == 1 && omok[i+3][j-3] == 1 & omok[i+4][j-4] == 1) win = 1;
					else if ( omok[i][j] == 2 && omok[i+1][j-1] == 2 && omok[i+2][j-2] == 2 && omok[i+3][j-3] == 2 & omok[i+4][j-4] == 2) win = 2;
				}
			}
			

			
		}
 
		scan.close();

	}

}
