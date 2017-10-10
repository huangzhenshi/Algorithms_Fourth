package commonFunction;

public class Utils {
	public static void printArr(Object[] arr){
		int index=0;
		for(Object o: arr){
			index++;
			System.out.println("the "+index+" element is: "+o.toString());
		}
		System.out.println("the length is :"+arr.length);
	}
}
