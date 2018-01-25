package headfirst.designpatterns.factory.pizzaaf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PizzaStoreTest {

	@ParameterizedTest(name = "{index}=> topping{0}, cost{1}")
	@CsvSource({
		"cheese, 15.99",
		"pepperoni,16.99",
		"clam,9.00",
		"veggie,16.99",
	})
	void NYTest(String topping, double cost) {
		
		PizzaStore nyStore = new NYPizzaStore();
		
		Pizza pizza = nyStore.orderPizza(topping);
		assertEquals(cost, pizza.cost, .002);
		
		
	}
	
	@ParameterizedTest(name = "{index}=> topping{0}, cost{1}")
	@CsvSource({
		"cheese,12.99",
		"pepperoni,16.99",
		"clam,14.99",
		"veggie,12.99",
	})
	void chicagoTest(String topping, double cost) {
		PizzaStore chicagoStore = new ChicagoPizzaStore();
	
		Pizza pizza = chicagoStore.orderPizza(topping);
		assertEquals(cost, pizza.cost, .002);
	}
}
