package step3_01.arrayAdvance;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//# 빙고 Ver2(플레이어 2명)

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
			
			
			//me 입력받기
			System.out.println("[ ME 차례 ]");
			
			
			
			//you 입력받기
			
			
			
			
			
			
			
			
			
		}
		
		
		

	}

}
