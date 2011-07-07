package blazon.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class ShieldDrawingService_Proxy extends RemoteServiceProxy implements blazon.client.ShieldDrawingServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "blazon.client.ShieldDrawingService";
  private static final String SERIALIZATION_POLICY ="896E3C89DC87DA7BEF2648F031346BE7";
  private static final blazon.client.ShieldDrawingService_TypeSerializer SERIALIZER = new blazon.client.ShieldDrawingService_TypeSerializer();
  
  public ShieldDrawingService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "draw", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void createShieldRepresentation(java.lang.String input, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ShieldDrawingService_Proxy.createShieldRepresentation", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      if (getRpcToken() != null) {
        streamWriter.writeObject(getRpcToken());
      }
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("createShieldRepresentation");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(input);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("ShieldDrawingService_Proxy.createShieldRepresentation",  "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ShieldDrawingService_Proxy.createShieldRepresentation", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
