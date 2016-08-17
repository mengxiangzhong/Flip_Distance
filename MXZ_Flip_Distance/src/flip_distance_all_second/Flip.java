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
	void firstCase(Trangulation t,int k,int kk,int []result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
			if (e[index].state && t.step_remained == sum )
				recursion(t,temd,current + 1,e);
			return;
		}
		tem = t.cpy();
		if(tem.fninit[result[0]].sn[result[1]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[1]
				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2
				&& !(tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[2]
				|| tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[1])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2
				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
	}
	void secondCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
			if (e[index].state && t.step_remained == sum )
				recursion(t,temd,current + 1,e);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		if(tem.fninit[result[0]].sn[result[1]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[1]
				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2
				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[1]
				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2
				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
	}
	void thirdCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
			if (e[index].state && t.step_remained == sum )
				recursion(t,temd,current + 1,e);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		Edge e = new Edge(result[1],result[3]);
		v[current - 1].add(e);
		if(tem.fninit[result[0]].sn[result[1]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[1]
				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2
				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[1]
				|| tem.last_last_edge_x == result[1] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2
				&& !(tem.last_last_edge_x == result[2] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2
				&& !(tem.last_last_edge_x == result[0] && tem.last_last_edge_y == result[3]
				|| tem.last_last_edge_x == result[3] && tem.last_last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				if( tem.isConvex(temresult) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
	}
	void fourthCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
			if (e[index].state && t.step_remained == sum )
				recursion(t,temd,current + 1,e);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		Edge e;
		if (!v[current - 1].isEmpty()){
			e = v[current - 1].lastElement();
		}
		else return;
		tem.current_edge_x = e.s;
		tem.current_edge_y = e.t;
		int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
		firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//		if( tem.isConvex(temresult) ){
//			secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
//			thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
//			fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
//			fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
//		}
	}
	void fifthCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem;
		t.cmp();
		if (t.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (t.fninit[teme.s].sn[teme.t] ==2 && t.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
			if (e[index].state && t.step_remained == sum )
				recursion(t,temd,current + 1,e);
			return;
		}
		tem = t.cpy();
		tem.diagonal(result);
		Edge e;
		if (!v[current - 1].isEmpty()){
			e = v[current - 1].lastElement();
		}
		else return;
		tem.current_edge_x = e.s;
		tem.current_edge_y = e.t;
		int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
		firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//		if( tem2.isConvex(temresult) ){
//			secondCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge);
//			thirdCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge);
//			fourthCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge);
//			fifthCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge);
//		}
		v[current - 1].remove(v[current - 1].size()-1);
	}
	void recursion(Trangulation t,int []temdd,int current,Edge[] edges){
		Edge e = null;
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
		int []result = t.isQuadrilateral(t.current_edge_x,t.current_edge_y);
		if ( result != null ){
			firstCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
			if( t.isConvex(result) ){
				secondCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
				thirdCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
				fourthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
				fifthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
			}
		}
	}
}
