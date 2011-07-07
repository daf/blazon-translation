package blazon.shared.shield.tinctures;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Fur_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getFurType(blazon.shared.shield.tinctures.Fur instance) /*-{
    return instance.@blazon.shared.shield.tinctures.Fur::furType;
  }-*/;
  
  private static native void setFurType(blazon.shared.shield.tinctures.Fur instance, java.lang.String value) 
  /*-{
    instance.@blazon.shared.shield.tinctures.Fur::furType = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.tinctures.Fur instance) throws SerializationException {
    setFurType(instance, streamReader.readString());
    
    blazon.shared.shield.tinctures.TinctureImpl_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static blazon.shared.shield.tinctures.Fur instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new blazon.shared.shield.tinctures.Fur();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.tinctures.Fur instance) throws SerializationException {
    streamWriter.writeString(getFurType(instance));
    
    blazon.shared.shield.tinctures.TinctureImpl_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return blazon.shared.shield.tinctures.Fur_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Fur_FieldSerializer.deserialize(reader, (blazon.shared.shield.tinctures.Fur)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Fur_FieldSerializer.serialize(writer, (blazon.shared.shield.tinctures.Fur)object);
  }
  
}
