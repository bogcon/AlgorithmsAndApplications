package ro.bogdanconstantinescu.graphmincuts;

/*
 * Node class used for a simple linked list.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.26
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/GraphMinCuts
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */
public class Node {

	public int vertex;
	public Node next;

	/**
	 * Constructor.
	 * 
	 * @param vertex
	 *            The vertex to store.
	 */
	public Node(final int vertex) {
		this.vertex = vertex;
		this.next = null;
	}

	/**
	 * Constructor.
	 * 
	 * @param vertex
	 *            The vertex to store.
	 * @param node
	 *            The next node to link with.
	 */
	public Node(final int vertex, final Node node) {
		this(vertex);
		this.next = node;
	}

	/**
	 * Clones the object.
	 * 
	 * @return The cloned object
	 */
	@Override
	public Node clone() {
		Node cloned = new Node(this.vertex);
		if (null != this.next) {
			cloned.next = this.next.clone();
		}
		return cloned;
	}
}
