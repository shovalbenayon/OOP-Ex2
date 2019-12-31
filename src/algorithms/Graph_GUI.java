package algorithms;

import algorithms.Graph_Algo;
import dataStructure.*;
import utils.Point3D;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Graph_GUI extends JFrame implements ActionListener, MouseListener,Serializable
{
    private static JFrame frame;
    graph Dgraph;
    LinkedList<Point3D> points = new LinkedList<Point3D>();
    ArrayList<node_data> SP= new ArrayList<node_data>();

    public Graph_GUI()
    {
        initGUI();
    }
    public Graph_GUI(graph g )
    {
        this.Dgraph = g;
        initGUI();
    }
    private void initGUI()
    {
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar menuBar = new MenuBar();

        Menu File = new Menu("File");
        menuBar.add(File);
        this.setMenuBar(menuBar);

        Menu Functions = new Menu("Functions");
        menuBar.add(Functions);
        this.setMenuBar(menuBar);

        Menu Size = new Menu("Size");
        menuBar.add(Size);
        this.setMenuBar(menuBar);

        MenuItem IsConnected = new MenuItem("IsConnected");
        IsConnected.addActionListener(this);

        MenuItem ShortestPathDist = new MenuItem("ShortestPathDist");
        ShortestPathDist.addActionListener(this);

        MenuItem ShortestPath = new MenuItem("ShortestPath");
        ShortestPath.addActionListener(this);

        MenuItem TSP = new MenuItem("TSP");
        TSP.addActionListener(this);

        MenuItem SaveToFile = new MenuItem("SaveToFile");
        SaveToFile.addActionListener(this);

        MenuItem InitFromFile = new MenuItem("InitFromFile");
        InitFromFile.addActionListener(this);

        MenuItem Nodes_Size = new MenuItem("Nodes Size");
        Nodes_Size.addActionListener(this);

        MenuItem Edges_size = new MenuItem("Edges size");
        Edges_size.addActionListener(this);

        File.add(SaveToFile);
        File.add(InitFromFile);

        Size.add(Nodes_Size);
        Size.add(Edges_size);

        Functions.add(ShortestPath);
        Functions.add(ShortestPathDist);
        Functions.add(TSP);
        Functions.add(IsConnected);

        this.addMouseListener(this);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Collection<node_data> col = Dgraph.getV();
        Iterator<node_data> iterNodes = col.iterator();

        while (iterNodes.hasNext())
        {
            g.setColor(Color.BLUE);
            node_data temp = iterNodes.next();
            Point3D p = new Point3D(temp.getLocation());
            g.fillOval((int)p.x(), (int)p.y(), 10, 10);
            g.drawString(String.valueOf(temp.getKey()) , (int)p.x() ,(int)p.y());
        }

        iterNodes = col.iterator();

        while (iterNodes.hasNext()){
            node_data tempNode = iterNodes.next();
            Collection<edge_data> edgeCol = this.Dgraph.getE(tempNode.getKey());
            if (edgeCol !=null) {
                Iterator<edge_data> iterEdge = edgeCol.iterator();

                while (iterEdge.hasNext()) {
                    {
                        edge_data ed = iterEdge.next();
                        node_data start = this.Dgraph.getNode(ed.getSrc());
                        node_data end = this.Dgraph.getNode(ed.getDest());
                        g.setColor(Color.RED);

                        g.drawLine((int) end.getLocation().x()+5, (int) end.getLocation().y()+5,
                                (int) start.getLocation().x()+5, (int) start.getLocation().y()+5);
                        String weight = String.valueOf(ed.getWeight());


                        double arrowX = ((end.getLocation().x()+2) * 8 + (start.getLocation().x())+2 )/ 9;
                        double arrowY = ((end.getLocation().y()+2 )* 8 + (start.getLocation().y())+2) / 9;
                        g.setColor(Color.YELLOW);
                        g.fillOval((int) arrowX, (int) arrowY, 10, 10);

                        g.setColor(Color.BLACK);
                        g.drawString(weight, (int) ((start.getLocation().x() + end.getLocation().x()) / 2), (int) (start.getLocation().y() + end.getLocation().y()) / 2);
                    }
                }
            }

        }

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        Point3D p = new Point3D(x,y);
        node_data new_node = new DataNode(Dgraph.nodeSize()+1 , p);
        Dgraph.addNode(new_node);
        repaint();
        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("mouseReleased");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("mouseEntered");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("mouseExited");
    }



}
