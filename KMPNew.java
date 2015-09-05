package Algorithm;

//3.0 Design,develop and write a program to solve String Matching Problem 
//using naive approach and the KMP algorithm. Compare their performance 


public class KMPNew {
	
	//public static String pattern; //String Matching 
	//public static String text; //String Matching
	 

public int[] preProcessPattern(char[] ptrn) {
   int i = 0, j = -1;
   int ptrnLen = ptrn.length;
   int[] b = new int[ptrnLen + 1];

   b[i] = j;
   while (i < ptrnLen) {
       while (j >= 0 && ptrn[i] != ptrn[j]) {
           // if there is mismatch consider next widest border
           j = b[j];
       }
       i++;
       j++;
       b[i] = j;
   }
     return b;
}


public void searchSubString(char[] text, char[] ptrn) {
   int i = 0, j = 0; int flag=0;
   // pattern and text lengths
   int ptrnLen = ptrn.length;
   int txtLen = text.length;

   // initialize new array and preprocess the pattern
   int[] b = preProcessPattern(ptrn);

   while (i < txtLen) {
       while (j >= 0 && text[i] != ptrn[j]) {
               j = b[j];
       }
       i++;
       j++;

       // a match is found
       if (j == ptrnLen) {
           System.out.println("FOUND SUBSTRING AT i " + i + " and index:"
                   + (i - ptrnLen));
                     j = b[j];
                     flag=1;
       					}
                  
   				}//while 
   if (flag==0)
		    System.out.println("match not found");

		}//method
}