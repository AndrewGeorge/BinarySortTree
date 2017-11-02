
public class Singletn {

	private static  Singletn singletn=new Singletn();
	public static int couremt1;
	public static int couremt2=0;
	
	private Singletn() {
		couremt1++;
		couremt2++;
	}
	public static  Singletn getSingletion(){
		return singletn;
	}
	static{
		System.err.println("staticcouremt1=="+couremt1);
		System.err.println("staticcouremt2=="+couremt2);
	}
}
