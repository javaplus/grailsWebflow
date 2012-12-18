package com.uber.pizza

class ToppingsController {

    def toppingsFlow={
		
		input{
			// define the topping as an input.  This will put the passed in topping parameter into this flow's flow scope.
			topping()
		}
		
		// The first real "state" or "step" in this flow. This is a view state. 
		selectTopping{
			// change the default method of finding a view and tells it to render the view found at this location.
			render(view:"/pizzaShop/orderPizza/selectToppings") 
			on("next"){
				// put the new topping into the flow
				flow.topping = params.topping
			}.to "finish"
			on("back").to "back"
		}
		
		finish(){ // finish
			// pass the topping as an output of this flow
			output{
				topping{flow.topping}
			}
			
		}
		
		back() // end this flow with the "back" event, back is NOT a reserved word or special at all.
	}	

}