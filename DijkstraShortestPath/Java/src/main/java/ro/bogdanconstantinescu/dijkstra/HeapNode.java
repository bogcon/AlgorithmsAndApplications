package ro.bogdanconstantinescu.dijkstra;

/*
 * Heap element.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.08.04
 * @version     1.0
 * @link        GitHub  https://github.com/bogcon/AlgorithmsAndApplications/tree/master/DijkstraShortestPath
 * @license     The MIT License (http://opensource.org/licenses/MIT); see LICENSE.txt
 */

public class HeapNode implements Comparable<HeapNode> {

	public int vertex;
	public int startVertex;
	public int shortestPath;

	/**
	 * Constructor.
	 *
	 * @param vertex
	 *            The vertex to store.
	 * @param startVertex
	 *            The start vertex.
	 * @param shortestPath
	 *            The shortest path from start vertex to vertex.
	 */
	public HeapNode(final int vertex, final int startVertex, final int shortestPath) {
		this.vertex = vertex;
		this.startVertex = startVertex;
		this.shortestPath = shortestPath;
	}

	@Override
	public int compareTo(HeapNode obj) {
		return this.shortestPath - obj.shortestPath;
	}

	@Override
	public Object clone() {
		return new HeapNode(this.vertex, this.startVertex, this.shortestPath);
	}
}
