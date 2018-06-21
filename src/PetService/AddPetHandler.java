package PetService;

import java.lang.reflect.InvocationTargetException;
public class AddPetHandler extends Handler {
	
	public AddPetHandler(AnimalList t, IOInterface o) {
		super(t, o);
		description = "Add pet to list. Syntax \"add name:Pet\"";
	}

	@Override
	public int execute(String input) {
		if(!input.matches("\\w+:.+")) {
			io.writeln("Invalid Parameters. Try \"add name:Pet\"");
			return 0;
		}
		String name =  input.split(":")[0];
		String type =  input.split(":")[1];
		try {
			Class<?> petClass = Class.forName("PetService." + type);
			
			if(name.isEmpty()) {
				io.writeln("Name must not be empty.");
			}
			
			Animal pet = (Animal)petClass.getConstructor(String.class, IOInterface.class ).newInstance(name, io);
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




