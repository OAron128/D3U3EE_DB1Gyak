package d3u3ee;

	import java.io.EOFException;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;

	public class D3U3EE_3_9 implements Serializable {

		private static int db = 0;

		public static void main(String[] args) {

			beir();
			try {
				atlag();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				piros();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				legdragabb();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			

		}

		private static final long serialVersionUID = 1L;
		String rsz;
		String tipus;
		int ar;

		public D3U3EE_3_9(String r, String t, int a) {
			this.rsz = r;
			this.tipus = t;
			this.ar = a;
		}

		public static void beir() {
			D3U3EE_3_9[] autoim = { new D3U3EE_3_9("R11", "piros", 333), new D3U3EE_3_9("R12", "feh�r", 233),
					new D3U3EE_3_9("R14", "k�k", 364) };

			db = autoim.length;

			try {
				ObjectOutputStream kifile = new ObjectOutputStream(new FileOutputStream("Autok.dat"));
				for (D3U3EE_3_9 auto : autoim) {
					kifile.writeObject(auto);
				}
				kifile.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("File nyitasi hiba");
			}
			System.out.println("OK");
		}

		public static void atlag() throws FileNotFoundException {

			int szum = 0;
			D3U3EE_3_9 ma;
			try {
				File fn = new File("Autok.dat");
				if (fn.exists()) {
					ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("Autok.dat"));
					try {
						while (true) {
							ma = (D3U3EE_3_9) kifile.readObject();
							szum = szum + ma.ar;
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
			
			System.out.println("Az autok atlagara: " + szum/db);

		}
		
		public static void piros() throws FileNotFoundException {

			int pirosak =0;
			D3U3EE_3_9 ma;
			try {
				File fn = new File("Autok.dat");
				if (fn.exists()) {
					ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("Autok.dat"));
					try {
						while (true) {
							ma = (D3U3EE_3_9) kifile.readObject();
							if(ma.tipus.equalsIgnoreCase("piros")) {
								pirosak++;
							}
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
			
			System.out.println("A piros autok szama: " + pirosak);

		}
		
		public static void legdragabb() throws FileNotFoundException {

			D3U3EE_3_9 ma;
			try {
				File fn = new File("Autok.dat");
				if (fn.exists()) {
					D3U3EE_3_9 max;
					ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("Autok.dat"));
					max = (D3U3EE_3_9)kifile.readObject();
					try {
						while (true) {
							ma = (D3U3EE_3_9) kifile.readObject();
							if(ma.ar>max.ar) {
								max = ma;
							}
						}
					} catch (EOFException ee) {
						ma = null;
					}
					kifile.close();
					System.out.println("A legdragabb auto rendszama: " + max.rsz + " �s az �ra " + max.ar);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("File nyitasi hiba");
			}
			

		}

	}