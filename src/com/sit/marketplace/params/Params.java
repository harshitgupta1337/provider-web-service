package com.sit.marketplace.params;

import java.util.HashMap;
import java.util.Map;

public class Params {
	
	private static Params instance = null;
	
	private static double DEFAULT_TRUST = 10.0;
	private static double DEFAULT_COST_PER_VM_PER_HOUR = 20.0;
	private static double DEFAULT_MIN_AVAILABILITY = 30.0;
	public static String TRUST_PARAM_NAME = "trust";
	public static String COST_PARAM_NAME = "costPerVmPerHour";
	public static String MIN_AVAILABILITY_PARAM_NAME = "minAvailability";
	
	private Map<String, Double> paramsMap;
	
	public Map<String, Double> getParamsMap(){
		return paramsMap;
	}
	
	public void setParamsMap(Map<String, Double> paramsMap){
		this.paramsMap = paramsMap;
	}
	
	protected Params() {
		paramsMap = new HashMap<String, Double>();
		paramsMap.put(TRUST_PARAM_NAME, DEFAULT_TRUST);
		paramsMap.put(MIN_AVAILABILITY_PARAM_NAME, DEFAULT_MIN_AVAILABILITY);
		paramsMap.put(COST_PARAM_NAME, DEFAULT_COST_PER_VM_PER_HOUR);
	}
	
	public static Params getInstance() {
		if(instance == null) {
			instance = new Params();
		}
		return instance;
	} 
}
