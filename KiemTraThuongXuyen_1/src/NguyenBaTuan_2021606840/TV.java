package NguyenBaTuan_2021606840;

public class TV extends Product  {

	private double size;
	private String color;

	public TV() {
		super();
	}

	public TV(String product_name, double product_price, int product_total, double size,
			String color) {
		super(product_name, product_price, product_total);
		this.size = size;
		this.color = color;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return  String.format(super.toString()+"size=%.1f, color=%s",getSize(), getColor());
                
               
	}
	
	

}
