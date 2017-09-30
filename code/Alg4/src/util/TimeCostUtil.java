package util;

import java.util.Date;

public class TimeCostUtil {
	public long millionTime=0l;
	public TimeCostUtil(){
		
		
	}
	
	public  void start(){
		millionTime= new Date().getTime();
	}
	public  long getCost(){
		long cost= new Date().getTime()-millionTime;
		return cost;
		
	}
}
