

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */




public class Warrior extends Hero
{

	static 
	{
		HeroFactory.getInstance().registerCharacter(1,Warrior.class);
		
		stats = new StatsTypes();
		
		stats.hitPoints = 125;
		stats.attackSpeed = 4;
		stats.chanceToHit = .8;
		stats.damageMin = 35;
		stats.damageMax = 60;
		stats.chanceToBlock = .2;
	}
	
    public Warrior(String playerName)
	{
		super(stats, playerName, new WarAttack());
		super.attackFlavorText = " swings a mighty sword at ";
    }//end constructor


}//end Hero class