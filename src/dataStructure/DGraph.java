package dataStructure;

import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph{
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
		if (Nodes_Map.containsKey(src))
			return this.Edges_Map.get(src).get(dest);
		return null;
	}

	/**
	 * this method add a node to the nodes map if the node isn't existing yet
	 * @param n the node to add
	 */
	public void addNode(node_data n) {
		if (this.Nodes_Map.get(n) ==  null) {
			this.Nodes_Map.put(n.getKey(), n);
			NM_size++;
			MC++;
		}
		else {
			System.out.println("Node already exist");
		}
	}

	@Override
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
		}
		else {
			throw new NullPointerException("ERR:Not Existing Nodes");
		}
		EM_size++;
		MC++;
	}

	@Override
	public Collection<node_data> getV() {
		return this.Nodes_Map.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return this.Edges_Map.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		return NM_size;
	}

	@Override
	public int edgeSize() {
		return EM_size;
	}

	@Override
	public int getMC() {
		return MC;
	}

}
