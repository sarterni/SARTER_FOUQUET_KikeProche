import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquet {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquet(), args);
	}

	public void test1_constructeur() {
		PaquetCarte paquet = new PaquetCarte();
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}

	public void test2_constructeurParam() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte("c");
		tab[1] = new Carte("b");
		tab[2] = new Carte("a");

		PaquetCarte paquet = new PaquetCarte(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}

	public void test3_getCarte_ok() {
		Carte[] tab = new Carte[3];
		String s1 = "nom;taille;poids;longevite;";
		String s2 = "ours;150;200;40;";
		tab[0] = new Carte(s1, s2);
		tab[1] = new Carte(s1, s2);
		tab[2] = new Carte(s1, s2);

		PaquetCarte paquet = new PaquetCarte(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

		Carte c = paquet.getCarte(0);
		assertEquals("la première carte  a pour taille 150", 150.0, c.getValeur("taille"));
		assertEquals("la première carte  a pour poids 200", 200.0, c.getValeur("poids"));
		assertEquals("la première carte  a pour longevite 40", 40.0, c.getValeur("longevite"));
	}

	public void test4_getCarte_horsTableau() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte("c");
		tab[1] = new Carte("b");
		tab[2] = new Carte("a");

		PaquetCarte paquet = new PaquetCarte(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

		Carte c = paquet.getCarte(3);
		assertEquals("la carte 3 n'existe pas", null, c);

	}

	public void test5_ajoutCarteFin() {
		Carte[] tab = new Carte[3];
		String s1 = "nom;taille;poids;longevite;";
		String s2 = "ours;150;200;40;";
		tab[0] = new Carte(s1, s2);
		tab[1] = new Carte(s1, s2);
		tab[2] = new Carte(s1, s2);
		PaquetCarte paquet = new PaquetCarte(tab);
		paquet.ajouterCarteFin(new Carte(s1, s2));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

		// chaque carte doit etre bien placee: place i => valeur i+1
		for (int i = 0; i < 3; i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la  carte  a pour taille 150", 150.0, c.getValeur("taille"));
			assertEquals("la  carte  a pour poids 200", 200.0, c.getValeur("poids"));
			assertEquals("la  carte  a pour longevite 40", 40.0, c.getValeur("longevite"));
		}

	}

	public void test6_retirerCarte() {
		Carte[] tab = new Carte[3];
		String s1 = "nom;taille;poids;longevite;";
		String s2 = "ours;150;200;40;";
		tab[0] = new Carte(s1, s2);
		tab[1] = new Carte(s1, s2);
		tab[2] = new Carte(s1, s2);

		PaquetCarte paquet = new PaquetCarte(tab);
		Carte c = paquet.retirerCarte(1);

		// test paquet
		assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
		assertEquals("la première carte  a pour taille 150", 150.0, paquet.getCarte(0).getValeur("taille"));
		assertEquals("la première carte  a pour poids 200", 200.0, paquet.getCarte(0).getValeur("poids"));
		assertEquals("la première carte  a pour longevite 40", 40.0, paquet.getCarte(0).getValeur("longevite"));

		assertEquals("la seconde carte  a pour taille 150", 150.0, paquet.getCarte(1).getValeur("taille"));
		assertEquals("la seconde carte  a pour poids 200", 200.0, paquet.getCarte(1).getValeur("poids"));
		assertEquals("la seconde carte  a pour longevite 40", 40.0, paquet.getCarte(1).getValeur("longevite"));

		// test carte retournee
		assertEquals("carte retiree a pour taille 150", 150.0, c.getValeur("taille"));
		assertEquals("carte retiree a pour poids 200", 200.0, c.getValeur("poids"));
		assertEquals("carte retiree a pour longevite 40", 40.0, c.getValeur("longevite"));

	}

	public void test7_construteurFichier() {

		String fichier = "../cartes/animaux.csv";
		PaquetCarte p1 = new PaquetCarte(fichier);

		assertEquals("la première carte  a pour taille 19", 19.0, p1.getCarte(1).getValeur("taille"));
		assertEquals("la première carte  a pour poids 1.3", 1.3, p1.getCarte(1).getValeur("poids"));
		assertEquals("la première carte  a pour longevite 7", 7.0, p1.getCarte(1).getValeur("longevite"));

	}

	public void test8_PiocherHasard() {
		Carte[] tab = new Carte[1];
		String s1 = "nom;taille;poids;longevite;";
		String s2 = "ours;150;200;40;";
		tab[0] = new Carte(s1, s2);

		PaquetCarte paquet = new PaquetCarte(tab);

		Carte g = paquet.piocherHasard();

		assertEquals("la première carte  a pour taille 150", 150.0, g.getValeur("taille"));
		assertEquals("la première carte  a pour poids 200", 200.0, g.getValeur("poids"));
		assertEquals("la première carte  a pour longevite 40", 40.0, g.getValeur("longevite"));

	}

	public void test9_PiocherHasard_TabNull() {

		PaquetCarte paquet = new PaquetCarte();

		Carte g = paquet.piocherHasard();

		assertEquals("la première carte  devrait être null", null, g);

	}

	public void test10_TrouverCarteProche() {
		String fichier = "../cartes/animaux.csv";
		PaquetCarte p1 = new PaquetCarte(fichier);

		int e = p1.trouverCarteProche(p1.getCarte(1), "longevite");

		assertEquals("la valeur devrait être 1", 1, e);

	}

}
