package blazon.shared.shield.tinctures;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Tinctures_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getTincturesOnLayer(blazon.shared.shield.tinctures.Tinctures instance) /*-{
    return instance.@blazon.shared.shield.tinctures.Tinctures::tincturesOnLayer;
  }-*/;
  
  private static native void setTincturesOnLayer(blazon.shared.shield.tinctures.Tinctures instance, java.util.List value) 
  /*-{
    instance.@blazon.shared.shield.tinctures.Tinctures::tincturesOnLayer = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.tinctures.Tinctures instance) throws SerializationException {
    setTincturesOnLayer(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static blazon.shared.shield.tinctures.Tinctures instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new blazon.shared.shield.tinctures.Tinctures();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.tinctures.Tinctures instance) throws SerializationException {
    streamWriter.writeObject(getTincturesOnLayer(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return blazon.shared.shield.tinctures.Tinctures_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Tinctures_FieldSerializer.deserialize(reader, (blazon.shared.shield.tinctures.Tinctures)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Tinctures_FieldSerializer.serialize(writer, (blazon.shared.shield.tinctures.Tinctures)object);
  }
  
}
