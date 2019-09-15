/* Programa capaz de calcular a velocidade média de um veículo com base em sua trajetória e
 * verificar em qual "via" o veículo estava(informação dada pelo usuário) e dizer se estava
 * àcima do limite e informar o valor da multa
 */
package ProvaMetods;

import javax.swing.JOptionPane;

public class VelociMedia {
	
	static float VelMed(float Dis1,float Dis2, float Tim) {//Método de cálculo da velocidade média
		float VelM =0;
		
		VelM=(Dis2 -Dis1)/Tim;
		
		return VelM;
	}
	static float VelMax(float VelM, String Av) {//Método para verificar qual era a velocidade máxima da via
		float VelMax =0;
		
		switch(Av) {//Velocidades máximas imaginaria ;)
		case "Av. Dutra":
			VelMax = 120;
			break;
		case "Av. Pires do Rio":
			VelMax = 100;
			break;
		case "Av. Jacú Pêssego":
			VelMax = 120;
			break;
		case "Av. Washington Luís":
			VelMax = 80;
			break;
		case "Av. Afonso Trigo":
			VelMax = 80;
			break;
		}
		
		
		return VelMax;
	}

	public static void main(String[] args) {
		String Avenida ="", Placa ="", Vias[]= {" ","Av. Dutra", "Av. Pires do Rio", "Av. Jacú Pêssego", "Av. Washington Luís", "Av. Afonso Trigo"};
		float VelM =0, VelMax =0, Dist1 =0, Dist2 =0, Time =0;
		
		Placa = JOptionPane.showInputDialog(null, "Insira o número da placa:");
		
		Avenida = (String)JOptionPane.showInputDialog(null, "Qual o nome da Avenida em que o Veículo esta?:", "Velocimetro", 3, null, Vias, Vias[0]);
		
		Dist1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Qual era a distância inicial do Veículo?:", "Velocimetro", 3));
		Dist2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Qual era a última distância do Veículo?:", "Velocimetro", 3));
		
		Time = Float.parseFloat(JOptionPane.showInputDialog(null, "Quanto tempo demorou este percurso?:", "Velocimetro", 3));
		
		VelM = VelMed(Dist1, Dist2, Time);
		
		VelMax = VelMax(VelM, Avenida);
		
		if(VelM>VelMax) {//Verificação da necessidade de multa
			
			float Mult =(float)(VelM*((0.15)*(VelM-VelMax)));//Cálculo da multa
			
			JOptionPane.showMessageDialog(null, "Veículo(" + Placa + ") está àcima da velocidade permitida na via:\nAv. " + Avenida + "\nVelocidade média de " + VelM + "km/h\n(" + (VelM-VelMax) + "km àcima do limite de " + VelMax + "km/h)\nMulta estipulada de :\n" + Mult, "Velocimetro", 2);
			
		}else {
			JOptionPane.showMessageDialog(null, "Veículo à " + VelM + "km/h \nMáxima da Avenida de " + VelMax + "km/h\nSEM INFRAÇÃO.", "Velocimetro", 1);
		}
		

	}

}
