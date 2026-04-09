package pekan3_2511533030;

public class stackArrayDriver_2511533030 {
	public static void main (String[] args) {
		stackArray_2511533030 s = new stackArray_2511533030();
		s.push_3030(10);
		s.push_3030(20);
		s.push_3030(30);
		System.out.println(s.pop_3030() + " dikeluarkan dari stack");
		System.out.println("Elemen teratas adalah :" + s.peek_3030());
		System.out.println("Elemen pada stack :");
		s.print();
	}

}
