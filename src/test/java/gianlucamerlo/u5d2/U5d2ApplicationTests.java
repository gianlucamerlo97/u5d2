package gianlucamerlo.u5d2;

import gianlucamerlo.u5d2.entities.Pizza;
import gianlucamerlo.u5d2.entities.Topping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5d2ApplicationTests {

	//test1
	@Test
	void testBasicPizza() {
		Pizza pizza = new Pizza("Margherita", List.of(), false);

		assertEquals("Margherita", pizza.getName());
		assertEquals(1012, pizza.getCalories());
		assertEquals(4.3, pizza.getPrice(), 0.001);
	}
	//test2
	@Test
	void testPizzaWithToppings() {
		Topping mozzarella = new Topping("Mozzarella", 100, 0.8);
		Topping olive = new Topping("Olive", 50, 0.6);
		Pizza pizza = new Pizza("Vegetariana", List.of(mozzarella, olive), false);

		assertEquals(1012 + 100 + 50, pizza.getCalories());
		assertEquals(4.3 + 0.8 + 0.6, pizza.getPrice(), 0.001);
	}

	//test3
	@Test
	void testPizzaXlExtra() {
		Topping funghi = new Topping("Funghi", 50, 0.5);
		Pizza pizza = new Pizza("Funghi XL", List.of(funghi), true);

		int expectedCalories = (int) ((1012 + 50) * 1.05);
		double expectedPrice = (4.3 + 0.5) * 1.10;

		assertEquals(expectedCalories, pizza.getCalories());
		assertEquals(expectedPrice, pizza.getPrice(), 0.001);
	}

	//test4
	@Test
	void testPizzaWithNullToppings() {
		Pizza pizza = new Pizza("Margherita", null, false);

		assertEquals(1012, pizza.getCalories());
		assertEquals(4.3, pizza.getPrice(), 0.001);
	}

	//test5
	@ParameterizedTest
	@CsvSource({
			"0, 0.0, 1012, 4.3",            // No topping
			"50, 1.0, 1113, 5.83",          // +5% calorie, +10% price
			"100, 2.0, 1213, 6.93",         // topping di 100 cal e 2.0€
			"30, 0.5, 1092, 5.28"
	})
	void testPizzaXlParametric(int toppingCalories, double toppingPrice, int expectedCalories, double expectedPrice) {
		Topping customTopping = new Topping("Custom", toppingCalories, toppingPrice);
		Pizza pizza = new Pizza("CustomXL", List.of(customTopping), true);

		assertEquals(expectedCalories, pizza.getCalories());
		assertEquals(expectedPrice, pizza.getPrice(), 0.01);
	}

}
