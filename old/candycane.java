import java.util.Scanner;
public class candycane{
	public static void main(String[] args){
		long holder = 0;
		long minh = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		int cownum = sc.nextInt();
		int canenum = sc.nextInt();
		long[] arr1 = new long[cownum];
		int[] arr2 = new int[canenum];
		for (int a=0; a<cownum;a++){
			System.out.print("");
			arr1[a] = sc.nextInt();
		}
		for (int b=0; b<canenum;b++){
			System.out.print("");
			arr2[b] = sc.nextInt();
		}
		for (int c=0; c<canenum;c++){
			minh = 0;
			for (int d = 0; d<cownum;d++){
				if(arr1[d]>minh){
					holder = arr1[d];
					if (arr1[d] >= arr2[c]){
						arr1[d] = arr1[d]+(arr2[c]-minh);
						break;
					}
					if (arr1[d] < arr2[c]){
						arr1[d] += ( arr1[d]-minh);
					}
					minh = holder;			
				}
			}
		}
		for (int x = 0; x<cownum;x++){
			if (x == cownum-1){
				System.out.print(arr1[x]);
				continue;
			}
			else{
				System.out.println(arr1[x]);
			}
			
		}
	}
}