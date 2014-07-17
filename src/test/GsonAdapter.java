package test;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class GsonAdapter extends TypeAdapter<Container> {
	
  @Override
  public Container read(final JsonReader in) throws IOException {
    Container container = new Container();

    in.beginObject();
    while (in.hasNext()) {
    	if(in.nextName().equals("x")){
    		container.setX(in.nextInt());
    	}
    	else{
    		container.setY(in.nextInt());
    	}
    }
    in.endObject();
    return container;
  }
  @Override
  public void write(final JsonWriter out, final Container container) throws IOException {
    out.beginObject();
    
    out.name("x").value(container.getX());
    out.name("y").value(container.getY());
    
    out.endObject();
  }
}