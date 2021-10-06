package d3u3ee;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class D3U3EE_3_8 {

	private static D3U3EE_3_8 adatok[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int szam = 0;

		while (szam != 5) {
			System.out.println(
					"Mit akar csin�lni? \n1. Adatok felvetel\n2. Adat torles\n3. Adat modositasa\n4. Adat listazasa\n5. Kilepes\n\n");
			szam = sc.nextInt();
			switch (szam) {

			case 1:
				int olvas = szamotker(sc);
				adatok = new D3U3EE_3_8[olvas];
				try {
					beker(adatok, sc);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					torles(adatok, sc);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					modosit(adatok,sc);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case 4:
				try {
					kiolvas(sc);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("viszl�t!");
				System.exit(0);
			default:
				System.out.println("Ilyen opci� nincs");
			}

		}

		sc.close();

	}

	private static int szamotker(Scanner sc) {
		System.out.println("H�ny adatot szeretne megadni? ");
		boolean ok = true;
		int olvas = 0;
		do {
			try {
				ok = true;
				olvas = sc.nextInt();
				if (olvas <= 0) {
					System.out.println("nem jo szamot adott meg");
					ok = false;
				}
			} catch (NumberFormatException e) {
				System.out.println(e);
				ok = false;
			}
		} while (!ok);
		return olvas;

	}

	private String aznosito;
	private String nev;
	private static int ossz;

	public static int getOssz() {
		return ossz;
	}

	public static void setOssz(int ossz) {
		D3U3EE_3_8.ossz = ossz;
	}

	public String getAznosito() {
		return aznosito;
	}

	public void setAznosito(String aznosito) {
		this.aznosito = aznosito;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public D3U3EE_3_8(String aznosito, String nev) {
		this.aznosito = aznosito;
		this.nev = nev;
	}

	@Override
	public String toString() {
		return "DJ7PNE_03_08 [aznosito=" + aznosito + ", nev=" + nev + "]";
	}

	public static D3U3EE_3_8[] beker(D3U3EE_3_8[] adatok, Scanner sc) throws IOException {

		FileWriter myWriter = new FileWriter("szemelyek.dat");

		for (int i = 0; i < adatok.length; i++) {

			System.out.println("Adja meg az azonos�t�t!");
			String azonosito = sc.next();

			System.out.println("Adja meg a nevet!");
			String nev = sc.next();

			adatok[i] = new D3U3EE_3_8(azonosito, nev);
			ossz++;

			try {
				myWriter.write(adatok[i].aznosito + " " + adatok[i].nev + "\n");
				myWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		myWriter.close();

		return adatok;

	}

	public static void torles(D3U3EE_3_8[] adatok, Scanner sc) throws IOException {

		File file = new File("szemelyek2.dat");
		File file2 = new File("szemelyek.dat");
		FileWriter myWriter = new FileWriter("szemelyek2.dat");

		System.out.println("Hanyadik rekordot szeretn� t�r�lni?");

		int bekert = sc.nextInt();
		bekert = bekert - 1;

		for (int i = 0; i < getOssz(); i++) {
			if (bekert == 0) {
				if (i != 0) {
					myWriter.write(adatok[i].aznosito + " " + adatok[i].nev + "\n");
					myWriter.flush();
					setOssz(getOssz()-1);
				}

			} else if (bekert != 0) {
				if (i != bekert) {
					myWriter.write(adatok[i].aznosito + " " + adatok[i].nev + "\n");
					myWriter.flush();
					setOssz(getOssz()-1);
				}
			}
		}

		myWriter.close();
		file2.delete();
		file.renameTo(file2);

	}

	public static void kiolvas(Scanner sc) throws IOException {

		String fnev = "szemelyek.dat";
		int db = 0;
		String valami;

		try {
			File myObj = new File(fnev);
			BufferedReader buff1 = new BufferedReader(new FileReader(myObj.getAbsoluteFile()));
			sc = new Scanner(buff1);
			while (sc.hasNextLine()) {
				valami = sc.nextLine();
				System.out.println(db + ". adat: " + valami);
				db++;
			}
			buff1.close();
		} catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}

	public static void modosit(D3U3EE_3_8[] adatok,Scanner sc) throws IOException {
		
		System.out.println("Hanyadik rekordot szeretn� m�dos�tani? " + getOssz() + "db adat van az �llom�nyban.");
		int szam = sc.nextInt();
		System.out.println("Mit szeretne modositani?\n1.Azonositot\n2.Nevet\n");
		int mit = sc.nextInt();
		
		FileWriter myWriter = new FileWriter("szemelyek.dat");
		
		for (int i = 0; i < getOssz(); i++) {
			if(i==(szam-1)) {
				switch(mit){
                case 1:
                    System.out.println("Adja meg az uj azonositot! ");
                    String azonosito = sc.next();
                    adatok[i].aznosito= azonosito;
                    break;

                case 2:
                    System.out.println("Adja meg az �j nevet! ");
                    String nev = sc.next();
                    adatok[i].nev=nev;
                    break;
                default: System.out.println("Nincs ilyen opci�, kil�p�s.."); System.exit(-1);
            }
			}
			
			myWriter.write(adatok[i].aznosito + " " + adatok[i].nev + "\n");
			myWriter.flush();
			
		}
		
		myWriter.close();
		
		
	}

}