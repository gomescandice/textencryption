package Infosec;

public class ECB {
	
	public static Encrypt E = new Encrypt();
	

	public static void main( String input, String key){
		
		int block = input.length()/12;
		for(int c = 0; c < 2; c++){
			
	
		String blocks [] = new String[block];
		if(c==0){
			for(int i=0;i< block ; i++)
			{
				blocks[i] = input.toString().substring(12*i, 12*(i+1));
				
			}	
		
			
			for(int x = 0; x < 2 ;x++)
			{
				String key1 = key.substring(x, x+8);
				String v = "";
				System.out.println("Key for "+ (x+1) +" round: "+ key1);
				for(int i=0;i< block ; i++)
				{
					blocks[i] = E.MiniDes(blocks[i], key1);
					v += blocks[i];
				}
			
				System.out.println("Output is of round "+ (x+1) + " is: "+ v);
			}
			String v = "";
			for(int i=0;i< block ; i++)
			{
		//	blocks[i] = input.toString().substring(12*i, 12*(i+1));
				String x = blocks[i].substring(0, 6);
				String y = blocks[i].substring(6,12);
			
				v += y;
				v+= x;
			
			}	
			
			System.out.println("Final Cipher: "+v);
			input = v;
		}
		else{
			for(int i=0;i< block ; i++)
			{
				blocks[i] = input.toString().substring(12*i, 12*(i+1));
				
			}	
		
			for(int x = 1; x > -1 ;x--)
			{
				String key1 = key.substring(x, x+8);
				String v = "";
				System.out.println("Key for "+ (x+1) +" round: "+ key1);
				for(int i=0;i< block ; i++)
				{
					blocks[i] = E.MiniDes(blocks[i], key1);
					v += blocks[i];
				}
			
				System.out.println("Output is of round "+ (x+1) + " is: "+ v);
			}
			String v = "";
			for(int i=0;i< block ; i++)
			{
		//	blocks[i] = input.toString().substring(12*i, 12*(i+1));
				String x = blocks[i].substring(0, 6);
				String y = blocks[i].substring(6,12);
			
				v += y;
				v+= x;
			
			}	
			System.out.println("Decrypted string is: " + v);
			
		}//else
		}//for
	}//main
}//class

