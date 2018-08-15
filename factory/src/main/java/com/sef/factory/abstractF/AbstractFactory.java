package com.sef.factory.abstractF;

public interface AbstractFactory {
	// 制造发动机
	public Engine createEngine();
	// 制造空调
	public Aircondition createAircondition();
}
