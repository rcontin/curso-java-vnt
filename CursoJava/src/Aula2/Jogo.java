/* 
 
1. Utilizando os conceitos aprendidos neste capítulo, implemente uma
classe chamada Jogo, com os atributos: nome, plataforma, gênero,
desenvolvedora.
2. Esta classe dever ter um construtor onde são passados os parâmetros.
3. Crie um método exibe(), onde são exibidos na tela os detalhes do Jogo.
4. Crie uma classe de teste TestaJogo, onde a classe Jogo será
instanciada com valores a sua escolha e os valores serão exibidos na
tela. 

*/

package Aula2;

public class Jogo {
	String nome;
	String plataforma;
	String genero;
	String desenvolvedora;
    	
	public Jogo(String nome, String plataforma, String genero, String desenvolvedora) {
	    this.nome = nome;	
	    this.plataforma = plataforma;
	    this.genero = genero;
	    this.desenvolvedora = desenvolvedora;
	}
	
	public void exibe() {
		System.out.println("Nome..........: " + nome + "\n"
						 + "Plataforma....: " + plataforma + "\n"
						 + "Genero........: " + genero + "\n"
						 + "Desenvolvedora: " + desenvolvedora + "\n");
	}
}
