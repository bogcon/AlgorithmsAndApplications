package ro.bogdanconstantinescu.sumofcompletiontime;

/*
 * Greedy algorithm for minimizing the weighted sum of completion times.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.09.06
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/SumOfCompletionTime
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/**
	 * Main function.
	 *
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) {
		System.out
				.println("------ Begin Greedy Minimizing The Weighted Sum Of Completion Times ------");
		long start, end;
		long sum = 0, completionSum = 0;

		/* read jobs, sorts them and calculate the result */
		start = System.currentTimeMillis();
		try {
			if (args.length < 2) {
				throw new Exception(
						"Please provide the ratio calculation strategy as the first argument and the input file as the second argument.");
			}
			// how should ratio be calculated (sum | division)
			final String strategy = args[0];
			if ("sum".equalsIgnoreCase(strategy)) {
				Job1[] jobs1 = readJobs1FromFile(args[1]);
				Arrays.sort(jobs1);
				for (int i = 0; i < jobs1.length; i++) {
					sum += jobs1[i].length;
					completionSum += jobs1[i].weight * sum;
				}
			} else if ("division".equalsIgnoreCase(strategy)) {
				Job2[] jobs2 = readJobs2FromFile(args[1]);
				Arrays.sort(jobs2);
				for (int i = 0; i < jobs2.length; i++) {
					sum += jobs2[i].length;
					completionSum += jobs2[i].weight * sum;
				}
			} else {
				throw new Exception(
						"The ratio calculation strategy should be one of 'sum' or 'division'");
			}
		} catch (Exception ex) {
			System.out.println("ERR. " + ex.getMessage());
			System.out
					.println("------- End Greedy Minimizing The Weighted Sum Of Completion Times -------");
			System.exit(-1);
		}
		end = System.currentTimeMillis();

		/* print result */
		System.out.println("The weighted sum of completion times = " + completionSum);

		System.out.println("Elapsed: " + ((double) (end - start) / 100)
				+ " seconds with sum calculation.");
		System.out
				.println("------- End Greedy Minimizing The Weighted Sum Of Completion Times -------");
	}

	/**
	 * Reads array of jobs from file.
	 *
	 * @param file
	 *            The file where to read array from.
	 * @return The read vector.
	 * @throws Exception
	 */
	public static Job1[] readJobs1FromFile(final String file) throws Exception {
		Scanner sc;
		FileInputStream fis = null;
		int n, weight, length;
		Job1[] v;
		Job1 job;
		try {
			fis = new FileInputStream(file);
			sc = new Scanner(fis);
			if (sc.hasNextInt()) {
				n = sc.nextInt();
			} else {
				throw new Exception("Could not read the number of elements vector has.");
			}
			v = new Job1[n];
			for (int i = 0; i < n; i++) {
				if (sc.hasNextInt()) {
					weight = sc.nextInt();
				} else {
					throw new Exception("Could not read weight for job " + (i + 1));
				}
				if (sc.hasNextInt()) {
					length = sc.nextInt();
				} else {
					throw new Exception("Could not read length for job " + (i + 1));
				}
				job = new Job1(length, weight);
				v[i] = job;
			}
			fis.close();
		} catch (Exception ex) {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
				}
			}
			throw ex;
		}
		return v;
	}

	/**
	 * Reads array of jobs from file.
	 *
	 * @param file
	 *            The file where to read array from.
	 * @return The read vector.
	 * @throws Exception
	 */
	public static Job2[] readJobs2FromFile(final String file) throws Exception {
		Scanner sc;
		FileInputStream fis = null;
		int n, weight, length;
		Job2[] v;
		Job2 job;
		try {
			fis = new FileInputStream(file);
			sc = new Scanner(fis);
			if (sc.hasNextInt()) {
				n = sc.nextInt();
			} else {
				throw new Exception("Could not read the number of elements vector has.");
			}
			v = new Job2[n];
			for (int i = 0; i < n; i++) {
				if (sc.hasNextInt()) {
					weight = sc.nextInt();
				} else {
					throw new Exception("Could not read weight for job " + (i + 1));
				}
				if (sc.hasNextInt()) {
					length = sc.nextInt();
				} else {
					throw new Exception("Could not read length for job " + (i + 1));
				}
				job = new Job2(length, weight);
				v[i] = job;
			}
			fis.close();
		} catch (Exception ex) {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
				}
			}
			throw ex;
		}
		return v;
	}
}
