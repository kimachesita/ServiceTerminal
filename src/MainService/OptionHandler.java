package MainService;

public class OptionHandler extends Handler {

	private Integer key;
	
	public OptionHandler(Integer i) {
		key = i;
	}

	@Override
	public int execute() {
		return key;
	}
}
