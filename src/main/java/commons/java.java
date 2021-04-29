package commons;

public class java {

	public static void main(String[] args) {
		String text = "Automation 01 Testing 345 Tutorials Online 123456";
		text = text.toLowerCase();
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == 'a') {
			count++;
			}
		}
		System.out.println(count);
		
		text = "Automation 01 Testing 345 Tutorials Online 123456";
		boolean comparevalue = text.contains("Testing");
		System.out.println("Ket qua: " + comparevalue);
		
		comparevalue = text.startsWith("Automation");
		System.out.println("Ket qua: " + comparevalue);
		
		comparevalue = text.startsWith("Online");
		System.out.println("Ket qua: " + comparevalue);
		
		int index = text.indexOf("Tutorials");
		System.out.println(index);
		
		text = text.replace("Online", "Offline");
		System.out.println(text);
		
		String subString[] = text.split(" ");
		String int_01 = subString[1];
		int num1 = int_01.length();
		
		String int_02 = subString[3];
		int num2 = int_02.length();
		
		String int_03 = subString[6];
		int num3 = int_03.length();
		
		int sum = num1 + num2 + num3;
		System.out.println(sum);
	}

}
