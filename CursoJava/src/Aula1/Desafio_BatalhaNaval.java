/* ---------------------------------------------------------
 * Desafio: BATALHA NAVAL
 * ---------------------------------------------------------
 *  Cada jogador deve dispor de uma área de 10x10 onde ele vai posicionar 
 *  5 navios de tamanhos diferentes: 
 *  um porta-aviões (comprimento 5), 
 *  um encouraçado (comprimento 4), 
 *  um submarino e um destroyer (ambom de comprimento 3), 
 *  e um barco de patrulha (comprimento 2). 
 *  Um jogador nunca deve saber a posição dos navios do oponente. Os navios de 
 *  um mesmo jogador não podem se cruzar e devem estar dentro das fronteiras da
 *  sua área disponível.
 *	Depois que todas as peças estão posicionadas, os jogadores se alternam em turnos 
 *  para lançar bombas sobre o outro oponente especificando qual posição ele deseja 
 *  atacar. Se algum dos navios do jogador que está sendo atacado estiver na posição 
 *  atacada, considera-se que o navio foi atingido. O ataque falha se o atacante lançar
 *  uma bomba em um local onde não existe nenhum navio do oponente.
 *	Caso todos as posições de um navio for atingida, o jogador atacado deve informar o 
 *  oponente qual dos seus navios afundou. O jogo continua até que um jogador afunde 
 *  todos os navios de seu oponente; este jogador é então considerado vencedor.
 *	Você deve desenvolver um programa que jogue uma partida de batalha naval entre 
 *  dois oponentes. Você precisa:
 *	Definir uma maneira de indicar o estado inicial dos navios dos jogadores;
 *	Exibir todos os movimentos dos jogadores, informando se os ataques foram bem 
 *  sucedidos ou não;
 *	Informar quando um navio é atingido e quando ele é afundado;
 *	Exibir ao final do jogo um mapa final do posicionamento final dos navios dos jogadores.
 */

package Aula1;

import java.util.Scanner;

public class Desafio_BatalhaNaval {
	static Scanner entrada = new Scanner (System.in);
	static String[][] t1 = new String[10][10];
	static String[][] t2 = new String[10][10];
	static barco barcoPA1 = new barco("PA", 1);
	static barco barcoEN1 = new barco("EN", 1);
	static barco barcoSB1 = new barco("SB", 1);
	static barco barcoDT1 = new barco("DT", 1);
	static barco barcoBP1 = new barco("BP", 1);
	static barco barcoPA2 = new barco("PA", 1);
	static barco barcoEN2 = new barco("EN", 1);
	static barco barcoSB2 = new barco("SB", 1);
	static barco barcoDT2 = new barco("DT", 1);
	static barco barcoBP2 = new barco("BP", 1);
	static Jogadas jogadasJogador1 = new Jogadas();
	static Jogadas jogadasJogador2 = new Jogadas();
	
	
		
	public static String[][] escolherTabuleiro(int jogador) {
		if (jogador == 1)
			return t1;
		if (jogador == 2)
			return t2;
		else
			return null;
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
	
	
	public static void posicionarNavio(int jogador, barco barcoo ){	
		String descricao = barcoo.descricaoBarco();
		int tamanho = barcoo.returnTamanho(descricao);
		
		System.out.println("Jogador " + jogador + ",\n"
				+ "Posicione seu " + descricao + " com tamanho " + tamanho + "...");

		int linha = Desafio_BatalhaNaval.getLinha();
		int coluna = Desafio_BatalhaNaval.getColuna();
		String direcao = Desafio_BatalhaNaval.getDirecao();
		
		System.out.println(descricao + " posicionado em linha " + linha + ", coluna " + coluna + ", direção " + direcao );
		
		Desafio_BatalhaNaval.adicionaNavioNoTabuleiro(jogador, linha, coluna, direcao, tamanho, descricao);
	}
	
		
	public static void adicionaNavioNoTabuleiro(int jogador, int linha, int coluna, String direcao, int tamanho, String peca){
		String[][] tabuleiro = escolherTabuleiro(jogador);

		if (direcao.equals("v")) {
			for (int count = linha; count < (linha + tamanho); count++) {
				if (count > 9)
					System.out.println("Posição Inválida! Excede o tabuleiro!");
				else
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
				if (count > 9)
					System.out.println("Posição Inválida! Excede o tabuleiro!");
				else
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
	
	
	public static boolean checaFimDoJogo(int tabuleiro) {
		if (tabuleiro == 2) {
			 if ((barcoPA2.returnVidaAtual() == 0) && (barcoEN2.returnVidaAtual() == 0)
				 && (barcoSB2.returnVidaAtual() == 0) && (barcoDT2.returnVidaAtual() == 0) &&
			 	(barcoBP2.returnVidaAtual() == 0)) {
					 return true;
				}
			 else 
				 return false;
		}
		if (tabuleiro == 1) {
			 if ((barcoPA1.returnVidaAtual() == 0) && (barcoEN1.returnVidaAtual() == 0)
				 && (barcoSB1.returnVidaAtual() == 0) && (barcoDT1.returnVidaAtual() == 0) &&
				(barcoBP1.returnVidaAtual() == 0)) {
					 return true;
					 }
			 else
				 return false;
		 }
		else 
			return false;
	}


	public static boolean checarAtaque(int jogador, int linhaAtaque, int colunaAtaque) {
		String[][] tabuleiro = new String[10][10];
		boolean ataqueResult = false;

		tabuleiro = escolherTabuleiro(jogador);
	
		if (jogador == 1) {
			switch (tabuleiro[linhaAtaque][colunaAtaque]) {
				case "PA": 
						(barcoPA1).decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						ataqueResult = true;
						break;
						
					case "EN": 
						barcoEN1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						ataqueResult = true;
						break;
						
					case "SB": 
						barcoSB1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						ataqueResult = true;
						break;
						
					case "DT": 
						barcoDT1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						ataqueResult = true;
						break;
						
					case "BP": 
						barcoBP1.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
						ataqueResult = true;
						break;
						
					case "--":
						System.out.println("Você errou!");
						ataqueResult = false;
						break;
			}
			tabuleiro[linhaAtaque][colunaAtaque] = "--";
			montarTabuleiro(tabuleiro);
		}
		if (jogador == 2) {
			switch (tabuleiro[linhaAtaque][colunaAtaque]) {
			case "PA": 
					barcoPA2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
					ataqueResult = true;
					break;
					
				case "EN": 
					barcoEN2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
					ataqueResult = true;
					break;
					
				case "SB": 
					barcoSB2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
					ataqueResult = true;
					break;
					
				case "DT": 
					barcoDT2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
					ataqueResult = true;
					break;
					
				case "BP": 
					barcoBP2.decreaseVida(tabuleiro[linhaAtaque][colunaAtaque]);
					ataqueResult = true;
					break;
					
				case "--":
					System.out.println("Você errou!");
					ataqueResult = false;
					break;
		}
		tabuleiro[linhaAtaque][colunaAtaque] = "--";
		montarTabuleiro(tabuleiro);
	}
		return ataqueResult;	
		
	}

 


	public static void main(String[] args) {

		int jogador;
		boolean fimDoJogo = false;
		boolean acerto = false;
				
		jogador = 1;
		posicionarNavio(jogador, barcoPA1); // Cria um <Porta-Aviões> para o Jogador 1
		posicionarNavio(jogador, barcoEN1); // Cria um <Enconraçado> para o Jogador 1
		posicionarNavio(jogador, barcoSB1); // Cria um <Submarino> para o Jogador 1
		posicionarNavio(jogador, barcoDT1); // Cria um <Destroyer> para o Jogador 1
		posicionarNavio(jogador, barcoBP1); // Cria um <Barco de Patrulha> para o Jogador 1
		
		jogador = 2;
		posicionarNavio(jogador, barcoPA2); // Cria um <Porta-Aviões> para o Jogador 2
		posicionarNavio(jogador, barcoEN2); // Cria um <Enconraçado> para o Jogador 2
		posicionarNavio(jogador, barcoSB2); // Cria um <Submarino> para o Jogador 2
		posicionarNavio(jogador, barcoDT2); // Cria um <Destroyer> para o Jogador 2
		posicionarNavio(jogador, barcoBP2); // Cria um <Barco de Patrulha> para o Jogador 2
		
		do {
			
			acerto = guerrear(1,2); // jogador 1 atacando tabuleiro 2
			
			if (acerto == true){
				if (checaFimDoJogo(2) == true) { // tabuleiro
					System.out.println("Jogo acabou");
					jogadasJogador1.imprimeJogadas();
					break;
				}		
			}
		
			acerto = guerrear(2,1);
				
			if (acerto == true){
				if (checaFimDoJogo(1) == true) { // tabuleiro
					System.out.println("Jogo acabou");
					jogadasJogador2.imprimeJogadas();
					break;
				}		
			}	

		} while (fimDoJogo == false);
	} //end main()



	public static boolean guerrear(int jogador, int tabuleiro){
		boolean sucesso;
					
		System.out.println("Jogador " + jogador + ", entre com a linha e coluna de ataque:");
		System.out.println("linhaAtaque: ");
		int linhaAtaque = entrada.nextInt();	
		System.out.println("colunaAtaque: ");
		int colunaAtaque = entrada.nextInt();
		
		sucesso = checarAtaque(tabuleiro, linhaAtaque, colunaAtaque);
		
		if (jogador == 1) 
			jogadasJogador1.armazenaJogadas(linhaAtaque, colunaAtaque, sucesso);
		if (jogador == 2) 			
			jogadasJogador2.armazenaJogadas(linhaAtaque, colunaAtaque, sucesso);
		
		return sucesso;
	}
	



} //end class