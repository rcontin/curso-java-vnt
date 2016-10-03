// test commit

package Aula1;

import java.util.Scanner;

public class Desafio_BatalhaNaval {
	static Scanner entrada = new Scanner (System.in);
	static String[][] t1 = new String[10][10];
	static String[][] t2 = new String[10][10];
	static barco barcoPA1 = new barco("PA", 5);
	static barco barcoEN1 = new barco("EN", 4);
	static barco barcoSB1 = new barco("SB", 3);
	static barco barcoDT1 = new barco("DT", 3);
	static barco barcoBP1 = new barco("BP", 2);
	static barco barcoPA2 = new barco("PA", 5);
	static barco barcoEN2 = new barco("EN", 4);
	static barco barcoSB2 = new barco("SB", 3);
	static barco barcoDT2 = new barco("DT", 3);
	static barco barcoBP2 = new barco("BP", 2);
	
	
	
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
			
			System.out.println("Peça posicionada em: ");
			for (int count = linha; count < (linha + tamanho); count++) {
				System.out.println("tabuleiro["+ count + "][" + coluna + "]");
			}
			
			montarTabuleiro(tabuleiro);
		}
			
		else if (direcao.equals("h")) {
			for (int count = coluna; count < (coluna + tamanho); count++) {
				tabuleiro[linha][count] = peca;
			}
			
			System.out.println("Peça posicionada em: ");
			for (int count = coluna; count < (coluna + tamanho); count++) {
				System.out.println("tabuleiro[" + linha + "][" + count + "]");
			}
			
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
	
	
	
	public void atacar(){
		
		
	}
	
	public void checarDano(int linha, int coluna){
		
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
		
		int jogador;
		
		for (jogador = 1; jogador <= 2; jogador++) {
			posicionarNavio(jogador, descricaoPA, tamanhoPortaAvioes);
			//posicionarNavio(jogador, descricaoEN, tamanhoEncouracado);
			//posicionarNavio(jogador, descricaoSB, tamanhoSubmarino);
			//posicionarNavio(jogador, descricaoDT, tamanhoDestroyer);
			//posicionarNavio(jogador, descricaoBP, tamanhoBarcoDePatrulha);
		}
		
		do {
			System.out.println("Jogador 1, entre com a linha e coluna de ataque:");
			System.out.println("linhaAtaque: ");
			int linhaAtaque = entrada.nextInt();	
			System.out.println("linhaAtaque: ");
			int colunaAtaque = entrada.nextInt();
			int tabuleiro = 2;
			
			checarAtaque(tabuleiro, linhaAtaque, colunaAtaque);
			
			if (checaFimDoJogo(1) == true) {
				System.out.println("Jogo acabou");
			}
			
			else {
				
				System.out.println("Jogador 2, entre com a linha e coluna de ataque:");
				System.out.println("linhaAtaque: ");
				linhaAtaque = entrada.nextInt();	
				System.out.println("linhaAtaque: ");
				colunaAtaque = entrada.nextInt();
				tabuleiro = 1;
				
				checarAtaque(tabuleiro, linhaAtaque, colunaAtaque);
				
				if (checaFimDoJogo(2) == true) {
					System.out.println("Jogo acabou");
				}
				
			}
		} while (checaFimDoJogo(1) == false);

}

	
		public static void checarAtaque(int jogador, int linhaAtaque, int colunaAtaque) {
			String[][] tabuleiro = new String[10][10];

			tabuleiro = escolherTabuleiro(jogador);
		
			if (jogador == 1) {
				switch (tabuleiro[linhaAtaque][colunaAtaque]) {
					case "PA": 
							(barcoPA1).decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
							break;
							
						case "EN": 
							barcoEN1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
							break;
							
						case "SB": 
							barcoSB1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
							break;
							
						case "DT": 
							barcoDT1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
							break;
							
						case "BP": 
							barcoBP1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
							break;
							
						case "--":
							System.out.println("Você errou!");
							break;
				}
				tabuleiro[linhaAtaque][colunaAtaque] = "--";
				montarTabuleiro(tabuleiro);
			}
			if (jogador == 2) {
				switch (tabuleiro[linhaAtaque][colunaAtaque]) {
				case "PA": 
						barcoPA2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						break;
						
					case "EN": 
						barcoEN2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						break;
						
					case "SB": 
						barcoSB2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						break;
						
					case "DT": 
						barcoDT2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						break;
						
					case "BP": 
						barcoBP2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						break;
						
					case "--":
						System.out.println("Você errou!");
						break;
			}
			tabuleiro[linhaAtaque][colunaAtaque] = "--";
			montarTabuleiro(tabuleiro);
		}	
			
		}

 public static boolean checaFimDoJogo(int jogador) {
if (jogador == 1) {
	 if ((barcoPA2.returnVidaAtual() == 0) && (barcoEN2.returnVidaAtual() == 0)
			 && (barcoSB2.returnVidaAtual() == 0) && (barcoDT2.returnVidaAtual() == 0) &&
		 	(barcoBP2.returnVidaAtual() == 0)) 
			 {
			 return true;
			 }
	 else 
		 return false;
}
if (jogador == 2) {
	 if ((barcoPA1.returnVidaAtual() == 0) && (barcoEN1.returnVidaAtual() == 0)
			 && (barcoSB1.returnVidaAtual() == 0) && (barcoDT1.returnVidaAtual() == 0) &&
		 	(barcoBP1.returnVidaAtual() == 0)) 
			 {
			 return true;
			 }
	 else
		 return false;

 }
else 
	return false;
 }

} //end classe desafio batalha naval