import java.util.Arrays;
import java.util.Random;

public class PaquetCarte {
    private Carte[] cartes;

    /**
     * Constructeur de paquet sans paramètre
     * construit un paquet de taille 0
     */
    public PaquetCarte() {
        this.cartes = new Carte[0];

    }

    /**
     * Constructeur avec paramètre
     * 
     * @param c c'est le tableau de cartes
     *          Construit un paquet avec les cartes qui sont donnés en paramètre
     */
    public PaquetCarte(Carte[] c) {
        this.cartes = c;
    }

    public PaquetCarte(String fichier) {
        LectureFichier file = new LectureFichier(fichier);
        String[] StringTab = file.lireFichier();
        Carte[] C1 = new Carte[StringTab.length];
        for (int i = 1; i < StringTab.length; i++) {
            Carte c1 = new Carte(StringTab[0], StringTab[i]);
            C1[i] = c1;
        }
        this.cartes = C1;
    }

    /** Méthode permetant d'avoir le nombre de cartes qui sont dans le paquet */
    public int getNbCartes() {
        return this.cartes.length;
    }
    /** méthode permetant d'avoir la carte a une place donné 
     * @param intk place donné
    */
    public Carte getCarte(int k) {
        if (k >= this.cartes.length) {
            return null;
        } else {
            return this.cartes[k];
        }
    }
    /**méthode qui ajoute une carte à la fin du paquet
     * @param Carte qui sera rajoutée
     */
    public void ajouterCarteFin(Carte c) {
        Carte[] paq = new Carte[this.cartes.length + 1];
        for (int i = 0; i < this.cartes.length; i++) {
            paq[i] = this.cartes[i];
        }
        paq[this.cartes.length] = c;
        this.cartes = new Carte[paq.length];
        for (int i = 0; i < this.cartes.length; i++) {
            this.cartes[i] = paq[i];
        }
    }

    /**
     * méhtode qui retire une Carte du a paquet a une place donné
     * @param k place de la Carte que l'on veut retirer
     * @return la Carte qui est retiré
     */
    public Carte retirerCarte(int k) {
        if (k > this.cartes.length) {
            return null;
        } else {
            // suprimer cette carte du tableau de cartes en créant un nouveau tableau de
            // taille inférieur
            Carte carte = this.cartes[k];
            Carte[] NewC = new Carte[this.cartes.length - 1];
            // recopier les objets cartes de l'atribut cartes jusqu'a l'indice k
            for (int i = 0; i < k; i++) {
                NewC[i] = this.cartes[i];
            }
            // supression de la carte et recopiage de la fin du tableau
            for (int i = k; i < this.cartes.length - 1; i++) {
                NewC[i] = this.cartes[i + 1];
            }
            // modifier les références pour que l'atribut cartes soit égal a ce nouveau
            // tableau
            this.cartes = NewC;
            // retourne la carte correspondante
            return carte;
        }
    }
/**
 * méthode permetant de donné aléatoirement une carte du paquet
 * @return la Carte choisi aléatoirement
 */
    public Carte piocherHasard() {

        if (this.cartes.length == 0) {
            return null;
        } else {
            Random r1 = new Random();

            int h = r1.nextInt(this.cartes.length);

            return this.cartes[h];
        }
    }
/**
 * méthode qui donne la place de la carte possédant le meme caractère qui à la valeur la plus proche
 * @param c Carte que l'on observe 
 * @param nomCaracn caractéristique que l'on veut observé
 * @return retourne la place de la carte la plus proche
 */
    public int trouverCarteProche(Carte c, String nomCarac) {
        double plusProche = Integer.MAX_VALUE;
        int indice = -1;
        for (int i = 1; i < this.cartes.length; i++) {
            double d = Math.abs(c.getValeur(nomCarac) - this.cartes[i].getValeur(nomCarac));
            if (d < plusProche) {
                plusProche = d;
                indice = i;
            }

        }
        return indice;
    }
/**
 * méthode permetant qui retourne le paquet selon une mise en forme
 * @return la présentation voulue du paquet
 */
    public String toString() {
        String res = "";
        for (int i = 1; i < this.cartes.length; i++) {
            res += this.cartes[i].toString() + "\n";
        }
        return res;
    }

}