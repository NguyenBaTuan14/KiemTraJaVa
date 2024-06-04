package NguyenBaTuan_2021606840;
import java.util.*;
public class Product implements Comparable<Product> {
	
	static Scanner sc = new Scanner(System.in);
	
	
	protected int product_id;
	protected String product_name;
	protected double product_price;
	protected int product_total;
	public Product() {
		this(null,0.0,0);
	}
	public Product(String product_name, double product_price, int product_total) {
		
		
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = product_total;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_total() {
		return product_total;
	}
	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}
	@Override
	public String toString() {
		return String.format("TV: id=%d, name=%s, price=%.2f, total=%d, ",
                getProduct_id(),
                getProduct_name(),
                getProduct_price(),
                getProduct_total() );
	}
	
	public void input() {
		System.out.print("Input product_id: ");
		product_id=sc.nextInt();
		sc.nextLine();
		System.out.print("Input product_name: ");
		product_name=sc.nextLine();
		System.out.print("Input product_price: ");
		product_price=sc.nextDouble();
		System.out.print("Input product_total: ");
		product_total=sc.nextInt();
	}
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		double result = this.product_price - o.product_price;
		if(result > 0) {
			return 1;
		}else if(result < 0) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
	

}
