import java.util.*;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sizeStr;
		Scanner s = new Scanner(System.in);
		sizeStr = s.nextLine();
		String[] sizeArray = splitFunc(sizeStr);
		int size = 0;
		if(validateInputArguments(sizeArray,2,"Size")) {
			size = Integer.parseInt(sizeArray[1]);
			System.out.println("SIZE OK");
		}
		else {
			System.out.println("Invalid Input");
		}
		LRUCaching caching = new LRUCaching(size);

		while(true) 
		{
			if(size>0) {
				String inputStr = s.nextLine();
				String[] inputArr = splitFunc(inputStr);

				String input = inputArr[0].toUpperCase();

				switch (input) {

				case "GET": 
					if(validateInputArguments(inputArr,2,"GET")) {
						caching.getFunc(inputArr[1]);
					}
					else {
						System.out.println("ERROR");
					}
					break;

				case "SET":
					if(validateInputArguments(inputArr,3,"SET")) {
						caching.setFunc(inputArr[1],inputArr[2]);
					}
					else {
						System.out.println("InValid input");
					}
					break;

				case "EXIT":
					System.exit(0);
					break;

				default: 
					System.out.println("InValid input");
					System.exit(0);
					break;
				}

			}

		}

	}

	public static String[] splitFunc(String s) {
		return s.split(" ");
	}

	public static boolean validateInputArguments(String[] strArr,int noOfArguments, String validFirstArg) {
		if (strArr.length == noOfArguments && strArr[0].equalsIgnoreCase(validFirstArg)) {
			return true;
		}
		return false;
	}



}
