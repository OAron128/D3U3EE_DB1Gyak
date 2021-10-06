package d3u3ee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class D3U3EE_3_4 {

	public static void main(String[] args) {

		visszair(olvasas());
	}
	
	
	public static String olvasas() {
		String szoveg;
		String[] tagok;
		int szovegid = 0;
		String nev="asd";
		
		try {
			System.out.println("Az első szó a txt neve");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = null;
			System.out.println("Írjon szavakat,majd a program -end- ig olvasbe!\n");
			while (szovegid >= 0) {
				szoveg = br.readLine();
				if (szovegid == 0) {
					bw = new BufferedWriter(new FileWriter(szoveg));
					nev = szoveg;
				} else {
					bw.write(szoveg);
					bw.newLine();
				}
				szovegid = szovegid + 1;
				tagok = szoveg.split(" ");
				for (String sz : tagok) {
					if (sz.compareTo("end") == 0) {
						br.close();
						szovegid = -1;
					}
				}
			}
			bw.close();
			System.out.println("Ok");
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
		return nev;
				
	}
	
	public static void visszair(String fnev) {
		String sor;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fnev));
			while ((sor = br.readLine()) != null) {
				System.out.println(sor.toUpperCase());
			}
			br.close();
			System.out.println("Ok");
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

}