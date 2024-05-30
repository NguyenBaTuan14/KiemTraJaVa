package NguyenBaTuan_2021606840;
import java.util.*;
public class TestTV {
	public static void main(String[] args) {
		int n = (int)(Math.random()*10)+5;
		
		TVManager tv = new TVManagerImpl(n);
		tv.printInfo();
		System.out.println("========================Add========================================");
		
		
		//Test addTV
		TV tvn1 = new TV( "REDME", 5000000, 10,45,"Red");
        tvn1.setProduct_id(34);
        if(tv.addTV(tvn1)) {
        	tv.printInfo();
        }else {
        	System.out.println("Add Tv : "+tvn1.toString()+" Khong thanh cong!");
        }
        System.out.println("========================Edit========================================");
        
        //Test editTV
        TV tvn2 = new TV("SONY",4000000,11,46,"White");
        tvn2.setProduct_id(34);
        if(tv.editTV(tvn2)) {
        	tv.printInfo();
        }else {
        	System.out.println("Khong ton tai TV can sua!");
        }
        
        System.out.println("========================Del========================================");
        //Test delTV
        if(tv.delTV(tvn2)) {
        	tv.printInfo();
        }else {
        	System.out.println("Khong the xoa!");
        }
        
        
        System.out.println("========================SearchName========================================");
        List<TV> searchNameResult = tv.searchTVByName("LG");
        for(TV item : searchNameResult) {
        	System.out.println("Tv: "+item.toString());
        }
        
        System.out.println("========================SearchPrice========================================");
        List<TV> searchPriceResult = tv.searchTVByPrice(4000000);
        for(TV item : searchPriceResult) {
        	System.out.println("Tv: "+item.toString());
        }
        
        System.out.println("========================SearchColor========================================");
        List<TV> searchColorResult = tv.searchTVByColor("Black");
        for(TV item : searchColorResult) {
        	System.out.println("Tv: "+item.toString());
        }
        
        
        System.out.println("========================SortedPrice========================================");
        List<TV> sortedPriceResult = tv.sortedTVByPrice(4000000,true);
        for(TV item : sortedPriceResult) {
        	System.out.println("Tv: "+item.toString());
        }
        
        
        System.out.println("========================SortedSize========================================");
        List<TV> sortedSizeResult = tv.sortedTVBySize(40,true);
        for(TV item : sortedSizeResult) {
        	System.out.println("Tv: "+item.toString());
        }
       
        
        
	}

}
