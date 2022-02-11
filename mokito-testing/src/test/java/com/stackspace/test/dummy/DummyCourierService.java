package com.stackspace.test.dummy;

public class DummyCourierService implements CourierService {

	@Override
	public void courier(String address) {
		throw new AssertionError("Method is not implemented!");
	}
}
