package algorithms;

public class ReverseWordOrder {

	public static String reverseorder(String inputString) {
		// TODO Auto-generated method stub
		
		StringBuilder resultString= new StringBuilder("");
		String[] stringArr= inputString.split(" ");
		
		for(int i=stringArr.length-1;i>=0;i--){
			resultString.append(stringArr[i]).append(" ");
		}
		
		return resultString.toString();
	}

}
