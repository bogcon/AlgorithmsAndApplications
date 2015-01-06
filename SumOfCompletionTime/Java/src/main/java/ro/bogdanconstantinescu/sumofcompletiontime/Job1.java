package ro.bogdanconstantinescu.sumofcompletiontime;

/*
 * Greedy algorithm for minimizing the weighted sum of completion times.
 * The ratio is calculated as difference between weight and length. Is not always optimal.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.09.06
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/SumOfCompletionTime
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

public class Job1 implements Comparable<Job1> {

	public int length;
	public int weight;

	public Job1(final int length, final int weight) {
		this.length = length;
		this.weight = weight;
	}

	@Override
	public int compareTo(Job1 job) {
		if (this.weight - this.length < job.weight - job.length) {
			return 1;
		} else if (this.weight - this.length == job.weight - job.length) {
			if (this.weight < job.weight) {
				return 1;
			} else if (this.weight == job.weight) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
