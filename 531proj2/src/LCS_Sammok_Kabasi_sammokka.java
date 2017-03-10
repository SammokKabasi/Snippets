import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LCS_Sammok_Kabasi_sammokka {

	public static void main(String[] args) {

		// read input from file
		String string = readFile(new File("input.txt"));
		String inputs[] = string.split("\n");

		String output = new LCS_Sammok_Kabasi_sammokka().findLcs(inputs[0], inputs[1]);
		printToOutput(new File("output.txt"), output);
//		System.out.println("\n\n\n\n\n\n");
//		System.out.println(output);
	}

	private static void printToOutput(File file, String outputText) {
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
			output.write(outputText);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error while writing to output");
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("Error while writing to output");
				}
			}
		}
	}

	public String findLcs(String first, String second) {
		char[] a = first.toCharArray();
		char[] b = second.toCharArray();
		int m = a.length;
		int n = b.length;
		int[][] opt = new int[m + 1][n + 1];
		String[][] pi = new String[m + 1][n + 1];
		int i, j;
		for (j = 0; j <= n; j++) {
			opt[0][j] = 0;
		}
		for (int x = 1; x <= m; x++) {
			pi[x][0] = "" + first.charAt(x - 1);
		}
		for (int x = 1; x <= n; x++) {
			pi[0][x] = "" + second.charAt(x - 1);
		}

		for (i = 1; i <= m; i++) {
			opt[i][0] = 0;
			for (j = 1; j <= n; j++) {
				if (a[i - 1] == b[j - 1]) {
					opt[i][j] = opt[i - 1][j - 1] + 1;
					pi[i][j] = "dg";
				} else if (opt[i][j - 1] >= opt[i - 1][j]) {
					opt[i][j] = opt[i][j - 1];
					pi[i][j] = "l";
				} else {
					opt[i][j] = opt[i - 1][j];
					pi[i][j] = "u";
				}
			}
		}

		// for (int x = 0; x < opt.length; x++) {
		// for (int y = 0; y < opt[x].length; y++) {
		// System.out.print(opt[x][y] + "," + pi[x][y] + "\t");
		// }
		// System.out.println();
		// }

		// construct string back

		String lcs = "";
		int x = m, y = n;
		while (x > 0 && y > 0) {
			switch (pi[x][y]) {
			case "dg": {
				lcs = a[x - 1] + lcs;
				x--;
				y--;
				break;
			}
			case "u": {
				x--;
				break;
			}
			case "l": {
				y--;
				break;
			}
			default: {
				throw new RuntimeException("Error occurred");
			}

			}

		}
//		System.out.println("LCS is ->" + lcs);
		// if(lcs.length()!=opt[m][n]) {
		// throw new RuntimeException("length not equal!");
		// }
		return opt[m][n] + "\n" + lcs;
	}

	public static String readFile(File inputFile) {
		BufferedReader br = null;
		String everything = null;
		try {
			br = new BufferedReader(new FileReader(inputFile));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
			// //System.out.println(everything);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return everything;

	}
}
