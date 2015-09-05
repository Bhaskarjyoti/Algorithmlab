package Algorithm;


public class LabKMP {
	public static String pattern; //String Matching 
	public static String text; //String Matching
	
		    public static void main(String[] args) 
		    {
		    	long startTime, stopTime,elapsedTime; //General complexity measurement
		    	pattern="ab";
				text="abcabdabcabeeabcabdabcabdaeabcabdabbeabcabcerfd";
				System.out.println("**************************************************************");
				System.out.println("Text to be seacrched:    "+text);
				System.out.println("Pattern to be seacrched: "+pattern);
				System.out.println("**************************************************************");

				System.out.println("Assignment 03 : Compare Naive based and Knuth Morris Pratt string matching algorithm: \n");
				System.out.println("");
				System.out.println("**********Naive Based String Matching Algorithm************* \n");
				startTime = System.nanoTime();
		        NaiveString nsm= new NaiveString(text,pattern);
		        int first_occur_position = nsm.naiveMatch();
		        
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
		        
		        
		        System.out.println();
		        // search for pattern in the string
		        stm.searchSubString(txt, ptrn);
		        
		        stopTime = System.nanoTime();
		        elapsedTime = stopTime - startTime;
		        System.out.println("Total time taken for KMP in nanosecond:" +elapsedTime);
		
		    }
	}


