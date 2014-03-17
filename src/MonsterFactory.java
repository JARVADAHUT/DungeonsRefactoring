import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.management.ReflectionException;


public class MonsterFactory {
	private Map<String,Class<?extends Monster>> characters;
	private static MonsterFactory instance;
	

	private MonsterFactory(){
		characters = new LinkedHashMap<String,Class<?extends Monster>>();
	}
	
	public static MonsterFactory getInstance(){
		if(instance == null)
			instance = new MonsterFactory();
		return instance;
	}
	
	public Monster getCharacter(String characterType) throws ReflectionException, ReflectiveOperationException, SecurityException {
		
		Class<?extends Monster> productClass = (Class<?extends Monster>)characters.get(characterType);
		Constructor<?extends Monster> productConstructor = productClass.getDeclaredConstructor(new Class[] { String.class });
		return (Monster)productConstructor.newInstance(new Object[] { });
	}


	public void registerCharacter(String characterName, Class<?extends Monster> characterClass) {
		characters.put(characterName, characterClass);
		
	}

}
