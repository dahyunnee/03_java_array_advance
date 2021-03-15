package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//# 빙고 Ver2(플레이어 2명)

//2021.03.15 20:00 ~ 20:22
public class ArrayEx45_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int maxNum = 5;
		
		
		int size = 50;
		
		int[][] me  = new int[maxNum][maxNum];
		int[][] you = new int[maxNum][maxNum];
		
		int[][] meMark  = new int[maxNum][maxNum];
		int[][] youMark = new int[maxNum][maxNum];

		
		int win = 0;
		int turn = 0;
		int p1X = 0;	int p1Y = 0;
		int p2X = 0;	int p2Y = 0;
		
	
		// me와 you 빙고판 만들기
		for (int i2 = 0; i2 < 2; i2++) {
			
			int[] temp = new int[maxNum*maxNum];
			int indexofTemp = 0;
			
			//랜덤 수 뽑아 temp 배열 저장
			for (int i = 0; i < temp.length; i++) {
				
				int randomNumber = ran.nextInt(size) + 1;
				if (i==0) temp[0] = randomNumber;
				
				for (int j = 0; j < i; j++) {		//중복되는 숫자 존재
					
					if ( randomNumber == temp[j]) {
						
						i --;
						break;
					}
					
					if ( j == i - 1) temp[i] = randomNumber;	
				}
				
			}
			
			//me빙고판 만들기
			if ( i2 == 0) {		
				
				for (int i = 0; i < me.length; i++) {
					for (int j = 0; j < me.length; j++) {
						
						me[i][j] = temp[indexofTemp ++];
						
					}
				}
				
				
			}
			//you 빙고판 만들기
			else if ( i2 == 1) {	
				
				for (int i = 0; i < you.length; i++) {
					for (int j = 0; j < you.length; j++) {
					
						you[i][j] = temp[indexofTemp ++];
					}
				}
								
			}
		}
		
		while(true) {
			
			//me빙고판 출력하기
			
			System.out.println("============== [ ME 빙고판 ] ==============");
			System.out.println();
			System.out.print("\t");
			for (int i = 0; i < maxNum; i++) {
				System.out.print(i + "\t");
			}
			System.out.println();
			for (int i = 0; i < me.length; i++) {
				
				System.out.print(i + "\t");
				for (int j = 0; j < me.length; j++) {
					
					if (meMark[i][j] == 1) System.out.print("O" + "\t");
					else System.out.print(me[i][j] + "\t");
					
					if ( j == me.length - 1) System.out.print("\n");
				}
			}
			
			System.out.println();
			System.out.println();
			//you 빙고판 출력하기
			System.out.println("============== [ YOU 빙고판 ] ==============");
			System.out.println();
			System.out.print("\t");
			for (int i = 0; i < maxNum; i++) {
				System.out.print(i + "\t");
			}
			System.out.println();
			for (int i = 0; i < you.length; i++) {
				
				System.out.print(i + "\t");
				for (int j = 0; j < you.length; j++) {
					
					if (youMark[i][j] == 1) System.out.print("X" + "\t");
					else System.out.print(you[i][j] + "\t");
					
					if ( j == you.length - 1) System.out.print("\n");
				}
			}
			
			if ( win == 1 ) {
				
				System.out.println("ME 승리!");
				break;
			}
			
			else if ( win == 2 ) {
				
				System.out.println("YOU 승리!");
				break;
			}
			
			if ( turn % 2 == 0 )	System.out.println("[ ME 차례 ]");
			else System.out.println("[ YOU 차례 ]");
		
			System.out.print("Y좌표 : ");
			int getY = scan.nextInt();
				
			System.out.print("X좌표 : ");
			int getX = scan.nextInt();
		
			
			if ( turn % 2 == 0) meMark[getY][getX] = 1;
			else youMark[getY][getX] = 1;
			
			
			
			if (turn % 2 == 0 ) {
				
				for (int k = 0; k < me.length; k++) {
					
					int numberofOne = 0;
					
					for (int j = 0; j < me.length ; j++) {		//가로 확인 0,0 0,1 ... 0,4 
						// 1,0 1,1 ... 1, 4
						
						if ( meMark[k][j] == 1 ) {
							
							numberofOne ++;
							
						}
						
						if ( j == meMark.length - 1 && numberofOne == 5) win = 1;
						
					}
					
					numberofOne = 0;
					
					for (int j = 0; j < meMark.length ; j++) {		//세로 확인
						
						if ( meMark[j][k] == 1 ) numberofOne ++;
						
						if ( j == meMark.length - 1 && numberofOne == 5 ) win = 1;
						
					}
					
					numberofOne = 0;
					
					if (k==0) {		//대각선 확인
						
						if (meMark[k][k] == 1 && meMark[k+1][k+1] == 1 && meMark[k+2][k+2] == 1 && meMark[k+3][k+3] == 1 && meMark[k+4][k+4] == 1) win = 1;//왼->오
						else if (meMark[k][meMark.length-1-k] == 1 && meMark[k+1][meMark.length-k-2] == 1 && meMark[k+2][meMark.length-3-k] == 1
								&& meMark[k+3][meMark.length-4-k] == 1 && meMark[k+4][meMark.length-5-k] == 1) win = 1; //오->왼
						
					}
					
					
				}		
				
				turn ++;
				
			}
			
			
			else {
				
				for (int k = 0; k < you.length; k++) {
					
					int numberofOne = 0;
					
					for (int j = 0; j < you.length ; j++) {		//가로 확인 0,0 0,1 ... 0,4 
						// 1,0 1,1 ... 1, 4
						
						if ( youMark[k][j] == 1 ) {
							
							numberofOne ++;
							
						}
						
						if ( j == youMark.length - 1 && numberofOne == 5) win = 2;
						
					}
					
					numberofOne = 0;
					
					for (int j = 0; j < youMark.length ; j++) {		//세로 확인
						
						if ( youMark[j][k] == 1 ) numberofOne ++;
						
						if ( j == youMark.length - 1 && numberofOne == 5 ) win = 2;
						
					}
					
					numberofOne = 0;
					
					if (k==0) {		//대각선 확인
						
						if (youMark[k][k] == 1 && youMark[k+1][k+1] == 1 && youMark[k+2][k+2] == 1 && youMark[k+3][k+3] == 1 && youMark[k+4][k+4] == 1) win = 1;//왼->오
						else if (youMark[k][youMark.length-1-k] == 1 && youMark[k+1][youMark.length-k-2] == 1 && youMark[k+2][youMark.length-3-k] == 1
								&& youMark[k+3][youMark.length-4-k] == 1 && youMark[k+4][youMark.length-5-k] == 1) win = 2; //오->왼
						
					}
					
					
				}		
				
				turn ++;
				
				
				
			}
			
			
			
			
			
			
		}
		
		
		

	}

}
