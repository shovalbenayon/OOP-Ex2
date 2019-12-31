# OOP-Ex2
In this project i developed a data structure, algorithms and GUI(Graphical User Interface).
The Project contains the development of a data structure of deliberate weighted graph.
In data Structure class i implemented the node data interface which is representing the dots on the graph and Edge Node that connecting between to Data nodes. After implementing those classes, i implementing DGraph which is a weighted graph.
the Class Graph_Algo contains DGraph and in this class i implemented a few algorithms .

DataNode:

the class is represen't a dot in the graph and have the following fields: key - the node id, Location - the point on a graph , Weight , Info and tag.

EdgeNode:

the class is represen't a edge in the graph and have the following fields: src - the source node id, dest - the destination node id , Weight , Info and tag.

DGraph:

this class is represent's a weighted graph that's have the following fields : 
hashMap <Integer , node_data> of the Data Nodes that save the nodes by their key, and hashMap <srs , hashMap <dest , edge_data>> of the Edges Nodes that save a hashmap of neighbors that connecting with Edge node . The HashMap save it by a sorce Data node key and inside by the Destination Data node key.

Graph_Algo:

Class Graph_Algo is implements graph_algorithms and represents collection of algorithms on deliberate weighted graphs. In class Graph_Algo we did functions such as: isConnected that returns true or false whether the graph is connected. graph is connected when it has at least one vertex and there is a path between every pair of vertices. Another function is shortestPathDist that returns the length of the shortest path between src and dest.
