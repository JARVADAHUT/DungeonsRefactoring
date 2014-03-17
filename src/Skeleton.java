

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster
{
	static 
	{
		MonsterFactory.getInstance().registerCharacter("skeleton",Skeleton.class);
		
		stats = new StatsTypes();
		
		stats.hitPoints = 100;
		stats.attackSpeed = 3;
		stats.chanceToHit = .8;
		stats.chanceToHeal = .3;
		stats.damageMin = 30;
		stats.damageMax = 50;
		stats.minHeal = 30;
		stats.maxHeal = 50;
	}

    public Skeleton()
	{
		super("Sargath the Skeleton", stats);
		super.attackFlavorText = " slices his rusty blade at ";
    }//end constructor


}//end class Skeleton