package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 *	# 관리비
*/


//2021.03.02 16:22 ~ 16:39
public class ArrayEx38_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] apt = {
				{101, 102, 103},	
				{201, 202, 203},	
				{301, 302, 303}	
			};
			
		int[][] pay = {
			{1000, 2100, 1300},	
			{4100, 2000, 1000},	
			{3000, 1600,  800}
		};
			
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		
		for (int i = 0; i < apt.length; i++) {
			
			int moneyofFloor = 0;
			for (int j = 0; j < apt[i].length; j++) {
				
				moneyofFloor += pay[i][j];
			}
			
			System.out.print(moneyofFloor + " ");
		}
		
		System.out.println();
		
		// 문제 2) 호를 입력하면 관리비 출력
		// 예    2) 입력 : 202	관리비 출력 : 2000
		
		System.out.print("호 => ");
		int adminMoney = scan.nextInt();
		
		
		for (int i = 0; i < apt.length; i++) {
			for (int j = 0; j < apt[i].length; j++) {
				
				if (apt[i][j] == adminMoney) {
					
					System.out.println("관리비 : " + pay[i][j] );
				}
			}
		}
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		
		int maxofAdminmoney = pay[0][0];
		int minofAdminmoney = pay[0][0];
		
		int maxofApt = apt[0][0];
		int minofApt = apt[0][0];
		
		for (int i = 0; i < apt.length; i++) {
			
			for (int j = 0; j < apt[i].length; j++) {
				
				if (i == 0 && j == 0) continue;
				
				if (maxofAdminmoney < pay[i][j]) {
					
					maxofAdminmoney = pay[i][j];
					maxofApt = apt[i][j];
				}
				
				else if (minofAdminmoney > pay[i][j]) {
					
					minofAdminmoney = pay[i][j];
					minofApt = apt[i][j];
				}
			}
		}
		
		System.out.println("최대 관리비 => " + maxofApt + "호, 최소관리비 => "
				+ minofApt + "호");
		
		// 문제 4) 호 2개를 입력하면 관리비 교체

		
		System.out.print("첫번째 호수 입력 = > ");
		int firstAptnum = scan.nextInt();
		
		System.out.print("두번째 호수 입력 = > ");
		int secondAptnum = scan.nextInt();
		
		int temp = 0;
		int temp2 = 0;
		
		for (int i = 0; i < apt.length; i++) {
			
			for (int j = 0; j < apt[i].length; j++) {
				
				if ( apt[i][j] == firstAptnum) {
					
					temp = pay[i][j];
				}
				
				else if(apt[i][j] == secondAptnum) {
					
					temp2 = pay[i][j];
				}
			}
		}
		
		int temp3 = temp;
		temp = temp2;
		temp2 = temp3;
		
		for (int i = 0; i < apt.length; i++) {
			
			for (int j = 0; j < apt[i].length; j++) {
				
				if ( apt[i][j] == firstAptnum) {
					
					pay[i][j] = temp;
				}
				
				else if(apt[i][j] == secondAptnum) {
					
					pay[i][j] = temp2;
				}
				
				System.out.print(pay[i][j]);
			}
		}

		
	}

}
