package Parser;

public class ResMessage extends Message {
	
	public ResMessage(String b){
		super.addHeaderType("RES");
		super.body = b;
	}
}
