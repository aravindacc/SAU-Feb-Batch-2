package assignments;

public class singleton_class {
	
	public static void main(String args[]) {
		Singleton obj1 = Singleton.returnObject();
				
		Singleton obj2 = Singleton.returnObject();
		
		String str_obj1 = obj1.str;
		String str_obj2 = obj2.str;
		
		System.out.println(str_obj1);
		System.out.println(str_obj2);
		
	}

}


class Singleton {
private static Singleton newobject = null;
	
	public String str;
	private Singleton() {
		str = "Kishan Mishra";
	}
	
	public static Singleton returnObject(){
		if (newobject == null) {
			newobject = new Singleton();
		}
		return newobject;
	}
}

