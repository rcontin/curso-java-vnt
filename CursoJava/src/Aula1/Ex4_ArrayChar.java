// 4. Faça um programa java que crie um array de char contendo as letras do alfabeto.

package Aula1;

public class Ex4_ArrayChar {

	public static void main(String[] args) {
    	char array[] = new char[26];      
    	int pos = 0; 
    	
    	for (char letra = 'A'; letra <= 'Z'; letra++) {
    		array[pos] = letra;    
    		System.out.println("Letra: " + letra + ", posição: " + pos);
    		pos++;
    	}
	}
}
