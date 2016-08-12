package flip_distance_heuristic;

import java.util.Scanner;
import java.util.Vector;

public class Trangulation {
	FirstNode [] fninit,fnfinal;
	static int vn;
	int step_used,step_remained;
	private static Scanner si;
	
	
	Trangulation(){
		fninit = new FirstNode[vn + 1];
		fnfinal = new FirstNode[vn + 1];
		for(int i = 1;i < vn + 1;i++){
			fninit[i] = new FirstNode();
			fnfinal[i] = new FirstNode();
		}
		step_remained = 0;
		step_used = 0;
	}
	
	Trangulation cpy(){
		Trangulation t = new Trangulation();
		t.step_remained = step_remained;
		t.step_used = step_used;
		for(int i = 1;i <= vn;i++){
			t.fninit[i].x = fninit[i].x;
			t.fninit[i].y = fninit[i].y;
			t.fnfinal[i].x = fnfinal[i].x;
			t.fnfinal[i].y = fnfinal[i].y;
			for(int j = 1;j <= vn;j++){
				t.fninit[i].sn[j] = fninit[i].sn[j];
				t.fnfinal[i].sn[j] = fnfinal[i].sn[j];
			}
		}
		return t;
	}
	
	
	boolean diagonal(int index1,int index2){
		int []r = new int [4];
		if((r = isConvex(index1, index2)) != null){
			fninit[r[0]].sn[r[2]] = 0;
			fninit[r[2]].sn[r[0]] = 0;
			fninit[r[1]].sn[r[3]] = 2;
			fninit[r[3]].sn[r[1]] = 2;
			step_used ++;
			return true;
		}
		return false;
	}
	void cmp(){
		int sum = 0;
		for(int i = 1;i <= vn;i++){
			for(int j = 1;j <= vn;j++)
			{
				if(fninit[i].sn[j] !=2 && fnfinal[i].sn[j] == 2)
					sum++;
			}
		}
		step_remained = sum / 2;
		return ;
	}
	
	int [] isConvex(int posi1,int posi2){
		int [] result = new int[4];
		float a = (float)((fninit[posi2].y - fninit[posi1].y) * 1.0 / (fninit[posi2].x - fninit[posi1].x));
		float b = fninit[posi2].y - a * fninit[posi2].x;
		int k1 = 0,k2 = 0;
		float max = -100000000,min = 100000000;
		for(int i = 1;i <= vn;i++){
			if(fninit[posi1].sn[i] != 0 && fninit[posi2].sn[i] != 0){
				float distance = fninit[i].y - a * fninit[i].x - b;
				if(distance > 0 && distance < min){
					k1 = i;
				}
				else if(distance < 0 && distance > max){
					k2 = i;
				}
			}
		}
		if(k1 != 0 && k2 != 0){
			result[0] = posi1;
			result[1] = k1;
			result[2] = posi2;
			result[3] = k2;
			a = (float)((fninit[result[1]].y - fninit[result[3]].y) * 1.0 / (fninit[result[1]].x - fninit[result[3]].x));
			b = fninit[result[1]].y - a * fninit[result[1]].x;
			if(fninit[result[0]].y - a * fninit[result[0]].x - b > 0 && fninit[result[2]].y - a * fninit[result[2]].x - b < 0 ||
					fninit[result[2]].y - a * fninit[result[2]].x - b > 0 && fninit[result[0]].y - a * fninit[result[0]].x - b < 0	)return result;
			else return null;
		}
		else return null;
	}
	
	
	int index(int x,int y){
		for(int i = 1;i <= vn;i++)
			if(fninit[i].x == x && fninit[i].y == y) return i;
		return 0;
	}
	
	void print(){
		System.out.println(step_used + " " + step_remained);
		for(int i = 1; i <= vn;i++){
			for(int j = 1;j <= vn;j++){
				System.out.print(fninit[i].sn[j] + "	");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i = 1; i <= vn;i++){
			for(int j = 1;j <= vn;j++){
				System.out.print(fnfinal[i].sn[j] + "	");
			}
			System.out.println();
		}
		return ;
	}
	public static void main(String[] args) {
		System.out.println("请输入顶点数：");
		si = new Scanner(System.in);
		int vertexnumber;
		vertexnumber = si.nextInt();
		FirstNode.vn = vertexnumber;
		Trangulation.vn = vertexnumber;
		Trangulation m = new Trangulation();
//		System.out.println(m.toString());
//		System.out.println(m.fninit);
//		System.out.println(m.fninit[0]);		
		
		System.out.println("请输入顶点值：");
		for(int i = 1; i <= vertexnumber;i++){
			m.fninit[i].x = si.nextInt();
			m.fninit[i].y = si.nextInt();
		}
		System.out.println("请输入固定边数：");
		int x1,x2;
		int en1 = si.nextInt();
		System.out.println("请输入固定边值：");
//		for(int i = 0;i < en1;i++){
//			x1 = si.nextInt();
//			y1 = si.nextInt();
//			x2 = si.nextInt();
//			y2 = si.nextInt();
//			int posi1 = m.index(x1, y1);
//			int posi2 = m.index(x2, y2);
//			m.fninit[posi1].sn[posi2] = 1;
//			m.fninit[posi2].sn[posi1] = 1;
//			m.fnfinal[posi1].sn[posi2] = 1;
//			m.fnfinal[posi2].sn[posi1] = 1;
//		}
		for(int i = 0;i < en1;i++){
			x1 = si.nextInt();
			x2 = si.nextInt();
			m.fninit[x1].sn[x2] = 1;
			m.fninit[x2].sn[x1] = 1;
			m.fnfinal[x1].sn[x2] = 1;
			m.fnfinal[x2].sn[x1] = 1;
		}
		System.out.println("请输入可变边数：");
		int en2 = si.nextInt();
		System.out.println("请输入原始可变边值：");
//		for(int i = 0;i < en2;i++){
//			x1 = si.nextInt();
//			y1 = si.nextInt();
//			x2 = si.nextInt();
//			y2 = si.nextInt();
//			int posi1 = m.index(x1, y1);
//			int posi2 = m.index(x2, y2);
//			m.fninit[posi1].sn[posi2] = 2;
//			m.fninit[posi2].sn[posi1] = 2;
//		}
		for(int i = 0;i < en2;i++){
			x1 = si.nextInt();
			x2 = si.nextInt();
			m.fninit[x1].sn[x2] = 2;
			m.fninit[x2].sn[x1] = 2;
		}
		System.out.println("请输入目标可变边值：");
//		for(int i = 0;i < en2;i++){
//			x1 = si.nextInt();
//			y1 = si.nextInt();
//			x2 = si.nextInt();
//			y2 = si.nextInt();
//			int posi1 = m.index(x1, y1);
//			int posi2 = m.index(x2, y2);
//			m.fnfinal[posi1].sn[posi2] = 2;
//			m.fnfinal[posi2].sn[posi1] = 2;
//		}
		for(int i = 0;i < en2;i++){
			x1 = si.nextInt();
			x2 = si.nextInt();
			m.fnfinal[x1].sn[x2] = 2;
			m.fnfinal[x2].sn[x1] = 2;
		}
		System.out.println("请输入参数值：");
		int parameter = si.nextInt();
		Vector<Trangulation> v1 = new Vector<Trangulation>();
		Vector<Trangulation> v2 = new Vector<Trangulation>();
		m.cmp();
		v1.add(m);
		int max;
		boolean state = true;
		Trangulation tem1,tem2;
		while(true)
		{
			max = 1000;
			while(!v1.isEmpty())
			{
				tem1 = (Trangulation)v1.firstElement();
				tem1.print();
				v1.remove(0);
				if(tem1.step_remained == 0) break;
				for(int i = 1;i <= Trangulation.vn;i++)
				{
					for(int j = 1;j <= Trangulation.vn;j++)
					{
						if(tem1.fninit[i].sn[j] == 2 && i < j)
						{
							tem2 = tem1.cpy();
							int []r = tem2.isConvex(i,j);
							if(r != null)
							{
								tem2.diagonal(i, j);
								tem2.cmp();
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
			if(!v1.isEmpty())tem1 = (Trangulation)v1.firstElement();
			else {
				state = false;
				tem1 = null;
			}
			if(state == false || tem1.step_used + tem1.step_remained > parameter
					|| tem1.step_remained == 0) break;
		}
		if(state && tem1.step_remained == 0)System.out.println("Yes instance!");
		else System.out.println("No instance!");
	}
}
