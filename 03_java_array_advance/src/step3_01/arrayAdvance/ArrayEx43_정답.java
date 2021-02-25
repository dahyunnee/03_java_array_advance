package step3_01.arrayAdvance;

import java.util.Random;
import java.util.Scanner;

// # 소코반


//2021.02.25 20:15 ~ 21:10
public class ArrayEx43_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;		// 0~6까지 배열
		final int PLAYER = 2;
		final int BALL = 3;
		final int GOAL = 7;
		final int WALL = 9;
		
		int[][] map = new int[SIZE][SIZE];
		
		int wallCount = 0;
		int pY = 0;
		int pX = 0;
		int ballY = 0;
		int ballX = 0;
		int goalY = 0;
		int goalX = 0;
		
		
		
		//벽 개수 입력받기
		System.out.print("설치할 벽의 개수를 입력하세요 => ");
		wallCount = scan.nextInt();
		
	
		//벽 만들기
		for (int i = 0; i < wallCount; i++) {
			
			int wallX = ran.nextInt(SIZE);  	// 0 ~ 6
			int wallY = ran.nextInt(SIZE);
			
			if (map[wallX][wallY] == 0) map[wallX][wallY] = WALL;		//좌표가 0인 경우에만 벽 설치 가능함
			else i--;
		}
		
		// 골 위치 정하기
		
		while(true) {
			
			goalX = ran.nextInt(SIZE);
			goalY = ran.nextInt(SIZE);
			
			if (map[goalX][goalY] == 0) {
				
				map[goalX][goalY] = GOAL;
				break;
			}
		}
		
		// 공 위치 정하기
		
		while(true) {
			
			ballX = ran.nextInt(SIZE - 1) + 1; // 1~5로 설정 ( 가장자리에 놓지 않기 위해)
			ballY = ran.nextInt(SIZE - 1) + 1;
			
			if (map[ballX][ballY] == 0) {
				
				map[ballX][ballY] = BALL;
				break;
			}
		}
		
		//초기 위치 출력
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				
				System.out.print(map[i][j] + " ");
				
				if (j == map.length - 1) System.out.println();
			}
		}
		
		
		// 사용자 위치 입력받기
		
		System.out.println();
		
		while(true) {
			
			System.out.print("사용자의 X인덱스를 입력하세요 => ");
			pX = scan.nextInt();
			System.out.print("사용자의 Y인덱스를 입력하세요 => ");
			pY = scan.nextInt();
			
			if (map[pX][pY] == 0) {
				
				map[pX][pY] = PLAYER;
				break; 
			}
			
		}
		
		
		//게임 시작하기
		
		while(true) {
			
			//말판 출력하기
			
			System.out.println();
			System.out.println("========================");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
					switch (map[i][j]) {
					
					case WALL : System.out.print("! "); break;
					case BALL : System.out.print("* "); break;
					case GOAL : System.out.print("G "); break;
					case PLAYER : System.out.print("옷 "); break;
					default : System.out.print("0 ");
					
					}
					
					if ( j == map.length - 1) System.out.println();
					
				}
			}
			System.out.println("========================");
			System.out.println();
			
			
			// 이동할 위치 입력받고 이동하기
			System.out.print("이동할 위치[ 상(1) 하(2) 좌(3) 우(4) ] => ");
			int getPosition = scan.nextInt();
			
			int previousPX = pX;		//이전 위치 기억하기
			int previousPY = pY;
			
			switch(getPosition) {		//위치 이동
			
			case 1: pX --; break;
			case 2: pX ++; break;
			case 3: pY --; break;
			case 4: pY ++; break;
			
			}
			
			if (pX < 0 || pX >= SIZE || pY < 0 || pY >= SIZE) {				//이동 불가능한 경우 ( 끝에 다다름)
				
				pX = previousPX;
				pY = previousPY;
				
				continue;
			}
			
			if (map[pX][pY] == GOAL || map[pX][pY] == WALL) {				// 벽이나 골대를 만난 경우 움직일 수 x
				
				pX = previousPX;
				pY = previousPY;
				
				continue;
				
			}
			
			
			//공을 만난 경우
			
			if (map[pX][pY] == BALL) {
				
	
				switch(getPosition) {		//위치 이동
				
				case 1: ballX --; break;
				case 2: ballX ++; break;
				case 3: ballY --; break;
				case 4: ballY ++; break;
				
				}
				
				if (map[ballX][ballY] == WALL ) {		//공이 벽 만난 경우
					
					ballX = pX;		//이전 위치로 (공의 이동하기 전 위치는 현재pX pY 위치임)
					ballY = pY;
					
					pX = previousPX;
					pY = previousPY;
					
					continue;
				}
				
				
				//while문 나갈 조건
				if (map[ballX][ballY] == GOAL) {
					
					System.out.println("게임 종료");
					break;
				}
				
				else map[ballX][ballY] = BALL;
				
				
			}
			
			//이동 가능한경우 사용자, 공 위치 다 바꿔주고 원래있던 곳 0으로 만들어줌
			map[previousPX][previousPY] = 0;
			map[pX][pY] = PLAYER;
			
			
			
		}
		
	
		scan.close();
		
	}

}
