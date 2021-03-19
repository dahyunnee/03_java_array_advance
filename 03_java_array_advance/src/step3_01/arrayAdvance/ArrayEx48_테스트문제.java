package step3_01.arrayAdvance;

import java.util.Scanner;

/*
  
	문제1) 1 ~ 백만 사이의 숫자를 입력받고 가운데 숫자 출력 
	(단 ! 짝수자리의 수는 짝수자리라고 출력)
	예)  123 ==> 2
	예)  1234 ==> 짝수의 자리이다
	예)  1 ==> 1
	예)  1234567 ==> 4
	
	힌트) 자리수를 구하고 배열을 만든다음 하나씩 저장 
	예) ==> 123 ==> 3 ==> arr[] = new int[3];
	
*/

public class ArrayEx48_테스트문제 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int countNumber = 0; 	//자리수
		
		System.out.print("[숫자 입력] : ");
		int getNumber = scan.nextInt();
		
		int temp = getNumber;
		
		while(getNumber >= 1) {
		
			getNumber /= 10;
			countNumber ++;		
		}
		
		getNumber = temp;
		int[] numberArray = new int[countNumber + 1];
		int indexofNumberArray = 0;
		
		//배열에 저장
		while(getNumber > 1) {
			
			numberArray[indexofNumberArray ++] = getNumber % 10;
			getNumber /= 10;
		}
		
		//짝수자리인 경우
		if ( countNumber % 2 == 0) {
			
			System.out.println("짝수자리의 수 입니다.");
		}
		//아닌경우
		else {
			
			if (countNumber == 1) System.out.println(temp + " ==> " + temp);
			else {
				
				countNumber /= 2;
				System.out.println(temp + " ==> " + numberArray[countNumber]);
			}
		}
		
		
		
	}

}
