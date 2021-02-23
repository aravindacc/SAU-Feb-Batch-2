
class Singleton {
    private static Singleton newobject = null;
    public String adminName;

    private Singleton() {
        this.adminName = "Abhinav Sharma";
    }

    public static Singleton returnObject() {
        if (newobject == null) {
            newobject = new Singleton();
        }
        return newobject;
    }
}

public class SingletonTrial {
    public static void main(String args[]) {
        Singleton obj1 = Singleton.returnObject();
        Singleton obj2 = Singleton.returnObject();

        String name1 = obj1.adminName;
        String name2 = obj2.adminName;

        System.out.println("My Name1 is : " + name1);
        System.out.println("My Name2 is : " + name2);

    }
}