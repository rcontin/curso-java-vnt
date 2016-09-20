package Aula1;

import java.util.Scanner;

public class Desafio_BatalhaNaval {
	static Scanner entrada = new Scanner (System.in);
	static String[][] t1 = new String[10][10];
	static String[][] t2 = new String[10][10];

	public static String[][] escolherTabuleiro(int jogador) {
		if (jogador == 1)
			return t1;
		if (jogador == 2)
			return t2;
		else
			return null;
	}
	
	public static void posicionarNavio(int jogador, String descricao, int tamanho){			
		System.out.println("Jogador " + jogador + ",\n"
				+ "Posicione seu " + descricao + " com tamanho " + tamanho + "...");

		int linha = Desafio_BatalhaNaval.getLinha();
		int coluna = Desafio_BatalhaNaval.getColuna();
		String direcao = Desafio_BatalhaNaval.getDirecao();
		
		System.out.println(descricao + " posicionado em linha " + linha + ", coluna " + coluna + ", direção " + direcao );
				 
		Desafio_BatalhaNaval.adicionaNavioNoTabuleiro(jogador, linha, coluna, direcao, tamanho, descricao);
	}
	
	public static int getLinha(){			
		System.out.println("Qual linha deseja posicionar? ");
		int linha = entrada.nextInt();	
			
		return linha;
	}
	
	public static int getColuna(){			
		System.out.println("Qual coluna deseja posicionar? ");
		int coluna = entrada.nextInt();	
			
		return coluna;
	}
	
	public static String getDirecao(){			
		System.out.println("Deseja que ele fique na horizontal ou vertical?"
				+ " (Digite V para vertical ou H para horizontal): ");
		String direcao = entrada.next();
			
		return direcao;
	}
	
	public static void adicionaNavioNoTabuleiro(int jogador, int linha, int coluna, String direcao, int tamanho, String peca){
		String[][] tabuleiro = escolherTabuleiro(jogador);

		if (direcao.equals("v")) {
			for (int count = linha; count < (linha + tamanho); count++) {
				tabuleiro[count][coluna] = peca;
			}
			
//			System.out.println("Peça posicionada em: ");
//			for (int count = linha; count < (linha + tamanho); count++) {
//				System.out.println("tabuleiro["+ count + "][" + coluna + "]");
//			}
			
			montarTabuleiro(tabuleiro);
		}
			
		else if (direcao.equals("h")) {
			for (int count = coluna; count < (coluna + tamanho); count++) {
				tabuleiro[linha][count] = peca;
			}
			
//			System.out.println("Peça posicionada em: ");
//			for (int count = coluna; count < (coluna + tamanho); count++) {
//				System.out.println("tabuleiro[" + linha + "][" + count + "]");
//			}
			
			montarTabuleiro(tabuleiro);
			
		}	

		else {
			System.out.println("Direcao nao reconhecida!");
		}
	}
		
	public static void montarTabuleiro(String value[][]) {	
		
		for (int linha = 0; linha <= 9; linha++) {
			for (int coluna = 0; coluna <= 9; coluna++) {
				if (value[linha][coluna] == null)
					value[linha][coluna] = "--";
				
				System.out.print("| " + linha + "," + coluna + ". " + value[linha][coluna] + " ");
				
				if (coluna==9) {
					System.out.println("|");
				}
			}
		}
	}


	public static void main(String[] args) {
		String descricaoPA = new String("PA"); // PortaAvioes
		int tamanhoPortaAvioes = 5;
		String descricaoEN = new String("EN"); // Encouraçado
		int tamanhoEncouracado = 4;
		String descricaoSB = new String("SB"); // Submarino
		int tamanhoSubmarino = 3; 
		String descricaoDT = new String("DT"); // Destroyer
		int tamanhoDestroyer = 3;
		String descricaoBP = new String("BP"); // BarcoPatrulha
		int tamanhoBarcoDePatrulha = 2;
		
		for (int jogador = 1; jogador <= 2; jogador++) {
			posicionarNavio(jogador, descricaoPA, tamanhoPortaAvioes);
			posicionarNavio(jogador, descricaoEN, tamanhoEncouracado);
			posicionarNavio(jogador, descricaoSB, tamanhoSubmarino);
			posicionarNavio(jogador, descricaoDT, tamanhoDestroyer);
			posicionarNavio(jogador, descricaoBP, tamanhoBarcoDePatrulha);
		}
	}


}

	
		
