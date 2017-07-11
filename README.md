# BasicCaesarCipher
Cryptography- Caesar Cipher
Caesar cipher is known as the earliest used substitution cipher. It just replaces each letter with another letter in alphabet. But, attention must be on the value of the shifted character numbers. For example,  when you use 'd' for 'a' then you need to use 'j' for 'g'. 
Let's look at the the English alphabet
        
		plain:    a b c d e f g h i j k l m n o p q r s t u v w x y z
		cipher:   f g h i j k l m n o p q r s t u v w x y z a b c d e

There is the key value which tells us that each letter shifted as how many letter and then represented. For cipher in here it is 5 because each letter is represented as 5.character after itself. 

For Caesar:

		C = E(keyValue, p) = (p + keyLength)mod26 #C: Cipher text, E: Encryption Process, p: Plain Text
		p = D(keyValue, C) = (C - k)mod26         #D: Decryption process	

There are some important things, 

		1. There is 25 key value that can be use at most so if cipher text is known then brute force will give you the answer in a short time(26 involves all letter, but you do not have to use letter itself for decryption)
		2. When you know the language of the text that you have, then brute force does not take a long time!
	
	
