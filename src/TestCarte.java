import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	private static final Object Lama = null;

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarte(), args);
	}

	public void testConstructeur_Normal() {
		Carte c1 = new Carte("Lama");

		assertEquals("le nom devrait être Lama", "Lama", c1.getNom());
	}
	public void testConstructeurChaine()
	{
		String s1="nom;taille;poids;longevite;";
		String s2="ours;150;200;40;";
		Carte c1 = new Carte (s1,s2);

		assertEquals("Le nom devrait être ours","ours", c1.getNom());
		
		assertEquals("La première caractéristique devrait être la taille","taille",c1.getNomCarac(0));
		assertEquals("La valeur devrait être 150",150.0,c1.getValeur("taille"));
		
		assertEquals("La deuxième caractéristique devrait être la poids","poids",c1.getNomCarac(1));
		assertEquals("La valeur devrait être 200",200.0,c1.getValeur("poids"));
		
		assertEquals("La troisième caractéristique devrait être la longevite","longevite",c1.getNomCarac(2));
		assertEquals("La valeur devrait être 40",40.0,c1.getValeur("longevite"));
		
	}


	public void test_methode_AjouterCarac() 
	{
		Carte c1 = new Carte("Panda");
		Carac car = new Carac("Poid", 40.0);
		c1.ajouterCarac(car);


		assertEquals("La valeur devrait être de 40", 40.0 , c1.getValeur("Poid"));
	}
	public void test_methode_setVisible()
	{
		Carte c1 = new Carte("Panda");
		c1.setVisible();
		assertEquals("le résultat devrai être true", true ,c1.getVisible());
	}

	public void test_methode_getValeurOK()
	{
		Carte c1 = new Carte("Panda");
		Carac car = new Carac("Poid", 80.0);
		c1.ajouterCarac(car);

		assertEquals("La valeur devrait être de 80", 80.0 , c1.getValeur("Poid"));
	}

	public void test_methode_getValeurExistePas()
	{
		Carte c1 = new Carte("Lama");
		assertEquals("La valeur devrait être de -1", -1.0 , c1.getValeur("Poid"));
	}

	public void test_methode_toString_nonVisible()
	{
		String s1="nom;taille;poids;longevite;";
		String s2="ours;150;200;40;";
		Carte c1 = new Carte (s1,s2);
		String rep =c1.toString();

		assertEquals("le résultat devrait être :ours -> *taille ???* *poids ???* *longevite ???* ","ours -> *taille ???* *poids ???* *longevite ???*", rep);
	}
	public void test_methode_toString_Visible()
	{
		String s1="nom;taille;poids;longevite;";
		String s2="ours;150;200;40;";
		Carte c1 = new Carte (s1,s2);
		c1.setVisible();
		String rep =c1.toString();
		assertEquals("le résultat devrait être :ours -> *taille 150.0* *poids 200.0* *longevite 40.0* ","ours -> *taille 150.0* *poids 200.0* *longevite 40.0*", rep);
	}
	// .......................................
	// .......................................
	// .......................................

}
