package flip_distance_heuristic;

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
