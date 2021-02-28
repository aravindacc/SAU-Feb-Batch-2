public class Singleton {
    public static void main(String args[])
    {
        SingletonHelper s1 = SingletonHelper.getInstance();

        SingletonHelper s2 = SingletonHelper.getInstance();

        SingletonHelper s3 = SingletonHelper.getInstance();

        s1.s = (s1.s).toUpperCase();

        System.out.println("String from s1 is: " + s1.s);
        System.out.println("String from s2 is: " + s2.s);
        System.out.println("String from s3 is: " + s3.s);
        System.out.println("\n");

        s3.s = (s3.s).toLowerCase();

        System.out.println("String from s1 is: " + s1.s);
        System.out.println("String from s2 is: " + s2.s);
        System.out.println("String from s3 is: " + s3.s);
    }
}

class SingletonHelper {
    private static SingletonHelper single_instance = null;

    public String s;

    private SingletonHelper()
    {
        s = "Some random text to test Singleton Classes in Java";
    }

    public static SingletonHelper getInstance()
    {
        if (single_instance == null)
            single_instance = new SingletonHelper();

        return single_instance;
    }
}
