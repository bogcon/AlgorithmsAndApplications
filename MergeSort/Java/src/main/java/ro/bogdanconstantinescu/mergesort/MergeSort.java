package ro.bogdanconstantinescu.mergesort;

/*
 * Sorting an vector via MergeSort algorithm and Divide and Conquer approach in
 * O(n * log n).
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.05
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/MergeSort
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	/**
	 * Main function. Reads vector, sorts it, and prints the sorted vector.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) {
		System.out.println("------ Begin MergeSort ------");
		int[] vectorToSort = new int[0], sortedVector;
		long start, end;

		/* read vector */
		try {
			if (args.length == 0) {
				throw new Exception("The input file must be given as an argument.");
			}
			vectorToSort = readVectorFromFile(args[0]);
		} catch (Exception ex) {
			System.out.println("ERR. " + ex.getMessage());
			System.out.println("------- End MergeSort -------");
			System.exit(-1);
		}

		/* print read vector */
		// System.out.print("The read vector is: ");
		// printVector(vectorToSort);
		// System.out.println();

		/* sort vector */
		start = System.currentTimeMillis();
		sortedVector = mergeSort(vectorToSort);
		end = System.currentTimeMillis();

		/* print sorted vector */
		System.out.print("The sorted vector is: ");
		printVector(sortedVector);
		System.out.println();

		System.out
				.println("Elapsed: " + ((double) (end - start) / 100) + " seconds while sorting.");
		System.out.println("------- End MergeSort -------\n");
	}

	/**
	 * Recursive function (based on Divide and Conquer algorithm) that sorts a
	 * vector (via Merge Sort algorithm).
	 * 
	 * @param v
	 *            The vector to sort.
	 * @return The sorted vector.
	 */
	public static int[] mergeSort(final int[] v) {
		if (1 == v.length) { // base case
			return v;
		}

		final int[] leftHalf = Arrays.copyOfRange(v, 0, v.length / 2);
		final int[] rightHalf = Arrays.copyOfRange(v, v.length / 2, v.length);
		return merge(mergeSort(leftHalf), mergeSort(rightHalf));
	}

	/**
	 * Merges two sorted vectors.
	 * 
	 * @param v1
	 *            The first vector. (should be sorted)
	 * @param v2
	 *            The second vector. (should be sorted)
	 * @return The combined v1,v2 sorted vector.
	 */
	public static int[] merge(final int[] v1, final int[] v2) {
		int n = v1.length + v2.length, k = 0, i = 0, j = 0;
		final int[] v = new int[n];
		while (i < v1.length && j < v2.length) {
			if (v1[i] <= v2[j]) {
				v[k++] = v1[i++];
			} else {
				v[k++] = v2[j++];
			}
		}
		if (i < v1.length) {
			while (k < n) {
				v[k++] = v1[i++];
			}
		}
		if (j < v2.length) {
			while (k < n) {
				v[k++] = v2[j++];
			}
		}
		return v;
	}

	/**
	 * Prints an array 's elements.
	 * 
	 * @param v
	 *            The vector to print.
	 */
	public static void printVector(int[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
	}

	/**
	 * Reads array from file.
	 * 
	 * @param file
	 *            The file where to read array from.
	 * @return The read vector.
	 * @throws Exception
	 */
	public static int[] readVectorFromFile(final String file) throws Exception {
		Scanner sc;
		FileInputStream fis = null;
		int n;
		int[] v;
		try {
			fis = new FileInputStream(file);
			sc = new Scanner(fis);
			if (!sc.hasNextInt()) {
				throw new Exception("Could not read the number of elements.");
			}
			n = sc.nextInt();
			v = new int[n];
			for (int i = 0; i < n; i++) {
				if (sc.hasNextInt()) {
					v[i] = sc.nextInt();
				} else {
					throw new Exception(
							"Number of declared elements does not match with the one found in file.");
				}
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
