
class Singleton {

    private static Singleton single_instance = null;

    public String s;

    private Singleton() {
        s = "You are in Singleton";
    }

    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}

class Main {
    public static void main(String args[]) {

        Singleton x = Singleton.getInstance();

        Singleton y = Singleton.getInstance();

        Singleton z = Singleton.getInstance();

        x.s = (x.s).toUpperCase();

        System.out.println("Your String is : " + x.s);
        System.out.println("\n");

        z.s = (z.s).toLowerCase();

        System.out.println("Your String is : " + x.s);

    }
}
