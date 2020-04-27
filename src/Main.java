import java.io.IOException;

public class Main {

	static String FICHIER = "ptitTest.txt";

	public static void main(String[] args) throws IOException {
		int compteLine = CalculeFacture.compteLine(FICHIER);
		String[] tabSansFin = CalculeFacture.lireFichier(FICHIER); 
		tabSansFin = CalculeFacture.remLastCase(tabSansFin);
		int[] tabIndex = CalculeFacture.indexSection(tabSansFin);
		
		CalculeFacture.verification(tabIndex, tabSansFin);
		 
		
		
		
	}

}