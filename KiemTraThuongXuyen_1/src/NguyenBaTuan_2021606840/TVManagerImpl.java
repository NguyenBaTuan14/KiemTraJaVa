package NguyenBaTuan_2021606840;

import java.util.*;







public class TVManagerImpl implements TVManager {

	protected ArrayList<TV> list;
	
	
	
	public TVManagerImpl(int n) {
		this.generateList(n);
	}

	@Override
	public boolean addTV(TV t) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(Product item : this.list) {
			if(item.getProduct_id() == t.getProduct_id()) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			this.list.add(t);
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public boolean editTV(TV t) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i = 0 ; i < this.list.size(); i++) {
			if(this.list.get(i).getProduct_id()==t.getProduct_id()) {
				this.list.set(i,t);
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public boolean delTV(TV t) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(Product item : this.list) {
			if(item.getProduct_id()==t.getProduct_id()) {
				flag = true;
			}
		}
		if(flag) {
			this.list.remove(t);
			return true;
		}else {
			return false;
		}
		
	}

	

	@Override
	public List<TV> searchTVByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<TV> newList = new ArrayList();
		for(TV item : this.list) {
			if(item.getProduct_name().equalsIgnoreCase(name)) {
				newList.add(item);
			}
		}
		return newList;
		
	}

	@Override
	public List<TV> searchTVByPrice(double price) {
		// TODO Auto-generated method stub
		ArrayList<TV> newList = new ArrayList();
		for(TV item : this.list) {
			if(item.getProduct_price() <= price) {
				newList.add(item);
			}
		}
		return newList;
	}

	@Override
	public List<TV> searchTVByColor(String color) {
		// TODO Auto-generated method stub
		ArrayList<TV> newList = new ArrayList();
		for(TV item : this.list) {
			if(item.getColor().equalsIgnoreCase(color)) {
				newList.add(item);
			}
		}
		return newList;
	}

	
	@Override
	public List<TV> sortedTVByPrice(double price, boolean isINC) {
		// TODO Auto-generated method stub
		ArrayList<TV> resultList = new ArrayList();
		for(TV item : this.list) {
			if(!(item.getProduct_price()<price)) {
				resultList.add(item);
			}
		}
		if(isINC) {
			Collections.sort(resultList);
		}else {
			Collections.sort(resultList,Collections.reverseOrder());
		}
		
		
		return resultList;
	}

	@Override
	public List<TV> sortedTVBySize(double size, boolean isINC) {
		// TODO Auto-generated method stub
		ArrayList<TV> resultList = new ArrayList();
		for(TV item : this.list) {
			if(!(item.getSize()<size)) {
				resultList.add(item);
			}
		}
		if(isINC) {
			resultList.sort(Comparator.comparingDouble(TV::getSize));
		}else {
			resultList.sort(Comparator.comparingDouble(TV::getSize).reversed());
		}
		
		
		return resultList;
	}
	
	
	public void printInfo() {
		
		this.list.forEach(tv -> {

			
				System.out.println("TV: "+tv.toString());
			
		});
	}

	@Override
	public void generateList(int n) {
		// TODO Auto-generated method stub
		this.list = new ArrayList<>(n);

		HashMap<Integer, TV> tmp = new HashMap<>();

		TV tv;
		int value;
		while (tmp.size() < n) {
			value = (int) (Math.random() * 100);
			double size = (double)(Math.random()*50)+20;

			if (!tmp.containsKey(value)) {
				if (value%2!=0) {
					tv = new TV("LG", value*100000, value,size,"Black");

				} else {
					tv = new TV("SAMSUNG", value*150000, value,size,"Silver");
				}

				tv.setProduct_id(value);
				this.list.add(tv);
				tmp.put(value, tv);
			}

		}
	}

}
