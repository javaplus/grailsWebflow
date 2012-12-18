package com.uber.pizza

class PizzaShopService {

    def orderPizza(crust, sauce, cheese) {
		
		if(!crust.equals("thin")){
			throw new Exception("Thin Crust is best!!!!")
		}
		
		// do real saving ordering whatever	
		println "${crust} ${sauce} ${cheese} Pizza Ordered"

    }
}
