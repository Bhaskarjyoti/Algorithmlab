package Algorithm;

/**
//5.0 Design,develop and write a program to solve String Matching Problem 
//using Rabin Karp Algorithm and determine its performance 

**/


import java.util.Random;
import java.math.BigInteger;


class RabinKarp1 
{
 /** String Pattern **/
 private String pat; 
 /** pattern hash value **/    
 private long patHash;    
 /** pattern length **/
 private int M;  
 /** Large prime **/         
 private long Q; 
 /** radix **/         
 private int R;   
 /** R^(M-1) % Q **/        
 private long RM;          

 /** Constructor **/
 public RabinKarp1(String txt, String pat) 
 {
     this.pat = pat;      
     R = 256;
     M = pat.length();
     Q = longRandomPrime();
     /** precompute R^(M-1) % Q for use in removing leading digit **/
     RM = 1;
     for (int i = 1; i <= M-1; i++)
        RM = (R * RM) % Q;
     patHash = hash(pat, M);
     search(txt);
   /*  if (pos == -1)
         System.out.println("\nNo Match\n");
     else
         System.out.println("Pattern found at position : "+ pos);
    */
     } 
 /** Compute hash **/
 private long hash(String key, int M)
 { 
     long h = 0; 
     for (int j = 0; j < M; j++) 
         h = (R * h + key.charAt(j)) % Q; 
     return h; 
 } 
 /** Funtion check **/
 private boolean check(String txt, int i) 
 {
     for (int j = 0; j < M; j++) 
         if (pat.charAt(j) != txt.charAt(i + j)) 
             return false; 
     return true;
 }
 /** Funtion to check for exact match**/
 private void search(String txt) 
 {
	 int foundflag=0;
     int N = txt.length(); 
     if (N < M)
    	  System.out.println("Pattern bigger");
     long txtHash = hash(txt, M); 
     /** check for match at start **/
     if ((patHash == txtHash) && check(txt, 0))
     {  foundflag=1;   
    	 System.out.println("\n Match found at position: 0");
    	// return 0;
     }
    	 /** check for hash match. if hash match then check for exact match**/
     for (int i = M; i < N; i++) 
     {
         // Remove leading digit, add trailing digit, check for match. 
         txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q; 
         txtHash = (txtHash * R + txt.charAt(i)) % Q; 
         // match
         int offset = i - M + 1;
         if ((patHash == txtHash) && check(txt, offset))
         {
            // return offset;
        	 System.out.println("\n Match found at position: " + offset); 
        	 foundflag=1;
         }
      }
     /** no match **/
     if (foundflag==0)
    		  System.out.println("No match found"); 
    		  				  
 }
 /** generate a random 31 bit prime **/
 private  long longRandomPrime() 
 {
     BigInteger prime = BigInteger.probablePrime(31, new Random());
     return prime.longValue();
 }
 /** Main Function **/
 

}