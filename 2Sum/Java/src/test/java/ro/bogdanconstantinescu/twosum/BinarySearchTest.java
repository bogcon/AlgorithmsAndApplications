package ro.bogdanconstantinescu.twosum;

/*
 * JUnit test for Binary Search.
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.08
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/2Sum
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

	protected Integer[] sortedVector;

	/**
	 * Setup fixtures.
	 */
	@Before
	public void setUp() {
		final Random randomGenerator = new Random();
		int lastGeneratedNumber = 0;
		/* generate random sorted vector with no equal elements */
		final int vLength = 100 + randomGenerator.nextInt(200); // [100, 200)
		this.sortedVector = new Integer[vLength];
		for (int i = 0; i < vLength; i++) {
			lastGeneratedNumber = lastGeneratedNumber + randomGenerator.nextInt(100) + 1;
			this.sortedVector[i] = lastGeneratedNumber;
		}
	}

	/**
	 * Test case for
	 * {@link BinarySearch#binarySearch(Comparable[], int, int, Comparable)}.
	 */
	@Test
	public void binarySearchTest() {
		/* search for first value */
		Integer searchfor = this.sortedVector[0];
		int pos = BinarySearch.binarySearch(this.sortedVector, 0, this.sortedVector.length - 1,
				searchfor);
		assertTrue(pos == 0);
		/* search for last value */
		searchfor = this.sortedVector[this.sortedVector.length - 1];
		pos = BinarySearch.binarySearch(this.sortedVector, 0, this.sortedVector.length - 1,
				searchfor);
		assertTrue(pos == this.sortedVector.length - 1);
		/* search for random value */
		final Random randomGenerator = new Random();
		final int searchForPos = randomGenerator.nextInt(this.sortedVector.length);
		searchfor = this.sortedVector[searchForPos];
		pos = BinarySearch.binarySearch(this.sortedVector, 0, this.sortedVector.length - 1,
				searchfor);
		assertTrue(pos == searchForPos);
		/* make two elements equal */
		this.sortedVector[57] = this.sortedVector[58];
		searchfor = this.sortedVector[57];
		pos = BinarySearch.binarySearch(this.sortedVector, 0, this.sortedVector.length - 1,
				searchfor);
		assertTrue(pos == 57 || pos == 58);
	}
}
