package flip_distance_all_first;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Trangulation extends JPanel{
	FirstNode [] fninit,fnfinal;
	private short [][] change;
	private static int limitvn,limitpk,limitnode,vn,pk,inputstyle;
	int current_edge_x,current_edge_y,last_edge_x,last_edge_y,last_last_edge_x,last_last_edge_y,step_remained;
	private int maxX,maxY;

	public void paint(Graphics g){
		print();
		for (int i = 1; i <= vn ; i++) {
			for (int j = 1; j <= vn ; j++) {
				if(fninit[i].sn[j] == 1) {
					if (fnfinal[i].sn[j] == 0 || change[i][j] == 1) {
						g.setColor(Color.red);
						g.drawLine((int) (fninit[i].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[i].y * getHeight() * 5.0 / 6 / maxY / 2 + 20), (int) (fninit[j].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[j].y * getHeight() * 5.0 / 6 / maxY / 2 + 20));
					}
					else {
						g.setColor(Color.green);
						g.drawLine((int) (fninit[i].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[i].y * getHeight() * 5.0 / 6 / maxY / 2 + 20), (int) (fninit[j].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[j].y * getHeight() * 5.0 / 6 / maxY / 2 + 20));
					}
				}
				if(fnfinal[i].sn[j] == 1) {
					if (change[i][j] == 1) {
						g.setColor(Color.blue);
						g.drawLine((int) (fninit[i].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[i].y * getHeight() * 5.0 / 6 / maxY / 2 + 20 + getHeight() / 2), (int) (fninit[j].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[j].y * getHeight() * 5.0 / 6 / maxY / 2 + 20 + getHeight() / 2));
					}
					else {
						g.setColor(Color.green);
						g.drawLine((int) (fninit[i].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[i].y * getHeight() * 5.0 / 6 / maxY / 2 + 20 + getHeight() / 2), (int) (fninit[j].x * getWidth() * 5.0 / 6 / maxX + 20), (int) (fninit[j].y * getHeight() * 5.0 / 6 / maxY / 2 + 20 + getHeight() / 2));
					}
				}
			}
		}
	}

	Trangulation(){
		maxX = 0;
		maxY = 0;
		fninit = new FirstNode[vn + 4];
		fnfinal = new FirstNode[vn + 4];
		change = new short[vn + 4][vn + 4];

		for(int i = 1;i < vn + 4;i++){
			fninit[i] = new FirstNode();
			fninit[i].x = 0;
			fninit[i].y = 0;
			fnfinal[i] = new FirstNode();
		}

		fninit[vn + 1].x = 0;
		fninit[vn + 1].y = 300;
		fninit[vn + 2].x = 300;
		fninit[vn + 2].y = 0;
		fninit[vn + 3].x = -300;
		fninit[vn + 3].y = -300;
		fninit[vn + 1].sn[vn + 2] = 1;
		fninit[vn + 1].sn[vn + 3] = 1;
		fninit[vn + 2].sn[vn + 1] = 1;
		fninit[vn + 2].sn[vn + 3] = 1;
		fninit[vn + 3].sn[vn + 1] = 1;
		fninit[vn + 3].sn[vn + 2] = 1;
		current_edge_x = 0;
		current_edge_y = 0;
		last_edge_x = 0;
		last_edge_y = 0;
		last_last_edge_x = 0;
		last_last_edge_y = 0;
		step_remained = 0;
	}

	private void createFirstTrangulation(){
		int x,y;

		for(int i = 1;i < vn + 1;){
			x = (int) (Math.random() * 10000)%limitnode + 1;
			y = (int) (Math.random() * 10000)%limitnode + 1;
			if(index(x,y) == 0){
				fninit[i].x = x;
				fninit[i].y = y;
				if (maxX < x)maxX = x;
				if (maxY < y)maxY = y;
				i++;
			}
		}
		System.out.println("开始循环");
		Triangle T = new Triangle(vn + 1,vn + 2,vn + 3),temT,temT2;
		for (int i = 1; i < vn + 1; i++) {
			temT = T;
			while (temT != null){
				if (temT.t1 != null && isVertexInTriangle(temT.t1,i)){
					temT = temT.t1;
				}
				else if (temT.t2 != null && isVertexInTriangle(temT.t2,i)){
					temT = temT.t2;
				}
				else if (temT.t3 != null && isVertexInTriangle(temT.t3,i)){
					temT = temT.t3;
				}
				else {
					System.out.println("第一个while");
					break;
				}
			}
			System.out.println("第一个循环结束");
			if (isVertexInEdge(temT.a,temT.b,i) || isVertexInEdge(temT.c,temT.b,i) || isVertexInEdge(temT.a,temT.c,i)){
				temT2 = T;
				while (temT2 != null){
					if (temT2.t1 != null && isVertexInTriangle(temT2.t1,i) && temT2 != temT){
						temT2 = temT2.t1;
					}
					else if (temT2.t2 != null && isVertexInTriangle(temT2.t2,i) && temT2 != temT){
						temT2 = temT2.t2;
					}
					else if (temT2.t3 != null && isVertexInTriangle(temT2.t3,i) && temT2 != temT){
						temT2 = temT2.t3;
					}
					else {
						System.out.println("第二个循环");
						break;
					}
				}
				System.out.println("第二个循环结束");
				if (isVertexInEdge(temT.a,temT.b,i)){
					temT.t1 = new Triangle(temT.a,temT.c,i);
					temT.t2 = new Triangle(temT.b,temT.c,i);
					fninit[temT.c].sn[i] = fninit[i].sn[temT.c] = 1;
					if (temT2.a != temT.a && temT2.a != temT.b){
						temT2.t1 = new Triangle(temT.a,temT2.a,i);
						temT2.t2 = new Triangle(temT.b,temT2.a,i);
						fninit[temT2.a].sn[i] = fninit[i].sn[temT2.a] = 1;
					}
					else if (temT2.b != temT.a && temT2.b != temT.b){
						temT2.t1 = new Triangle(temT.a,temT2.b,i);
						temT2.t2 = new Triangle(temT.b,temT2.b,i);
						fninit[temT2.b].sn[i] = fninit[i].sn[temT2.b] = 1;
					}
					else if (temT2.c != temT.a && temT2.c != temT.b){
						temT2.t1 = new Triangle(temT.a,temT2.c,i);
						temT2.t2 = new Triangle(temT.b,temT2.c,i);
						fninit[temT2.c].sn[i] = fninit[i].sn[temT2.c] = 1;
					}
				}
				else if (isVertexInEdge(temT.a,temT.c,i)){
					temT.t1 = new Triangle(temT.a,temT.b,i);
					temT.t2 = new Triangle(temT.c,temT.b,i);
					fninit[temT.b].sn[i] = fninit[i].sn[temT.b] = 1;
					if (temT2.a != temT.a && temT2.a != temT.c){
						temT2.t1 = new Triangle(temT.a,temT2.a,i);
						temT2.t2 = new Triangle(temT.c,temT2.a,i);
						fninit[temT2.a].sn[i] = fninit[i].sn[temT2.a] = 1;
					}
					else if (temT2.b != temT.a && temT2.b != temT.c){
						temT2.t1 = new Triangle(temT.a,temT2.b,i);
						temT2.t2 = new Triangle(temT.c,temT2.b,i);
						fninit[temT2.b].sn[i] = fninit[i].sn[temT2.b] = 1;
					}
					else if (temT2.c != temT.a && temT2.c != temT.c){
						temT2.t1 = new Triangle(temT.a,temT2.c,i);
						temT2.t2 = new Triangle(temT.c,temT2.c,i);
						fninit[temT2.c].sn[i] = fninit[i].sn[temT2.c] = 1;
					}
				}
				else if (isVertexInEdge(temT.c,temT.b,i)){
					temT.t1 = new Triangle(temT.c,temT.a,i);
					temT.t2 = new Triangle(temT.b,temT.a,i);
					fninit[temT.a].sn[i] = fninit[i].sn[temT.a] = 1;
					if (temT2.a != temT.c && temT2.a != temT.b){
						temT2.t1 = new Triangle(temT.c,temT2.a,i);
						temT2.t2 = new Triangle(temT.b,temT2.a,i);
						fninit[temT2.a].sn[i] = fninit[i].sn[temT2.a] = 1;
					}
					else if (temT2.b != temT.c && temT2.b != temT.b){
						temT2.t1 = new Triangle(temT.c,temT2.b,i);
						temT2.t2 = new Triangle(temT.b,temT2.b,i);
						fninit[temT2.b].sn[i] = fninit[i].sn[temT2.b] = 1;
					}
					else if (temT2.c != temT.c && temT2.c != temT.b){
						temT2.t1 = new Triangle(temT.c,temT2.c,i);
						temT2.t2 = new Triangle(temT.b,temT2.c,i);
						fninit[temT2.c].sn[i] = fninit[i].sn[temT2.c] = 1;
					}
				}
			}
			else{
				temT.t1 = new Triangle(temT.c,temT.a,i);
				temT.t2 = new Triangle(temT.b,temT.a,i);
				temT.t3 = new Triangle(temT.c,temT.b,i);
				fninit[temT.a].sn[i] = fninit[i].sn[temT.a] = 1;
				fninit[temT.b].sn[i] = fninit[i].sn[temT.b] = 1;
				fninit[temT.c].sn[i] = fninit[i].sn[temT.c] = 1;
			}
		}
		System.out.println("创建完成");
		print();
	}

	private void modifyTrangulation(){
		int sum,index;
		System.out.println("进入修改");
		for (int i = 1; i <= vn; i++) {
			sum = 0;
			index = 1;
			for (int j = 1; j <= vn; j++) {
				if (fninit[i].sn[j] == 1){
					sum++;
					index = j;
				}
			}
			if (sum == 1){
				fninit[i].sn[index] = fninit[index].sn[i] = 0;
				i = 0;
			}
		}
		System.out.println("修改结束");
		print();
	}

	private boolean isLegal(){
		int sum = 0;
		for (int i = 1; i <= vn; i++) {
			for (int j = 1; j <= vn; j++) {
				if (fninit[i].sn[j] == 1)sum++;
			}
		}
		return sum >= 6;
	}

	private void createSecondTrangulation(){
		System.out.println("进入第二个");
		for (int i = 1; i <= vn; i++) {
			for (int j = 1; j <= vn; j++) {
				fnfinal[i].sn[j] = fninit[i].sn[j];
			}
		}
		int k = pk,x,y;
		int count = 0;
		System.out.println(pk);
		while (k > 0){
			if (count >= 100) break;
			x = (int )(Math.random() * vn) + 1;
			y = (int )(Math.random() * vn) + 1;
			if (x == y)y++;
			if (fninit[x].sn[y] == 0 || y > vn){
				count++;
				continue;
			}
			int [] result = isQuadrilateral(x,y);
			if (result == null || !isConvex(result)){
				count++;
				continue;
			}
			diagonal(result);
			change[result[0]][result[2]] = change[result[2]][result[0]] = 1;
			k--;
			count = 0;
			System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
			print();
		}
		System.out.println("结束第二个");
		print();
	}

	private boolean isVertexInEdge(int x, int y, int z){
		int a = (fninit[x].x - fninit[z].x) * (fninit[y].y - fninit[z].y);
		int b = (fninit[x].y - fninit[z].y) * (fninit[y].x - fninit[z].x);
		return a == b;
	}

	private double area(int x, int y, int z){
		double sum,len1,len2,len3,mean;
		len1 =Math.sqrt( (fninit[x].x - fninit[y].x) * (fninit[x].x - fninit[y].x) + (fninit[x].y - fninit[y].y) * (fninit[x].y - fninit[y].y));
		len2 =Math.sqrt( (fninit[x].x - fninit[z].x) * (fninit[x].x - fninit[z].x) + (fninit[x].y - fninit[z].y) * (fninit[x].y - fninit[z].y));
		len3 =Math.sqrt( (fninit[z].x - fninit[y].x) * (fninit[z].x - fninit[y].x) + (fninit[z].y - fninit[y].y) * (fninit[z].y - fninit[y].y));
		mean = (len1 + len2 + len3) / 2;
		sum = Math.sqrt(mean * (mean - len1) * (mean - len2) * (mean - len3));
		return sum;
	}

	private boolean isVertexInTriangle(Triangle t, int vertex){
		double areas,area1,area2,area3;
		areas = area(t.a,t.b,t.c);
		area1 = area(t.a,t.b,vertex);
		area2 = area(t.a,vertex,t.c);
		area3 = area(vertex,t.b,t.c);
		return Math.abs(areas - area1 - area2 - area3) < 0.01;
	}

	Trangulation cpy(){
		Trangulation t = new Trangulation();
		t.maxX = maxX;
		t.maxY = maxY;
		t.last_edge_x = current_edge_x;
		t.last_edge_y = current_edge_y;
		t.last_last_edge_x = last_edge_x;
		t.last_last_edge_y = last_edge_y;
		t.step_remained = step_remained;
		for(int i = 1;i <= vn;i++){
			t.fninit[i].x = fninit[i].x;
			t.fninit[i].y = fninit[i].y;
			for(int j = 1;j <= vn;j++){
				t.change[i][j] = change[i][j];
				t.fninit[i].sn[j] = fninit[i].sn[j];
				t.fnfinal[i].sn[j] = fnfinal[i].sn[j];
			}
		}
		return t;
	}


	void diagonal(int [] r){
		fninit[r[0]].sn[r[2]] = 0;
		fninit[r[2]].sn[r[0]] = 0;
		fninit[r[1]].sn[r[3]] = 1;
		fninit[r[3]].sn[r[1]] = 1;
	}
	void cmp(){
		int sum = 0;
		for(int i = 1;i <= vn;i++){
			for(int j = 1;j <= i;j++)
			{
				if(fninit[i].sn[j] == 0 && fnfinal[i].sn[j] == 1)
					sum++;
			}
		}
		step_remained = sum;
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
		float p,q;
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
		return p * q < 0;
	}


	private int index(int x, int y){
		for(int i = 1;i <= vn;i++)
			if(fninit[i].x == x && fninit[i].y == y) return i;
		return 0;
	}

	private void print(){
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
		System.out.println();
		System.out.println();
		for(int i = 1; i <= vn;i++){
			for(int j = 1;j <= vn;j++){
				System.out.print(change[i][j] + "	");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	public static void main(String[] args) {
		long starttime,endtime;
		JFrame jf = new JFrame("Tranglulation");
		jf.setSize(800,800);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Trangulation.limitvn = 20;
		Trangulation.limitpk = 10;
		Trangulation.limitnode = 100;
		Trangulation m;
		Flip f;

		Trangulation.inputstyle = 0;
		if (Trangulation.inputstyle == 1) {
			System.out.println("请输入顶点数：");
			Scanner si = new Scanner(System.in);
			Trangulation.vn = si.nextInt();
			FirstNode.vn = Trangulation.vn;
			m = new Trangulation();

			System.out.println("请输入顶点值：");
			for (int i = 1; i <= Trangulation.vn; i++) {
				m.fninit[i].x = si.nextInt();
				m.fninit[i].y = si.nextInt();
				if (m.maxX < m.fninit[i].x)m.maxX = m.fninit[i].x;
				if (m.maxY < m.fninit[i].y)m.maxY = m.fninit[i].y;
			}
			System.out.println("请输入固定边数：");
			int x1, x2;
			int en1 = si.nextInt();
			System.out.println("请输入固定边值：");
			for (int i = 0; i < en1; i++) {
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
			for (int i = 0; i < en2; i++) {
				x1 = si.nextInt();
				x2 = si.nextInt();
				m.fninit[x1].sn[x2] = 1;
				m.fninit[x2].sn[x1] = 1;
			}
			System.out.println("请输入目标可变边值：");
			for (int i = 0; i < en2; i++) {
				x1 = si.nextInt();
				x2 = si.nextInt();
				m.fnfinal[x1].sn[x2] = 1;
				m.fnfinal[x2].sn[x1] = 1;
				if (m.fninit[x1].sn[x2] != 1){
					m.change[x1][x2] = m.change[x2][x1] = 1;
				}
			}
			System.out.println("请输入参数值：");
			Trangulation.pk = si.nextInt();
			starttime = System.currentTimeMillis();
			m.cmp();
			jf.add(m);
			f = new Flip();
//			Flip.output = true;
			if (m.step_remained <= Trangulation.pk) {
				DigitDecomposition dd = new DigitDecomposition(Trangulation.pk);
				dd.create();
				int[] tem;
				Edge[] v1;
				v1 = new Edge[m.step_remained];
				int k = 0;
				for (int i = 1; i <= Trangulation.vn; i++) {
					for (int j = 1; j <= Trangulation.vn; j++) {
						if (m.fnfinal[i].sn[j] == 0 && m.fninit[i].sn[j] == 1 && i < j) {
							v1[k] = new Edge(i, j);
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
					if (Flip.output) for (int j = 0; j <= tem[0]; j++) {
						System.out.print(tem[j] + "	");
					}
					if (Flip.output) System.out.println();
					f.recursion(m, tem, 1, v1, 0);
					if (f.state) break;
				}
			}
			if (f.state) System.out.println("Yes instance!");
			else System.out.println("No instance!");
			si.close();
			endtime = System.currentTimeMillis();
			System.out.println("运行时间为：" + (endtime - starttime));
		}
		else{
			vn = (int)(Math.random() * 10000) % Trangulation.limitvn + 3;
			pk = (int)(Math.random() * 10000) % Trangulation.limitpk + 1;
			FirstNode.vn = Trangulation.vn;
			while(true){
				m =  new Trangulation();
				m.createFirstTrangulation();
				m.modifyTrangulation();
				if (m.isLegal())break;
			}
			m.createSecondTrangulation();
			jf.add(m);
			m.cmp();
//			Flip.output = true;

			Trangulation.pk = Trangulation.pk - 2;
			if (Trangulation.pk >= 1) {
				starttime = System.currentTimeMillis();
				System.out.println("减2后的参数：" + Trangulation.pk);
				f = new Flip();
				if (m.step_remained == 0) f.state = true;
				if (m.step_remained <= Trangulation.pk) {
					DigitDecomposition dd = new DigitDecomposition(Trangulation.pk);
					dd.create();
					int[] tem;
					Edge[] v1;
					v1 = new Edge[m.step_remained];
					int k = 0;
					for (int i = 1; i <= Trangulation.vn; i++) {
						for (int j = 1; j <= Trangulation.vn; j++) {
							if (m.fnfinal[i].sn[j] == 0 && m.fninit[i].sn[j] == 1 && i < j) {
								v1[k] = new Edge(i, j);
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
						if (Flip.output) for (int j = 0; j <= tem[0]; j++) {
							System.out.print(tem[j] + "	");
						}
						if (Flip.output) System.out.println();
						f.recursion(m, tem, 1, v1, 0);
						if (f.state) break;
					}
				}
				if (f.state) System.out.println("Yes instance!");
				else System.out.println("No instance!");
				endtime = System.currentTimeMillis();
				System.out.println("运行时间为：" + (endtime - starttime));
			}

			Trangulation.pk = Trangulation.pk + 2;
			starttime = System.currentTimeMillis();
			System.out.println("实际给定的参数：" + Trangulation.pk);
			f = new Flip();
			if (m.step_remained == 0)f.state = true;
			if (m.step_remained <= Trangulation.pk) {
				DigitDecomposition dd = new DigitDecomposition(Trangulation.pk);
				dd.create();
				int[] tem;
				Edge[] v1;
				v1 = new Edge[m.step_remained];
				int k = 0;
				for (int i = 1; i <= Trangulation.vn; i++) {
					for (int j = 1; j <= Trangulation.vn; j++) {
						if (m.fnfinal[i].sn[j] == 0 && m.fninit[i].sn[j] == 1 && i < j) {
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
					if (Flip.output)for (int j = 0; j <= tem[0]; j++) {
						System.out.print(tem[j] + "	");
					}
					if (Flip.output)System.out.println();
					f.recursion(m, tem, 1, v1,0);
					if (f.state) break;
				}
			}
			if(f.state)System.out.println("Yes instance!");
			else System.out.println("No instance!");
			endtime = System.currentTimeMillis();
			System.out.println("运行时间为：" + (endtime - starttime));
		}
	}
}

