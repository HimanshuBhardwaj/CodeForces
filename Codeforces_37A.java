
/**
 * Hello world!
 *
 */

import java.util.*;

public class Codeforces_37A
{
	public static void main(String S[])
	{
		Scanner inp = new Scanner(System.in);
		
		int n=inp.nextInt();
		
		//int num,count;
		int arr[] = new int[1001];
		
		int count=0;
		int num=0;
		int max=0;
		for(int i=0;i<n;i++)
		{
			num = inp.nextInt();
			if(arr[num]==0)
			{
				count++;
			}
			arr[num]++;
			
			
			if(arr[num]>max)
			{
				max=arr[num];
			}
		}
		
		System.out.println(max+" "+count);
		
		
		
	}
}


