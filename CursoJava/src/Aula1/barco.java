package Aula1;

public class barco {
	String descricaoBarco;
	int vidaCheia;
	int vidaAtual;
	int barcosVivos = 5;
	
	public barco(String descricao, int tamanho){
		descricaoBarco = descricao;
		vidaCheia = tamanho;
		vidaAtual = tamanho;
	}
	
	public void decreaseVida(String barco) {
		vidaAtual--;
		System.out.println("Barco " + descricaoBarco + " ainda tem " + vidaAtual + " vidas");
		
		if (vidaAtual == 0) {
			System.out.println("Barco Destruído!");
			barcosVivos--;
			
			if (barcosVivos == 0)
				System.out.println("Você Perdeu");
		}
	}
	
	public int returnTamanho(String barco){
		int tamanho = 0;
		switch (barco){
		case "PA": tamanho = 5;
		case "EN": tamanho = 4;
		case "SB": tamanho = 3;
		case "DT": tamanho = 3;
		case "BP": tamanho = 2;
		}
		return tamanho;
	}

	public int returnVidaAtual(){
		return vidaAtual;
	}
	
	
	public void storePosition(int linha, int coluna, int vida) {
		
		
	}
	
	
	public void setaArrayLinha(int linha, int vida) {	
		int arrayLinha[] = new int[vida];
		
		for (int count = 0; count < vida; count++) {
			arrayLinha[count] = linha;
		}
	}

	public void setaArrayColuna(int coluna, int vida) {	
		int arrayColuna[] = new int[vida];
		
		for (int count = 0; count < vida; count++) {
			arrayColuna[count] = coluna;
		}
	}



}
