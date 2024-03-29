package dmacc.beans;

import jakarta.persistence.Embeddable;

@Embeddable
public class Toppings {
	
	private boolean pepperoni = false;
	private boolean sausage = false;
	private boolean mushrooms = false;
	private boolean olives = false;
	private boolean pineapple = false;
	private boolean greenPeppers = false;
	
	public Toppings() {
		super();
	}
	
	public Toppings(boolean pepperoni) {
		super();
		this.pepperoni = pepperoni;
	}
	
	public Toppings(boolean pepperoni, boolean sausage) {
		super();
		this.pepperoni = pepperoni;
		this.sausage = sausage;
	}
	
	public Toppings(boolean pepperoni, boolean sausage, boolean mushrooms) {
		super();
		this.pepperoni = pepperoni;
		this.sausage = sausage;
		this.mushrooms = mushrooms;
	}
	
	public Toppings(boolean pepperoni, boolean sausage, boolean mushrooms, boolean olives) {
		super();
		this.pepperoni = pepperoni;
		this.sausage = sausage;
		this.mushrooms = mushrooms;
		this.olives = olives;
	}

	public Toppings(boolean pepperoni, boolean sausage, boolean mushrooms, boolean olives, boolean pineapple) {
		super();
		this.pepperoni = pepperoni;
		this.sausage = sausage;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.pineapple = pineapple;
	}
	
	public Toppings(boolean pepperoni, boolean sausage, boolean mushrooms, boolean olives, boolean pineapple,
			boolean greenPeppers) {
		super();
		this.pepperoni = pepperoni;
		this.sausage = sausage;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.pineapple = pineapple;
		this.greenPeppers = greenPeppers;
	}

	public Toppings(long id, boolean pepperoni, boolean sausage, boolean mushrooms, boolean olives, boolean pineapple,
			boolean greenPeppers) {
		super();
		this.pepperoni = pepperoni;
		this.sausage = sausage;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.pineapple = pineapple;
		this.greenPeppers = greenPeppers;
	}
	
	public boolean isPepperoni() {
		return pepperoni;
	}

	public void setPepperoni(boolean pepperoni) {
		this.pepperoni = pepperoni;
	}

	public boolean isSausage() {
		return sausage;
	}

	public void setSausage(boolean sausage) {
		this.sausage = sausage;
	}

	public boolean isMushrooms() {
		return mushrooms;
	}

	public void setMushrooms(boolean mushrooms) {
		this.mushrooms = mushrooms;
	}

	public boolean isOlives() {
		return olives;
	}

	public void setOlives(boolean olives) {
		this.olives = olives;
	}

	public boolean isPineapple() {
		return pineapple;
	}

	public void setPineapple(boolean pineapple) {
		this.pineapple = pineapple;
	}

	public boolean isGreenPeppers() {
		return greenPeppers;
	}

	public void setGreenPeppers(boolean greenPeppers) {
		this.greenPeppers = greenPeppers;
	}

	@Override
	public String toString() {
	    StringBuilder resultStr = new StringBuilder();
	    String[] toppingNames = {"pepperoni", "sausage", "mushrooms", "olives", "pineapple", "green peppers"};
	    boolean[] isOnPizza = {isPepperoni(), isSausage(), isMushrooms(), isOlives(), isPineapple(), isGreenPeppers()};
	    
	    for (int i = 0; i < toppingNames.length; i++) {
	        if (isOnPizza[i]) {
	            resultStr.append(toppingNames[i]);
	            resultStr.append(String.format(", "));
	        }
	    }
	    
	    if (resultStr.length() == 0) {
	        resultStr.append("None");
	    } else {
	        resultStr.setLength(resultStr.length() - 2);
	    }
	    
	    return resultStr.toString();
	}
}
