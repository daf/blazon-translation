package blazon.shared.shield.tinctures;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Metal_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getColour(blazon.shared.shield.tinctures.Metal instance) /*-{
    return instance.@blazon.shared.shield.tinctures.Metal::colour;
  }-*/;
  
  private static native void setColour(blazon.shared.shield.tinctures.Metal instance, java.lang.String value) 
  /*-{
    instance.@blazon.shared.shield.tinctures.Metal::colour = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.tinctures.Metal instance) throws SerializationException {
    setColour(instance, streamReader.readString());
    
    blazon.shared.shield.tinctures.TinctureImpl_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static blazon.shared.shield.tinctures.Metal instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new blazon.shared.shield.tinctures.Metal();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.tinctures.Metal instance) throws SerializationException {
    streamWriter.writeString(getColour(instance));
    
    blazon.shared.shield.tinctures.TinctureImpl_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return blazon.shared.shield.tinctures.Metal_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Metal_FieldSerializer.deserialize(reader, (blazon.shared.shield.tinctures.Metal)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Metal_FieldSerializer.serialize(writer, (blazon.shared.shield.tinctures.Metal)object);
  }
  
}
