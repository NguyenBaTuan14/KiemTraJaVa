package NguyenBaTuan_2021606840;

import java.util.*;

public interface TVManager {
	
	public boolean addTV(TV t);
	
	public boolean editTV(TV t);
	
	public boolean delTV(TV t);
	
	public List<TV> searchTVByName(String name);
	
	public List<TV> searchTVByPrice(double price);
	
	public List<TV> searchTVByColor(String color);
	
	public List<TV> sortedTVByPrice(double price, boolean isINC);
	
	public List<TV> sortedTVBySize(double size, boolean isINC);
	
	public void printInfo();
	
	public void generateList(int n);

}
