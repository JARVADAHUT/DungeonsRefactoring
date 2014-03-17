

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster
{
	static 
	{
		MonsterFactory.getInstance().registerCharacter("gremlin",Gremlin.class);
		
		stats = new StatsTypes();
		
		stats.hitPoints = 70;
		stats.attackSpeed = 5;
		stats.chanceToHit = .8;
		stats.chanceToHeal = .4;
		stats.damageMin = 15;
		stats.damageMax = 30;
		stats.minHeal = 20;
		stats.maxHeal = 40;
	}

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", stats);
		super.attackFlavorText = " jab his kris at ";

    }//end constructor


}//end class Gremlin