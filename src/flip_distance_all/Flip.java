package flip_distance_all;

import java.util.Vector;

public class Flip {
	boolean state;
	Vector <Trangulation> v;
	Flip(){
		state = false;
		v = new Vector<Trangulation>();
	}
	void firstCase(Trangulation t,int k,int kk,int []result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem = t.cpy();
		tem.cmp();
		if (tem.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (tem.fninit[teme.s].sn[teme.t] ==2 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
//			for(int i = 0; i < e.length; i++) {
//				if (tem.fninit[e[i].s].sn[e[i].t] ==2 && tem.fnfinal[e[i].s].sn[e[i].t] == 0)sum++;
//				else{
//					e[i].state = true;
//				}
//			}
			if (e[index].state && tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			return;
		}
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
//					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
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
//					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
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
//					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
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
//					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
	}
	void secondCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem = t.cpy();
		tem.cmp();
		if (tem.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (tem.fninit[teme.s].sn[teme.t] ==2 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
//			for(int i = 0; i < e.length; i++) {
//				if (tem.fninit[e[i].s].sn[e[i].t] ==2 && tem.fnfinal[e[i].s].sn[e[i].t] == 0)sum++;
//				else{
//					e[i].state = true;
//				}
//			}
			if (e[index].state && tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			return;
		}
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
//					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
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
//					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
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
//					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
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
//					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
//					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge,index);
				}
			}
		}
	}
	void thirdCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem = t.cpy();
		tem.cmp();
		if (tem.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (tem.fninit[teme.s].sn[teme.t] ==2 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
//			for(int i = 0; i < e.length; i++) {
//				if (tem.fninit[e[i].s].sn[e[i].t] ==2 && tem.fnfinal[e[i].s].sn[e[i].t] == 0)sum++;
//				else{
//					e[i].state = true;
//				}
//			}
			if (e[index].state && tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			return;
		}
		tem.diagonal(result);
		tem.current_edge_x = result[1];
		tem.current_edge_y = result[3];
		v.add(tem);
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
		Trangulation tem2,tem = t.cpy();
		tem.cmp();
		if (tem.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (tem.fninit[teme.s].sn[teme.t] ==2 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
//			for(int i = 0; i < e.length; i++) {
//				if (tem.fninit[e[i].s].sn[e[i].t] ==2 && tem.fnfinal[e[i].s].sn[e[i].t] == 0)sum++;
//				else{
//					e[i].state = true;
//				}
//			}
			if (e[index].state && tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			return;
		}
		tem.diagonal(result);
		tem.current_edge_x = result[1];
		tem.current_edge_y = result[3];
		tem.cmp();
		if (tem.step_remained == 0){
			state = true;
			return;
		}
		if (k - 1 == 0 || kk - 1 == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 0; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] ==2 && tem.fnfinal[e[i].s].sn[e[i].t] == 0)sum++;
				else{
					e[i].state = true;
				}
			}
			if (e[index].state && tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			return;
		}
		if (!v.isEmpty()){
			tem2 = v.lastElement();
		}
		else return;
		int []temresult = tem2.isQuadrilateral(tem2.current_edge_x,tem2.current_edge_y);
		firstCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge,index);
//		if( tem2.isConvex(temresult) ){
//			secondCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//			thirdCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//			fourthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//			fifthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//		}
	}
	void fifthCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge,int index){
		if (state || current == temdd[0] + 1) return;
		Trangulation tem2,tem = t.cpy();
		tem.cmp();
		if (tem.step_remained == 0){
			state = true;
			return;
		}
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (Edge teme:e) {
				if (tem.fninit[teme.s].sn[teme.t] ==2 && tem.fnfinal[teme.s].sn[teme.t] == 0)sum++;
				else{
					teme.state = true;
				}
			}
//			for(int i = 0; i < e.length; i++) {
//				if (tem.fninit[e[i].s].sn[e[i].t] ==2 && tem.fnfinal[e[i].s].sn[e[i].t] == 0)sum++;
//				else{
//					e[i].state = true;
//				}
//			}
			if (e[index].state && tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			return;
		}
		tem.diagonal(result);
		tem.current_edge_x = result[1];
		tem.current_edge_y = result[3];
		tem.cmp();
		if (tem.step_remained == 0){
			state = true;
			return;
		}
		if (k - 1 == 0 || kk - 1 == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 0; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] ==2 && tem.fnfinal[e[i].s].sn[e[i].t] == 0)sum++;
				else{
					e[i].state = true;
				}
			}
			if (e[index].state && tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			return;
		}
		if (!v.isEmpty()){
			tem2 = v.lastElement();
		}
		else return;
		int []temresult = tem2.isQuadrilateral(tem2.current_edge_x,tem2.current_edge_y);
		firstCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge,index);
//		if( tem2.isConvex(temresult) ){
//			secondCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//			thirdCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//			fourthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//			fifthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
//		}
		v.remove(v.size()-1);
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
//				thirdCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
//				fourthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
//				fifthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges,index);
			}
		}
	}
}
