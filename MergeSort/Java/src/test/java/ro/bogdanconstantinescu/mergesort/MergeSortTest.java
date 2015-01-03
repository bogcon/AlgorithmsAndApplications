package ro.bogdanconstantinescu.mergesort;

/*
 * JUnit test for MergeSort.
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.05
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/MergeSort
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class MergeSortTest {
	protected int[] mergeV11 = { 1, 2, 3, 4, 5 };
	protected int[] mergeV12 = { 6, 7, 8, 9, 10 };
	protected int[] mergeV21;
	protected int[] mergeV22;
	protected int[] arrayToSort1 = { 11, 7, 99, 34, 33, 34, 0, 100, 2 };
	protected int[] arrayToSort2;

	/**
	 * Constructor; initializes stuffs.
	 */
	public MergeSortTest() {
		/* generate random sorted vectors */
		final Random randomGenerator = new Random();
		final int v1Length = 10 + randomGenerator.nextInt(100);
		final int v2Length = 20 + randomGenerator.nextInt(200);
		this.mergeV21 = new int[v1Length];
		this.mergeV22 = new int[v2Length];
		this.mergeV21[0] = randomGenerator.nextInt(10000);
		this.mergeV22[0] = randomGenerator.nextInt(20000);
		for (int i = 1; i < v1Length; i++) {
			this.mergeV21[i] = this.mergeV21[i - 1] + randomGenerator.nextInt(10);
		}
		for (int i = 1; i < v2Length; i++) {
			this.mergeV22[i] = this.mergeV22[i - 1] + randomGenerator.nextInt(10);
		}

		/* generate random unsorted hopefully:) vector */
		final int v3Length = 100 + randomGenerator.nextInt(200);
		this.arrayToSort2 = new int[v3Length];
		for (int i = 0; i < v3Length; i++) {
			this.arrayToSort2[i] = randomGenerator.nextInt(10000);
		}
	}

	/**
	 * Test case for {@link MergeSort#merge(int[], int[])}.
	 */
	@Test
	public void mergeTest() {
		final int[] merged1 = MergeSort.merge(this.mergeV11, this.mergeV12);
		assertEquals("merged 1 length is not ok", this.mergeV11.length + this.mergeV12.length,
				merged1.length);

		final int[] merged2 = MergeSort.merge(this.mergeV12, this.mergeV11);
		assertEquals("merged 2 length is not ok", this.mergeV11.length + this.mergeV12.length,
				merged2.length);

		assertArrayEquals("merged 1 and 2 are not equal", merged1, merged2);

		Arrays.sort(merged1);
		assertArrayEquals("merged 1|2 are not sorted", merged2, merged1);

		final int[] merged3 = MergeSort.merge(this.mergeV21, this.mergeV22);
		assertEquals("merged 3 length is not ok", this.mergeV21.length + this.mergeV22.length,
				merged3.length);

		final int[] merged4 = MergeSort.merge(this.mergeV22, this.mergeV21);
		assertEquals("merged 4 length is not ok", this.mergeV21.length + this.mergeV22.length,
				merged4.length);

		assertArrayEquals("merged 3 and 4 are not equal", merged3, merged4);

		Arrays.sort(merged3);
		assertArrayEquals("merged 3|4 are not sorted", merged3, merged4);

		final int[] merged5 = MergeSort.merge(this.mergeV11, this.mergeV22);
		assertEquals("merged 5 length is not ok", this.mergeV11.length + this.mergeV22.length,
				merged5.length);

		final int[] merged6 = MergeSort.merge(this.mergeV22, this.mergeV11);
		assertEquals("merged 6 length is not ok", this.mergeV22.length + this.mergeV11.length,
				merged6.length);

		assertArrayEquals("merged 5 and 6 are not equal", merged5, merged6);

		Arrays.sort(merged6);
		assertArrayEquals("merged 5|6 are not sorted", merged5, merged6);
	}

	/**
	 * Test case for {@link MergeSort#mergeSort(int[])}.
	 */
	@Test
	public void mergeSortTest() {
		final int[] sorted1 = MergeSort.mergeSort(this.arrayToSort1);
		final int[] sorted1Cloned = Arrays.copyOfRange(sorted1, 0, sorted1.length);
		Arrays.sort(sorted1Cloned);
		assertArrayEquals("sorted 1 is not sorted", sorted1, sorted1Cloned);

		final int[] sorted2 = MergeSort.mergeSort(this.arrayToSort2);
		final int[] sorted2Cloned = Arrays.copyOfRange(sorted2, 0, sorted2.length);
		Arrays.sort(sorted2Cloned);
		assertArrayEquals("sorted 2 is not sorted", sorted2, sorted2Cloned);
	}
}