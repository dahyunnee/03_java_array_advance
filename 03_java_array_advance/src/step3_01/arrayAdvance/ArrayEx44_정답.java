package step3_01.arrayAdvance;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//# 빙고 Ver1(플레이어 1명)


//2021.02.26 19:11 ~ 
public class ArrayEx44_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int maxNum = 5;
		int[][] bingo = new int[maxNum][maxNum];
		int[][] mark = new int[maxNum][maxNum];	
		int[] temp = new int[maxNum*maxNum];
		int size = 50;	
		int win = 0;
		
		//랜덤 숫자 temp 배열에 저장 (중복 x)
		
		for (int i = 0; i < temp.length; i++) { // 0 ~ 24
			
			int randomNumber = ran.nextInt(size) + 1; // 1~50까지
			
			
			for (int j = 0; j < i ; j++) {
				
				if (randomNumber == temp[j]) {
					
					i--;
					break;
				}

			}
			
			temp[i] = randomNumber;
		}
		
		//System.out.println(Arrays.toString(temp));
		
		//bingo 배열에 temp배열 넣기
		
		int indexofTemp = 0;
		
		for (int i = 0; i < bingo.length; i++) {
			
			for (int j = 0; j < bingo.length; j++) {
				
				bingo[i][j] = temp[indexofTemp ++];
			}
		}
		
		//System.out.println(Arrays.toString(bingo));
		
		
		//게임 시작
		while(true) {
			
			//빙고판 출력
			System.out.println("================ 빙고게임 ================");
			for (int i = 0; i < maxNum; i++) {
				System.out.print("\t" + i);
			}
			System.out.println();
			System.out.println();
			for (int i = 0; i < bingo.length; i++) {
				
				System.out.print(i + "\t");
				for (int j = 0; j < bingo.length; j++) {
					
					if ( mark[i][j] == 0 ) {
						System.out.print(bingo[i][j] + "\t");
						
					}
					else System.out.print("O" + "\t");
					if (j == bingo.length - 1) System.out.println("\n");
				}
				
			}
			
			System.out.println();
			
			//while문 나가기
			if (win == 1) {
				
				System.out.println("끝");
				break;
			}
			
			//값 얻어오기
			System.out.print("y좌표를 입력하세요 (0~4) => ");
			int inputY = scan.nextInt();
			
			if (inputY < 0 || inputY >= maxNum) {
				
				System.out.println("좌표를 다시 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("x좌표를 입력하세요 (0~4) => ");
			int inputX = scan.nextInt();
			
			if (inputX < 0 || inputX >= maxNum) {
				
				System.out.println("좌표를 다시 입력하세요");
				System.out.println();
				continue;
				
			}
			
			//선택된 좌표 o로 바꾸기
			if (mark[inputY][inputX] == 0) {
				
				mark[inputY][inputX] = 1;
			}
			else {
				
				System.out.println("이미 선택되었습니다.");
				continue;
			}
			
			//연속 5개 o있는지 찾기
			
			//  0 1 2 3 4
			//0
			//1
			//2
			//3
			//4
			//0,4 1,3 2,2, 3,1 4,0
		
			for (int k = 0; k < mark.length; k++) {
				for (int j = 0; j < mark.length - 1; j++) {		//가로 확인 0,0 0,1 ... 0,4 
																// 1,0 1,1 ... 1, 4
					if ( mark[k][j] == 1 ) continue;
					
					if ( j == maxNum - 1 ) win = 1;
					
				}
				
				for (int j = 0; j < mark.length - 1; j++) {		//세로 확인
					
					if ( mark[j][k] == 1 ) continue;
					
					if ( j == mark.length - 1 ) win = 1;
					
				}

				if (k==0) {		//대각선 확인
					
					if (mark[k][k] == 1 && mark[k+1][k+1] == 1 && mark[k+2][k+2] == 1 && mark[k+3][k+3] == 1 && mark[k+4][k+4] == 1) win = 1;//왼->오
					else if (mark[k][mark.length-1-k] == 1 && mark[k+1][mark.length-k-2] == 1 && mark[k+2][mark.length-3-k] == 1
							&& mark[k+3][mark.length-4-k] == 1 && mark[k+4][mark.length-5-k] == 1) win = 1; //오->왼
					
				}
				
			
			}		
			
		}
		
		scan.close();
	}

}
