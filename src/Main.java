import java.io.IOException;

public class Main {

	static String FICHIER = "restaurant.txt";

	public static void main(String[] args) throws IOException {
		int compteLine = CalculeFacture.compteLine(FICHIER);
		System.out.println("Ligne="+compteLine);
		String[] tabSansFin = CalculeFacture.lireFichier(FICHIER);
		System.out.println("length ligne = " + tabSansFin.length);
		tabSansFin = CalculeFacture.remLastCase(tabSansFin);
		System.out.println(tabSansFin[0] + " verification du premier donner du tableau");
		int[] tabIndex = CalculeFacture.indexSection(tabSansFin);
		System.out.println(tabIndex[0]+"index"+tabIndex[1]+tabIndex[2]);
		System.out.println("Equation " + ((tabIndex[2] - tabIndex[1])-1));
		if (tabIndex[0] == 1234567890) {
			System.out.println("Vous avez oublié de mettre un des trois catégories sur des lignes"
					+ " séparer avec un deux points à la fin (Clients :, Plats :, Commandes :)");
		}else if (tabIndex[0] == 987654321) {
			System.out.println(tabSansFin[0]);
		}else if (!tabSansFin[tabIndex[0]].contains("Clients :") || !tabSansFin[tabIndex[1]].contains("Plats :") 
				|| !tabSansFin[tabIndex[2]].contains("Commandes :") ) {
			System.out.println("Les sections ne sont pas en bonne ordre ou ils sont mal écrit"
					+ "(Clients :, Plats :, Commandes :)");
		}else if (tabIndex[1] - 1 < 1 || (tabIndex[2] - tabIndex[1] <= 1 || 
				(tabSansFin.length-tabIndex[2]) <= 1)) {
			System.out.println("Il a aucun contenu dans le fichier");
		}else{
			System.out.println("yes");
			String[][] tabPersonne = new String[tabIndex[1] - 1][2];
			String[][] tabPlat = new String[(tabIndex[2] - tabIndex[1])-1][2];
			String[][] tabCommande = new String[tabSansFin.length - tabIndex[2]][3];
			tabPersonne = CalculeFacture.creerTabPersonne(tabIndex, tabSansFin);
			tabPlat = CalculeFacture.creerTabPlat(tabIndex, tabSansFin);
			tabCommande = CalculeFacture.creerTabCommande(tabIndex, tabSansFin);

			CalculeFacture.creerFichier(CalculeFacture.dateFichier(),tabPlat,tabPersonne,tabCommande);
			
		}
		
		
		
	}

}