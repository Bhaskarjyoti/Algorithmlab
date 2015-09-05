package Algorithm;

public class NaiveString {
	public String pattern;
	public String text;
	int n;
	int m;
	//public int comparison;
		
	public NaiveString(String text, String pattern) {
		// TODO Auto-generated constructor stub
		//constructor
		this.text=text;
		this.pattern= pattern;
		n=text.length();
		m=pattern.length();
		//comparison=0;
	}

	public void setNaiveString(String text1)
	{
		this.text =text1;
	}
	public int naiveMatch()
	   {
		int i,j;
		int position =0;
		for (i=0; i<=n-m; i++) 
			{
			
			  j = 0;
			  while (pattern.charAt(j) == text.charAt(i + j))
			  			{
			  //comparison++;
			  if (j==m-1)   //reached the end of the pattern
			  		{   position=i;
			  		System.out.println("Pattern match Position=" + position);
			    	break;  // here the value of i will be the position 
			  		}
			    	else j++;
			  			} //while loop
			 // comparison++;  
			} //for loop 
		
		return position;
	   }
	
	
}
