import java.lang.reflect.Constructor;
import java.util.LinkedList;

import javax.management.ReflectionException;


public class HeroFactory {
	private LinkedList<Class<? extends Hero>> characters;
	private static HeroFactory instance;
	

	private HeroFactory(){
		characters = new LinkedList<Class<? extends Hero>>();
	}
	
	public static HeroFactory getInstance(){
		if(instance == null)
			instance = new HeroFactory();
		return instance;
	}

	
	public Hero getCharacter(int characterIndex, String playerName) throws ReflectionException, ReflectiveOperationException, SecurityException {
		
		Class<? extends Hero> productClass = (Class<? extends Hero>)characters.get(characterIndex);
		Constructor<? extends Hero> productConstructor = productClass.getDeclaredConstructor(new Class[]{String.class});
		return (Hero)productConstructor.newInstance(new Object[] {playerName});
	}


	public void registerCharacter(int position, Class<? extends Hero> characterClass) {
		characters.add(position,characterClass);
		
	}
	
	
	public String getRegisteredCharactersList(){
		String result = "";
		int i = 0;
		for(Class<? extends Hero> h : characters ){
			result += ++i + ". " + h.getSimpleName() + "\n";
		}
		return result;
	}

}
