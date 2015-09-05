package Algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * Edge of Graph
 * @author Prateek
 */
class Edge {
 int src;
 int dest;
 int weight;

 public Edge(int src,int dest,int weight) { //constructor
  this.src=src;
  this.dest=dest;
  this.weight=weight;
 }

 @Override
 public String toString() {
  return "Edge: "+src+ " - " + dest + " | " +"  Weight: "+ weight;
 							}
} //class Edge

/**
 * Bellman's Algorithm for Single Source Shortest Path
 * 
 *
 */
 class BellmanFordNew {
 
 private static final int MAX_INF=999999;

 private int mNumVertices;   // Number of vertices in the graph
 private int mNumEdges;  // Number of edges in the graph
 
 // Input Edge List
 private List<Edge> mEdgeList; 
 public BellmanFordNew(int numVertices,int numEdges) { //constructor
  this.mNumVertices=numVertices;
  this.mNumEdges=numEdges;
  
  this.mEdgeList=new ArrayList<Edge>(numEdges);
 }
 
 private  boolean bellmanFord(int src)
 {
  // maintains the updated distance
  int[] dist=new int[mNumVertices];
  
  //print out the graph
   printAdjMatrix();
   System.out.println("**************************************");
   System.out.println("Number of vertices="+mNumVertices);
   System.out.println("Number of Edges="+mNumEdges);
   System.out.println("**************************************");
   System.out.println("Calculating single source shortest path from source="+src);
   System.out.println("**************************************");
  
  //Initialisation //have space for only SINGLE Source shortest path
  for(int i=0;i<mNumVertices ; i++) 
   dist[i] = MAX_INF;
  dist[src]=0;
  
  //calculation of shortest path 
    for(int i=1;i<= mNumVertices-1 ; i++)
  {
   for(int j=0;j< mNumEdges ; j++) 
   {
    Edge edge=mEdgeList.get(j);
    int u=edge.src;
    int v=edge.dest;
    int weight=edge.weight;
    
    // Relaxing the edge
    if(dist[v] > dist[u]+weight)
     dist[v]=dist[u]+weight;
   }
   System.out.println("shortest path after relaxing " + i +" times");
   printShortestPath(src , dist);
  }
  
  //check for negative cycles, by inspecting the distance of all vertices
  // if we find any dist[v] greater distance than dist[u]+ weight, that means 
  // we have already cycled through some edge more than once
  for(int i=0 ;i< mNumEdges ;i++)
  {
   Edge edge=mEdgeList.get(i);
   int u=edge.src;
   int v=edge.dest;
   int weight=edge.weight;
   
   if(dist[u]+weight < dist[v])
   {
	   System.out.println("Checking for negative cycle in the graph...");
	   System.out.println("Negative Cycle Exists !!!! Shortest path CANNOT be calculated");
    return false;
   }
  }
  System.out.println("From Source " +src +", final single source shortest path =>"); 
  printShortestPath(src , dist);
  return true;
 }  //bellmanFord method
 
 //---------------------------------------------------------------------
 
 private void printShortestPath(int src , int[] dist) {
  for(int i=0;i<mNumVertices ;i++)
   System.out.println(src + " ---> " + i + "    "   +dist[i]);
 }
 
 //------------------------------------------------------------
 
 private void printAdjMatrix()
 {
	 System.out.println("*************Adjacency list for the graph**************");
	 for(int j=0;j< mNumEdges ; j++) 
	   {
	    Edge edge=mEdgeList.get(j);
	    int u=edge.src;
	    int v=edge.dest;
	    int weight=edge.weight;
	    System.out.println("source->"+u+";"+"destination->"+v+";"+"weight->"+weight);
	   }
 }

 //------------------------------------------------------------
 
 public void helper() {
  
  mEdgeList.add(new Edge(0, 1, -1));
  mEdgeList.add(new Edge(0, 2, 4));
  mEdgeList.add(new Edge(0, 4, 2));
  
  mEdgeList.add(new Edge(1, 2, 3));
  mEdgeList.add(new Edge(1, 3, -2));
  
  mEdgeList.add(new Edge(3, 1, 1));
  mEdgeList.add(new Edge(3, 2, 5));
  
  mEdgeList.add(new Edge(4, 3, -3));
  
  int sourceVertex = 0;
  bellmanFord(sourceVertex);
 					}
 
 public void helper1() {
	  
	  mEdgeList.add(new Edge(0, 1, -1));
	  mEdgeList.add(new Edge(0, 2, 4));
	  mEdgeList.add(new Edge(0, 4, 2));
	  
	  mEdgeList.add(new Edge(1, 2, 3));
	  mEdgeList.add(new Edge(1, 3, 2));
	  
	  mEdgeList.add(new Edge(3, 1, 1));
	  mEdgeList.add(new Edge(3, 2, 5));
	  
	  mEdgeList.add(new Edge(4, 3, -3));
	  
	  int sourceVertex = 0;
	  bellmanFord(sourceVertex);
	 					}
	 }
 
 
 