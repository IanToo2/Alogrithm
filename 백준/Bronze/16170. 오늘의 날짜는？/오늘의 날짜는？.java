import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		Calendar now = Calendar.getInstance();
		
		System.out.println(now.get(Calendar.YEAR));
		System.out.println("0" +""+ (now.get(Calendar.MONTH)+1));
		System.out.println(now.get(Calendar.DATE));
		
		
	}

	private static void run() {

	}
}
