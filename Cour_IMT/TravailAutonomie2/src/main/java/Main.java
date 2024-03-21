public class Main {
    public static void main(String[] args) {
        MonstreTresEffrayantBuilder b1 = new MonstreTresEffrayantBuilder();
        Director director = new Director(b1);
        director.construct();
        Monstre m1 = b1.getResult();
        String result = m1.toString();
        System.out.println(result);

        System.out.println("****************************************************************");

        MonstreGentilBuilder b2 = new MonstreGentilBuilder();
        director = new Director(b2);
        director.construct();
        Monstre m2 = b2.getResult();
        result = m2.toString();
        System.out.println(result);

        System.out.println("****************************************************************");

        Manager manager = new Manager();
        manager.register("monstre gentil", m2);
        Product m2Fils = manager.create("monstre gentil");
        System.out.println(m2Fils.toString());

        System.out.println("****************************************************************");

        manager.register("monstre tres effrayant", m1);
        Product m1Fils = manager.create("monstre tres effrayant");
        System.out.println(m1Fils.toString());
    }
}
