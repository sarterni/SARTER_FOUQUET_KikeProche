public class MainCarte {
    public static void main(String[] args) {
        LectureFichier file = new LectureFichier("../cartes/animaux.csv");
        String[] StringTab = file.lireFichier();
        for (int i = 1; i < StringTab.length; i++) {
            Carte c1 = new Carte(StringTab[0],StringTab[i]);
            String rep1 = c1.toString();
            System.out.println(rep1+"\n");
            c1.setVisible();
            String rep2 = c1.toString();
            System.out.println(rep2+"\n");
        }

    }
}