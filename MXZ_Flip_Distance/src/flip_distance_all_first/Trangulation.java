package flip_distance_all_first;

import java.util.Scanner;

public class Trangulation {
	FirstNode[] fninit,fnfinal;
	static int vn,pk;
	int current_edge_x,current_edge_y,last_edge_x,last_edge_y,last_last_edge_x,last_last_edge_y,step_remained;


	Trangulation(){
		fninit = new FirstNode[vn + 1];
		fnfinal = new FirstNode[vn + 1];
		for(int i = 1;i < vn + 1;i++){
			fninit[i] = new FirstNode();
			fnfinal[i] = new FirstNode();
		}
		current_edge_x = 0;
		current_edge_y = 0;
		last_edge_x = 0;
		last_edge_y = 0;
		last_last_edge_x = 0;
		last_last_edge_y = 0;
		step_remained = 0;
	}

	Trangulation cpy(){
		Trangulation t = new Trangulation();
		t.last_edge_x = current_edge_x;
		t.last_edge_y = current_edge_y;
		t.last_last_edge_x = last_edge_x;
		t.last_last_edge_y = last_edge_y;
		t.step_remained = step_remained;
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


	void diagonal(int [] r){
		fninit[r[0]].sn[r[2]] = 0;
		fninit[r[2]].sn[r[0]] = 0;
		fninit[r[1]].sn[r[3]] = 2;
		fninit[r[3]].sn[r[1]] = 2;
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
	}

	int [] isQuadrilateral(int posi1,int posi2){
		int [] result = new int[4];
		int k1 = 0,k2 = 0;
		if (fninit[posi2].x - fninit[posi1].x != 0){
			float a = (float)((fninit[posi2].y - fninit[posi1].y) * 1.0 / (fninit[posi2].x - fninit[posi1].x));
			float b = fninit[posi2].y - a * fninit[posi2].x;
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
		}
		else{
			float max = -100000000,min = 100000000;
			for(int i = 1;i <= vn;i++){
				if(fninit[posi1].sn[i] != 0 && fninit[posi2].sn[i] != 0){
					float distance = fninit[i].x - fninit[posi1].x;
					if(distance > 0 && distance < min){
						k1 = i;
					}
					else if(distance < 0 && distance > max){
						k2 = i;
					}
				}
			}
		}
		if(k1 != 0 && k2 != 0){
			result[0] = posi1;
			result[1] = k1;
			result[2] = posi2;
			result[3] = k2;
			return result;
		}
		else return null;
	}

	boolean isConvex(int [] result){
		float p = 0,q = 0;
		if (fninit[result[1]].x - fninit[result[3]].x != 0){
			float a = (float)((fninit[result[1]].y - fninit[result[3]].y) * 1.0 / (fninit[result[1]].x - fninit[result[3]].x));
			float b = fninit[result[1]].y - a * fninit[result[1]].x;
			p = fninit[result[0]].y - a * fninit[result[0]].x - b;
			q = fninit[result[2]].y - a * fninit[result[2]].x - b;
		}
		else{
			p = fninit[result[0]].x - fninit[result[1]].x;
			q = fninit[result[2]].x - fninit[result[1]].x;
		}
		if(p * q < 0)
			return true;
		else
			return false;
	}


//	int index(int x,int y){
//		for(int i = 1;i <= vn;i++)
//			if(fninit[i].x == x && fninit[i].y == y) return i;
//		return 0;
//	}

	void print(){
		System.out.println(step_remained);
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
	}
	public static void main(String[] args) {
		System.out.println("请输入顶点数：");
		Scanner si = new Scanner(System.in);
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
//		int x1,x2,y1,y2;
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
		Trangulation.pk = parameter;
		m.cmp();
		Flip f = new Flip();
		if (m.step_remained <= parameter) {
			DigitDecomposition dd = new DigitDecomposition(parameter);
			dd.create();
			int[] tem;
			Edge[] v1;
			v1 = new Edge[m.step_remained];
			int k = 0;
			for (int i = 1; i <= Trangulation.vn; i++) {
				for (int j = 1; j <= Trangulation.vn; j++) {
					if (m.fnfinal[i].sn[j] == 0 && m.fninit[i].sn[j] == 2 && i < j) {
						v1[k] = new Edge(i,j);
						k++;
					}
				}
			}
			for (int i = 0; i < dd.count; i++) {
				tem = dd.result[i];
				if (tem[0] > v1.length) continue;
				for (Edge e : v1) {
					e.state = false;
				}
				if (f.output)for (int j = 0; j <= tem[0]; j++) {
					System.out.print(tem[j] + "	");
				}
				if (f.output)System.out.println();
				f.recursion(m, tem, 1, v1,0);
				if (f.state) break;
			}
		}
		if(f.state)System.out.println("Yes instance!");
		else System.out.println("No instance!");
		si.close();
	}
}

