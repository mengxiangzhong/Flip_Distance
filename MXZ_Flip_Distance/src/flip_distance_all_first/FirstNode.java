package flip_distance_all_first;

class Edge{
	int s,t;
	boolean state;
	Edge(){
		s = 0;
		t = 0;
		state = false;
	}
	Edge(int x,int y){
		s = x;
		t = y;
		state = false;
	}
}

public class FirstNode {
	int x,y;
	static int vn;
	short[] sn;
	FirstNode(){
		x = 0;
		y = 0;
		sn = new short[vn + 1];
		for(int i = 1;i <= vn; i++){
			sn[i] = 0;
		}
	}
}
