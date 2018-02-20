package Infosec;

import java.util.HashMap;

public class Encrypt {
	 static String [] s1_0 = {"101", "010", "001", "110", "011", "100", "111", "000"};
	 static String [] s1_1 = {"001", "100", "110", "010", "000", "111", "101", "011"};
	
	 static String [] s2_0 = {"100", "000", "110", "101", "111", "001", "011", "010"};
	 static String [] s2_1 = {"101", "011", "000", "111", "110", "010", "001", "100"};
	
	 public String MiniDes(String input, String key)
	{	
		String left = "";
		String right = "";
		String right1 = "";
		String right2 = "";
		String left2 = "";
		Integer len = input.length();
			
			left = input.substring(0, 6);
			right = input.substring(6, 12);
			
			right1 = expansion(right);
		
			right1 = xor(right1,key);
			
			String S1 = "";
			String S2 = "";
			
			right1 = SBOX(right1);
			
			right2 = xor(right1,left);
			
			left2 = right;
		
			return left2+right2;
			
			
		}
	

public String SBOX(String input) {
	char [] S1 = new char[4];
	char [] S2 = new char[4];
	
	 String i1;
	 String i2;
	 
	String val1 = input.substring(1,4);
	int v1 = Integer.parseInt(val1,2);
	
	
	String val2 = input.substring(5,8);
	int v2 = Integer.parseInt(val2,2);
	
	S1[0] = input.charAt(0);
	//S1[1] = input.charAt(1);
	//S1[2] = input.charAt(2);
	//S1[3] = input.charAt(3);
	S2[0] = input.charAt(4);
	//S2[1] = input.charAt(5);
	//S2[2] = input.charAt(6);
	//S2[3] = input.charAt(7);
	
	if(S1[0] == '0')
	{
		i1 = s1_0[v1];
	}
	else{
		i1 = s1_1[v1];
	}
	
	if(S2[0] == '0')
	{
		i2 = s2_0[v2];
	}
	else{
		i2 = s2_1[v2];
	}
	
	return i1+i2;
	}
public String xor(String right,String key) {
	char [] right1 = new char[right.length()];
	if(right.length()==key.length())
	{
		for(int i = 0; i<right.length(); i++)
		{
			char r1 = (char)right.charAt(i);
			char r2 = (char)key.charAt(i);
			if(r1!=r2){
				right1[i] = '1';
			}
			else{
				right1[i] = '0';
			}	
		}	
	}
	return String.valueOf(right1);
}
	public String expansion(String right) {
		char [] right1 = new char[8];
		
		
		right1 [0] = right.charAt(0);
		right1 [1] = right.charAt(1);
		right1 [2] = right.charAt(3);
		right1 [3] = right.charAt(2);
		right1 [4] = right.charAt(3);
		right1 [5] = right.charAt(2);
		right1 [6] = right.charAt(4);
		right1 [7] = right.charAt(5);
		
		
		return String.valueOf(right1);
	
	}	
	
}
