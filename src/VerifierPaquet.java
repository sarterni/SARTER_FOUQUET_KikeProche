class VerifierPaquet{
  // cette classe a pour objectif de verifier que les methodes
  // de la classe Paquet sont correctement ecrites

  public static void main(String[] args){
    // constructeurs
    PaquetCarte paq = new PaquetCarte();

    // methodes Q9
    paq.ajouterCarteFin(new Carte("dauphin"));
    paq.retirerCarte(0);

    // methode Q11
    Carte c = paq.piocherHasard();

    // methode Q12
    int res = paq.trouverCarteProche(c,"taille");

  }

}
