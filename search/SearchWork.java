package search;

public class SearchWork {

	public static void main(String[] args) {
		Searching s=new Searching();
	//	System.out.println(s.firsCont(9));
			int a=4;
			System.out.println("a "+Integer.toBinaryString(a));
			int b=4;
			System.out.println("b "+Integer.toBinaryString(b));
			int sum=a^b;
			int carry=a&b<<1;
			System.out.println(sum+" sum "+Integer.toBinaryString(sum));
			System.out.println("carry "+Integer.toBinaryString(carry));
			System.out.println();
			System.out.println(Integer.toBinaryString(sum&carry)+" "+(sum&carry));
			//System.out.println(sum);
			//System.out.println(carry);
		
	}
}
