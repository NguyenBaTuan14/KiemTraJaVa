package NguyenBaTuan_2021606840;

public class Product implements Comparable<Product> {
	
	
	private int product_id;
	private String product_name;
	private double product_price;
	private int product_total;
	public Product() {
		super();
	}
	public Product(String product_name, double product_price, int product_total) {
		super();
		
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
		return String.format("id=%d, name=%s, price=%.2f, total=%d, ",
                getProduct_id(),
                getProduct_name(),
                getProduct_price(),
                getProduct_total() );
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
