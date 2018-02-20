package Infosec;

public class CBC {
public static Encrypt E = new Encrypt();

	public static void main( String input, String key,String iv){
					
	int block = input.length()/12;
	String blocks [] = new String[block];
	for(int c = 0; c < 2; c++)
	{
		if(c==0)
		{		//Encryption
			for(int i=0;i< block ; i++)
			{
				blocks[i] = input.toString().substring(12*i, 12*(i+1));					
			}	
			String v = "";	
			for(int i=0;i< block ; i++){
				blocks[i] = xor(blocks[i],iv);
				for(int x = 0; x < 2 ;x++)
				{
					String key1 = key.substring(x, x+8);
					blocks[i] = E.MiniDes(blocks[i], key1);
					if(x==1){
						String y = blocks[i].substring(0, 6);
						String z = blocks[i].substring(6,12);
						blocks[i] = "";
						blocks[i] += z;
						blocks[i] += y;
					}
				}
				iv = blocks[i];
				v += blocks[i];
			}
			System.out.println("Final Cipher: "+v);	
			input = v;
		}						
		else{		//Decryption
			
			for(int i=0;i< block ; i++)
			{
				blocks[i] = input.toString().substring(12*i, 12*(i+1));					
			}	
			String v = "";	
			for(int i=0;i< block ; i++){
				
				
				String temp = blocks[i];
				for(int x = 1; x > -1 ;x--)
				{
					
					String key1 = key.substring(x, x+8);
					blocks[i] = E.MiniDes(blocks[i], key1);
					if(x==0){
						String y = blocks[i].substring(0, 6);
						String z = blocks[i].substring(6,12);
						blocks[i] = "";
						blocks[i] += z;
						blocks[i] += y;
					}
				}
				blocks[i] = xor(blocks[i],iv);
				iv = temp;
				v += blocks[i];		
			}
			System.out.println("Decrypted Text is: "+v);	
			
		
		}
	}
}
		
	public static String xor(String plaintext,String iv) {
		char [] v = new char[plaintext.length()];
		if(plaintext.length()==iv.length())
		{
			for(int i = 0; i<plaintext.length(); i++)
			{
				char r1 = (char)plaintext.charAt(i);
				char r2 = (char)iv.charAt(i);
				if(r1!=r2){
					v[i] = '1';
				}
				else{
					v[i] = '0';
				}	
			}	
		}
		return String.valueOf(v);
	}

}
