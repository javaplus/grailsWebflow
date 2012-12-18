package com.uber.pizza

class PizzaShopController {

	//def pizzaShopService;
	
	def orderPizzaFlow = {
		
		// the first "state" or step in our flow is the first one defined.  
		// this is the only time order matters.
		// unless it contains an action or subflow call it is typically a view state.
		
		// by default a view state looks for a view with the following path /views/{controller}/{flow}/{viewStateName}
		
		// so for the next state it is going to look in /views/pizzaShop/orderPizza/selectCrust.gsp
		selectCrust{
			on("next"){
				flow.crust = params.crust // put the submitted value into the flow
			}.to "selectSauce"
		}
		
		
		selectSauce{
			on("next"){
				flow.sauce = params.sauce
			}.to "selectCheese"
		
			on("back").to "selectCrust"
		}
		
		
		selectCheese{
			onEntry{
				flash.cheese = flow.cheese?:"Mozzarella"
			}
			on("next"){
				
				flow.cheese = params.cheese
			}.to "selectTopping"
		
			on("back").to "selectSauce"
		}
		
		selectTopping{
			subflow(controller:"toppings", action:"toppings", input:[topping:{flow.topping}])
			on("finish"){
				flow.topping = currentEvent.attributes.topping
			}.to "review"
			on("back").to "selectCheese"
		}
		
		review{
			on("order").to "orderPizza"
			on("back").to "selectTopping"
		}
		
		orderPizza{
			action{
				pizzaShopService.orderPizza(flow.crust, flow.sauce, flow.cheese)
			}
			on("success").to "complete"
			on(Exception).to "selectCrust"
		}
		
		complete{}
		
	}
}
