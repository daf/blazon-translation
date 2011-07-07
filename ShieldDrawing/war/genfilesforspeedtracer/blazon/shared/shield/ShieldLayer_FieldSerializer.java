package blazon.shared.shield;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ShieldLayer_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native blazon.shared.shield.ShieldLayer getNextLayer(blazon.shared.shield.ShieldLayer instance) /*-{
    return instance.@blazon.shared.shield.ShieldLayer::nextLayer;
  }-*/;
  
  private static native void setNextLayer(blazon.shared.shield.ShieldLayer instance, blazon.shared.shield.ShieldLayer value) 
  /*-{
    instance.@blazon.shared.shield.ShieldLayer::nextLayer = value;
  }-*/;
  
  private static native blazon.shared.shield.tinctures.Tinctures getTinctures(blazon.shared.shield.ShieldLayer instance) /*-{
    return instance.@blazon.shared.shield.ShieldLayer::tinctures;
  }-*/;
  
  private static native void setTinctures(blazon.shared.shield.ShieldLayer instance, blazon.shared.shield.tinctures.Tinctures value) 
  /*-{
    instance.@blazon.shared.shield.ShieldLayer::tinctures = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.ShieldLayer instance) throws SerializationException {
    setNextLayer(instance, (blazon.shared.shield.ShieldLayer) streamReader.readObject());
    setTinctures(instance, (blazon.shared.shield.tinctures.Tinctures) streamReader.readObject());
    
  }
  
  public static blazon.shared.shield.ShieldLayer instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new blazon.shared.shield.ShieldLayer();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.ShieldLayer instance) throws SerializationException {
    streamWriter.writeObject(getNextLayer(instance));
    streamWriter.writeObject(getTinctures(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return blazon.shared.shield.ShieldLayer_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    blazon.shared.shield.ShieldLayer_FieldSerializer.deserialize(reader, (blazon.shared.shield.ShieldLayer)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    blazon.shared.shield.ShieldLayer_FieldSerializer.serialize(writer, (blazon.shared.shield.ShieldLayer)object);
  }
  
}
