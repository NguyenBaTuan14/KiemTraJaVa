package NguyenBaTuan_2021606840;

import java.util.*;

public interface TVManager {
	
	public boolean addTV(TV t);
	
	public boolean editTV(TV t);
	
	public boolean delTV(TV t);
	
	public List<TV> searchTV(String name);
	
	
	
	public List<TV> sortedTV(double price);
	
	
	
	public void printInfo();
	
	public void generateList(int n);

}
