package algorithms;

import java.io.*;
import java.util.*;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms , Serializable {
	private DGraph graphalgo = new DGraph();

	@Override
	public void init(graph g) {
		Collection<node_data> new_data = (Collection<node_data>) g.getV();
		Iterator<node_data> iter = new_data.iterator();

		while (iter.hasNext()) {this.graphalgo.addNode(iter.next());}
		iter = new_data.iterator();
		while (iter.hasNext()) {
			node_data temp = iter.next();
			if(g.getE(temp.getKey()) != null) {
				Collection<edge_data> new_edge = g.getE(temp.getKey());
				Iterator<edge_data> iter_edge = new_edge.iterator();
				while (iter_edge.hasNext()) {
					edge_data t = iter_edge.next();
					this.graphalgo.connect(t.getSrc(), t.getDest(), t.getWeight());

				}
			}

		}
	}
	public int getnodeSize(){
		return graphalgo.nodeSize();
	}
	public int getedgeSize(){
		return graphalgo.edgeSize();
	}

	@Override
	public void init(String file_name) {
		Graph_Algo g = new Graph_Algo();
		try
		{
			FileInputStream file = new FileInputStream(file_name);
			ObjectInputStream in = new ObjectInputStream(file);

			g = (Graph_Algo)in.readObject();
			this.init(g.graphalgo);

			in.close();
			file.close();

			System.out.println("Object has been deserialized");
			System.out.println(g);
		}

		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}

		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}

	}

	@Override
	public void save(String file_name) throws IOException {
		try {
			FileOutputStream file = new FileOutputStream(file_name);
			ObjectOutputStream out = new ObjectOutputStream(file);


			out.writeObject(this);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		} catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		Graph_Algo new_graph = new Graph_Algo();
		new_graph.init(this.graphalgo);
		return (graph) new_graph.graphalgo;
	}

}
