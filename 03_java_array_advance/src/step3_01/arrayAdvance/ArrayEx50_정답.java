package step3_01.arrayAdvance;

/*
 * # 달팽이
 * 
 * 1	2	3	4	5	
 * 16	17	18	19	6	
 * 15	24	25	20	7	
 * 14	23	22	21	8	
 * 13	12	11	10	9
 * 
 * 00 01 02 03 04 
 * 10 11 12 13 14
 * 20 21 22 23 24
 * 30 31 32 33 34
 * 40 41 42 43 44
 * 
 * 
 * 1) 오른쪽 방향으로 순서대로 숫자저장
 * 2) 아래쪽 방향으로 순서대로 숫자저장
 * 3) 왼쪽 방향으로 순서대로 숫자저장
 * 4) 윗쪽 방향으로 순서대로 숫자저장
 * 
 * 1)2)3)4) 반복
 */

// 2021.03.19 19:25 ~ 19:53
class Map{
	
	void printArray(int[][] map) {
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
}
public class ArrayEx50_정답 {

	public static void main(String[] args) {

		Map mp = new Map();
		int[][] map = new int[5][5];
		
		
		int rowNumber = 0;
		int colNumber = map.length - 1;
		
		int arrayNumber = 1;

		int mapLength = 0;
				
		while (true) {
			
			
			if ( arrayNumber > 25 ) break;
			
		    for (int i = 0 + mapLength; i < map.length - mapLength; i++) {
				
				map[rowNumber][i] = arrayNumber ++;
				//mp.printArray(map);
			}
			
			for (int i = 0 + mapLength; i < map.length - mapLength - 1; i++) {
			
				map[i+1][colNumber] = arrayNumber ++;
				//mp.printArray(map);
			}
		
			for (int i = 0 + mapLength; i < map.length - mapLength - 1; i++) {
				map[4-rowNumber][3-i] = arrayNumber ++; 
				//mp.printArray(map);
			}
			
			for (int i = 0 + mapLength; i < map.length -2 - mapLength; i++) {
				map[3-i][rowNumber] = arrayNumber ++;
				//mp.printArray(map);
			}
			
			rowNumber ++;
			colNumber --;
			mapLength ++;
			
		}
		mp.printArray(map);
		
		
		
	}

}
