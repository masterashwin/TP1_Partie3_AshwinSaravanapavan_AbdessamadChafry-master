import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class Test {
	
	@org.junit.jupiter.api.Test
	void testremLastCaseUneDonner() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Clients :"};
		String[] tableau = test.remLastCase(input);
		String[] reponse = {"Erreur il y avait moins qu'une ligne dans le fichier. Ajouter plus de contenu"
				+ " dans la facture et n'oublier pas d'écrire Fin au dernier ligne."};
		
		assertArrayEquals(reponse, tableau);
	}
	
	@org.junit.jupiter.api.Test
	void testremLastCase() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Clients :",
				"Roger",
				"Céline",
				"Steeve"
				,"Plats :"
				,"Poutine 10.5"
				,"Frites 2.5"
				,"Repas_Poulet 15.75"
				,"Commandes :"
				,"Roger Poutine 1"
				,"Céline Frites 2"
				,"Céline Repas_Poulet 1"
				,"Fin"};
		String[] tableau = test.remLastCase(input);
		String[] reponse = {"Clients :",
				"Roger",
				"Céline",
				"Steeve"
				,"Plats :"
				,"Poutine 10.5"
				,"Frites 2.5"
				,"Repas_Poulet 15.75"
				,"Commandes :"
				,"Roger Poutine 1"
				,"Céline Frites 2"
				,"Céline Repas_Poulet 1"};
		assertArrayEquals(reponse, tableau);
	}
	
	@org.junit.jupiter.api.Test
	void testremLastCaseAucuneDonner() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {};
		String[] tableau = test.remLastCase(input);
		String[] reponse = {"Erreur il y avait moins qu'une ligne dans le fichier. Ajouter plus de contenu"
				+ " dans la facture et n'oublier pas d'écrire Fin au dernier ligne."};
		
		assertArrayEquals(reponse, tableau);
	}

	@org.junit.jupiter.api.Test
	void testindexSection() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Clients :",
			"Roger",
			"Céline",
			"Steeve"
			,"Plats :"
			,"Poutine 10.5"
			,"Frites 2.5"
			,"Repas_Poulet 15.75"
			,"Commandes :"
			,"Roger Poutine 1"
			,"Céline Frites 2"
			,"Céline Repas_Poulet 1"};
		int[] tableau = test.indexSection(input);
		int[] reponse = {0,4,8};
		
		assertArrayEquals(reponse, tableau);
	}
	
	@org.junit.jupiter.api.Test
	void testindexSectionTableauErroner() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Erreur autre information"};
		int[] tableau = test.indexSection(input);
		int[] reponse = {1234567890};
		
		assertArrayEquals(reponse, tableau);
	}
	
	@org.junit.jupiter.api.Test
	void testCreerTabPers() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Clients :",
				"Roger",
				"Céline",
				"Steeve"
				,"Plats :"
				,"Poutine 10.5"
				,"Frites 2.5"
				,"Repas_Poulet 15.75"
				,"Commandes :"
				,"Roger Poutine 1"
				,"Céline Frites 2"
				,"Céline Repas_Poulet 1"};
		int[] index = {0,4};
		String[][] tableau = test.creerTabPersonne(index,input);
		String[][] reponse = {{"Roger","C�line","Steeve",""},{"0 ","0 ","0 ","0 "}};
		
		assertArrayEquals(reponse, tableau);
	}
	
	@org.junit.jupiter.api.Test
	void testTabPlat() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Clients :",
				"Roger",
				"CÃ©line",
				"Steeve"
				,"Plats :"
				,"Poutine 10.5"
				,"Frites 2.5"
				,"Repas_Poulet 15.75"
				,"Commandes :"
				,"Roger Poutine 1"
				,"CÃ©line Frites 2"
				,"CÃ©line Repas_Poulet 1"};
		int[] index = {0,4,8};
		String[][] tableau = test.creerTabPlat(index,input);
		String[][] reponse = {{"Poutine","Frites","Repas_Poulet"},{"10.5","2.5","15.75"}};
		
		assertArrayEquals(reponse, tableau);
	}
	
	@org.junit.jupiter.api.Test
	void testTabCommande() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Clients :",
				"Roger",
				"Céline",
				"Steeve"
				,"Plats :"
				,"Poutine 10.5"
				,"Frites 2.5"
				,"Repas_Poulet 15.75"
				,"Commandes :"
				,"Roger Poutine 1"
				,"Céline Frites 2"
				,"Céline Repas_Poulet 1"};
		int[] index = {0,4,8};
		String[][] tableau = test.creerTabCommande(index,input);
		String[][] reponse = {{"Roger","C�line","C�line"},{"Poutine","Frites","Repas_Poulet"},{"1","2","1"}};
		
		assertArrayEquals(reponse, tableau);
	}
	
	@org.junit.jupiter.api.Test
	void testAfficher() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[][] tabPlat = {{"Poutine","Frites","Repas_Poulet"},{"10.5","2.5","15.75"}};
		String[][] tabPers = {{"Roger","C�line","Steeve"},{"0","0","0"}};
		String[][] tabCom = {{"Roger","C�line","C�line"},{"Poutine","Frites","Repas_Poulet"},{"1","2","1"}};
		
		
		
		String tableau = test.afficher(tabPlat,tabPers,tabCom);
		String[] reponseTableau = {tableau};
		String[] input = {"Clients :",
				"Roger",
				"Céline",
				"Steeve"
				,"Plats :"
				,"Poutine 10.5"
				,"Frites 2.5"
				,"Repas_Poulet 15.75"
				,"Commandes :"
				,"Roger Poutine 1"
				,"Céline Frites 2"
				,"Céline Repas_Poulet 1"};
		
		assertArrayEquals(input, reponseTableau);
	}
	
	
	@org.junit.jupiter.api.Test
	void testAdditionneString() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[][] input = {{"Roger","Steeve"},{"0 ","5 "}};
		String tableau = test.additionneString(input);
		String[] reponseTableau = {tableau};
		String[] reponse = {"Roger 0.0$\nSteeve 5.0$"};
		
		assertArrayEquals(reponse, reponseTableau);
	}
	
	@org.junit.jupiter.api.Test
	void compteLineTest() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String input = "restaurant.txt";
		int resultat = test.compteLine(input);
		int reponse = 13;
		assertEquals(reponse, resultat);
	}
	
	@org.junit.jupiter.api.Test
	void dateFichierTest() {
		CalculeFacture test = new CalculeFacture();
		String resultat = test.dateFichier();
		String reponse = "Facture_du_27\\04\\20 08-14.txt";
		assertEquals(reponse, resultat);
	}
	
	@org.junit.jupiter.api.Test
	void testCreerFichier() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String nomFichier = "restaurant.txt";
		String[][] tabPlat = {{"Poutine","Frites","Repas_Poulet"},{"10.5","2.5","15.75"}};
		String[][] tabPers = {{"Roger","Cï¿½line","Steeve"},{"0","0","0"}};
		String[][] tabCom = {{"Roger","Cï¿½line","Cï¿½line"},{"Poutine","Frites","Repas_Poulet"},{"1","2","1"}};
		
		test.creerFichier(nomFichier,tabPlat,tabPers,tabCom);
		
	}

}
