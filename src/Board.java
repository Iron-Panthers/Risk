
public class Board {

	static int[][] board = new int[][]{
		  { 1, -3, 0, 6,},
		  { 3, 4, -1, 5,},
		  { 2, -4, 0, 7,},
		  { 0, 0, 8, 0,},
		};

		static String[] boardN = new String[]{ "  ", "Ve", "Ar", "Pe", "Br", "Us", "Ca", "Mx", "Ha", };
		static String[] boardB = new String[]{ "  ", "--", "||", "\\ ", "/ "};
	
	public static void main(String[] args) {
		
		

			System.out.println(board.length + "rows");
			System.out.println(board[3].length + "colums");
		
			//
			System.out.println();
			
			for (int i = 0; i<board.length; i++) {
				System.out.println();
				for (int j = 0; j<board[i].length; j++) {
					if (board[i][j] > -1) {
						System.out.print(boardN[board[i][j]]);
					}
					else {
						System.out.print(boardB[Math.abs(board[i][j])]);//abs
					}
				}
			}
			//
			
			if (isTouching("Br", "US")) {//will later be changed to user imput
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
	}
	
	public static boolean isTouching(String a, String b) { /** need to check for bridges **/
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		int aN = 0;
		int bN = 0;
		
		for (int i=0; i<boardN.length; i++) {//figures out the number the country is for first imput
			if (a==boardN[i]) {
				aN = i;
			}
		}
		for (int i = 0; i<board.length; i++) {//gets x and y coordinate of first imput
			for (int j = 0; j<board[i].length; j++) {
				if (aN == board[i][j]) {
					System.out.println();
					y1 = i;
					x1 = j;
					System.out.println(a + " is at (" + x1 + ", " + y1 + ")");
					
				}
			}
		}
		
		for (int i=0; i<boardN.length; i++) {//figures out the number the country is for second imput
			if (b==boardN[i]) {
				bN = i;
			}
		}
		for (int i = 0; i<board.length; i++) {//gets x and y coordinate of second imput
			for (int j = 0; j<board[i].length; j++) {
				if (bN == board[i][j]) {
					y2 = i;
					x2 = j;
					System.out.println(b + " is at (" + x2 + ", " + y2 + ")");
					
				}
			}
		}
		//
		try {// might get ArrayIndexOutOfBoundsException
			
			if(x1==x2) {
				if (y1+1==y2 || y1-1==y2) {
					return true;
				}
			}
			else if(y1==y2) {
				if (x1+1==x2 || x1-1==x2) {
					return true;
				}
			}
			////////////////////////////////////////////////////////////////// bridges:
			
			else if (board[y1][x1+1]==-4 && x1+1 == x2 && y1-1==y2) {//right-up bridge
				return true;
			}
			else if (board[y2][x2+1]==-4 && x2+1 == x1 && y2-1==y1) {//down-left bridge
				return true;
			}
			//////////////////////////////////////////////////////////////////
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		if(x1==x2) {
			if (y1+1==y2 || y1-1==y2) {
				return true;
			}
		}
		else if(y1==y2) {
			if (x1+1==x2 || x1-1==x2) {
				return true;
			}
		}
		////////////////////////////////////////////////////////////////// bridges:
		
		else if (board[y1][x1+1]==-4 && x1+1 == x2 && y1-1==y2) {//right-up bridge
			return true;
		}
		else if (board[y2][x2+1]==-4 && x2+1 == x1 && y2-1==y1) {//down-left bridge
			return true;
		}
		else if (board[y1][x1+1]==-3 && x2-1 == x1 && y2-1==y1) {//up-left bridge
			return true;
		}
		else if (board[y2][x2+1]==-3 && x1-1 == x2 && y1-1==y2) {//down-right bridge
			return true;
		}
		else if (board[y1][x1+1]==-1 && x1+2 == x2 && y1==y2) {//left-right bridge
			return true;
		}
		else if (board[y2][x2+1]==-1 && x2+2 == x1 && y2==y1) {//right-left bridge
			return true;
		}
		//////////////////////////////////////////////////////////////////
		return false;
	}
}
