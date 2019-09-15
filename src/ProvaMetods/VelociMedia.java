/* Programa capaz de calcular a velocidade m�dia de um ve�culo com base em sua trajet�ria e
 * verificar em qual "via" o ve�culo estava(informa��o dada pelo usu�rio) e dizer se estava
 * �cima do limite e informar o valor da multa
 */
package ProvaMetods;

import javax.swing.JOptionPane;

public class VelociMedia {
	
	static float VelMed(float Dis1,float Dis2, float Tim) {//M�todo de c�lculo da velocidade m�dia
		float VelM =0;
		
		VelM=(Dis2 -Dis1)/Tim;
		
		return VelM;
	}
	static float VelMax(float VelM, String Av) {//M�todo para verificar qual era a velocidade m�xima da via
		float VelMax =0;
		
		switch(Av) {//Velocidades m�ximas imaginaria ;)
		case "Av. Dutra":
			VelMax = 120;
			break;
		case "Av. Pires do Rio":
			VelMax = 100;
			break;
		case "Av. Jac� P�ssego":
			VelMax = 120;
			break;
		case "Av. Washington Lu�s":
			VelMax = 80;
			break;
		case "Av. Afonso Trigo":
			VelMax = 80;
			break;
		}
		
		
		return VelMax;
	}

	public static void main(String[] args) {
		String Avenida ="", Placa ="", Vias[]= {" ","Av. Dutra", "Av. Pires do Rio", "Av. Jac� P�ssego", "Av. Washington Lu�s", "Av. Afonso Trigo"};
		float VelM =0, VelMax =0, Dist1 =0, Dist2 =0, Time =0;
		
		Placa = JOptionPane.showInputDialog(null, "Insira o n�mero da placa:");
		
		Avenida = (String)JOptionPane.showInputDialog(null, "Qual o nome da Avenida em que o Ve�culo esta?:", "Velocimetro", 3, null, Vias, Vias[0]);
		
		Dist1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Qual era a dist�ncia inicial do Ve�culo?:", "Velocimetro", 3));
		Dist2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Qual era a �ltima dist�ncia do Ve�culo?:", "Velocimetro", 3));
		
		Time = Float.parseFloat(JOptionPane.showInputDialog(null, "Quanto tempo demorou este percurso?:", "Velocimetro", 3));
		
		VelM = VelMed(Dist1, Dist2, Time);
		
		VelMax = VelMax(VelM, Avenida);
		
		if(VelM>VelMax) {//Verifica��o da necessidade de multa
			
			float Mult =(float)(VelM*((0.15)*(VelM-VelMax)));//C�lculo da multa
			
			JOptionPane.showMessageDialog(null, "Ve�culo(" + Placa + ") est� �cima da velocidade permitida na via:\nAv. " + Avenida + "\nVelocidade m�dia de " + VelM + "km/h\n(" + (VelM-VelMax) + "km �cima do limite de " + VelMax + "km/h)\nMulta estipulada de :\n" + Mult, "Velocimetro", 2);
			
		}else {
			JOptionPane.showMessageDialog(null, "Ve�culo � " + VelM + "km/h \nM�xima da Avenida de " + VelMax + "km/h\nSEM INFRA��O.", "Velocimetro", 1);
		}
		

	}

}
