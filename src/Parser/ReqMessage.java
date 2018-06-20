package Parser;

public class ReqMessage extends Message {
	
	public ReqMessage(String b){
		super.addHeaderType("REQ");
		super.body = b;
	}
}
