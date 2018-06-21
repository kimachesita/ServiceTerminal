package MainService;

import java.io.IOException;

public abstract class Handler {
	public String description;
	public abstract int execute() throws IOException;
}
