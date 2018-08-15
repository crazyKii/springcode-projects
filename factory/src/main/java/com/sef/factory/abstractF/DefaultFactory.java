package com.sef.factory.abstractF;

public class DefaultFactory implements AbstractFactory{

	public Engine createEngine() {
		return new EngineB();
	}

	public Aircondition createAircondition() {
		return new AirconditionB();
	}
}
