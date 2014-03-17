

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	
	static 
	{
		HeroFactory.getInstance().registerCharacter(3,Sorceress.class);
		
		stats = new StatsTypes();
		
		stats.hitPoints = 75;
		stats.attackSpeed = 5;
		stats.chanceToHit = .7;
		stats.damageMin = 25;
		stats.damageMax = 50;
		stats.chanceToBlock = .3;
	}
	
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress(String playerName)
	{
		super(stats, playerName, new SorAttack());
		super.attackFlavorText = " casts a spell of fireball at ";

    }//end constructor

//-----------------------------------------------------------------
	/*
	 * Abstracted up to base class
	
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: increaseHitPoints();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		    if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);

    }//end overridden method
    
    */

}//end class