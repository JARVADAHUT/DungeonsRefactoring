import java.util.Scanner;



/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	protected int numTurns;
	protected ISpecialAttack specialAttackBehavior;
	private static Scanner kb = new Scanner(System.in);
//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(StatsTypes stats, String playerName, ISpecialAttack atk)
  {
	  
	super(stats);
	this.chanceToBlock = stats.chanceToBlock;
	super.name = playerName;
	
	specialAttackBehavior = atk;
  }

  public void incrementNumTurns()
  {
	  numTurns++;
  }
  
/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  //public void readName()
  //{
  //	System.out.print("Enter character name: ");//-------------------------------------------------------------------------------------- Moved this whole method to Dungeon AM
  //	name = Keyboard.readString();
  //}//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2." + specialAttackBehavior.getSpecialDescription());
		    System.out.print("Choose an option: ");
		    
		    choice = 1;
		    
		    try
		    {
		    	choice = kb.nextInt();
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Ha, you tried to put in invalid input. So just to piss you off we defaulted it to Attack Opponent.");
		    	
		    }
		    kb.nextLine();
		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: specialAttackBehavior.preformSpecial(this, opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		    if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);

	}//end battleChoices

}//end Hero class