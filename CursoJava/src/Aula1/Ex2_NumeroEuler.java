package Aula1;
public class Ex2_NumeroEuler {
	
	public static void main(String[] args) {
		int max = 10; 
		float item = 0;
		
		for (int i = 0; i < (max); i++) {
			int fatorial = 1; // 0! = 1
	
			for (int x = 1; x <= i; x++){
				fatorial = fatorial * x;
			}
			System.out.println(i + "! = " + fatorial);
			
			item = item + (1.0f / fatorial);
			System.out.println("Item " + i + " = 1/" + i + "! --> " + item);			
		}
	}
}