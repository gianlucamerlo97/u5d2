package gianlucamerlo.u5d2.entities;

import lombok.Getter;

@Getter
public abstract class Item {

	protected int calories;
	protected double price;

	public Item(int calories, double price) {
		this.calories = calories;
		this.price = price;
	}

}
