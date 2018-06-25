package SourceMainJava;

public class problemTwo {

	public static void main(String f[]) {
		
			
			int a = 25;
			
			int[] b = new int[a];
			b[0] = 0;
			b[1] = 1;			
			
			for(int i = 2; i < a; i ++) {
				b[i] = b[i-1] + b[i-2];
			}
			
			for(int i = 0; i < a; i++) {
				System.out.print(b[i] + " ");
			}
			}
	}