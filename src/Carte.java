import java.util.Arrays;
/**
 * atributs :
 * nom Srting qui correspond au nom de la carte
 * visible booleen qui est vraie si la carte est du coté ou ses valeurs sont visibles
 * caracs Carac[] corespond à toutes les caractéristiques d'une carte
 */
public class Carte {
    private String nom;
    private boolean visible;
    private Carac[] caracs;

    /**
     * Constructeur construisant une carte sans caractéristique mais qui a un nom
     * @param nom nom que l'on veut donné à la carte
     */
    public Carte(String nom) {
        this.nom = nom;
        this.caracs = new Carac[0];
    }
    /**
     * Constructeur construisant une carte avec des caractéristiques et leur valeurs
     * @param carac nom des caractéristiques donné
     * @param valeur valeur des caractéristiques donné
     */
    public Carte(String carac, String valeur) {
        String[] s1 = carac.split(";");
        String[] s2 = valeur.split(";");
        this.nom = s2[0];
        int y = 1;
        int u = 0;
        this.caracs = new Carac[3];
        for (int i = 1; i < s1.length; i++) {
            double t = Double.parseDouble(s2[y]);
            Carac c = new Carac(s1[i], t);
            this.caracs[u] = c;
            y = y + 1;
            u = u + 1;
        }

    }
    /**
     * méthode qui ajoute une caractéristiques a la carte
     * @param c caractéristique donné
     */
    public void ajouterCarac(Carac c) {
        Carac[] tabC = new Carac[this.caracs.length + 1];
        for (int i = 0; i < this.caracs.length; i++) {
            // tabC correspond au nouveau tableau créé
            tabC[i] = this.caracs[i];
        }

        tabC[this.caracs.length] = c;
        this.caracs = tabC;
    }
    /**
     * méthode qui donne la valeur d'une caractéristique de la carte
     * @param nom nom de la caractéristique
     * @return retourne la valeur de cette caractéristique
     */
    public double getValeur(String nom) {

        boolean tr = false;
        int i = 0;
        while (i < this.caracs.length && tr == false) {
            if (this.caracs[i].etreEgal(nom)) {
                tr = true;
            } else {
                i = i + 1;
            }
        }
        if (tr == true) {
            return this.caracs[i].getValeur();
        } else {
            return -1.0;
        }
    }
/**
 * méthode qui donne le nom de la Carte
 * @return retourne le nom de la Carte
 */
    public String getNom() {
        return this.nom;
    }
    /**
     * méhtode qui passe la Carte en visible
     */
    public void setVisible() {
        this.visible = true;
    }
    /**
     * methode qui donne un booléen qui est vrai si les valeurs de la Carte sont visibles
     * @return
     */
    public boolean getVisible() {
        return this.visible;
    }
    /**
     * méthode qui donne le nom d'une caractéristique de la Carte
     * @param i place dans la carte
     * @return le nom de la caractéristique
     */
    public String getNomCarac(int i) {
        return this.caracs[i].getNom();
    }
/**
 * donne le nombre de caractéristique
 * @return le nombre de caractéristique de la carte 
 */
    public int getNombreCarac()
    {
        return this.caracs.length;
    }
/**méthode qui retourne la carte selon une mise en forme
 * @return la présentation voulue de la Carte
 */
    public String toString() {
        if (this.visible==false)
        {
            return this.nom+" -> *"+ this.getNomCarac(0)+" ???* *"+this.getNomCarac(1)+" ???* *"+this.getNomCarac(2)+" ???*";
        }
        else
        {
            return this.nom+" -> *"+ this.getNomCarac(0)+" "+this.getValeur(this.getNomCarac(0))+"* *"+this.getNomCarac(1)+" "+this.getValeur(this.getNomCarac(1))+"* *"+this.getNomCarac(2)+" "+this.getValeur(this.getNomCarac(2))+"*";
        }
        
    

}
}