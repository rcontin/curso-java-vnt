package Aula1;
// Faça um programa em Java que liste todos os números primos abaixo de 1000
public class Ex3_Primos {

	public static void main(String[] args) {
		
		for (int cont = 0; cont < 1000; cont++) {
			int restoDivisao = 0;
			
			for (int divisor = 1; divisor < (cont); divisor++) {
				if (cont % divisor == 0) {
					restoDivisao = restoDivisao + 1;
				}
			}
			
			if (cont == 1)
				restoDivisao = 1;
			
			if (restoDivisao == 1) 
				System.out.println("Numero " + cont + " é Primo!");
			
		}
	}
}
