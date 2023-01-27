
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Friend!!");
		//System.out.println(addNumber(2,3));
		MainClass mc = new MainClass();
		String nonStaticMethodOutput = mc.addString("Ayush", "Ranjan");
		int a = mc.addNumber(10, 20);
		System.out.println(nonStaticMethodOutput);
		System.out.println(a);
	}
	
	public int addNumber(int a, int b) {
		//Integer adding
		return a+b;
	}
	
	public String addString(String a, String b) {
		//String adding
		if(a!=null && b!=null) {
			return a+" "+b;
		}
		
		return "failed";
	}

}
