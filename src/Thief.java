

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{
	
	static 
	{
		HeroFactory.getInstance().registerCharacter(2,Thief.class);
		
		stats = new StatsTypes();
		
		stats.hitPoints = 75;
		stats.attackSpeed = 6;
		stats.chanceToHit = .8;
		stats.damageMin = 20;
		stats.damageMax = 40;
		stats.chanceToBlock = .5;
	}
	
    public Thief(String playerName)
	{
		super(stats, playerName, new ThiAttack());
		super.attackFlavorText = " stabs the shit out of ";


    }//end constructor
}