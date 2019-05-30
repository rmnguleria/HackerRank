import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps2
{

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr)
	{
		boolean[] visited = new boolean[arr.length];

		// 7 , 1 , 3 , 2 , 6, 5, 6

		int sum = 0;

		for (int i = 0; i < arr.length; i++)
		{

			if (!visited[i])
			{
				sum += cycle(i, arr, visited) - 1;
			}
		}

		return sum;

	}

	private static int cycle(int i, final int[] arr, boolean[] visited)
	{
		int cycleSize = 0;

		while (!visited[i])
		{
			visited[i] = true;
			i = arr[i] - 1;
			cycleSize += 1;
		}

		return cycleSize;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++)
		{
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
