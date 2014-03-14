import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.management.ReflectionException;


public class HeroFactory {
	private Map<String,Class<Hero>> characters;
	private static HeroFactory instance;
	

	private HeroFactory(){
		characters = new LinkedHashMap<String,Class<Hero>>();
	}
	
	public static HeroFactory getInstance(){
		if(instance == null)
			instance = new HeroFactory();
		return instance;
	}

	public Hero getCharacter(String characterType) throws ReflectionException, ReflectiveOperationException, SecurityException {
		
		Class<Hero> productClass = (Class<Hero>)characters.get(characterType);
		Constructor productConstructor = productClass.getDeclaredConstructor(new Class[] { String.class });
		return (Hero)productConstructor.newInstance(new Object[] { });
	}


	public void registerCharacter(String characterName, Class characterClass) {
		characters.put(characterName, characterClass);
		
	}

}
