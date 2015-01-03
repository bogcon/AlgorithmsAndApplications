package ro.bogdanconstantinescu.twosum;

/*
 * JUnit test for QuickSort.
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.08
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/2Sum
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
	protected Integer[] arrayToSort;

	/**
	 * Setup fixtures.
	 */
	@Before
	public void setUp() {
		Random randomGenerator = new Random();
		/* generate random unsorted hopefully:) vector */
		int vLength = 100 + randomGenerator.nextInt(200);
		this.arrayToSort = new Integer[vLength];
		for (int i = 0; i < vLength; i++) {
			this.arrayToSort[i] = randomGenerator.nextInt(10000);
		}
	}

	/**
	 * Test case for {@link QuickSort#partition(Comparable[], int, int)}; pick
	 * pivot between all array 's elements.
	 */
	@Test
	public void partition1Test() {
		int leftPos = 0;
		int rightPos = this.arrayToSort.length - 1;
		int pivotPos = QuickSort.partition(this.arrayToSort, leftPos, rightPos);
		for (int i = leftPos; i < pivotPos; i++) {
			if (this.arrayToSort[i] >= this.arrayToSort[pivotPos]) {
				fail("Partitioning failed.");
			}
		}
		for (int i = pivotPos; i <= rightPos; i++) {
			if (this.arrayToSort[i] < this.arrayToSort[pivotPos]) {
				fail("Partitioning failed.");
			}
		}
	}

	/**
	 * Test case for {@link QuickSort#partition(Comparable[], int, int)}; pick
	 * pivot between random positions.
	 */
	@Test
	public void partition2Test() {
		Random randomGenerator = new Random();
		int leftPos = randomGenerator.nextInt(this.arrayToSort.length);
		int rightPos = leftPos + randomGenerator.nextInt(this.arrayToSort.length - leftPos);

		int pivotPos = QuickSort.partition(this.arrayToSort, leftPos, rightPos);
		for (int i = leftPos; i < pivotPos; i++) {
			if (this.arrayToSort[i] >= this.arrayToSort[pivotPos]) {
				fail("Partitioning failed.");
			}
		}
		for (int i = pivotPos; i <= rightPos; i++) {
			if (this.arrayToSort[i] < this.arrayToSort[pivotPos]) {
				fail("Partitioning failed.");
			}
		}
	}

	/**
	 * Test case for {@link QuickSort#partition(Comparable[], int, int)}; pick
	 * pivot from a vector of 1 element.
	 */
	@Test
	public void partition3Test() {
		int leftPos = 0;
		int rightPos = 0;

		int pivotPos = QuickSort.partition(this.arrayToSort, leftPos, rightPos);
		for (int i = leftPos; i < pivotPos; i++) {
			if (this.arrayToSort[i] >= this.arrayToSort[pivotPos]) {
				fail("Partitioning failed.");
			}
		}
		for (int i = pivotPos; i <= rightPos; i++) {
			if (this.arrayToSort[i] < this.arrayToSort[pivotPos]) {
				fail("Partitioning failed.");
			}
		}
	}

	/**
	 * Test case for {@link QuickSort#quickSort(Comparable[], int, int)}.
	 */
	@Test
	public void quickSortTest() {
		Integer[] arrayToSortCloned = Arrays.copyOfRange(this.arrayToSort, 0,
				this.arrayToSort.length);
		Arrays.sort(arrayToSortCloned);
		QuickSort.quickSort(this.arrayToSort, 0, this.arrayToSort.length - 1);

		assertArrayEquals("quick sort did not sort the array well", arrayToSortCloned,
				this.arrayToSort);
	}
}
