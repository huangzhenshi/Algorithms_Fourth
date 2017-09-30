package sort;


public class Test extends Example{
	public static void main(String[] argu){
		Quick exa=new Quick();
		/*Shell exa=new Shell();*/
		outputCostByGrowSize(1000,1000,exa,false);
	}
	
	
	public static void compareSelectionAndInsertion(){
		Insertion exa=new Insertion();
		long costAveCostByCount=testAveCost(exa,1000,1000,false);
		System.out.println("insertion cost:1000 size,1000times: "+costAveCostByCount);
		
		Selection exa2=new Selection();
		long costAveCostByCount2=testAveCost(exa2,1000,1000,false);
		System.out.println("selection cost:1000 size,1000times: "+costAveCostByCount2);
	}
	
	
	
	
	


	
}
