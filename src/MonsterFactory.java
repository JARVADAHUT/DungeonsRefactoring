import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.management.ReflectionException;


public class MonsterFactory {
	private Map<String,Class<Monster>> characters;
	private static MonsterFactory instance;
	

	private MonsterFactory(){
		characters = new LinkedHashMap<String,Class<Monster>>();
	}
	
	public static MonsterFactory getInstance(){
		if(instance == null)
			instance = new MonsterFactory();
		return instance;
	}
	
	public Monster getCharacter(String characterType) throws ReflectionException, ReflectiveOperationException, SecurityException {
		
		Class<Monster> productClass = (Class<Monster>)characters.get(characterType);
		Constructor productConstructor = productClass.getDeclaredConstructor(new Class[] { String.class });
		return (Monster)productConstructor.newInstance(new Object[] { });
	}


	public void registerCharacter(String characterName, Class characterClass) {
		characters.put(characterName, characterClass);
		
	}

}
