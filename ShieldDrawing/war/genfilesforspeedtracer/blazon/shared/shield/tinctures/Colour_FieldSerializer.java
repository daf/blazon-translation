package blazon.shared.shield.tinctures;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Colour_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getColour(blazon.shared.shield.tinctures.Colour instance) /*-{
    return instance.@blazon.shared.shield.tinctures.Colour::colour;
  }-*/;
  
  private static native void setColour(blazon.shared.shield.tinctures.Colour instance, java.lang.String value) 
  /*-{
    instance.@blazon.shared.shield.tinctures.Colour::colour = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.tinctures.Colour instance) throws SerializationException {
    setColour(instance, streamReader.readString());
    
    blazon.shared.shield.tinctures.TinctureImpl_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static blazon.shared.shield.tinctures.Colour instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new blazon.shared.shield.tinctures.Colour();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.tinctures.Colour instance) throws SerializationException {
    streamWriter.writeString(getColour(instance));
    
    blazon.shared.shield.tinctures.TinctureImpl_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return blazon.shared.shield.tinctures.Colour_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Colour_FieldSerializer.deserialize(reader, (blazon.shared.shield.tinctures.Colour)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Colour_FieldSerializer.serialize(writer, (blazon.shared.shield.tinctures.Colour)object);
  }
  
}
