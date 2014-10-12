package com.example.wastehandlems;

@SuppressWarnings("serial")
public class WasteHandleException 
extends Exception {
	public WasteHandleException(String message) {
		super(message);
	}
	
	public WasteHandleException(String message, Exception innerException) {
		super(message, innerException);
	}
}
