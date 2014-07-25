package com.sit.marketplace.jsonutils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sit.marketplace.params.Params;

public class ParamsGsonAdapter extends TypeAdapter<Map<String, Double>> {
	
	  @Override
	  public Map<String, Double> read(final JsonReader in) throws IOException {
	    Map<String, Double> map = new HashMap<String, Double>();

	    in.beginObject();
	    while (in.hasNext()) {
	    	map.put(in.nextName(), in.nextDouble());
	    }
	    in.endObject();
	    return map;
	  }
	  @Override
	  public void write(final JsonWriter out, final Map<String, Double> paramsMap) throws IOException {
	    out.beginObject();
	    
	    out.name(Params.TRUST_PARAM_NAME).value(paramsMap.get(Params.TRUST_PARAM_NAME));
	    out.name(Params.MIN_AVAILABILITY_PARAM_NAME).value(paramsMap.get(Params.MIN_AVAILABILITY_PARAM_NAME));
	    out.name(Params.COST_PARAM_NAME).value(paramsMap.get(Params.COST_PARAM_NAME));
	    
	    out.endObject();
	  }
}
