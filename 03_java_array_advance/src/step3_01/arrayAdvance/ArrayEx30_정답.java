package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * # ATM[4단계] : 전체 기능구현
 * 
 * 1. 회원가입
 * . id와 pw를 입력받아 가입
 * . 가입 시 돈 1000원 부여
 * . id 중복체크
 * 2. 회원탈퇴
 * . 로그인시에만 이용가능
 * 3. 로그인
 * . id와 pw를 입력받아 로그인
 * . 로그아웃 상태에서만 이용가능
 * 4. 로그아웃
 * . 로그인시에만 이용가능
 * 5. 입금
 * . 로그인시에만 이용가능
 * 6. 이체
 * . 로그인시에만 이용가능
 * 7. 잔액조회
 * . 로그인시에만 이용가능
 */

//2021.02.27 18:58 ~ 20:16
public class ArrayEx30_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int MAX = 5;
		
		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMoney = new int[MAX];
		
		int usrCnt = 0;
		boolean isLogin = false;
		int loginId = -1;
		
		
		String menu = "=== 메가IT ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
		
		while(true) {
			
			
			System.out.println(menu);
			System.out.print("입력 => ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				
				if (usrCnt == arId.length) {
					
					System.out.println("5명 초과. 회원탈퇴 후 재진행");
					continue;
				}
				//ID 입력받아서 중복체크

				while(true) {
					boolean isOverlapped = false;
					
					System.out.print("[ ID ] : ");
					int inputId = scan.nextInt();
					
					if (usrCnt == 0) {
						
						usrCnt ++;
						arId[0] = inputId;	//첫 가입자 무조건 가입 가능
						
						break;
					}
					
					for (int i = 0; i < arId.length; i++) {	//중복ID 존재하는지 확인
						
						if (arId[i] == inputId) {
							System.out.println("중복ID 존재. 다시 입력해주세요.");
							isOverlapped = true;
							break;
						}
						else if(i == usrCnt ) {
							
							usrCnt ++;
							arId[i] = inputId;
							break;
						}
					}
					
					if (isOverlapped == true) continue;
					if (arId[usrCnt - 1] != 0) break;	// 배열에 id 존재시 while문 탈출
					
				}
				
				System.out.print("[ PW ] : ");		//pw 입력받기
				arPw[usrCnt - 1] = scan.nextInt();
				
				arMoney[usrCnt - 1] = 1000;	//가입시 1000원 줌
				
				
				
			}
			else if(sel == 2) {	//회원 탈퇴
				
				if (isLogin == true) {
					
					usrCnt --;
					arId[loginId] = 0;
					arPw[loginId] = 0;
					arMoney[loginId] = 0;
					loginId = -1;
					isLogin = false;
					
				}
				
				else {
					System.out.println("로그인을 먼저 시도하세요");
				}
				System.out.println();
				
				
			}
			else if(sel == 3) {//로그인
				
				System.out.print("[ID] 입력 => ");
				int getId = scan.nextInt();
				
				System.out.print("[PW] 입력 => ");
				int getPw = scan.nextInt();
				
				//Id, Pw 확인하기
				for (int i = 0; i < arId.length; i++) {		
					
					if ( getId == arId[i] ) { 	//Id 존재 
						
						//Pw 확인
						if (arPw[i] == getPw) {
							
							isLogin = true;
							loginId = i;
							System.out.println("로그인 성공");
							break;
						}
						else {
							System.out.println("비밀번호 틀림");
							break;
						}
						
					}
					else if ( i == arId.length - 1 && getId != arId[i]){
						
						System.out.println("존재하지 않는 Id 입니다. ");
					}
				}
				System.out.println();
			}
			else if(sel == 4) {	//로그아웃
				
				if (isLogin == true) {
					
					loginId = -1;
					isLogin = false;
					
				}
				
				else {
					System.out.println("로그인을 먼저 시도하세요.");
				}
				System.out.println();
				
			}
			else if(sel == 5) {	//입금
				
				if (isLogin == true) {
					
					System.out.print("입금하실 금액 => ");
					int depositMoney = scan.nextInt();
					
					arMoney[loginId] += depositMoney;
					
					System.out.println("입금완료.");
				}
				else {
					
					System.out.println("로그인을 먼저 시도하세요.");
				}
				System.out.println();
				
			}
			else if(sel == 6) {	//이체
				
				if (isLogin == true) {
					
					System.out.print("이체하실 계좌 => ");
					int transferId = scan.nextInt();
					
					for (int j = 0; j < arId.length; j++) {
						
						if (arId[j] == transferId) {	//계좌 존재시 이체할 금액 입력받기
							
							System.out.print("이체할 금액 => ");
							int transferMoney = scan.nextInt();
							
							
							if (transferMoney > arMoney[loginId]) {
								System.out.println("잔액 부족");
								break;
							}
							else {
								
								arMoney[j] += transferMoney;
								arMoney[loginId] -= transferMoney;
								break;
								
							}
						}
						else if (j == arId.length - 1 && arId[j] != transferId){
							
							System.out.println("존재하지 않는 계좌입니다. ");
							break;
							
						}
					}
					
				}
				
				else System.out.println("로그인을 먼저 시도하세요");
				System.out.println();
			}
			else if(sel == 7) {	//잔액조회
				
				if (isLogin == true) {
					
					System.out.println("잔액은 " + arMoney[loginId] + "원 입니다.");
				}
				
				else System.out.println("로그인을 먼저 시도하세요");
				System.out.println();
				
			}
			else if(sel == 0) {
				break;
			}
		}



	}

}
