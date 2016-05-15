package CodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DiamondInheritance
{
	static ArrayList<Integer>[] adj;
	static boolean[] vis;
	static boolean diamond;

	static void search(int x)
	{
		if (diamond)
			return;

		if (vis[x])
			diamond = true;

		vis[x] = true;
		for (int i : adj[x])
			search(i);
	}

	public static void main(String[] args) throws Exception
	{
		out = new PrintWriter(new FileWriter("out.txt"));

		int t = readInt();
		for (int r = 1; r <= t; r++)
		{
			int n = readInt();
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adj[i] = new ArrayList<Integer>();

			for (int i = 0; i < n; i++)
			{
				int m = readInt();
				for (int j = 0; j < m; j++)
					adj[readInt() - 1].add(i);
			}

			diamond = false;

			for (int i = 0; i < n && !diamond; i++)
			{
				vis = new boolean[n];
				search(i);
			}

			out.printf("Case #%d: ", r);
			if (diamond)
				out.println("Yes");
			else
				out.println("No");
		}
		out.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter out = new PrintWriter(new BufferedWriter(
			new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static String next() throws IOException
	{
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException
	{
		return Long.parseLong(next());
	}

	static int readInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException
	{
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException
	{
		return next().charAt(0);
	}

	static String readLine() throws IOException
	{
		return br.readLine().trim();
	}
}
