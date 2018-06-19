package Parser;

public class ReqMessage extends Message {
	
	public ReqMessage(String b){
		super.type = "REQ";
		super.body = b;
	}
}
