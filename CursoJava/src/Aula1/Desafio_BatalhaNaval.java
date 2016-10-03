/* ---------------------------------------------------------
 * Desafio: BATALHA NAVAL
 * ---------------------------------------------------------
 *  Cada jogador deve dispor de uma �rea de 10x10 onde ele vai posicionar 
 *  5 navios de tamanhos diferentes: 
 *  um porta-avi�es (comprimento 5), 
 *  um encoura�ado (comprimento 4), 
 *  um submarino e um destroyer (ambom de comprimento 3), 
 *  e um barco de patrulha (comprimento 2). 
 *  Um jogador nunca deve saber a posi��o dos navios do oponente. Os navios de 
 *  um mesmo jogador n�o podem se cruzar e devem estar dentro das fronteiras da
 *  sua �rea dispon�vel.
 *	Depois que todas as pe�as est�o posicionadas, os jogadores se alternam em turnos 
 *  para lan�ar bombas sobre o outro oponente especificando qual posi��o ele deseja 
 *  atacar. Se algum dos navios do jogador que est� sendo atacado estiver na posi��o 
 *  atacada, considera-se que o navio foi atingido. O ataque falha se o atacante lan�ar
 *  uma bomba em um local onde n�o existe nenhum navio do oponente.
 *	Caso todos as posi��es de um navio for atingida, o jogador atacado deve informar o 
 *  oponente qual dos seus navios afundou. O jogo continua at� que um jogador afunde 
 *  todos os navios de seu oponente; este jogador � ent�o considerado vencedor.
 *	Voc� deve desenvolver um programa que jogue uma partida de batalha naval entre 
 *  dois oponentes. Voc� precisa:
 *	Definir uma maneira de indicar o estado inicial dos navios dos jogadores;
 *	Exibir todos os movimentos dos jogadores, informando se os ataques foram bem 
 *  sucedidos ou n�o;
 *	Informar quando um navio � atingido e quando ele � afundado;
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
		
		System.out.println(descricao + " posicionado em linha " + linha + ", coluna " + coluna + ", dire��o " + direcao );
		
		Desafio_BatalhaNaval.adicionaNavioNoTabuleiro(jogador, linha, coluna, direcao, tamanho, descricao);
	}
	
		
	public static void adicionaNavioNoTabuleiro(int jogador, int linha, int coluna, String direcao, int tamanho, String peca){
		String[][] tabuleiro = escolherTabuleiro(jogador);

		if (direcao.equals("v")) {
			for (int count = linha; count < (linha + tamanho); count++) {
				tabuleiro[count][coluna] = peca;
			}
			
			System.out.println("Pe�a posicionada em: ");
			for (int count = linha; count < (linha + tamanho); count++) {
				System.out.println("tabuleiro["+ count + "][" + coluna + "]");
			}
			
			montarTabuleiro(tabuleiro);
		}
			
		else if (direcao.equals("h")) {
			for (int count = coluna; count < (coluna + tamanho); count++) {
				tabuleiro[linha][count] = peca;
			}
			
			System.out.println("Pe�a posicionada em: ");
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
	
	
	public static boolean checaFimDoJogo(int jogador) {
		if (jogador == 1) {
			 if ((barcoPA2.returnVidaAtual() == 0) && (barcoEN2.returnVidaAtual() == 0)
				 && (barcoSB2.returnVidaAtual() == 0) && (barcoDT2.returnVidaAtual() == 0) &&
			 	(barcoBP2.returnVidaAtual() == 0)) {
					 return true;
				}
			 else 
				 return false;
		}
		if (jogador == 2) {
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
						System.out.println("Voc� errou!");
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
					System.out.println("Voc� errou!");
					ataqueResult = false;
					break;
		}
		tabuleiro[linhaAtaque][colunaAtaque] = "--";
		montarTabuleiro(tabuleiro);
	}
		return ataqueResult;	
		
	}

 


	public static void main(String[] args) {
		int[] movimentoLinhasJogador1 = new int[10];
		int[] movimentoColunasJogador1 = new int[10];
		boolean[] movimentoResultJogador1 = new boolean[10];
		int jogador;
		boolean fimDoJogo = false;
		int count1 = 0;
		
		
		jogador = 1;
		posicionarNavio(jogador, barcoPA1); // Cria um Porta-Avi�es para o Jogador 1
		posicionarNavio(jogador, barcoEN1); // Cria um Porta-Avi�es para o Jogador 1
		posicionarNavio(jogador, barcoSB1); // Cria um Porta-Avi�es para o Jogador 1
		posicionarNavio(jogador, barcoDT1); // Cria um Porta-Avi�es para o Jogador 1
		posicionarNavio(jogador, barcoBP1); // Cria um Porta-Avi�es para o Jogador 1
		
		jogador = 2;
		posicionarNavio(jogador, barcoPA2);
		posicionarNavio(jogador, barcoEN2);
		posicionarNavio(jogador, barcoSB2);
		posicionarNavio(jogador, barcoDT2);
		posicionarNavio(jogador, barcoBP2);
		
		
		do {
			System.out.println("Jogador 1, entre com a linha e coluna de ataque:");
			System.out.println("linhaAtaque: ");
			int linhaAtaque = entrada.nextInt();	
			movimentoLinhasJogador1[count1] = linhaAtaque;
			System.out.println("linhaAtaque: ");
			int colunaAtaque = entrada.nextInt();
			movimentoColunasJogador1[count1] = colunaAtaque;
			
			int tabuleiro = 2; // jogador 1 ataca no tabuleiro 2
			
			movimentoResultJogador1[count1] = checarAtaque(tabuleiro, linhaAtaque, colunaAtaque);
			count1++;
			
			if (checaFimDoJogo(1) == true) {
				System.out.println("Jogo acabou");
				fimDoJogo = true;
				for (int i = 0; i < 10 ; i++)
					System.out.println("Movimentos: " + movimentoLinhasJogador1[i] + movimentoColunasJogador1[i] + movimentoResultJogador1[i]);
			}		
			else {	
				System.out.println("Jogador 2, entre com a linha e coluna de ataque:");
				System.out.println("linhaAtaque: ");
				linhaAtaque = entrada.nextInt();	
				System.out.println("linhaAtaque: ");
				colunaAtaque = entrada.nextInt();
				tabuleiro = 1; // jogador 2 ataca no tabuleiro 1
				
				checarAtaque(tabuleiro, linhaAtaque, colunaAtaque);
				
				if (checaFimDoJogo(2) == true) {
					System.out.println("Jogo acabou");
					fimDoJogo = true;
				}	
			}
		} while (fimDoJogo == false);
	} //end main()
	
} //end class