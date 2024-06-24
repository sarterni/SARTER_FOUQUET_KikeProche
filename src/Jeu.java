import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private PaquetCarte main;
    private PaquetCarte pioche;
    private String nomFichier;
    private int nombreCarte;

    public Jeu(String nomFich, int nbc) {
        this.nomFichier = nomFich;
        this.pioche = new PaquetCarte(this.nomFichier);
        this.main = new PaquetCarte();
    }

    public void creerMain() {

        for (int index = 1; index < this.nombreCarte; index++) {

            this.main.ajouterCarteFin(this.pioche.getCarte(index));
            this.pioche.retirerCarte(index);
        }

    }

    public void piocher() {
        Carte c1 = this.pioche.piocherHasard();
        this.main.ajouterCarteFin(c1);
        int i = -1;
        for (int index = 0; index < this.pioche.getNbCartes(); index++) {
            if (this.pioche.getCarte(i) == c1) {
                i = index;
            }
        }
        this.pioche.retirerCarte(i);
    }

    public Carte tirage() {
        Carte c1 = this.pioche.piocherHasard();
        c1.setVisible();
        return c1;
    }

    public String caracté(Carte c) {
        Random r1 = new Random();

        int h = r1.nextInt(c.getNombreCarac());

        return c.getNomCarac(h);
    }

    public boolean tester(Carte tiré, int numCarte, String carac) {
        boolean juste = false;

        if (this.main.trouverCarteProche(tiré, carac) == numCarte) {

            juste = true;
        }
        return juste;

    }

    public void créerTiret(String mot) {
        System.out.println("------" + mot + "------");
    }

    public boolean jouer() {
        boolean gagne = false;
        Scanner sc = new Scanner(System.in);
        this.creerMain();
        while (this.main.getNbCartes() != 0 || this.pioche.getNbCartes() != 0) {
            Carte cPioche = this.tirage();
            String sPioche = cPioche.toString();
            String e = "La caractéristique testé est : " + this.caracté(cPioche);
            this.créerTiret("CARTE ET CARAC");
            System.out.println(sPioche+"\n"+e);
            this.créerTiret("");

            this.créerTiret("MAIN DU JOUEUR");
            String sMain = this.main.toString();
            System.out.println(sMain);
            this.créerTiret("");

            this.créerTiret("Choix");
            System.out.println("Quelle carte de votre main est la plus proche");
            int rep = sc.nextInt();
            System.out.println(rep);
            this.créerTiret("REPONSE");
            if (this.tester(cPioche, rep, sMain)==true) {
                System.out.println("Bien joue il n'y avait pas plus proche");
                this.créerTiret("");
            } else {
                System.out.println("eh non, il y avait une carte plus proche:");
                Carte Bc =this.pioche.getCarte(this.main.trouverCarteProche(cPioche, sMain));
                String sBc=Bc.toString();
                System.out.println(sBc);
                System.out.println("on les retire et on ajoute deux nouvelles cartes");
                this.main.retirerCarte(rep);
                this.main.retirerCarte(this.main.trouverCarteProche(cPioche, sMain));
                this.piocher();
                this.piocher();
                this.créerTiret("");
            }

        }
        if (this.main.getNbCartes() != 0) {
            gagne=true;
        }
        return gagne;
    }

    public PaquetCarte getMain()
    {
        return this.main;
    }
    public PaquetCarte getPioche()
    {
        return this.pioche;
    }
    public int getNbCarte()
    {
        return this.nombreCarte;
    }

}
