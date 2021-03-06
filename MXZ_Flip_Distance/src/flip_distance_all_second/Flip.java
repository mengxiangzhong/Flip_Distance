package flip_distance_all_second;

import java.util.Vector;

public class Flip {
	boolean state;
	static boolean output;
	int [] resultcount;
	private Vector[] v;
	Flip(){
	}
	Flip(int k){
		state = false;
		resultcount = new int[5];
		v = new Vector[k + 1];
		for (int i = 0; i <= k; i++) {
			v[i] = new Vector<Edge>();
			v[i].clear();
		}
	}
	private void in(int n){
		for (int i = 0; i < n; i++) {
			System.out.print("	");
		}
		System.out.println("------------------>>>>>>");
	}
	private void out(int n){
		for (int i = 0; i < n; i++) {
			System.out.print("	");
		}
		System.out.println("<<<<<<------------------");
	}
	private void print(int k, int style, int n){
		for (int i = 0; i < n; i++) {
			System.out.print("	");
		}
		System.out.println("当前处在第" + k + "个连通块,进行的是第" + style + "种操作");
	}
	private void printAction(int x1, int y1, int x2, int y2, int choice, int n){
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
	private Edge[] edgecpy(Edge[] edges){
		Edge[] e = new Edge[edges.length];
		for (int i = 0; i < e.length; i++) {
			e[i] = new Edge(edges[i].s,edges[i].t);
			e[i].state = edges[i].state;
		}
		return e;
	}
	private void firstCase(Trangulation t, int k, int kk, int[] result, int[] temd, int current, Edge[] edge, int index, int n,int [] temcount){
		if (output)in(n);
		if (state) {
			if (output)out(n);
			return;
		}
		Trangulation tem = t.cpy();
		tem.cmp();
		if(tem.step_remained == 0) {
			state = true;
			for (int i = 0; i < 5; i++) {
				resultcount[i] = temcount[i];
			}
			return;
		}
		if (k == 0 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0;
			for (Edge teme:e) {
				if (!teme.state){
					if(tem.fninit[teme.s].sn[teme.t] ==1 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
					}
				}
			}
			tem.cmp();
			if (e[index].state && tem.step_remained == sum)
				recursion(tem,temd,current + 1,e,n + 1,temcount);
			if (output)out(n);
			return;
		}
		if (output)print(current,1,n);
		if(!(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[1]
				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		if(!(tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[2]
				|| tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[1])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		if(!(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		if(!(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		if (output)out(n);
	}
	private void secondCase(Trangulation t, int k, int kk, int[] result, int[] temd, int current, Edge[] edge, int index, int n,int [] temcount){
		if (output)in(n);
		if (state){
			if (output)out(n);
			return;
		}
		Trangulation tem = t.cpy();
		tem.diagonal(result);
		tem.cmp();
		if(tem.step_remained == 0) {
			state = true;
			for (int i = 0; i < 5; i++) {
				resultcount[i] = temcount[i];
			}
			return;
		}
		if (k == 1 || kk == 1 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0;
			for (Edge teme:e) {
				if (!teme.state){
					if(tem.fninit[teme.s].sn[teme.t] ==1 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
					}
				}
			}
			if (e[index].state && tem.step_remained == sum)
				recursion(tem,temd,current + 1,e,n + 1,temcount);
			if (output)out(n);
			return;
		}
		if (output)print(current,2,n);
		if (output)printAction(result[0],result[2],result[1],result[3],1,n);
		{
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		{
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		{
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		{
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		if (output)out(n);
	}
	private void thirdCase(Trangulation t, int k, int kk, int[] result, int[] temd, int current, Edge[] edge, int index, int n,int [] temcount){
		if (output)in(n);
		if (state) {
			if (output)out(n);
			return;
		}
		Trangulation tem = t.cpy();
		tem.diagonal(result);
		tem.cmp();
		if(tem.step_remained == 0) {
			state = true;
			for (int i = 0; i < 5; i++) {
				resultcount[i] = temcount[i];
			}
			return;
		}
		if (k == 1 || kk == 1 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0;
			for (Edge teme:e) {
				if (!teme.state){
					if(tem.fninit[teme.s].sn[teme.t] ==1 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
					}
				}
			}
			if (e[index].state && tem.step_remained == sum)
				recursion(tem,temd,current + 1,e,n + 1,temcount);
			if (output)out(n);
			return;
		}
		Edge e = new Edge(result[1],result[3]);
		v[current - 1].add(e);
		if (output)print(current,3,n);
		if (output)printAction(result[0],result[2],result[1],result[3],1,n);
		if (output)printAction(result[1],result[3],0,0,3,n);
		{
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		{
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		{
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		{
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			if (output)printAction(tem.last_edge_x,tem.last_edge_y,tem.current_edge_x,tem.current_edge_y,2,n);
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				temcount[0] += 1;
				firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
				temcount[0] -= 1;
				if( tem.isConvex(temresult) ){
					temcount[1] += 1;
					secondCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[1] -= 1;
					temcount[2] += 1;
					thirdCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[2] -= 1;
					temcount[3] += 1;
					fourthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[3] -= 1;
					temcount[4] += 1;
					fifthCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
					temcount[4] -= 1;
				}
			}
		}
		if (output)out(n);
	}
	private void fourthCase(Trangulation t, int k, int kk, int[] result, int[] temd, int current, Edge[] edge, int index, int n,int [] temcount){
		if (output)in(n);
		if (state) {
			if (output)out(n);
			return;
		}
		Trangulation tem = t.cpy();
		tem.diagonal(result);
		tem.cmp();
		if(tem.step_remained == 0) {
			state = true;
			for (int i = 0; i < 5; i++) {
				resultcount[i] = temcount[i];
			}
			return;
		}
		if (k == 1 || kk == 1 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0;
			for (Edge teme:e) {
				if (!teme.state){
					if(tem.fninit[teme.s].sn[teme.t] ==1 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
					}
				}
			}
			if (e[index].state && tem.step_remained == sum)
				recursion(tem,temd,current + 1,e,n + 1,temcount);
			if (output)out(n);
			return;
		}
		if (output)print(current,4,n);
		if (output)printAction(result[0],result[2],result[1],result[3],1,n);
		Edge e;
		if (!v[current - 1].isEmpty()){
			e = (Edge) v[current - 1].lastElement();
		}
		else {
			if (output)out(n);
			return;
		}
		tem.current_edge_x = e.s;
		tem.current_edge_y = e.t;
		if (output)printAction(result[1],result[3],e.s,e.t,4,n);
		int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
		temcount[0] += 1;
		firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
		temcount[0] -= 1;
		if (output)out(n);
	}
	private void fifthCase(Trangulation t, int k, int kk, int[] result, int[] temd, int current, Edge[] edge, int index, int n,int [] temcount){
		if (output)in(n);
		if (state){
			if (output)out(n);
			return;
		}
		Trangulation tem = t.cpy();
		tem.diagonal(result);
		tem.cmp();
		if(tem.step_remained == 0) {
			state = true;
			for (int i = 0; i < 5; i++) {
				resultcount[i] = temcount[i];
			}
			return;
		}
		if (k == 1 || kk == 1 || kk == 0){
			Edge [] e = edgecpy(edge);
			int sum = 0;
			for (Edge teme:e) {
				if (!teme.state){
					if(tem.fninit[teme.s].sn[teme.t] ==1 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
					else {
						teme.state = true;
					}
				}
			}
			if (e[index].state && tem.step_remained == sum)
				recursion(tem,temd,current + 1,e,n + 1,temcount);
			if (output)out(n);
			return;
		}
		if (output)print(current,5,n);
		if (output)printAction(result[0],result[2],result[1],result[3],1,n);
		Edge e;
		if (!v[current - 1].isEmpty()){
			e = (Edge) v[current - 1].lastElement();
		}
		else {
			if (output)out(n);
			return;
		}
		tem.current_edge_x = e.s;
		tem.current_edge_y = e.t;
		if (output)printAction(result[1],result[3],e.s,e.t,5,n);
		int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
		temcount[0] += 1;
		firstCase(tem,k - 1,kk - 1,temresult,temd,current,edge,index,n + 1,temcount);
		temcount[0] -= 1;
		v[current - 1].remove(v[current - 1].size()-1);
		if (output)out(n);
	}
	void recursion(Trangulation t,int []temdd,int current,Edge[] edges,int n,int [] temcount){
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
			for (int i = 0; i < 5; i++) {
				resultcount[i] = temcount[i];
			}
			return;
		}
		t.current_edge_x = e.s;
		t.current_edge_y = e.t;
		if (output)printAction(e.s,e.t,0,0,0,n);
		int []result = t.isQuadrilateral(t.current_edge_x,t.current_edge_y);
		if ( result != null ){
			temcount[0] += 1;
			firstCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n,temcount);
			temcount[0] -= 1;
			if( t.isConvex(result) ){
				temcount[1] += 1;
				secondCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n,temcount);
				temcount[1] -= 1;
				temcount[2] += 1;
				thirdCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n,temcount);
				temcount[2] -= 1;
				temcount[3] += 1;
				fourthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n,temcount);
				temcount[3] -= 1;
				temcount[4] += 1;
				fifthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index,n,temcount);
				temcount[4] -= 1;
			}
		}
	}
}
