package flip_distance_convex;

import java.util.Scanner;

public class Trangulation {
	
	int vertex_number,edge_number,parameter;
	short [][] edge = new short[100][100];
	Scanner si = new Scanner(System.in);
	int step_used = 0;
	int step_remained = 0;
	
	
	public Trangulation()
	{
		
	}
	
	
	public Trangulation(Trangulation t)
	{
		vertex_number = t.vertex_number;
		edge_number = t.edge_number;
		parameter = t.parameter;
		step_used = t.step_used;
		step_remained = t.step_remained;
		for(int i = 1;i <= vertex_number;i++)
		{
			for(int j = 1;j <= vertex_number;j++)
			{
				edge[i][j] = t.edge[i][j];
			}
		}
	}
	
	
	
	void init(int vn,int en,int pk)
	{
		vertex_number = vn;
		edge_number = en;
		parameter = pk;
		for(int i = 1;i <= vertex_number;i++)
		{
			for(int j = 1;j <= vertex_number;j++)
			{
				edge[i][j] = 0;
			}
		}
		System.out.println("ÇëÊäÈë±ß£º");
		for(int i = 0;i < edge_number;i++)
		{
			int a = si.nextInt();
			int b = si.nextInt();
			edge[a][b] = 1;
			edge[b][a] = 1;
		}
		for(int i = 1;i <= vertex_number;i++)
		{
			for(int j = 1;j <= vertex_number;j++)
			{
				if(edge[i][j] != 0)
				{
					edge[i][j] = 0;
					for(int k = 1;k <= vertex_number;k++)
					{
						if(edge[i][k] != 0 && edge[j][k] != 0)
						{
							edge[i][j]++;
						}
					}
					edge[j][i] = edge[i][j];
				}
			}
		} 
		//si.close();
	}
	
	
	void print()
	{
		System.out.println(step_used + "	" + step_remained);
		for(int i = 1;i <= vertex_number;i++)
		{
			for(int j = 1;j <= vertex_number;j++)
			{
				System.out.print(edge[i][j] + "	");
			}
			System.out.println();
		}
	}
	
	
	boolean diagonal(int s,int t)
	{
		int []a = new int [2];
		int i = 0;
		for(int k = 1;k <= vertex_number;k++)
		{
			if(edge[s][k] != 0 && edge[t][k] != 0)
			{
				a[i++] = k;
			}
		}
		if(edge[a[0]][a[1]] == 0)
		{
			edge[s][t] = edge[t][s] = 0;
			edge[a[0]][a[1]] = edge[a[1]][a[0]] = 2;
			step_used++;
			return true;
		}
		return false;
	}
	
	
	void cmp(Trangulation t)
	{
		int count = 0;
		for(int i = 1;i <= vertex_number;i++)
		{
			for(int j = 1;j <= vertex_number;j++)
			{
				if(edge[i][j] == 2 && t.edge[i][j] != 2)
				{
					count++;
				}
			}
		}
		step_remained = count / 2;
	}
}

