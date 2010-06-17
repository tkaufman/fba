package com.pillar.fba

import grails.test.*

class ClientControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testList() {
    // mock the params object	
	    def controller = new ClientController()
	    controller.list()

    }
}
