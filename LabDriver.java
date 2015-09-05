package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class LabRunner 
{
	// This is the class which runs the different options with the input parameters  and instantiated from LabDriver
	//public int primality;  //Monte Carlo 
	public String pattern; //String Matching 
	public String text; //String Matching
	
	
	public int MAX_VALUE = 999;  //For Bellman Ford 
	int numberofvertices = 0;  //For Bellman Ford 
    int source, destination;   //For Bellman Ford 
    
    public int option;  
    long startTime, stopTime,elapsedTime; //General complexity measurement
    long elapsedTime1, elapsedTime2, elapsedTime3, elapsedTime4, elapsedTime5;

	public LabRunner(String p, String t , int menu)  //constructor when this is instantiated with user defined strings
		{
	 pattern=p;
	 text=t;
	 option=menu;
		}
	
		public void set_text_pattern(String p, String t)
			{
		pattern=p;
		 text=t;
			}
	
	public LabRunner(int menu)  //constructor when this is instantiated with default values for primality, pattern, text etc.
	{
		pattern="eabcabdab";
		text="abcabdabcabeeabcabdabcabdaeabcabdabbeabcabcerfd";
		System.out.println("**************************************************************");
		System.out.println("Text to be seacrched:    "+text);
		System.out.println("Pattern to be seacrched: "+pattern);
		System.out.println("**************************************************************");
		
		//primality=15739;
		option=menu;
	}

	
	public void runOption(int option) throws IOException
	 {
		switch(option) {
		case 1: 
		{
			      System.out.println("Assignment 01 : Bellman Ford Algorithm \n");
			      System.out.println("********Bellman Ford : single Source Shortest Path Algorithm************* \n");
			      System.out.println("...................................................................");
				  System.out.println("single source shortest path calculation for Grpah 1 ................");
				  System.out.println("...................................................................");
				  startTime = System.nanoTime();
				  BellmanFordNew graph=new BellmanFordNew(5, 8);
				  graph.helper();
				  stopTime = System.nanoTime();
			      elapsedTime = stopTime - startTime;
			      System.out.println("Total time taken for Bellman Ford calculation in nanosecond:" +elapsedTime);
				  System.out.println("...................................................................");
				  System.out.println("single source shortest path calculation for Grpah 2 ................");
				  System.out.println("...................................................................");
				  startTime = System.nanoTime();
				  BellmanFordNew graph1=new BellmanFordNew(5,8);
				  graph1.helper1();
				  stopTime = System.nanoTime();
			      elapsedTime = stopTime - startTime;
			      System.out.println("Total time taken for Bellman Ford calculation in nanosecond:" +elapsedTime);
				  
				 
			break;
		}
		case 2: 
		{
			   System.out.println("Assignment 02 : Monte Carlo primality test Algorithm \n");   
			   System.out.println("********Miller Rabin Primality Test Algorithm************* \n");
			   Scanner scan = new Scanner(System.in);
		       System.out.println("Miller Rabin Primality Algorithm Test\n");
		       /** Make an object of MillerRabin class **/
		       MillerRabin mr = new MillerRabin();
		       /** Accept number **/
		       System.out.println("Enter number\n");
		       long num = scan.nextLong();
		       /** Accept number of iterations **/
		       System.out.println("\nEnter number of iterations");
		       int k = scan.nextInt();
		       /** check if prime **/
		       boolean prime = mr.isPrime(num, k);
		       if (prime)
		           System.out.println("\n"+ num +"is prime");
		       else
		           System.out.println("\n"+ num +" is composite");
		    scan.close();
			break;
		}
		case 3: 
		{
			
			System.out.println("Assignment 03 : Compare Naive based and Knuth Morris Pratt string matching algorithm: \n");
			System.out.println("");
			System.out.println("**********Naive Based String Matching Algorithm************* \n");
			startTime = System.nanoTime();
	        NaiveString nsm= new NaiveString(text,pattern);
	        int first_occur_position = nsm.naiveMatch();
	        System.out.println("The text '" + pattern
	                + "' is last found after the " + first_occur_position
	                + " position.");
	       // System.out.println("Total comparison done="+nsm.comparison);
	        stopTime = System.nanoTime();
	        elapsedTime = stopTime - startTime;
	        System.out.println("Total time taken for Naive search in nanosecond:" +elapsedTime);
	 
			//******************KMP Now ******************************
	        System.out.println("");
	        System.out.println("");
	        
	        System.out.println("**********KMP String Matching Algorithm************* \n");
	        startTime = System.nanoTime();
	        
	        KMPNew stm = new KMPNew();
	      
	        char[]ptrn=pattern.toCharArray();
	        char[]txt= text.toCharArray();
	        
	        System.out.print(" ");
	        for (char c : txt) {
	            System.out.print(c + "   ");
	        }
	        System.out.println();
	        // search for pattern in the string
	        stm.searchSubString(txt, ptrn);
	        
	        stopTime = System.nanoTime();
	        elapsedTime = stopTime - startTime;
	        System.out.println("Total time taken for KMP in nanosecond:" +elapsedTime);
			break;
		}
		case 5: 
		{
			    System.out.println("Assignment 05 : Rabin Karp String Matching Algorithm \n");

		        System.out.println("**********Rabin Karp  Matching Algorithm************* \n");
			    startTime = System.nanoTime();
			    RabinKarp1 rk = new RabinKarp1(text, pattern);
		       stopTime = System.nanoTime();
		        elapsedTime = stopTime - startTime;
		        System.out.println("Total time taken for Rabin Karp in nanosecond:" +elapsedTime);

			break;
		}
		case 4: 
		{
			System.out.println("Assignment 04 : Finite Automata based String Matching Algorithm Test\n");
			System.out.println("**********FA based string Matching Algorithm************* \n");
			startTime = System.nanoTime();
			SearchStringUsingDFA dfa = new SearchStringUsingDFA();
	        dfa.searchDFA(pattern.toCharArray(), text.toCharArray());
	        stopTime = System.nanoTime();
	        elapsedTime = stopTime - startTime;
	        System.out.println("Total time taken for FA based string matching in nanosecond:" +elapsedTime);
	        break;
		}
		
		case 6: 
			System.out.println("********************Boyer Moore String Matching Algorithm*************\n");
			startTime = System.nanoTime();
			BoyerMoore bm = new BoyerMoore(); 
	        bm.findPattern(text, pattern); 
	        stopTime = System.nanoTime();
	        elapsedTime = stopTime - startTime;
	        System.out.println("Total time taken for Boyer Moore string matching in nanosecond:" +elapsedTime);
	        break;
			
		case 7 : 
			System.out.println("************Comparing String Matching Algorithms************\n");
			System.out.println("************************************************************\n");
			//naive based 
			System.out.println("**********Naive Based String Matching Algorithm************* \n");
			startTime = System.nanoTime();
	        NaiveString nsm= new NaiveString(text,pattern);
	        int first_occur_position = nsm.naiveMatch();
	        System.out.println("The text '" + pattern
	                + "' is last found after the " + first_occur_position
	                + " position.");
	       // System.out.println("Total comparison done="+nsm.comparison);
	        stopTime = System.nanoTime();
	        elapsedTime1 = stopTime - startTime;
	        
	        //KMP 
	        System.out.println("");
	        System.out.println("");
	        
	        System.out.println("**********KMP String Matching Algorithm************* \n");
	        startTime = System.nanoTime();
	        
	        KMPNew stm = new KMPNew();
	      
	        char[]ptrn=pattern.toCharArray();
	        char[]txt= text.toCharArray();
	        
	        System.out.print(" ");
	        for (char c : txt) {
	            System.out.print(c + "   ");
	        }
	        System.out.println();
	        
	        // search for pattern in the string
	        stm.searchSubString(txt, ptrn);
	        
	        stopTime = System.nanoTime();
	        elapsedTime2 = stopTime - startTime;
	        
	        //DFA 
	        System.out.println("**********FA Based String Matching Algorithm************* \n");
	        System.out.println("Assignment 04 : Finite Automata based String Matching Algorithm \n");
			startTime = System.nanoTime();
			SearchStringUsingDFA dfa = new SearchStringUsingDFA();
	        dfa.searchDFA(pattern.toCharArray(), text.toCharArray());
	        stopTime = System.nanoTime();
	        elapsedTime3 = stopTime - startTime;
	       
	        //Rabin Karp 
	        startTime = System.nanoTime();
	        System.out.println("**********Rabin Karp Based String Matching Algorithm************* \n");
	        System.out.println("Assignment 05 : Rabin Karp String Matching Algorithm \n");
	        RabinKarp1 rk = new RabinKarp1(text, pattern);
	        stopTime = System.nanoTime();
	        elapsedTime4 = stopTime - startTime;
	        
	        //Boyer Moore 
	        System.out.println("**********Boyer Moore String Matching Algorithm************* \n");
	        System.out.println("Boyer Moore String Matching Algorithm \n");
			startTime = System.nanoTime();
			BoyerMoore bm1 = new BoyerMoore(); 
	        bm1.findPattern(text, pattern); 
	        stopTime = System.nanoTime();
	        elapsedTime5 = stopTime - startTime;
	        
	        //print the time  
	        System.out.println("******************************************************************\n");
	        System.out.println("Total time taken for Naive based method in nanosecond:"+elapsedTime1);
	        System.out.println("Total time taken for KMP based method in nanosecond:"+elapsedTime2);
	        System.out.println("Total time taken for DFA based method in nanosecond:"+elapsedTime3);
	        System.out.println("Total time taken for Rabin Karp based method in nanosecond:"+elapsedTime4);
	        System.out.println("Total time taken for Boyer Moore based method in nanosecond:"+elapsedTime5);
	        System.out.println("******************************************************************\n");
			break;
		case 8: 
		{
			System.out.println("Thank you for using our Advanced Algorithm Lab Experiments Demo System......");
			System.out.println("Good bye......");
	        break;
		}
    } //switch
	          
        
               
        
	} //runOption 
} //labRunner class

//***************************************************************************

public class LabDriver {  // this is the class with the main

	public static void pauseProg(){
		System.out.println("Press enter to continue...");
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		}
	
	 // only for test purposes
    public static void main(String[] args) throws IOException {
    	
    	int option = 0; 
    	
    	System.out.println("***************************************************************************");
		System.out.println("*                                                                         *");
		System.out.println("*          Welcome to the Advanced Algorithm Lab Assignments              *");
		System.out.println("*                                                                         *");
		System.out.println("*                 CSE M Tech 2015 Sem II                                  *");
		System.out.println("*                                                                         *");
		System.out.println("*                   Bhaskarjyoti Das                                      *");
		System.out.println("***************************************************************************");
	
		pauseProg();
		
		
    	do 
    	{
    	System.out.println("****************************************************************************************");
    	System.out.println("");
    	System.out.println("OPTION 1 : Bellman Ford Single Source Shortest Path Algorithm given an Adjacency Matrix");
    	System.out.println("");
    	System.out.println("OPTION 2 : Monte Carlo Algorithm to test primality of an integer ");
    	System.out.println("");
    	System.out.println("OPTION 3 : String Matching problem with Naive based and KMP algorithm");
    	System.out.println("");
    	System.out.println("OPTION 4 : String Matching problem with Finite Automata");
    	System.out.println("");
    	System.out.println("OPTION 5 : Rabin Karp algorithm");
    	System.out.println("");
    	System.out.println("OPTION 6 : Boyer Moore String Matching algorithm(s)");
    	System.out.println("");
    	System.out.println("OPTION 7 : Compare String Matching algorithm(s)");
    	System.out.println("");
    	System.out.println("OPTION 8 : EXIT");
    	System.out.println("");
    	System.out.println("                     Enter an option 1-8");
    	System.out.println("****************************************************************************************");
    	BufferedReader stdin = new BufferedReader(new InputStreamReader (System.in));
    	try { 
    		option = Integer.parseInt (stdin.readLine());
    	}catch(NumberFormatException ex){
            System.err.println("Ilegal input (only option 1-8 allowed");
            
        }  

    	System.out.println("**************You have entered option*************:"+option);
    	
     		LabRunner lb= new LabRunner(option); // instantiate using the right constructor
     		
    	    lb.runOption(option);
    	    pauseProg(); 
    		
    	} 
    	while (option!=8);
    	 
    }
}
