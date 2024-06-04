package NguyenBaTuan_2021606840;

import java.util.*;
import java.util.stream.Collectors;


public class TV extends Product implements TVManager {

	public static ArrayList<TV> list = new ArrayList();

	private String tv_screenType;
	private int tv_screenSize;

	public TV(int n) {
		this.generateList(n);

	}

	public TV() {

	}

	public TV(String product_name, double product_price, int product_total, String tV_screenType, int tV_screenSize) {
		super(product_name, product_price, product_total);
		tv_screenType = tV_screenType;
		tv_screenSize = tV_screenSize;
	}

	public String getTV_screenType() {
		return tv_screenType;
	}

	public void setTV_screenType(String tV_screenType) {
		tv_screenType = tV_screenType;
	}

	public int getTV_screenSize() {
		return tv_screenSize;
	}

	public void setTV_screenSize(int tV_screenSize) {
		tv_screenSize = tV_screenSize;
	}

	@Override
	public String toString() {
		return String.format(super.toString() + "size=%d, Type=%s", getTV_screenSize(), getTV_screenType()+"\n");

	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		super.input();

		sc.nextLine();

		System.out.print("Input Tivi's screentype: ");
		tv_screenType = sc.nextLine();
		System.out.print("Input Tivi's screensize: ");
		tv_screenSize = sc.nextInt();

		sc.nextLine();
	}

	@Override
	public boolean addTV(TV t) {
		// TODO Auto-generated method stub
		boolean flag = false;

		for (Product item : this.list) {
			if (item.getProduct_id() == t.getProduct_id()) {
				flag = true;
				
				break;
			}
		}

		if (!flag) {
			this.list.add(t);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean editTV(TV t) {
		// TODO Auto-generated method stub
		int index = list.indexOf(t);
		System.out.println("Enter alternative information of tv: ");
		t.input();
		
		list.set(index,t);
		
		return (list.get(index).equals(t)? true:false);
	}
	public boolean editTVTest(TV t) {
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
		list.remove(t);
		return list.contains(t) ? false : true;
	}

	@Override
	public List<TV> searchTV(String name) {
		// TODO Auto-generated method stub
		ArrayList<TV> tmpList = new ArrayList();
		switch (name) {
		case "1": {
			System.out.print("Enter TV's name: ");
			String tmpName = sc.nextLine();
			tmpList = (ArrayList<TV>) list.stream().filter(x -> x.getProduct_name().equals(tmpName))
					.collect(Collectors.toList());
			break;
		}
		case "2": {
			System.out.print("Enter TV's price: ");
			double tmpPrice = sc.nextDouble();
			sc.nextLine();
			tmpList = (ArrayList<TV>) list.stream().filter(x -> x.getProduct_price() == tmpPrice)
					.collect(Collectors.toList());
			break;
		}
		case "3": {
			System.out.print("Enter TV's ScreenType: ");
			
			String tmpScreenType = sc.nextLine();
			tmpList = (ArrayList<TV>) list.stream().filter(x -> x.getTV_screenType().equals(tmpScreenType))
					.collect(Collectors.toList());
			break;
		}
		case "4": {
			System.out.print("Enter TV's ScreenSize: ");
			int tmpScreenSize = sc.nextInt();
			sc.nextLine();
			tmpList = (ArrayList<TV>) list.stream().filter(x -> x.getTV_screenSize() == tmpScreenSize)
					.collect(Collectors.toList());
			break;
		}
		default:
			System.out.println("Invalid option");
			break;

		}
		return tmpList;
	}

	@Override
	public List<TV> sortedTV(double price) {
		// TODO Auto-generated method stub
		switch ((int) price) {
		case 1: {
			System.out.println("1: Sort ascending ");
			System.out.println("0: sort discending");
			System.out.print("Enter your choose: ");
			int optionSort = sc.nextInt();
			switch (optionSort) {
			case 1: {
				list.sort(Comparator.comparing(TV::getProduct_price));
				break;
			}
			case 0: {
				list.sort(Comparator.comparing(TV::getProduct_price).reversed());
				break;
			}
			default:
				System.out.println("Invalid option");
				break;
			}
			break;
		}
		case 2: {
			System.out.println("1: Sort ascending ");
			System.out.println("0: sort discending");
			System.out.print("Enter your choose: ");
			int optionSort = sc.nextInt();
			switch (optionSort) {
			case 1: {
				list.sort(Comparator.comparing(TV::getTV_screenSize));
				break;
			}
			case 0: {
				list.sort(Comparator.comparing(TV::getTV_screenSize).reversed());
				break;
			}
			default:
				System.out.println("Invalid option");
				break;
			}
			break;
		}

		default:
			System.out.println("Invalid option");
			break;

		}

		return list;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		this.list.forEach(tv -> {

			System.out.println(tv.toString());

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
			int size = (int) (Math.random() * 50) + 20;

			if (!tmp.containsKey(value)) {
				if (value % 2 != 0) {
					tv = new TV("LG", value * 100000, value, "LED", size);

				} else {
					tv = new TV("SAMSUNG", value * 150000, value, "OLED", size);
				}

				tv.setProduct_id(value);
				this.list.add(tv);
				tmp.put(value, tv);
			}

		}

	}
	public static void main(String[] args) {
		try {
			System.out.println("Enter the number of the listTV: ");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				TV m = new TV();
				boolean flag = false;
				do {
					flag = false;
					System.out.println("Input a new TV: ");
					m.input();

					if (!new TV().addTV(m)) {
						flag = true;
						System.out.println("This TV is existed!, re-intput.");
						
					}

				} while (flag==true);
				if (!flag) {
					System.out.println("Add successfull!");
				}
			}

			int option;
			do {
				System.out.println("Enter your options: ");
				System.out.println("1: Add a new TV");
				System.out.println("2: Edit a TV");
				System.out.println("3: Delete a TV");
				System.out.println("4: Search a TV");
				System.out.println("5: Sort listTV");
				System.out.println("6: Print listTV");
				System.out.println("7: QuickTest");
				System.out.println("0. Exit");

				option = sc.nextInt();
				sc.nextLine();

				switch (option) {
				case 1: {
					TV m = new TV();
					boolean flag = false;
					do {
						flag = false;
						System.out.println("Input a new TV: ");
						m.input();

						if (!new TV().addTV(m)) {
							flag = true;
							System.out.println("This TV is existed!, re-intput.");
							
						}

					} while (flag);
					if (!flag) {
						System.out.println("Add successfull!");
					}
					break;

				}
				case 2: {
					boolean check = false;
					System.out.println("Enter the id of TV you want to edit: ");
					int id = sc.nextInt();
					for (TV item : list) {
						if (item.getProduct_id() == id) {
							if (new TV().editTV(item)) {
								System.out.println("Edit successfull!");
							} else {
								System.out.println("edit failed");
							}
							check = true;
							break;
						}
					}
					if (!check) {
						System.out.println("Id is invalid");
					}
					break;
				}
				case 3: {
					boolean check = false;
					System.out.println("Enter the id of TV you want to delete: ");
					int id = sc.nextInt();
					for (TV item : list) {
						if (item.getProduct_id() == id) {
							if (new TV().delTV(item)) {
								System.out.println("Delete successfull!");
							} else {
								System.out.println("Delete failed");
							}
							check = true;
							break;
						}
					}
					if (!check) {
						System.out.println("Id is invalid");
					}
					break;
				}
				case 4: {
					System.out.println("Search by: ");
					System.out.println("1: Name ");
					System.out.println("2: Price ");
					System.out.println("3: Screentype ");
					System.out.println("4: Screensize ");
					int optionSearch = sc.nextInt();
					sc.nextLine();
					System.out.println(new TV().searchTV(String.valueOf(optionSearch)));
					break;
				}
				case 5: {
					System.out.println("Sort by: ");
					System.out.println("1: Price ");
					System.out.println("2: screensize ");

					int optionSort = sc.nextInt();
					sc.nextLine();
					System.out.println(new TV().sortedTV(optionSort));
					break;

				}
				case 6: {
					System.out.println(list);
					break;
				}
				case 7: {
					int c = (int) (Math.random() * 10) + 5;

					TVManager tv = new TV(c);
					tv.printInfo();
					System.out.println("========================Add========================================");

					// Test addTV
					TV tvn1 = new TV("REDME", 5000000, 10, "OLED", 40);
					tvn1.setProduct_id(34);
					if (tv.addTV(tvn1)) {
						tv.printInfo();
					} else {
						System.out.println("Add Tv : " + tvn1.toString() + " Unsuccessfull!");
					}
					System.out.println("========================Edit========================================");

					// Test editTV
					TV tvn2 = new TV("SONY", 4000000, 11, "OLED", 40);
					tvn2.setProduct_id(34);
					if (new TV().editTVTest(tvn2)) {
						tv.printInfo();
					} else {
						System.out.println("Khong ton tai TV can sua!");
					}

					System.out.println("========================Del========================================");
					// Test delTV
					if (tv.delTV(tvn2)) {
						tv.printInfo();
					} else {
						System.out.println("Khong the xoa!");
					}

					System.out.println("========================SearchName========================================");
					List<TV> searchNameResult = tv.searchTV("1");
					for (TV item : searchNameResult) {
						System.out.println("Tv: " + item.toString());
					}

					System.out.println("========================SearchPrice========================================");
					List<TV> searchPriceResult = tv.searchTV("2");
					for (TV item : searchPriceResult) {
						System.out.println("Tv: " + item.toString());
					}

					System.out.println(
							"========================SearchScreenType========================================");
					List<TV> searchScreenTypeResult = tv.searchTV("3");
					for (TV item : searchScreenTypeResult) {
						System.out.println("Tv: " + item.toString());
					}
					System.out.println(
							"========================SearchScreenSize========================================");
					List<TV> searchScreenSizeResult = tv.searchTV("4");
					for (TV item : searchScreenSizeResult) {
						System.out.println("Tv: " + item.toString());
					}

					System.out.println("========================SortedPrice========================================");
					List<TV> sortedPriceResult = tv.sortedTV(1);
					for (TV item : sortedPriceResult) {
						System.out.println("Tv: " + item.toString());
					}

					System.out.println(
							"========================SortedScreenSize========================================");
					List<TV> sortedScreenSizeResult = tv.sortedTV(2);
					for (TV item : sortedScreenSizeResult) {
						System.out.println("Tv: " + item.toString());
					}
					break;
				}
				case 0: {
					System.out.println("Thanks for your used");
					break;
				}
				default:
					System.out.println("Re-enter!");
					option = 1;
					break;
				}

			} while (option >= 1 && option <= 6);

			sc.close();
		} catch (Exception e) {
			System.out.println("Error...");
		}
		System.exit(0);
	}

	

}
