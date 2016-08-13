package flip_distance_all;

import java.util.Vector;

/**
 * Created by Lenovo on 2016/8/4.
 */

public class Flip {
	boolean state;
	Vector <Trangulation> v;
	Flip(){
		state = false;
		v = new Vector<Trangulation>();
	}
	void firstCase(Trangulation t,int k,int kk,int []result,int []temdd,int current,Edge[] edge){
		if (state || current == temdd.length) return;
		Trangulation tem = t.cpy();
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 1; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] !=2 && tem.fnfinal[e[i].s].sn[e[i].t] == 2)sum++;
			}
			tem.cmp();
			if (tem.step_remained == 0){
				state = true;
				return;
			}
			if (tem.step_remained == sum )
				recursion(tem,temd,current + 1,e);
			else return;
		}
		if(tem.fninit[result[0]].sn[result[1]] == 2
				&& !(tem.last_edge_x == result[0] && tem.last_edge_y == result[1]
				|| tem.last_edge_x == result[1] && tem.last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2
				&& !(tem.last_edge_x == result[1] && tem.last_edge_y == result[2]
				|| tem.last_edge_x == result[2] && tem.last_edge_y == result[1])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2
				&& !(tem.last_edge_x == result[2] && tem.last_edge_y == result[3]
				|| tem.last_edge_x == result[3] && tem.last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2
				&& !(tem.last_edge_x == result[0] && tem.last_edge_y == result[3]
				|| tem.last_edge_x == result[3] && tem.last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
	}
	void secondCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge){
		if (state || current == temdd.length) return;
		Trangulation tem = t.cpy();
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 1; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] !=2 && tem.fnfinal[e[i].s].sn[e[i].t] == 2)sum++;
			}
			tem.cmp();
			if (tem.step_remained == sum)
				recursion(tem,temd,current + 1,e);
			else return;
		}
		tem.diagonal(result);
		if(tem.fninit[result[0]].sn[result[1]] == 2
				&& !(tem.last_edge_x == result[0] && tem.last_edge_y == result[1]
				|| tem.last_edge_x == result[1] && tem.last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2
				&& !(tem.last_edge_x == result[2] && tem.last_edge_y == result[1]
				|| tem.last_edge_x == result[1] && tem.last_edge_y == result[2])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2
				&& !(tem.last_edge_x == result[2] && tem.last_edge_y == result[3]
				|| tem.last_edge_x == result[3] && tem.last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2
				&& !(tem.last_edge_x == result[0] && tem.last_edge_y == result[3]
				|| tem.last_edge_x == result[3] && tem.last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
	}
	void thirdCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge){
		if (state || current == temdd.length) return;
		Trangulation tem = t.cpy();
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 1; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] !=2 && tem.fnfinal[e[i].s].sn[e[i].t] == 2)sum++;
			}
			tem.cmp();
			if (tem.step_remained == sum)
				recursion(tem,temd,current + 1,e);
			else return;
		}
		tem.diagonal(result);
		v.add(tem);
		if(tem.fninit[result[0]].sn[result[1]] == 2
				&& !(tem.last_edge_x == result[0] && tem.last_edge_y == result[1]
				|| tem.last_edge_x == result[1] && tem.last_edge_y == result[0])) {
			tem.current_edge_x = result[0];
			tem.current_edge_y = result[1];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[1]].sn[result[2]] == 2
				&& !(tem.last_edge_x == result[2] && tem.last_edge_y == result[1]
				|| tem.last_edge_x == result[1] && tem.last_edge_y == result[2])) {
			tem.current_edge_x = result[1];
			tem.current_edge_y = result[2];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[2]].sn[result[3]] == 2
				&& !(tem.last_edge_x == result[2] && tem.last_edge_y == result[3]
				|| tem.last_edge_x == result[3] && tem.last_edge_y == result[2])) {
			tem.current_edge_x = result[2];
			tem.current_edge_y = result[3];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
		if(tem.fninit[result[3]].sn[result[0]] == 2
				&& !(tem.last_edge_x == result[0] && tem.last_edge_y == result[3]
				|| tem.last_edge_x == result[3] && tem.last_edge_y == result[0])) {
			tem.current_edge_x = result[3];
			tem.current_edge_y = result[0];
			int []temresult = tem.isQuadrilateral(tem.current_edge_x,tem.current_edge_y);
			if ( temresult != null ){
				firstCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				if( tem.isConvex(result) ){
					secondCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					thirdCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fourthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
					fifthCase(tem,k - 1,kk - 1,temresult,temdd,current,edge);
				}
			}
		}
	}
	void fourthCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge){
		if (state || current == temdd.length) return;
		Trangulation tem = t.cpy();
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 1; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] !=2 && tem.fnfinal[e[i].s].sn[e[i].t] == 2)sum++;
			}
			tem.cmp();
			if (tem.step_remained == sum)
				recursion(tem,temd,current + 1,e);
			else return;
		}
		tem.diagonal(result);
		if (k - 1 == 0 || kk - 1 == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 1; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] !=2 && tem.fnfinal[e[i].s].sn[e[i].t] == 2) {
					sum++;
				}
				else e[i].state = true;
			}
			tem.cmp();
			if (tem.step_remained == sum)
				recursion(tem,temd,current + 1,e);
			else return;
		}
		Trangulation tem2 = v.lastElement();
		int []temresult = tem2.isQuadrilateral(tem2.current_edge_x,tem2.current_edge_y);
		if ( temresult != null ){
			firstCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge);
			if( tem2.isConvex(result) ){
				secondCase(tem2,k - 1,kk,temresult,temdd,current,edge);
				thirdCase(tem2,k - 1,kk,temresult,temdd,current,edge);
				fourthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
				fifthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
			}
		}
	}
	void fifthCase(Trangulation t,int k,int kk,int [] result,int []temdd,int current,Edge[] edge){
		if (state || current == temdd.length) return;
		Trangulation tem = t.cpy();
		if (k == 0 || kk == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 1; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] !=2 && tem.fnfinal[e[i].s].sn[e[i].t] == 2) {
					sum++;
				}
				else e[i].state = true;
			}
			tem.cmp();
			if (tem.step_remained == sum)
				recursion(tem,temd,current + 1,e);
			else return;
		}
		tem.diagonal(result);
		if (k - 1 == 0 || kk - 1 == 0){
			int []temd = temdd.clone();
			Edge [] e = edge.clone();
			int sum = 0;
			for (int i = 1; i < e.length; i++) {
				if (tem.fninit[e[i].s].sn[e[i].t] !=2 && tem.fnfinal[e[i].s].sn[e[i].t] == 2) {
					sum++;
				}
				else e[i].state = true;
			}
			tem.cmp();
			if (tem.step_remained == sum)
				recursion(tem,temd,current + 1,e);
			else return;
		}
		Trangulation tem2 = v.lastElement();
		int []temresult = tem2.isQuadrilateral(tem2.current_edge_x,tem2.current_edge_y);
		if ( temresult != null ){
			firstCase(tem2,k - 1,kk - 1,temresult,temdd,current,edge);
			if( tem2.isConvex(result) ){
				secondCase(tem2,k - 1,kk,temresult,temdd,current,edge);
				thirdCase(tem2,k - 1,kk,temresult,temdd,current,edge);
				fourthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
				fifthCase(tem2,k - 1,kk,temresult,temdd,current,edge);
			}
		}
		v.remove(v.size()-1);
	}
	void recursion(Trangulation t,int []temdd,int current,Edge[] edges){
		Edge e = null;
		for (int i = 0; i < edges.length; i++) {
			if (!edges[i].state){
				e = edges[i];
				break;
			}
		}
		if(t.step_remained == 0 || e == null) {
			state = true;
			return;
		}
		t.current_edge_x = e.s;
		t.current_edge_y = e.t;
		int []result = t.isQuadrilateral(t.current_edge_x,t.current_edge_y);
		if ( result != null ){
			firstCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges);
			if( t.isConvex(result) ){
				secondCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges);
				thirdCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges);
				fourthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges);
				fifthCase(t,temdd[current],temdd[current] * 2,result,temdd,current,edges);
			}
		}
	}
}
