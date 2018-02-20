package Infosec;


public class OFB {
	public static Encrypt E = new Encrypt();
	public static void main(String input, String key,String iv){
		
		int block = input.length()/12;
		String iv1 = iv;
		for(int c = 0; c < 2; c++){
			String blocks [] = new String[block];
			if(c==0)
			{		
				for(int i=0;i< block ; i++)
				{
					blocks[i] = input.toString().substring(12*i, 12*(i+1));				
				}	
				String v = "";	
				String u = "";
				for(int i=0;i< block ; i++){
					for(int x = 0; x < 2 ;x++)
					{
						String key1 = key.substring(x, x+8);
						u = E.MiniDes(iv, key1);
						if(x==1){
							String y = u.substring(0, 6);
							String z = u.substring(6,12);
							u = "";
							u += z;
							u += y;
						}
					}
					iv = u;
					blocks[i] = xor(blocks[i],u);						
					v += blocks[i];
				}
				System.out.println("Final Cipher: "+v);	
				input = v;
			}

			else{
				iv = iv1;
				for(int i=0;i< block ; i++)
				{
					blocks[i] = input.toString().substring(12*i, 12*(i+1));				
				}	
				String v = "";	
				String u = "";
				for(int i=0;i< block ; i++){
					for(int x = 0; x < 2 ;x++)
					{
						String key1 = key.substring(x, x+8);
						u = E.MiniDes(iv, key1);
						if(x==1){
							String y = u.substring(0, 6);
							String z = u.substring(6,12);
							u = "";
							u += z;
							u += y;
						}
					}
					iv = u;
					blocks[i] = xor(blocks[i],u);						
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
