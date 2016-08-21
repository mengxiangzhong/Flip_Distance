package flip_distance_all_second;

import java.util.Vector;

public class Flip {
	boolean state;
	Vector <Edge> v[];
	Flip(){
	}
	Flip(int k){
		state = false;
		v = new Vector[k];
		for (int i = 0; i < k; i++) {
			v[i] = new Vector<Edge>();
			v[i].clear();
		}
	}
	void in(int n){
		for (int i = 0; i < n; i++) {
			System.out.print("	");
		}
		System.out.println("------------------>>>>>>");
	}
	void out(int n){
		for (int i = 0; i < n; i++) {
			System.out.print("	");
		}
		System.out.println("<<<<<<------------------");
	}
	void print(int k,int style,int n){
		for (int i = 0; i < n; i++) {
			System.out.print("	");
		}
		System.out.println("当前处在第" + k + "个连通块,进行的是第" + style + "种操作");
	}
	void printAction(int x1,int y1,int x2,int y2,int choice,int n){
		for (int i = 0; i < n; i++) {
			System.out.print("	");
		}
		if (choice == 1){
			System.out.println("从边" + x1 + y1 + "翻到" + x2 + y2);
		}
		else if (choice == 2){
			System.out.println("当前操作边由" + x1 + y1 + "移到" + x2 + y2);
		}
		else if (choice == 3){
			System.out.println("把边" + x1 + y1 + "压栈");
		}
		else if (choice == 4){
			System.out.println("跳到栈顶" + x1 + y1 + "，当前操作边为" + x2 + y2);
		}
		else if (choice == 0){
			System.out.println("当前操作边为" + x1 + y1);
		}
		else{
			System.out.println("跳到栈顶" + x1 + y1 + "，删除栈顶边，当前操作边为" + x2 + y2);
		}
	}
	Edge[] edgecpy(Edge[] edges){
		Edge[] e = new Edge[edges.length];
		for (int i = 0; i < e.length; i++) {
			e[i] = new Edge(edges[i].s,edges[i].t);
			e[i].state = edges[i].state;
		}
		return e;
	}
	void firstCase(Trangulation t,int k,int kk,int []result,int []temd,int current,Edge[] edge,int index,int n){
		in(n);
		if (state || current == temd[0] + 1) {
			out(n);
			return;
		}
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (k == 0 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0,count = 0;
			for (Edge teme:e) {
				if (teme.state == false){
					if(t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
						count++;
					}
				}
			}
			if (e[index].state && t.step_remained == sum && count == temd[current])
//			if (t.step_remained == sum && count == temd[current])
				recursion(t,temd,current + 1,e,n + 1);
			out(n);
			return;
		}
		tem = t.cpy();
		print(current,1,n);
		if(tem.fninit[result[0]].sn[result[1]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[1]
				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2
				&& !(tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[2]
				|| tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[1])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2
				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		out(n);
	}
	void secondCase(Trangulation t,int k,int kk,int [] result,int []temd,int current,Edge[] edge,int index,int n){
		in(n);
		if (state || current == temd[0] + 1){
			out(n);
			return;
		}
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (k == 0 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0,count = 0;
			for (Edge teme:e) {
				if (teme.state == false){
					if(t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
						count++;
					}
				}
			}
			if (e[index].state && t.step_remained == sum && count == temd[current])
//			if (t.step_remained == sum && count == temd[current])
				recursion(t,temd,current + 1,e,n + 1);
			out(n);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		print(current,2,n);
		printAction(result[0],result[2],result[1],result[3],1,n);
		if(tem.fninit[result[0]].sn[result[1]] == 2){
//		if(tem.fninit[result[0]].sn[result[1]] == 2
//				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[1]
//				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2){
//		if(tem.fninit[result[1]].sn[result[2]] == 2
//				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[1]
//				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2){
//		if(tem.fninit[result[2]].sn[result[3]] == 2
//				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[3]
//				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2){
//		if(tem.fninit[result[3]].sn[result[0]] == 2
//				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[3]
//				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		out(n);
	}
	void thirdCase(Trangulation t,int k,int kk,int [] result,int []temd,int current,Edge[] edge,int index,int n){
		in(n);
		if (state || current == temd[0] + 1) {
			out(n);
			return;
		}
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (k == 0 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0,count = 0;
			for (Edge teme:e) {
				if (teme.state == false){
					if(t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
						count++;
					}
				}
			}
			if (e[index].state && t.step_remained == sum && count == temd[current])
//			if (t.step_remained == sum && count == temd[current])
				recursion(t,temd,current + 1,e,n + 1);
			out(n);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		Edge e = new Edge(result[1],result[3]);
		v[current - 1].add(e);
		print(current,3,n);
		printAction(result[0],result[2],result[1],result[3],1,n);
		printAction(result[1],result[3],0,0,3,n);
		if(tem.fninit[result[0]].sn[result[1]] == 2){
//		if(tem.fninit[result[0]].sn[result[1]] == 2
//				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[1]
//				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2){
//		if(tem.fninit[result[1]].sn[result[2]] == 2
//				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[1]
//				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2){
//		if(tem.fninit[result[2]].sn[result[3]] == 2
//				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[3]
//				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2){
//		if(tem.fninit[result[3]].sn[result[0]] == 2
//				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[3]
//				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
				}
			}
		}
		out(n);
	}
	void fourthCase(Trangulation t,int k,int kk,int [] result,int []temd,int current,Edge[] edge,int index,int n){
		in(n);
		if (state || current == temd[0] + 1) {
			out(n);
			return;
		}
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (k == 0 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0,count = 0;
			for (Edge teme:e) {
				if (teme.state == false){
					if(t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
						count++;
					}
				}
			}
			if (e[index].state && t.step_remained == sum && count == temd[current])
//			if (t.step_remained == sum && count == temd[current])
				recursion(t,temd,current + 1,e,n + 1);
			out(n);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		print(current,4,n);
		printAction(result[0],result[2],result[1],result[3],1,n);
		Edge e;
		if (!v[current - 1].isEmpty()){
			e = v[current - 1].lastElement();
		}
		else {
			out(n);
			return;
		}
		tem.current_edge_x = e.s;
		tem.current_edge_y = e.t;
		printAction(result[1],result[3],e.s,e.t,4,n);
		int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
		firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
		out(n);
	}
	void fifthCase(Trangulation t,int k,int kk,int [] result,int []temd,int current,Edge[] edge,int index,int n){
		in(n);
		if (state || current == temd[0] + 1){
			out(n);
			return;
		}
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (t.step_remained == 0){
			state = true;
			out(n);
			return;
		}
		if (k == 0 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0,count = 0;
			for (Edge teme:e) {
				if (teme.state == false){
					if(t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
						count++;
					}
				}
			}
			if (e[index].state && t.step_remained == sum && count == temd[current])
//			if (t.step_remained == sum && count == temd[current])
				recursion(t,temd,current + 1,e,n + 1);
			out(n);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		print(current,5,n);
		printAction(result[0],result[2],result[1],result[3],1,n);
		Edge e;
		if (!v[current - 1].isEmpty()){
			e = v[current - 1].lastElement();
		}
		else {
			out(n);
			return;
		}
		tem.current_edge_x = e.s;
		tem.current_edge_y = e.t;
		printAction(result[1],result[3],e.s,e.t,5,n);
		int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
		firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1);
		v[current - 1].remove(v[current - 1].size()-1);
		out(n);
	}
	void recursion(Trangulation t,int []temdd,int current,Edge[] edges,int n){
		Edge e = null;
		v[current - 1].clear();
		int index = 0;
		for (int i = 0; i < edges.length; i++) {
			if (!edges[i].state){
				e = edges[i];
				index = i;
				break;
			}
		}
		if (state || (current == temdd[0] + 1 && index != 0)) return;
		t.cmp();
		if(t.step_remained == 0 || e == null) {
			state = true;
			return;
		}
		t.current_edge_x = e.s;
		t.current_edge_y = e.t;
		printAction(e.s,e.t,0,0,0,n);
		int []result = t.isQuadrilateral(t.current_edge_x,t.current_edge_y);
		if ( result != null ){
			firstCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n);
			if( t.isConvex(result) ){
				secondCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n);
				thirdCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n);
				fourthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n);
				fifthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n);
			}
		}
	}
}
