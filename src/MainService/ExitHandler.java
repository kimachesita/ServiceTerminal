package MainService;

public class ExitHandler extends Handler {

	public ExitHandler() {
		description = "Exits service and disconnects from the server";
	}

	@Override
	public int execute() {
		return -1;
	}

}
