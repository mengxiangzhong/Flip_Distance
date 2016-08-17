package flip_distance_all_first;

/**
 * Created by Lenovo on 2016/8/10.
 */
public class DigitDecomposition {
	int [][] result;
	int digit;
	int count;
	int size;
	DigitDecomposition(){

	}
	DigitDecomposition(int digit){
		size = (int )Math.pow(2,digit - 1) + 10;
		result = new int[size][size];
		count = 0;
		this.digit = digit;
	}
	void recursion(int k,int rest,int [] tem){
		if(rest == 0) {
			result[count][0] = k;
			for(int i = 1;i <= k;i++){
				result[count][i] = tem[i - 1];
			}
			count++;
			return ;
		}
		for (int i = 1;i <= digit;i++){
			if(rest >= i) {
				tem[k] = i;
				recursion(k + 1, rest - i,tem);
			}
		}
	}
	void create(){
		int [] tem = new int[size];
		for (int i = 1;i <= digit;i++){
			tem[0] = i;
			recursion(1,digit - i,tem);
		}
	}
	void print(){
		for(int i = 0;i < count;i++){
			for(int j = 1;j <= result[i][0];j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();

		}
	}
//
//	public static void main(String[] args) {
//		DigitDecomposition dd = new DigitDecomposition(8);
//		dd.create();
//		dd.print();
//	}
}
