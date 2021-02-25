package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * 
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 
 * 1. 추가
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 * 
 */


// 2021.02.24 19:22 ~ 19:56
public class ArrayEx40_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] scores = null;
		int elementCnt = 0;
		
		while(true) {
			
			//현재 배열 프린트
			System.out.print("현재 배열 => [");
			for (int i = 0; i < elementCnt; i++) {
				
				if (i!=elementCnt - 1) System.out.print(scores[i] + ", ");
				else System.out.print(scores[i]);
			}
			System.out.println("]");
			System.out.println();
			
			//메뉴
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			int[] temp = null;
			
			if		(sel == 1) {
				
				System.out.print("추가할 수를 입력하세요 => ");
				int inputNumber = scan.nextInt();
				
				if ( elementCnt == 0) scores = new int[elementCnt + 1];		//배열에 아무것도 들어있지 않을 때
				
				else {		//배열에 수가 들어있을 때
					
					temp = scores;	//임시 배열에 담아두기
					
					scores = new int[elementCnt + 1];
					
					for (int i = 0; i < temp.length; i++) {		//옮기기
						
						scores[i] = temp[i];
					}
					
					temp = null;
				}
				
				scores[elementCnt] = inputNumber;		//수 추가하기
				
				elementCnt ++;
				
			}
			else if (sel == 2) {
				
				System.out.print("삭제할 인덱스를 입력하세요 => ");
				int inputIndex = scan.nextInt();
				
				if ( inputIndex < 0 || inputIndex >= elementCnt) {		//존재하지 않는 인덱스 입력 시
					
					System.out.println("존재하지 않는 인덱스입니다.");
					continue;
				}
				
				temp = scores;		// 0, 1 ,2 ,3, 4 => inputIndex = 2, elementCnt = 5
				
				scores = new int[elementCnt - 1];		
				int scoresIndex = 0;
				
				for (int i = 0; i < inputIndex; i++) {		//삭제할 인덱스 전까지 scores배열에 담기
					
					scores[scoresIndex ++] = temp[i];
					
				}
				
				for (int i = inputIndex + 1; i < temp.length; i++) {		//삭제할 인덱스 이후 값부터 socres 배열에 담기 
					
					scores[scoresIndex ++] = temp[i];
				}
				
				temp = null;
				elementCnt --;
				
			}
			else if (sel == 3) {
				
				System.out.print("삭제할 값을 입력하세요 => ");
				int inputValue = scan.nextInt();
				
				int valueIndex = -1;
				
				for (int i = 0; i < scores.length; i++) {		//삭제할 값의 인덱스 번호 찾기 
					
					if (inputValue == scores[i]) valueIndex = i;
				}
				
				if (valueIndex == -1) {			// 배열에 해당 값 존재하지 않는 경우
					
					System.out.println("해당 값이 존재하지 않습니다.");
					continue;
				}
				
				temp = scores;
				scores = new int[elementCnt - 1];
				
				int scoresIndex = 0;
				
				for (int i = 0; i < temp.length; i++) {		//해당 값의 인덱스가 아니면 임시배열에서 scores배열로 복사
															// Line 87 ~ 96 다른 방법으로 
					
					if ( i != valueIndex) scores[scoresIndex ++] = temp[i];
				}
				
				temp = null;
				elementCnt --;
				
				
			}
			else if (sel == 4) {
				
				System.out.print("삽입할 인덱스의 값을 입력하세요 => ");
				int inputIndex = scan.nextInt();
				
				if (inputIndex < 0 || inputIndex >= elementCnt) {
					
					System.out.println("존재하지 않는 인덱스입니다.");
					continue;
				}
				
				System.out.print("삽입할 값을 입력하세요 => ");
				int inputValue = scan.nextInt();
				
				temp = scores;
				
				scores = new int[elementCnt + 1];
				int scoresIndex = 0;
				
				//삽입할 인덱스의 번호 전까지 scores 배열에 복사
				for (int i = 0; i < inputIndex; i++) {		// 0, 1, 2, 3 ,4 -> inputIndex = 2, elementCnt = 5
															// 0, 1 , 5, 2,3,4
					scores[scoresIndex ++] = temp[i];
				}
				
				//삽입할 인덱스에 입력받은 수 넣기
				scores[scoresIndex ++] = inputValue;
				
				//남은 배열 복사
				for (int i = inputIndex ; i < temp.length; ++i) {
					
					scores[scoresIndex ++] = temp[i];
				}
				
				elementCnt ++;
				temp = null;
				
			}
			else if (sel == 0) {
				break;
			}
		}



	}

}
