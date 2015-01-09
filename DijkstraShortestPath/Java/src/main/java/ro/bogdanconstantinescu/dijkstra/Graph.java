package ro.bogdanconstantinescu.dijkstra;

/*
 * Graph class.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.08.04
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/DijkstraShortestPath
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */
public class Graph {

	public int n;
	public int m;
	public Node[] edges;

	/**
	 * Constructor.
	 *
	 * @param n
	 *            Number of vertices the graph has.
	 * @param m
	 *            Number of edges the graph has.
	 * @param edges
	 *            The edges, key is the tail vertex and the value is a simple
	 *            linked list of head vertices the tail vertex has edge(s) with.
	 */
	public Graph(final int n, final int m, final Node[] edges) {
		this.n = n;
		this.m = m;
		this.edges = edges;
	}
}