package Aula1;

import java.util.ArrayList;

public class Jogadas {
	static ArrayList<Integer> movimentoLinhasJogador = new ArrayList<>();
	static ArrayList<Integer> movimentoColunasJogador = new ArrayList<>();
	static ArrayList<Boolean> movimentoResultJogador = new ArrayList<>();
	static int tamanho = 0;

	public void armazenaJogadas(int linha, int coluna, boolean sucesso){
		movimentoLinhasJogador.add(linha);
		movimentoColunasJogador.add(coluna);	
		movimentoResultJogador.add(sucesso);
	}
	
	public int returnTam() {
		tamanho = movimentoResultJogador.size();
		return tamanho;
	}
	
	public void imprimeJogadas(){
		tamanho = returnTam(); 
		for (int i = 0; i < tamanho ; i++)
			System.out.println("Movimentos: " 
					+ movimentoLinhasJogador.get(i) 
					+ movimentoColunasJogador.get(i) 
					+ movimentoResultJogador.get(i));
	}

} //class Jogadas