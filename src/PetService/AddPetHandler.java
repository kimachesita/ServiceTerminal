package PetService;

import java.lang.reflect.InvocationTargetException;
public class AddPetHandler extends Handler {
	
	private String packageName = "PetService.";
	
	public AddPetHandler(AnimalList t, IOInterface o) {
		super(t, o);
	}

	@Override
	public int execute(String input) {
		String name =  input.split(":")[0];
		String type =  input.split(":")[1];
		try {
			Class<?> petClass = Class.forName(packageName + type);
			if(name.isEmpty()) {
				io.writeln("Name must not be empty.");
			}
			Animal pet = (Animal)petClass.getConstructor(new Class[] { java.lang.String.class }).newInstance(name);
			super.addToList(pet);
		} catch ( InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			io.writeln("Error Creating Pet");
			//System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			//e.printStackTrace();
			io.writeln("Cannot spawn. Animal Currently extinct.");
		}
		return 0;
	}
}




