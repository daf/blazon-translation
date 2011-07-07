package blazon.shared.shield.tinctures;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TinctureImpl_FieldSerializer {
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.tinctures.TinctureImpl instance) throws SerializationException {
    instance.colour1 = streamReader.readString();
    instance.colour2 = streamReader.readString();
    instance.name = streamReader.readString();
    
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.tinctures.TinctureImpl instance) throws SerializationException {
    streamWriter.writeString(instance.colour1);
    streamWriter.writeString(instance.colour2);
    streamWriter.writeString(instance.name);
    
  }
  
}
