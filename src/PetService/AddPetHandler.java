package PetService;
import java.lang.reflect.InvocationTargetException;

public class AddPetHandler extends Handler {

	public AddPetHandler(AnimalList t) {
		super(t);
	}

	@Override
	public int execute(String input) {
		String name =  input.split(":")[0];
		String type =  input.split(":")[1];
		try {
			Class<?> petClass = Class.forName(type);
			if(name.isEmpty()) {
				System.out.println("Name must not be empty.");
				return 0;
			}
			Animal pet = (Animal)petClass.getConstructor(new Class[] { String.class }).newInstance(name);
			super.addToList(pet);
		} catch ( InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			System.out.println("Error Creating Pet");
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			System.out.println("Cannot spawn. Animal Currently extinct.");
		}
		return 0;
	}

}
