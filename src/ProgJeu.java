public class ProgJeu {

    public static void main(String[]args) {


        String nomFich="../cartes/animaux.csv";
        int main = 5;
        Jeu j1 = new Jeu(nomFich, main);
        for (int index = 1; index < j1.getNbCarte()+1; index++) {

            j1.getMain().ajouterCarteFin(j1.getPioche().getCarte(index));
            j1.getPioche().retirerCarte(index);
        }
        j1.creerMain();
        boolean rep=j1.jouer();
        System.out.println(rep);
        
    }
    
}
