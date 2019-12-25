package dataStructure;
import com.sun.corba.se.impl.orbutil.graph.NodeData;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DGraph implements graph, Serializable {
	private HashMap<Integer , node_data> Nodes_Map = new HashMap<>();
	private HashMap<Integer , HashMap<Integer , edge_data>> Edges_Map = new HashMap<>();
	private int NM_size;
	private int EM_size;
	private int MC;

	/**
	 * this method returns the node data by the key
	 * @param key - the node_id
	 * @return node data
	 */
	public node_data getNode(int key) {
		if (Nodes_Map.containsKey(key))
			return this.Nodes_Map.get(key);
		return null;
	}

	/**
	 * this method returns the edge of 2 nodes data only if the source node exists
	 * @param src the source node
	 * @param dest the destination node
	 * @return
	 */
	public edge_data getEdge(int src, int dest) {
		if (Edges_Map.containsKey(src))
			return this.Edges_Map.get(src).get(dest);
		return null;
	}

	/**
	 * this method add a node to the nodes map if the node isn't existing yet
	 * @param n the node to add
	 */
	public void addNode(node_data n) {
		if (!Nodes_Map.containsKey(n)) {
			this.Nodes_Map.put(n.getKey(), n);
			NM_size++;
			MC++;
		}
		else {
			System.out.println("Node already exist");
		}
	}

	/**
	 * Connect an edge with weight w between node src to node dest.
	 * Note: this method should run in O(1) time.
	 * @param src - the source of the edge.
	 * @param dest - the destination of the edge.
	 * @param w - positive weight representing the cost (aka time, price, etc) between src-->dest.
	 */
	public void connect(int src, int dest, double w) {
		if (this.getNode(src) != null && this.getNode(dest)!= null ){
			edge_data t = new EdgeNode(src , dest , w);
			if (this.getEdge(src , dest) == null) {
				if (this.Edges_Map.get(src) == null) {
					this.Edges_Map.put(src, new HashMap<Integer, edge_data>());
					this.Edges_Map.get(src).put(dest, t);
				}
				else
					this.Edges_Map.get(src).put(dest, t);
			}
			EM_size++;
			MC++;
		}
		else {
			throw new NullPointerException("ERR:Not Existing Nodes");
		}
	}

	/**
	 * This method return a pointer (shallow copy) for the
	 * collection representing all the nodes in the graph.
	 * Note: this method should run in O(1) time.
	 * @return Collection<node_data>
	 */
	public Collection<node_data> getV() {
		return this.Nodes_Map.values();
	}

	/**
	 * This method return a pointer (shallow copy) for the
	 * collection representing all the edges getting out of
	 * the given node (all the edges starting (source) at the given node).
	 * Note: this method should run in O(1) time.
	 * @return Collection<edge_data>
	 */
	public Collection<edge_data> getE(int node_id) {
		if (this.Edges_Map.containsKey(node_id))
			return this.Edges_Map.get(node_id).values();
		return null;
	}



	/**
	 * Delete the node (with the given ID) from the graph -
	 * and removes all edges which starts or ends at this node.
	 * This method should run in O(n), |V|=n, as all the edges should be removed.
	 * @return the data of the removed node (null if none).
	 * @param key
	 */
	public node_data removeNode(int key) {
		if (this.Nodes_Map.containsKey(key) ){
			Map<Integer, node_data> map = Nodes_Map;
			for (int newKey : map.keySet()) {
				node_data newNode = map.get(newKey);
				if (this.getEdge(key, newNode.getKey()) != null)
					removeEdge(key, newNode.getKey());
				if (this.getEdge(newNode.getKey(), key) != null)
					removeEdge(newNode.getKey(), key);
			}
			this.Nodes_Map.remove(key);
			MC++;
			NM_size--;
		}
		return null;
		}

	/**
	 * Delete the edge from the graph,
	 * Note: this method should run in O(1) time.
	 * @param src
	 * @param dest
	 * @return the data of the removed edge (null if none).
	 */
	public edge_data removeEdge(int src, int dest) {
		if (this.Nodes_Map.containsKey(src)  & this.Nodes_Map.containsKey(dest)){
			edge_data rm = this.Edges_Map.get(src).get(dest);
			if (this.Edges_Map.get(src).get(dest) != null){
				this.Edges_Map.get(src).remove(dest);
				this.EM_size--;
				this.MC++;
				return rm;
			}
		}
		return null;
	}

	/** return the number of vertices (nodes) in the graph.
	 * Note: this method should run in O(1) time.
	 * @return
	 */
	public int nodeSize() {
		return NM_size;
	}

	/**
	 * return the number of edges (assume directional graph).
	 * Note: this method should run in O(1) time.
	 * @return
	 */
	public int edgeSize() {
		return EM_size;
	}

	/**
	 * return the Mode Count - for testing changes in the graph.
	 * @return
	 */
	public int getMC() {
		return MC;
	}

	public static void main(String[] args) {
//		DGraph g = new DGraph();
//		node_data a = new DataNode( 1);
//		node_data k = new DataNode( 2);
//		node_data h = new DataNode( 3);
//		node_data s = new DataNode( 4);
//		node_data l = new DataNode( 5);
//	//	edge_data e = new EdgeNode(1,2, 7);
//		g.addNode(a);
//		g.addNode(k);
//		g.addNode(h);
//		g.addNode(s);
//		g.addNode(l);
//			g.connect(1, 3, 8);
//			g.connect(1, 4, 9);
//			g.connect(1, 5, 10);
//			g.connect(5,1,4);
//			g.connect(4, 3, 11);
//			g.connect(2, 3, 12);
//
//		g.connect(1,2,7);
//		System.out.println(g.getEdge(1,3).getWeight());
//		g.removeEdge(1,2);
//		System.out.println(g.getEdge(1,2));
//		g.removeEdge(2,3);
//		System.out.println(g.getEdge(2,3).getWeight());
//		g.removeNode(1);
//		System.out.println(g.getEdge(5,1).getWeight());

	}
}
