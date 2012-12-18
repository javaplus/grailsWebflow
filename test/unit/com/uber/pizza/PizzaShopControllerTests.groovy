package com.uber.pizza



import grails.test.mixin.*
import grails.test.mixin.webflow.WebFlowUnitTestSupport;

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PizzaShopController)
class PizzaShopControllerTests extends WebFlowUnitTestSupport {

    void testPizzaFlow() {
		
		def viewSelectCrust = startFlow()
       
		assertEquals "selectCrust", viewSelectCrust.viewName
    }
}
