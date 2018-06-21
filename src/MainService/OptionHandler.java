package MainService;

public class OptionHandler extends Handler {

	private Integer key;
	
	public OptionHandler(Integer i, String d) {
		key = i;
		description = d;
	}

	@Override
	public int execute() {
		return key;
	}
}
