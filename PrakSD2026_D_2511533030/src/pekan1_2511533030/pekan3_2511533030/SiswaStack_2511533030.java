package pekan3_2511533030;
import java.util.ArrayList;

class Siswa {
	String nama;
	int nim;
	
	public Siswa (String nama, int nim) {
		this.nama = nama;
		this.nim = nim;
	}
	
	@Override
	public String toString() {
		return "Nim: " + nim + ", Nama: " + nama;
		
	}

}
public class SiswaStack_2511533030 {
	private ArrayList<Siswa> stack;
	
	public SiswaStack_2511533030() {
		stack = new ArrayList<>();
	}
	
	public void push(Siswa mhs) {
		stack.add(mhs);
	}
	
	public Siswa pop() {
		if (!isEmpty()) {
			return stack.remove(stack.size() - 1);
		}
		return null;
	}
	
	public Siswa peek() {
		if (!isEmpty()) {
			return stack.get(stack.size() - 1);
		}
		return null;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void tampilkanSiswa() {
		for (int i = stack.size() - 1;i >= 0; i--) {
			System.out.println(stack.get(i));
			
		}
	}
	public static void main (String[] args) {
		SiswaStack_2511533030 studentStack = new SiswaStack_2511533030();
		
		Siswa mhs1 = new Siswa("Ali", 1);
		Siswa mhs2 = new Siswa("Boby", 2);
		Siswa mhs3 = new Siswa("Charles", 3);
		studentStack.push(mhs1);
		studentStack.push(mhs2);
		studentStack.push(mhs3);
		
		System.out.println("Siswa di dalam stack:");
		studentStack.tampilkanSiswa();
		
		System.out.println("siswa teratas " + studentStack.peek());
		System.out.println("mengeluarkan siswa teratas dari stack: " + studentStack.pop());
		studentStack.tampilkanSiswa();
		
	}
	
	
}