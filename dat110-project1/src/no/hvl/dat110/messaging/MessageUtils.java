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
		
		data = new byte[MessageConfig.SEGMENTSIZE];
		
		int paylength = message.getData().length;

		data[0] = (byte)paylength;
		
		for(int i = 0; i < message.getData().length; i++) {
			data[i+1] = message.getData()[i];
		}
		// TODO - END
		return data;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// TODO - START
		// decapsulate segment and put received data into a message
		
		byte[] data = new byte[segment[0]];
		
		for(int i = 0; i < segment[0]; i++) {
			data[i] = segment[i+1];
		}
		message = new Message(data);
		// TODO - END
		
		return message;
		
	}
	
}
