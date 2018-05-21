package br.gov.mctic.sib.estatico;

public class Teste {
	static int seq = 0;
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>TESTE<<<<<<<<<<<");
		
		Thread t1 = new Thread() {
			public void run() {
				for (int i=0; i< 10; i++) {
					System.out.println(">>t1<<");
					ver(seq++);	
				}
			};
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for (int i=0; i< 10; i++) {
					System.out.println(">>t2<<");
					ver(seq++);	
				}
			};
		};
		
		Thread t3 = new Thread() {
			public void run() {
				for (int i=0; i< 10; i++) {
					System.out.println(">>t3<<");
					ver(seq++);	
				}
			};
		};
		t1.start();
		t2.start();
		t3.start();
		
		
	}

	
	public static void ver(int seq) {
		System.out.println("==>"+seq);
	}
}
