

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Ogre extends Monster
{
	static 
	{
		MonsterFactory.getInstance().registerCharacter("ogre",Ogre.class);

		stats = new StatsTypes();
		
		stats.hitPoints = 200;
		stats.attackSpeed = 2;
		stats.chanceToHit = .6;
		stats.chanceToHeal = .1;
		stats.damageMin = 30;
		stats.damageMax = 50;
		stats.minHeal = 30;
		stats.maxHeal = 50;
		
	}

    public Ogre()
	{
		super("Oscar the Ogre", stats);
		super.attackFlavorText = " slowly swings a club toward's ";

    }//end constructor


}//end Monster class