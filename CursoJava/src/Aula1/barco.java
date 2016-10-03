package Aula1;

public class barco {
	String descricaoBarco;
	int vidaCheia;
	int vidaAtual;
	int barcosVivos = 5;
	int tamanho;
	
	public barco(String descricao, int tamanho){
		descricaoBarco = descricao;
		vidaCheia = tamanho;
		vidaAtual = tamanho;
		this.tamanho = tamanho;
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
		return tamanho;
	}

	public int returnVidaAtual(){
		return vidaAtual;
	}
	
	public String descricaoBarco(){
		return descricaoBarco;
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
