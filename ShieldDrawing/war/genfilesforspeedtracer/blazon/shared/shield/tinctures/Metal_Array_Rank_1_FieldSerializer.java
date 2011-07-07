package blazon.shared.shield.tinctures;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Metal_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, blazon.shared.shield.tinctures.Metal[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static blazon.shared.shield.tinctures.Metal[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new blazon.shared.shield.tinctures.Metal[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, blazon.shared.shield.tinctures.Metal[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return blazon.shared.shield.tinctures.Metal_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Metal_Array_Rank_1_FieldSerializer.deserialize(reader, (blazon.shared.shield.tinctures.Metal[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    blazon.shared.shield.tinctures.Metal_Array_Rank_1_FieldSerializer.serialize(writer, (blazon.shared.shield.tinctures.Metal[])object);
  }
  
}
