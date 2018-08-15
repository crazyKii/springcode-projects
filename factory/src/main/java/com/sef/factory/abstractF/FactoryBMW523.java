package com.sef.factory.abstractF;

public class FactoryBMW523 implements AbstractFactory {

	public Engine createEngine() {
		 return new EngineB();    
	}

	public Aircondition createAircondition() {
		 return new AirconditionB();    
	}
}
