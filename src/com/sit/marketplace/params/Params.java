package com.sit.marketplace.params;

import java.util.HashMap;
import java.util.Map;

public class Params {
	
	private static Params instance = null;
	
	private static double DEFAULT_PARAM_1 = 10.0;
	private static double DEFAULT_PARAM_2 = 20.0;
	private static double DEFAULT_PARAM_3 = 30.0;
	
	private Map<String, Double> paramsMap;
	
	public Map<String, Double> getParamsMap(){
		return paramsMap;
	}
	
	public void setParamsMap(Map<String, Double> paramsMap){
		this.paramsMap = paramsMap;
	}
	
	protected Params() {
		paramsMap = new HashMap<String, Double>();
		paramsMap.put("param1", DEFAULT_PARAM_1);
		paramsMap.put("param2", DEFAULT_PARAM_2);
		paramsMap.put("param3", DEFAULT_PARAM_3);
	}
	
	public static Params getInstance() {
		if(instance == null) {
			instance = new Params();
		}
		return instance;
	} 
}
