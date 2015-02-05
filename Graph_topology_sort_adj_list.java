
/**
 * Hello world!
 *
 */

import java.util.*;

public class Graph_topology_sort_adj_list 
{
	public static void main(String S[])
	{
		Scanner inp = new Scanner(System.in);
		
		int n = inp.nextInt();
		int m = inp.nextInt();
		
		Graph gp = new Graph(n);
		
		int from,to;
		
		for(int i=0;i<m;i++)
		{
			from  = inp.nextInt();
			to    = inp.nextInt();
			
			gp.adj_list[from].add(to);
			
			
		}
		
		gp.printAdjList();
		
		System.out.println();
		
		gp.TOPO();
	}
}


class Graph{
	
	public List<Integer> adj_list[];
	public int n;
	public int visited[];
	Graph(int no)
	{
		n = no;
		adj_list = (List<Integer> [])new List [n];
		visited = new int[n];
		
		for(int i=0;i<n;i++)
		{
			adj_list[i] = new LinkedList<Integer>();
		}
		
		
	}
	
	boolean isAdjecent(int from, int to)
	{
		if(from<0 || to<0 ||from >=n || to >= n)
			return false;
		
		List<Integer> in = adj_list[from];
		
		for(int i=0;i<in.size();i++)
		{
			if(in.get(i)==to)
				return true;
		}
		
	
		return false;
	}
	
public	void printAdjList()
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(i+": ");
			for(int j=0;j<(adj_list[i]).size();j++)
			{
				System.out.print((adj_list[i]).get(j)+" " );
			}
			System.out.println();
		}
	}
	
	
public	void DFS(int x)
	{
		if(x<0 || x>n || visited[x]==1)
			return;
		
		visited[x]=1;
		
		for(int i=0;i<adj_list[x].size();i++)
		{
			DFS(adj_list[x].get(i));
		}
		
		System.out.print(x +" ");
	}
	
	public void TOPO()
	{
		for(int i=0;i<n;i++)
		{
			if(this.visited[i]==0)
			{
				DFS(i);
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
	
	
	
}
