package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		
		int a = payload != null ? payload.length:0;
		
		rpcmsg = new byte[a + 1];
		
		rpcmsg[0] = rpcid;
		
		for(int i = 0; i < a; i++) {
			rpcmsg[i+1] = payload[i];
		}
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		
		int len = rpcmsg.length - 1;
		byte[] payload = new byte[len];
		
		for (int i = 0; i < len; i++) {
			payload[i] = rpcmsg[i+1];
		}
		
		return payload;
		
	}
	
	public static byte[] marshallString(String str) {
		
		byte[] encoded = new byte[2];
		
		// TODO - START 
		
		encoded = str.getBytes();
		
		// TODO - END
		
		return encoded;
	}
	
	public static String unmarshallString(byte[] data) {
		
		
		// TODO - START 
		
		String decoded = new String(data);
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		return null;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		
		return;
		
	}
	
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}
	
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}
	
	public static byte[] marshallInteger(int x) {
		
		
		ByteBuffer bb = ByteBuffer.allocate(Integer.BYTES); 
	    bb.putInt(x); 
		
		return bb.array();
	}
	
	
	public static int unmarshallInteger(byte[] data) {
		
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
	    return byteBuffer.getInt();
		
	}
}
