package blazon.shared.shield;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Shield_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native blazon.shared.shield.ShieldLayer getBase(blazon.shared.shield.Shield instance) /*-{
    return instance.@blazon.shared.shield.Shield::base;
  }-*/;
  
  private static native void setBase(blazon.shared.shield.Shield instance, blazon.shared.shield.ShieldLayer value) 
  /*-{
    instance.@blazon.shared.shield.Shield::base = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.Shield instance) throws SerializationException {
    setBase(instance, (blazon.shared.shield.ShieldLayer) streamReader.readObject());
    
  }
  
  public static blazon.shared.shield.Shield instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new blazon.shared.shield.Shield();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.Shield instance) throws SerializationException {
    streamWriter.writeObject(getBase(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return blazon.shared.shield.Shield_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    blazon.shared.shield.Shield_FieldSerializer.deserialize(reader, (blazon.shared.shield.Shield)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    blazon.shared.shield.Shield_FieldSerializer.serialize(writer, (blazon.shared.shield.Shield)object);
  }
  
}
