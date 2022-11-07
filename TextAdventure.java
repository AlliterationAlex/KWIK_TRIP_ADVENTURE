import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;
  
  Boolean hasMoney = false;
  Boolean shoppingGlazer = false;
  Boolean exploringGlazer = false;
  Boolean outsideGlazer = false;
  Boolean stefanGlazer = false;
  Boolean bathroomGlazer = false;
  Boolean whiteGlazer = false;
  int count = 0;
  String input;
  int randInt;
  
  public TextAdventure()
  {
    console = new FancyConsole("Great Kwik Trip Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

   
    ourHero = new Player("Bob", 100, 0);
  }

  public void play()
  {
    
    console.setImage("3kwiktrip.png");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();
    ourHero.changeName(input);
    String name = ourHero.getName();
    
    System.out.println("\n" + name + ", You are on a very long road trip, and are exhausted from driving.\nNothing would make you feel better right now than some glazers and\nfriendly customer service.\nOf course, there's only one place to get that: Kwik Trip! Let's go inside.\n");
    input = inScanner.nextLine();
    
    console.setImage("3inside.jpg");
    System.out.println("\nWow, what a clean and inviting building! Let's go find those glazers.\n");
    input = inScanner.nextLine();

    console.setImage("glazer0.jpg");
    System.out.println("Oh no! Kwik Trip is out of glazers!\nA nearby employee tells you that there are six glazers left hidden around the store.\nCan you find them all to make a complete 6 pack?\n");
    input = inScanner.nextLine();
    
    console.setImage("3inside.jpg");
    System.out.println("Great! Let's find some glazers.");
    importantMethod();
  }



  
  public void importantMethod()
  {
  
    console.setImage("3inside.jpg");
    input = inScanner.nextLine();
    System.out.println("\n1 = Explore\n2 = Go Shopping\n3 = Go outside\n4 = Go to the bathroom\n");
    input = inScanner.nextLine();
    
    
    
    
    if (input.equals("1"))
    {
      randInt = (int)(Math.random() * 6) + 1;
      if (randInt == 1)
      {
        console.setImage("2crackedWheat.jpg");
        System.out.println("\nLook! A patch of cracked wheat bread out in the wild!\n");
      }
      else if (randInt == 2)
      {
        console.setImage("2eightGrain.jpg");
        System.out.println("\nYou found some eight grain bread! Can you name all eight grains?\n");
      }
      else if (randInt == 3)
      {
        console.setImage("2italian.jpg");
        System.out.println("\nYou encounter a lonesome loaf of italian bread grazing in a feild!\n");
      }
      else if (randInt == 4 && count == 5)
      {
        System.out.println("\nKwik Trip White Bread! On a whim, you ask it if it has seen any glazers lying around,\nand it shows you a glazer, it's most prized posession! What do you do?\n1 = steal the glazer\n2 = ask politely for the glazer.\n");
        randInt = (int)(Math.random() * 2) + 1;
        input = inScanner.nextLine();
        while (!input.equals("1") || !input.equals("2"))
          {
          System.out.println("You moron, you didn't enter 1 or 2!");
          input = inScanner.nextLine();
          }

        if (input.equals("1") && randInt == 1)
        {
          System.out.println("\nYou steal the glazer and run. The bread doesn't have legs, so it can't chase you.\n");
          whiteGlazer = true;
          glazer();
        }
        else if (input.equals("1") && randInt == 2)
        {
          System.out.println("\nYou reach for the glazer, but the white bread is one step ahead of you.\nIt has it's phone out and is calling the police, so you make a run for it.\n You get in your car and try to drive away, but your car explodes! It was a setup!\n");
        endBad();
        }
        else if (input.equals("2") && randInt == 1)
        {
          System.out.println("\nYou ask for the glazer, and the white bread says no and laughs at you.\nHow humiliating! You are so embarrased that you accidentally explode your car when driving away!\n");
        endBad();
        }
        else
        {
          System.out.println("\nYou ask for the glazer, and the white bread says yes! You got a glazer!\n");
          whiteGlazer = true;
          glazer();
        }
      }
      else if (randInt == 5)
      {
        console.setImage("3atm.jpg");
        System.out.println("\nThe Kwik Trip no fee atm! You decide to withdraw some money so you can pay for groceries.\n");
        hasMoney = true;
      }
      else if (!exploringGlazer)
      {
        System.out.println("\nYou went exploring the store, and found a glazer hiding in a raw chicken box!\n");
        exploringGlazer = true;
        glazer();
      }
      else
        System.out.println("\nYou search for glazers but don't find any.\n");
    }
    
    else if (input.equals("2"))
    {
      if (!hasMoney)
        System.out.println("\nBefore you go shopping, you check your pockets only to find you have no money!\n");
      else
      {
        System.out.println("\nYou find a special flavor of Kwik Trip dunkers, but they just aren't the same as glazers,\nso you move on.\n");
        randInt = (int)(Math.random() * 5) + 1;
        if (randInt == 1)
        {
          console.setImage("1blueberry.jpg");
        }
        else if (randInt == 2)
        {
          console.setImage("1chocolate.jpg");
        }
        else if (randInt == 3)
        {
          console.setImage("1cremeDream.jpg");
        }
        else if (randInt == 4)
        {
          console.setImage("1lemon.jpg");
        }
        else if (!shoppingGlazer)
        {
          System.out.println("\nYou went to fill up a drink, and a glazer popped out of the ice dispenser!\n");
          shoppingGlazer = true;
          glazer();
        }
        else
          System.out.println("\nYou search for glazers but don't find any.\n");
      }
    }
    else if (input.equals("3"))
    {
      randInt = (int)(Math.random() * 5) + 1;
      if (randInt == 1)
      {
        console.setImage("3gasPump.png");
        System.out.println("\nOh look! You found the gas pumps! Give yourself a pat on the back.\n");
      }
      else if (randInt == 2)
      {
        console.setImage("3sign.jpg");
        System.out.println("\nWoah, Kwik Trip has a no-fee ATM? I wonder where it is!\n");
      }
      else if (randInt == 3)
      {
        console.setImage("3hiringSign.jpg");
        System.out.println("\nLook! Kwik Trip is hiring! Do you want to apply?\n1 = yes\n2 = no\n");
        input = inScanner.nextLine();
        System.out.println("You think about it, then remember you are on a road trip and are a thousand miles from home.\n");
        
      }
      else if (randInt == 4)
      {
        console.setImage("3stefan.jpg");
        System.out.println("\nLook! Stefan is heading in for his shift! Say \"hi\" to Stefan!\n");
        input = inScanner.nextLine();
        if (input.equals("hi"))
        {
          System.out.println("/nStefan gave you a glazer because you said hi!\n");
          stefanGlazer = true;
          glazer();
        }
      }
      else if (!outsideGlazer)
      {
        System.out.println("\nYou went exploring outside, and found a glazer in one of the garbage cans!\n");
        outsideGlazer = true;
        glazer();
      }
      else
        System.out.println("\nYou search for glazers but don't find any.\n");
    }
    else if (input.equals("4"))
    {
      console.setImage("3bathroom.jpg");
      randInt = (int)(Math.random() * 2) + 1;
      if (randInt == 1 && !bathroomGlazer)
      {
        System.out.println("\nYou go to the bathroom, and find a glazer under one of the toilet seats!\n");
        bathroomGlazer = true;
        glazer();
      }
      else
      {
        System.out.println("\nWow, what a clean bathroom! Hey, what's that noise coming from the stall?\n");
        input = inScanner.nextLine();
        console.setImage("3methLab.png");
        System.out.println("Oh no, let's get out of here!");
        
      }

    }
    else
    {
      System.out.println("\nYou silly goose, you didn't enter a number 1-4. Try again!\n");
    }
  input = inScanner.nextLine();
  importantMethod();
  }



  
  
  public void glazer()
  {
    input = inScanner.nextLine();
    count = 0;
    if (shoppingGlazer)
      count ++;
    if (exploringGlazer)
      count ++;
    if (outsideGlazer)
      count ++;
    if (stefanGlazer)
      count ++;
    if (bathroomGlazer)
      count ++;
    if (whiteGlazer)
      count ++;
    if (count == 1)
    {
      console.setImage("glazer1.jpg");
      System.out.println("You got your first glazer! Only 5 more to go!");
    }
    else if (count == 2)
    {
      console.setImage("glazer2.jpg");
      System.out.println("You found the next glazer! Keep it up!");
    }
    else if (count == 3)
    {
      console.setImage("glazer3.jpg");
      System.out.println("Halfway there!");
    }
    else if (count == 4)
    {
      console.setImage("glazer4.jpg");
      System.out.println("4 down, 2 to go!");
    }
    else if (count == 5)
    {
      console.setImage("glazer5.jpg");
      System.out.println("So close!");
    }
    else
    {
      console.setImage("glazer6.jpg");
      System.out.println("You found all 6!");
      endGood();
    }
    input = inScanner.nextLine();
  }

  int i = 0;
  private void endBad()
  {
    console.setImage("3explosion.jpg");
    input = inScanner.nextLine();
    System.out.println("You have died. If you would like to play again, play again.");
    while (i != 100000)
      input = inScanner.nextLine();
    
  }

  private void endGood()
  {
    input = inScanner.nextLine();
    console.setImage("3stefan.jpg");
    System.out.println("You take your glazers to the register to purchase, and Stefan is your cashier!\n");
    randInt = (int)(Math.random() * 2) + 1;
    input = inScanner.nextLine();
    if (!hasMoney && randInt == 1)
        {
          System.out.println("As you are about to pay, you realise you don't have money, so you can't buy glazers!\nOh no!");
          endBad();
        }
        else if (!hasMoney)
        {
          System.out.println("As you are about to pay, you realise you don't have money, so you can't buy glazers!\nStefan says \"It's okay!\" and pays for you.\nTalk about good customer service!");
        }
        else
        {
          System.out.println("You buy your glazers and have a great drive home.\nTHE END");
     
        }
  }



}
