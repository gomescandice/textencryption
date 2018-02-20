package Infosec;

public class CTR {
	public static Encrypt E = new Encrypt();
		

	public static void main( String input, String key, String nonce){
			
		
	int block = input.length()/12;
	String nonce1 = nonce;
	for(int c = 0; c < 2; c++){	
		String blocks [] = new String[block];		
		if(c==0){
			for(int i=0;i< block ; i++)
			{
				blocks[i] = input.toString().substring(12*i, 12*(i+1));
				
			}	
			String u = "";
			String v = "";
			for(int i=0;i< block ; i++){
				for(int x = 0; x < 2 ;x++)
				{
					String key1 = key.substring(x, x+8);
					u = E.MiniDes(nonce, key1);
					if(x==1){
						String y = u.substring(0, 6);
						String z = u.substring(6,12);
						u = "";
						u += z;
						u += y;
					}
				}
				blocks[i] = xor(blocks[i],u);						
				v += blocks[i];
				char [] b = nonce.toCharArray();
				nonce = addOne(b);
			}
			System.out.println("Final Cipher: "+v);	
			input = v;
		}					
		else
		{
			nonce = nonce1;	
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
					u = E.MiniDes(nonce, key1);
					if(x==1){
						String y = u.substring(0, 6);
						String z = u.substring(6,12);
						u = "";
						u += z;
						u += y;
					}
				}
				blocks[i] = xor(blocks[i],u);						
				v += blocks[i];
				char [] b = nonce.toCharArray();
				nonce = addOne(b);
			}
			System.out.println("Decrypted Text is: "+v);	
		}
	}
		
}
	
	private static String addOne (char [] b) {
		
		
		int lastPosition = b.length-1; 
		for (int i = lastPosition ; i >= 0; i--) {
	        if (b[i] == '0') {
	            b[i] = '1';
	            return String.valueOf(b); 
	        }
	        b[i] = '0';     
	                  
	    }
	    return String.valueOf(b); 
	}
	public static String xor(String plaintext,String output) {
		char [] v = new char[plaintext.length()];
		if(plaintext.length()==output.length())
		{
			for(int i = 0; i<plaintext.length(); i++)
			{
				char r1 = (char)plaintext.charAt(i);
				char r2 = (char)output.charAt(i);
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
