import java.util.*;


public class StringFunctions {

	/*Implement an algorithm to determine if a string has all unique characters. What if you cannot
	use additional data structures? */
	public Boolean uniqueCharInString(String s) {
		s = stringSorting(s);

		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				System.out.println("Given String doesnot have unique characters");
				return false;
			}
		}
		System.out.println("Given String have unique characters");
		return true;
	}

	public String stringSorting(String s) {
		char c[] = s.toCharArray();
		Arrays.sort(c);
		return String.valueOf(c);
	}

	/*Implement an algorithm to determine if a string has all unique characters. */
	public Boolean uniqueCharInStringUsingHasMap(String s){

		HashSet<String> set=new HashSet<String>();  

		for(int i=0;i<s.length();i++) {
			if(set.contains(s.substring(i, i+1))){
				System.out.println("Given String doesnot have unique characters");
				return false;
			}
			else {
				set.add(s.substring(i, i+1));
			}
		}

		/*To parse through the set
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		 */

		System.out.println("Given String have unique characters");
		return true;
	}

	/*
	 * Write a method to replace all spaces in a string with ‘%20’.
	 * */
	public String replaceSpaceInString(String s) {
		String replacedStr = s.replace(" ", "%20");
		System.out.println("String " + s +" has been changed to " +  replacedStr);
		return replacedStr;
	}

	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are
	set to 0
	 */
	public void newMatrixCreationOnCondition(int[][] a, int n,int m) {
		//function to check if 0 exists in a matrix
		int[][] newMatrix = new int[n][m] ;
		newMatrix = a;
		ArrayList<String> tempList = checkReturnPositionsInMatrix(a,n,m);

		for(String str: tempList)
		{
			replaceZeroMatrix(newMatrix, n, m, Integer.parseInt(str.split(",")[0]), Integer.parseInt(str.split(",")[1]));
		}
	
		displayMatrix(newMatrix,n,m);
	}


	public int[][] replaceZeroMatrix(int[][] newMatrix,int n,int m, int row, int col) {

		for(int i = 0;i<n;i++) {
			newMatrix[i][col] = 0;
		}
		for(int j = 0;j<m;j++) {
			newMatrix[row][j] = 0;
		}

		return newMatrix;
	}

	public void displayMatrix(int[][] a, int n,int m) {
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

	
	public ArrayList<String> checkReturnPositionsInMatrix(int[][] a, int n, int m) {
		ArrayList<String> positionArr = new ArrayList<String>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++) {
				if(a[i][j] == 0) {
					positionArr.add(i+","+j);
				}
			}
		}
		return positionArr;
	}

}
