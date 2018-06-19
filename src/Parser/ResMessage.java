package Parser;

public class ResMessage extends Message {
	
	public ResMessage(String b){
		super.type = "RES";
		super.body = b;
	}
}
