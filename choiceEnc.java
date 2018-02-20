package Infosec;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class choiceEnc {
	public static void main(String []  args){
		
		String input, key;
		System.out.println("Enter Full Name:");
		Scanner scan1= new Scanner(System.in);
		String name = scan1.nextLine();
//		String name = "Candice Gomes";
		name = name.replaceAll("\\s", "");
		name = name.toUpperCase();
		name = name.substring(0, 10);
		
		System.out.println("Enter your UTA ID");
		Scanner scan2 = new Scanner(System.in);
		Long id = scan2.nextLong();
//		Long id = 1001427308L;
		
		String plaintext =name;
		plaintext += " ";
		plaintext += id;
		plaintext += ".";
		System.out.println(plaintext);	
		
		System.out.println("Please enter your birthday from Julian Calender: ");
		Scanner scan3 = new Scanner(System.in);	
		int date = scan3.nextInt();
			
//		int date = 159;
		key = Integer.toBinaryString(date);
		
		key = String.format("%9s", Integer.toBinaryString(date)).replace(" ", "0");
		System.out.println("Your key is: " + key);
				
		input = toStringToByte(plaintext);	
		
		
		
		System.out.println("Enter one of the following commands:");
		System.out.println("1 - ECB");
		System.out.println("2 - CBC");
		System.out.println("3 - OFB");
		System.out.println("4 - CRT");
		System.out.println("5 - exit");
		Scanner scanchoice = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter \"1\", \"2\" or \"3\", \"4\", \"5\"");
		int choiceentry = scanchoice.nextInt();

		while (choiceentry != 5) {

			if (choiceentry < 1 || choiceentry > 4) {

				System.out.println("Enter \"1\", \"2\", \"3\", \"4\" or \"5\"");
				choiceentry = scanchoice.nextInt();

			}

			else if(choiceentry == 1) {
				ECB test = new ECB();
				test.main(input, key);
				break;
			}
			else if(choiceentry == 2) {
				System.out.println("Enter the initialization vector of 12 bits consisting of 0's and 1's: \n");
				Scanner scan4= new Scanner(System.in);
				String iv = scan4.nextLine();
				if(iv.length()!=12){
					System.out.println("Initialization vector should be 12 bits only!");
					break;
				}
				CBC test1 = new CBC();
				test1.main(input, key,iv);
				break;
			}
			else if(choiceentry == 3) {
				System.out.println("Enter the initialization vector of 12 bits consisting of 0's and 1's: \n");
				Scanner scan5= new Scanner(System.in);
				String iv = scan5.nextLine();
				if(iv.length()!=12){
					System.out.println("Initialization vector should be 12 bits only!");
					break;
				}
				OFB test2 = new OFB();
				test2.main(input, key,iv);
				break;
			}
			else if(choiceentry == 4) {
				System.out.println("Enter the nonce of 12 bits consisting of 0's and 1's: \n");
				Scanner scan6 = new Scanner(System.in);
				String nonce = scan6.nextLine();
				if(nonce.length()!=12){
					System.out.println("Nonce should be 12 bits only!");
					break;
				}
				CTR test3 = new CTR();
				test3.main(input,key,nonce);
				break;
			}
			else if(choiceentry == 5) {
				System.exit(0);
			}

		} 
	}	
	public static String toStringToByte(String string){
			
		HashMap<String,Integer> DECIMAL = new HashMap<String,Integer>();
	//	Iterator<String> key = DECIMAL.keySet().iterator();
		//	Iterator<Integer> value = DECIMAL.values().iterator();
		String result;
			
		DECIMAL.put("A", 1);
		DECIMAL.put("B", 2);
		DECIMAL.put("C", 3);
		DECIMAL.put("D", 4);
		DECIMAL.put("E", 5);
		DECIMAL.put("F", 6);
		DECIMAL.put("G", 7);
		DECIMAL.put("H", 8);
		DECIMAL.put("I", 9);
		DECIMAL.put("J", 10);
		DECIMAL.put("K", 11);
		DECIMAL.put("L", 12);
		DECIMAL.put("M", 13);
		DECIMAL.put("N", 14);
		DECIMAL.put("O", 15);
		DECIMAL.put("P", 16);
		DECIMAL.put("Q", 17);
		DECIMAL.put("R", 18);
		DECIMAL.put("S", 19);
		DECIMAL.put("T", 20);
		DECIMAL.put("U", 21);
		DECIMAL.put("V", 22);
		DECIMAL.put("W", 23);
		DECIMAL.put("X", 24);
		DECIMAL.put("Y", 25);
		DECIMAL.put("Z", 26);
		DECIMAL.put("1", 27);
		DECIMAL.put("2", 28);
		DECIMAL.put("3", 29);
		DECIMAL.put("4", 30);
		DECIMAL.put("5", 31);
		DECIMAL.put("6", 32);
		DECIMAL.put("7", 33);
		DECIMAL.put("8", 34);
		DECIMAL.put("9", 35);
		DECIMAL.put("0", 36);
		DECIMAL.put(".", 37);
		DECIMAL.put(" ", 38);
			
		int len = string.length();
		String v = "";
		for(int i = 0; i<len; i++)
		{
			char temp = string.charAt(i);
			int value = DECIMAL.get(String.valueOf(temp));
			//String c = Integer.toBinaryString(value);
			String c = String.format("%6s", Integer.toBinaryString(value)).replace(" ", "0");
			v = v + c;
		}
		System.out.println("This is your input string: " + v);
		result = v;		
		return result;
	}
}
