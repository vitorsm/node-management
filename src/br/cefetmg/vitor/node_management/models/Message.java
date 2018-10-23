package br.cefetmg.vitor.node_management.models;


public enum Message {
	
	REQUEST_STATUS(1),
	RESPONSE_STATUS_IDLE(2),
	RESPONSE_STATUS_BUSY(3),
	NEW_EXECUTOR(4);
	
	private final int value;
	
	Message(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}
	
	public static Message toMessageType(int value) {
		
		for (Message message : Message.values()) {
			if (message.value == value)
				return message;
		}
		
		return null;
	}
}
