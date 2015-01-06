package ro.bogdanconstantinescu.sumofcompletiontime;

/*
 * Greedy algorithm for minimizing the weighted sum of completion times.
 * The ratio is calculated as weight divided by length. Is always optimal.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.09.06
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/SumOfCompletionTime
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

public class Job2 implements Comparable<Job2> {

	public int length;
	public int weight;

	public Job2(final int length, final int weight) {
		this.length = length;
		this.weight = weight;
	}

	@Override
	public int compareTo(Job2 job) {
		if (this.weight * job.length < job.weight * this.length) {
			// w1/len1 < w2/len2 <=> w1*len2 < w2.len1
			return 1;
		} else if (this.weight * job.length == job.weight * this.length) {
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
