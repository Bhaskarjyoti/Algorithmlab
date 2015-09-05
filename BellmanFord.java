//Lab Assignment 01 : Design, develop and write a program to implement the Bellman Ford algorithm and determine its performance
//Give its applications

package Algorithm;
 
public class BellmanFord
{
    public int             distances[];
    public int             numberofvertices;
    public int MAX_VALUE = 999;

 //***********************************************************************
    public BellmanFord(int numberofvertices)    //constructor
    {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
    }
 //**********************************************************************
    public void BellmanFordEvaluation(int source, int destination,
            int adjacencymatrix[][])
    {
    	        for (int node = 1; node <= numberofvertices; node++)
    	        {
            distances[node] = MAX_VALUE; //initialize to infinity 
    	        }
    	    distances[source] = 0;  //initialize 
    	    
    	//calculate single source shortest path 
    	    
        for (int node = 1; node <= numberofvertices - 1; node++) // relax it |V|-1 time 
        {
            for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
            {
                for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
                {
                    if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                    {
                        if (distances[destinationnode] > distances[sourcenode]
                                + adjacencymatrix[sourcenode][destinationnode])
                            distances[destinationnode] = distances[sourcenode]
                                    + adjacencymatrix[sourcenode][destinationnode];
                    }
                }
            }
        }
       
        // now we check for negative cycle 
        
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
            {
                if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                {
                    if (distances[destinationnode] > distances[sourcenode]
                            + adjacencymatrix[sourcenode][destinationnode])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
        
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
           // if (vertex == destination)
                System.out.println("distance of source  " + source + " to "
                        + vertex + " is " + distances[vertex]);
        }
    }
 //**********************************************************************************************
    
}