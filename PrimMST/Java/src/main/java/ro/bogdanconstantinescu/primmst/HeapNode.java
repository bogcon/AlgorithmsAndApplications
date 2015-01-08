package ro.bogdanconstantinescu.primmst;

/*
 * Heap element.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.09.07
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/PrimMST
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

public class HeapNode implements Comparable<HeapNode> {

	public int vertex;
	public int tailVertex;
	public int weight;

	/**
	 * Constructor.
	 *
	 * @param vertex
	 *            The vertex to store.
	 * @param tailVertex
	 *            The tail vertex.
	 * @param weight
	 *            The weight between tailVertex and vertex.
	 */
	public HeapNode(final int vertex, final int tailVertex, final int weight) {
		this.vertex = vertex;
		this.tailVertex = tailVertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(HeapNode obj) {
		if (this.weight > obj.weight) {
			return 1;
		} else if (this.weight == obj.weight) {
			return 0;
		}
		return -1;
	}
}
