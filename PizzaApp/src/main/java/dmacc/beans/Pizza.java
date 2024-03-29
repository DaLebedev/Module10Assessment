package dmacc.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue
	private long id;
	private char size = 'S';
	private boolean stuffedCrust = false;
	private double baseCost = 10.00;
	
	@Autowired
	private Toppings toppings;
	
	private double finalPrice = baseCost;

	public Pizza() {
		super();
	}

	public Pizza(char size, boolean stuffedCrust, double baseCost, Toppings toppings) {
		super();
		this.size = size;
		this.stuffedCrust = stuffedCrust;
		this.baseCost = baseCost;
		this.toppings = toppings;
	}
	
	public Pizza(long id, char size, boolean stuffedCrust, double baseCost, Toppings toppings) {
		super();
		this.id = id;
		this.size = size;
		this.stuffedCrust = stuffedCrust;
		this.baseCost = baseCost;
		this.toppings = toppings;
	}
	
	public double calculatePrice() {
		if (toppings != null) {
	        for (boolean topping : new boolean[]{toppings.isPepperoni(), toppings.isSausage(), toppings.isMushrooms(), toppings.isOlives(), toppings.isPineapple(), toppings.isGreenPeppers()}) {
	            if (topping) {
	                this.finalPrice += 0.50;
	            }
	        }
	    }
		
		if (stuffedCrust) {
			this.finalPrice += 2.50;
		}
		
		switch (size) {
		case 'M':
			this.finalPrice += 1.00;
			break;
		case 'L':
			this.finalPrice += 1.75;
			break;
		default:
			break;
		}
		
	    return this.finalPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public boolean isStuffedCrust() {
		return stuffedCrust;
	}

	public void setStuffedCrust(boolean stuffedCrust) {
		this.stuffedCrust = stuffedCrust;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public Toppings getToppings() {
		return toppings;
	}

	public void setToppings(Toppings toppings) {
		this.toppings = toppings;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
	    this.finalPrice = finalPrice;
	}
	
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", size=" + size + ", stuffedCrust=" + stuffedCrust + ", baseCost=" + baseCost
			+ ", toppings=" + toppings + ", finalPrice=" + finalPrice + "]";
	}
	
}