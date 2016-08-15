package flip_distance_convex;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		Trangulation t1 = new Trangulation();
		Trangulation t2 = new Trangulation();
		Trangulation tem1 = null;
		Trangulation tem2 = null; 
		int max;
		Scanner si = new Scanner(System.in);
		int en,vn,pk;
		
		
		System.out.println("请输入顶点数,边数和参数（v e k）:");
		vn = si.nextInt();
		en = si.nextInt();
		pk = si.nextInt();
		//si.close();
		t1.init(vn,en,pk);
		t1.print();
		t2.init(vn,en,pk);
		t1.cmp(t2);
		t2.print();
		Vector<Trangulation> v1 = new Vector<Trangulation>();
		Vector<Trangulation> v2 = new Vector<Trangulation>();
		v1.add(t1);
		while(true)
		{
			max = 1000;
			while(!v1.isEmpty())
			{
				tem1 = (Trangulation)v1.firstElement();
				tem1.print();
				v1.remove(0);
				if(tem1.step_remained == 0) break;
				for(int i = 1;i <= tem1.vertex_number;i++)
				{
					for(int j = 1;j <= tem1.vertex_number;j++)
					{
						if(tem1.edge[i][j] == 2 && i < j)
						{
							tem2 = new Trangulation(tem1);
							if(tem2.diagonal(i, j))
							{
								tem2.cmp(t2);
								tem2.print();
								if(tem2.step_remained + tem2.step_used < max)
								{
									max = tem2.step_remained + tem2.step_used;
								}
								v2.add(tem2);
							}
						}
					}
				}
			}
			while(!v2.isEmpty())
			{
				tem1 = (Trangulation)v2.firstElement();
				//tem1.print();
				if(tem1.step_remained + tem1.step_used == max)
				{
					v1.add(tem1);
				}
				v2.remove(0);
			}
			tem1 = (Trangulation)v1.firstElement();
			if(tem1.step_used + tem1.step_remained > tem1.parameter
					|| tem1.step_remained == 0) break;
		}
		if(tem1.step_remained == 0)System.out.println("Yes instance!");
		else System.out.println("No instance!");
		si.close();
//		t1.print();
//		t1.diagonal(2, 5);
//		t1.print();
	}
}
