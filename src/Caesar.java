/**
 * @author aleaddin
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class Caesar {
	public static final int MAX_KEY_SIZE = 26;	
	static Scanner input = new Scanner(System.in);//get message and key from user
	
	public static char operationType() throws IOException{
		System.out.println("Enter d to decrypt or e to encrypt?");
		char rep = (char) System.in.read();//may throw exception
//		char rep = input.next().trim().charAt(0); //to get process using Scanner
		return rep;
	}
	
	//get message to encrypt or decrypt
	public static String message() throws IOException{
		System.out.println("Enter your message: ");
		String message = input.next();
		return message;
	}
	
	//get key value
	public static int learnKey() throws IOException{
		System.out.println("What is the key value: ");
		int keyUser = input.nextInt();
		keyUser = keyUser % MAX_KEY_SIZE; //key value must be less than alphabet length
		input.close();
		return keyUser;
	}
	
	public static String finishedMessage(char operation, char message[], int key){
		
		int valueToShift=0;//value which is in use to exchange encrypted or decrypted character
		
		if(operation == 'd'){
			key = -key; //to get back in alphabet as much as key length
		}
		
		String finishedMessage ="";//message to be filled as encrypted or decrypted user's message
		
		for(char i : message){
		
			if(Character.isLetter(i)){//if letter is not character then just concatenate it with message
									//if it is letter then do the shift operation
				valueToShift =(int) i;
				valueToShift = valueToShift + key;
				
				//controlling ASCII boundary for each character to shift
				if(Character.isUpperCase(i)){
					if(valueToShift > 'Z')
						valueToShift = valueToShift - 26;
					else if(valueToShift < 'A')
						valueToShift = valueToShift + 26;
				}
				else if(Character.isLowerCase(i)){
					if(valueToShift > 'z')
						valueToShift = valueToShift - 26;
					else if(valueToShift < 'a')
						valueToShift = valueToShift + 26;
				}

				finishedMessage = finishedMessage + (char)valueToShift;//concatenation of shifted characters
			
			}
			else
				finishedMessage = finishedMessage + i;//just concatenate if 'i' is not letter
		}
		
		return finishedMessage;
	
	}

	public static void main(String[] args) throws IOException {
	
	char operation = operationType();
	char message[] = message().toCharArray();
	int key = learnKey();
	
	String finishedMessage = finishedMessage(operation, message, key);
	
	if(operation == 'e'){
		System.out.println("Your encrypted message is: ");
		System.out.println(finishedMessage);
	}
	else{
		System.out.println("Your decrypted message is: ");
		System.out.println(finishedMessage);
	}
	}
}
