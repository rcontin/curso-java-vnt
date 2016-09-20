// Faça um programa em Java que calcule a soma de todos os inteiros de 1 a 100. 
// Ex: 1+2+3+4+...+100 = ?

package Aula1;
	
public class Ex1_SomaInteiros {
	
	static int subTotal = 0;	

	public static void main(String[] args) {
	
		for (int cont = 1; cont <= 100 ; cont++) {
			System.out.println("Contador = " + cont);
			subTotal = subTotal + cont;  
			System.out.println("Subtotal = " + subTotal);	
		}
		
	}
}
