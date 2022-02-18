import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Crypto {

	public static void main(String[] args) {
		method("t'es un petit malin toi a venir jusqu'ici regarder ce que je fais ! :)");
	}
	
	public static void method(String str) {
		
		System.out.println("Encryption of " + str + " using a personal cryptosystem.");
		
		byte[] myBytes = str.getBytes(); // ASCII chars array
		
		byte[] randoms = new byte[myBytes.length];	
		
		for (int i = 0 ; i < myBytes.length ; i++) { // Storing random
			byte[] _loc = new byte[myBytes.length];
			Random random = new Random();
		    random.nextBytes(_loc);
			randoms[i] = _loc[i];
		}
		
		for(int j = 0 ; j < myBytes.length ; j++) { // Shifting using the stored random
			myBytes[j] ^= randoms[j];
		}
		
		String cipher = new String(myBytes, StandardCharsets.UTF_8);
		
		System.out.println("Cipher is : " + cipher);
		
		for(int j = 0 ; j < myBytes.length ; j++) {
			myBytes[j] ^= randoms[j];
		}
		
		String plain = new String(myBytes, StandardCharsets.UTF_8);
		
		System.out.println("Plaintext is : " + plain);
		
		/*
		 * /!\ Disclaimer /!\
		 * This encryption scheme is relatively solid provided that we do not directly notice that it is a derivative of the "One Time Pad". 
		 * Frequency analysis is impossible on this diagram. In order to counter the possible test of xoring on the encrypted, 
		 * we could add an additional random on the bits, shift them, finally solutions exist but they must absolutely be implemented.
		 */
	}
}
