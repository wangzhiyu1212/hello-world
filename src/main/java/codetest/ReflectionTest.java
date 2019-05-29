package codetest;

class Demo {
	
	private String name;
	
	public Demo() {
		
	}
	
	public Demo(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
public class ReflectionTest {

	public static void main(String args[]) {
		Class<?> demoClass = null;
		try {
			demoClass = Class.forName("test.Demo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Demo demo = null;
		try {
			demo = (Demo)demoClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		demo.setName("name1");
		System.out.println(demo.getName());
		System.out.println(demo.hashCode());
		System.out.println(demo.toString());
		System.out.println(demo.getClass());
	}
}
