public class MainLecture {
    public static void main(String[] args) {
        LectureFichier file = new LectureFichier("../cartes/animaux.csv");
        String[] StringTab = file.lireFichier();

        for (int i = 0; i < StringTab.length; i++) {
            System.out.println(StringTab[i]);
        }
    }
}
