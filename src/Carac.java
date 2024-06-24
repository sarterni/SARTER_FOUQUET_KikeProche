public class Carac {
    /**
     * artibuts :
     * valeur double valeur de la caractéristique
     * nomCarcac String nom de la caractéristique
     */
    private String nomCarac;
    private double valeur;
/**
 * constructeur qui construit une caractéristique a partir d'un nom et d'une valeur
 * @param nom nom de la caractéristique
 * @param v valeur de la caractéristique
 */
    public Carac(String nom,double v)
    {
        this.nomCarac=nom;
        this.valeur=v;
    }
    /**
     * méthode qui donne la valeur de la caractéristique
     * @return
     */
    public double getValeur()
    {
        return this.valeur;
    }
    /**
     * méthode qui donne le nom de la caractéristique
     * @return le nom de la caractéristique 
     */
    public String getNom()
    {
        return this.nomCarac;
    }
    /**
     * donne un booléen qui est vrai si les noms de caractéristiques sont égaux
     * @param nom nom que l'on veut comparer 
     * @return le bolléen
     */
    public boolean etreEgal(String nom)
    {
        boolean egale=false;
        if (nom.equals(this.nomCarac))
        {
            egale=true;
        }

        return egale;
    }

}