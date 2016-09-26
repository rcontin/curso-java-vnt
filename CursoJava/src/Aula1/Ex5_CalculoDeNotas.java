// 5. Escreva um programa que faça o cálculo das notas PO1, PO2 
// e calcule se o total de pontos foi suficiente (pontos = PO1x2 + P02x4).

package Aula1;

import java.util.Scanner;

public class Ex5_CalculoDeNotas {
	static Scanner entrada = new Scanner (System.in);
	
	public static void main(String[] args) {
		float PO1;
		float PO2;
		float media;
						
		System.out.println("Entre com PO1: ");
		PO1 = entrada.nextFloat();
		
		System.out.println("Entre com PO2: ");
		PO2 = entrada.nextFloat();

		media = calculaPontos(PO1, PO2);
		System.out.println("Média: " + media);
		
		if (media >= 7.0)
			System.out.println("Média 7 atigida. Aluno Aprovado!");
		else
			System.out.println("Média 7 não atingida. Aluno Reporvado!");

	}
	

	public static float calculaPontos(float PO1, float PO2) {
		float pontos;
		pontos = ((PO1 * 2) + (PO2 * 4));
		pontos = (pontos / 6);
		return pontos;
	}
}
