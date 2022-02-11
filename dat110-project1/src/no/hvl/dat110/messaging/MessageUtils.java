package no.hvl.dat110.messaging;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin layer
		
		//hente data en gong!!!
		
		data = message.getData();
		
		int lengda = data != null ? data.length : 0;
	
		byte leng = (byte)lengda;

		segment = new byte[MessageConfig.SEGMENTSIZE];
		
		segment[0] = leng;
		
		for(int i = 0; i < leng; i++) {
			segment[i+1] = data[i];
		}
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// TODO - START
		// decapsulate segment and put received data into a message
		
		int len = segment[0];
		
		byte[] data = new byte[len];
		
		for(int i = 0; i < len; i++) {
			data[i] = segment[i+1];
		}
		message = new Message(data);
		// TODO - END
		
		return message;
		
	}
	
}
