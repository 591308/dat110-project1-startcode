package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		
		rpcmsg = new byte[payload.length+1];
		
		rpcmsg[0] = rpcid;
		
		for(int i = 0; i < payload.length; i++) {
			rpcmsg[i+1] = payload[i];
		}
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		
		payload = new byte[rpcmsg.length-1];
		
		for(int i = 0; i < rpcmsg.length-1; i++) {
			payload[i] = rpcmsg[i+1];
		}
		
		
		// TODO - END
		
		return payload;
		
	}
	
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		encoded = new byte[1+str.getBytes().length];
		
		encoded[0] = (byte) str.getBytes().length;
		
		for(int i = 0; i < str.getBytes().length; i++) {
			encoded[i+1] = str.getBytes()[i];
		}
		
		// TODO - END
		
		return encoded;
	}
	
	public static String unmarshallString(byte[] data) {
		
		
		// TODO - START 
		
		String decoded = new String(Arrays.copyOfRange(data, 1, data.length));
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		
		// TODO - START 
		byte[] encoded = new byte[0];
		
		// TODO - END
		
		return encoded;
		
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
		
		
		// TODO - START 
		
		byte[] encoded = new byte[5];
		
		byte[] b = ByteBuffer.allocate(4).putInt(x).array();

		for(int i = 1; i< encoded.length; i++) {
			encoded[i] = b[i-1];
		}

		// TODO - END
		
		return encoded;
	}
	
	
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		decoded = ByteBuffer.wrap(Arrays.copyOfRange(data, 1, data.length)).getInt();
		// TODO - END
		
		return decoded;
		
	}
}
