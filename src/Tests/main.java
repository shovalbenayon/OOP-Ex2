package Tests;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.DataNode;
import dataStructure.graph;
import dataStructure.node_data;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        DGraph dg = new DGraph();
        node_data nd1 = new DataNode(1);
        node_data nd2 = new DataNode(2);
        node_data nd3 = new DataNode(3);
        node_data nd4 = new DataNode(4);
        node_data nd5 = new DataNode(5);

        dg.addNode(nd1);
        dg.addNode(nd2);
        dg.addNode(nd3);
        dg.addNode(nd4);
        dg.addNode(nd5);

        dg.connect(1,2,7);
        dg.connect(1,4,8);
        dg.connect(1,3,9);
        dg.connect(1,5,2);
        dg.connect(2,3,9);
        dg.connect(4,5,9);

        System.out.println(dg.edgeSize());
        Graph_Algo ga = new Graph_Algo();
        ga.init(dg);
        System.out.println(ga.getnodeSize());
        System.out.println(ga.getedgeSize());


        graph gajhgj =  ga.copy();
        System.out.println("new"+gajhgj.edgeSize());
        gajhgj.connect(2, 5, 80);
        System.out.println(gajhgj.getE(2).size());
        Graph_Algo f = new Graph_Algo();

       ga.save("graph g");
       f.init("graph g");
        System.out.println(f.getedgeSize());
    }
}
