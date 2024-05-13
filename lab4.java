package amogh;

public class lab4 {

	public static void main(String[] args) 
	{
		//constructor 1
		String strLiteral="Hey, Acharya!";
		System.out.println("String created using string literal: "+strLiteral);
		
		//constructor 2
		char[] charArray= {'A','c','h','a','r','y','a'};
		String strFromArray = new String(charArray);
		System.out.println("String created from a character array: "+strFromArray);
		
		//constructor 3
		String strFromArraySubset = new String(charArray,0,3);
		System.out.println("String created with subset of character array: "+strFromArraySubset);
		
		//constructor 4
		String orgStr="Information Science and Engineering";
		String copstr=new String(orgStr);
		System.out.println("String created by a copy constructor: "+copstr);
		
		//constructor 5
		StringBuilder strbu = new StringBuilder("Acharya");
		String srfrombu = new String(strbu);
		System.out.println("String created using StringBuilder method:"+srfrombu);
		
		//Constructor 6
		byte[] byteArray= {65,99,104,97,114,121,97};
		String strByte=new String(byteArray);
		System.out.println("String created from byte array: "+strByte);
		
		//Constructor 7
		byte[] byteArrayUTF8={65,99,104,97,114,121,97};
		String strfromutf8 = new String(byteArrayUTF8, java.nio.charset.StandardCharsets.UTF_8);
		System.out.println("String created byte array UTF8:"+strfromutf8);
		
		
	}

}
