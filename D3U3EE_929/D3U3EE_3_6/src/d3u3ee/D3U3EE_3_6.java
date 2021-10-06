package d3u3ee;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class D3U3EE_3_6 implements Serializable {

	public static void main(String[] args) {

		hf4();
		try {
			visszaolvas();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static final long serialVersionUID = 1L;
	String rendszam;
	String fajta;
	int ar;

	public D3U3EE_3_6(String r, String t, int a) {
		this.rendszam = r;
		this.fajta = t;
		this.ar = a;
	}

	public static void hf4() {
		D3U3EE_3_6[] autok = { new D3U3EE_3_6("R12", "Seat", 420), new D3U3EE_3_6("R13", "Peugeot", 360),
				new D3U3EE_3_6("R15", "BMW", 128) };
		try {
			ObjectOutputStream kifile = new ObjectOutputStream(new FileOutputStream("Autok.dat"));
			for (D3U3EE_3_6 auto : autok) {
				kifile.writeObject(auto);
			}
			kifile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File nyitasi hiba");
		}
		System.out.println("OK");
	}
	
	public static void visszaolvas() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hanyadik rekordot szeretne visszaolvasni?");
		boolean ok = true;
		int olvas = 0;
		do {
			try {
				ok = true;
				olvas = sc.nextInt();
				if (olvas <= 0 || olvas > 10) {
					System.out.println("nem jo szamot adott meg");
					ok = false;
				}
			} catch (NumberFormatException e) {
				System.out.println(e);
				ok = false;
			}
		} while (!ok);
		
		sc.close();
		
		int sor =1;
		D3U3EE_3_6 ma;
		try {
			File fn = new File("Autok.dat");
			if (fn.exists()) {
				ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("Autok.dat"));
				try {
					while (true) {
						ma = (D3U3EE_3_6) kifile.readObject();
						if (sor==olvas) {
							System.out.println("rendszam=" + ma.rendszam);
							System.out.println("tipus=" + ma.fajta);
							System.out.println("ar=" + ma.ar);
						}
						sor++;
					}
				} catch (EOFException ee) {
					ma = null;
				}
				kifile.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File nyitasi hiba");
		}
		System.out.println("OK2");
		
		sc.close();

		
		
	}

}
