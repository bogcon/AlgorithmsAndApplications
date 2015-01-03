package ro.bogdanconstantinescu.twosum;

/*
 * Binary search. Searches for a value in a sorted vector in O(log n).
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.08
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/2Sum
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

public class BinarySearch {

	/**
	 * Binary search for a given value in a sorted vector.
	 *
	 * @param <T>
	 *            Any comparable object.
	 * @param v
	 *            The sorted vector to search in.
	 * @param left
	 *            The left margin of the vector.
	 * @param right
	 *            The right margin of the vector.
	 * @param searchedValue
	 *            The searched value.
	 * @return Position in the vector of the searched value, -1 if not found.
	 */
	public static <T extends Comparable<T>> int binarySearch(final T[] v, final int left,
			final int right, final T searchedValue) {
		if (right < left) {
			return -1;
		}
		final int middle = (right + left) / 2;
		if (v[middle].equals(searchedValue)) {
			return middle;
		} else if (searchedValue.compareTo(v[middle]) > 0) {
			return binarySearch(v, middle + 1, right, searchedValue);
		}
		return binarySearch(v, left, middle - 1, searchedValue);
	}
}
