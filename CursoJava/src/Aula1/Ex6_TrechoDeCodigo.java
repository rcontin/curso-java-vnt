// 6. Qual o valor de i e n após a execução?

package Aula1;

public class Ex6_TrechoDeCodigo {

	public static void main(String[] args) {
		int i = 10;
		int n = i++%5;
		
		System.out.println("i =  " + i); //Deve ser 11
		System.out.println("n =  " + n); //Deve ser 0
	}
	
}
