import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class Test {
//Ashwin Saravanapavan
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
//Ashwin Saravanapavan
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
	
	void testindexSectionTableauErroner() throws IOException {
		CalculeFacture test = new CalculeFacture();
		String[] input = {"Erreur autre information"};
		int[] tableau = test.indexSection(input);
		int[] reponse = {1234567890};
		
		assertArrayEquals(reponse, tableau);
	}
	
	
	
	

}
