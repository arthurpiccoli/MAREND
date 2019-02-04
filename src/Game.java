import java.util.HashMap;
import java.util.Map;

/**
 * Cria e inicializa todas outras classes do jogo, inicializando assim o jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Hero hero;
    private Map<String, Buyable> store;
        
    /**
     * Método construtor da classe Game.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        hero = new Hero("You", 8, 1, 0);
        store = new HashMap();
        createStore();      
        
    }
    
    /**
     * Cria a loja do jogo.
     */
    private void createStore(){
        Buyable revolver = new Buyable(new Weapon("revolver", "a revolver that was used by Django himself", 10, 500), 500);
        Buyable cake = new Buyable(new Consumable("cake", "the cake, that cake", 0, 0), 50);
        Buyable cloak = new Buyable(new Armor("cloak", "a cloak that will make you almost invencible", 2, 1000), 1000);
        Buyable cheese = new Buyable(new Consumable("cheese", "a piece of cheese, use DoTA for reference", 3, 1000), 10);
        Buyable potion = new Buyable(new Consumable("potion", "a potion like any other potion in RPGs", 1, 50), 50);
                
        store.put("revolver", revolver);
        store.put("cake", cake);
        store.put("cloak", cloak);
        store.put("cheese", cheese);
        store.put("potion", potion);
    }
    
    /**
     * Cria as salas do jogo.
     */
    private void createRooms()
    {
        Room living, kitchen, corridor, basementFront, bathroom, bedroom, yard, outside, basement, store2,
                underworld, store1, bifurcation1, forest, valley, bifurcation2, dungeon, castle, backroom, castleFront;
      
        // create the rooms
        //House
        living = new Room("in a regular living room with a giant 55'' TV");
        kitchen = new Room("in a kitchen, here's suposed to have food and everything you could forgot in here");
        corridor = new Room("in a corridor that leads to your bedroom and the bathroom");
        bathroom = new Room("in a bathroom, maybe there's something useful here");
        bedroom = new Room("in in your bedroom, pick your stuff");
        yard = new Room("in the front yard, you can go back inside for an marvelous adventure or go outside for the real world");
        outside = new Room("GAME OVER");
        basement = new Room("in the basement, this may have been closed for decades");
        basementFront = new Room("in front of the basement, but first you must have the key to open it");
        
        //Underworld
        underworld = new Room("in the underworld, maybe you shouldn't have opened that can");
        store1 = new Room("STORE");
        store2 = new Room("STORE");
        bifurcation1 = new Room("with an option ahead of you, choose wisely, you can't come back,\nYou can go left for an enchantred forest or right for a death valley");
        forest = new Room("in the forest, just 'cause it's enchantred doesn't mean it has good things");
        valley = new Room("DEAD");   
        bifurcation2 = new Room("almost there, you kind of made it through the most dificult part of the game");
        dungeon = new Room("in the dungeon, maybe you'll find some skeletons, like any RPG");
        castleFront = new Room("in front of brand new castle, but you need a lever to open it,\n"
                + "That's why there's a dungeon in the other direction");
        castle = new Room("in Mr. Cthulu's King of the Underworld and Root of the Evil Castle, do your best now");
        backroom = new Room("in Cthulu's bedroom maybe, I don't know if these kind of criature sleeps anyway.\n"
                + "But hey, here's your controller");
        
        //room exits
        //House
        living.setExit("kitchen", kitchen);
        living.setExit("corridor", corridor);
        living.setExit("yard", yard);
        living.setExit("basement", basementFront);
        
        basementFront.setExit("back", living);
        basement.setExit("back", living);
        
        corridor.setExit("back", living); 
        corridor.setExit("bedroom", bedroom);
        corridor.setExit("bathroom", bathroom);
        
        bathroom.setExit("back", corridor);
        bedroom.setExit("back", corridor);

        yard.setExit("inside", living);
        yard.setExit("outside", outside);
        
        kitchen.setExit("back", living);
        
        //Underworld
        underworld.setExit("upworld", basement);
        underworld.setExit("store", store1);
        underworld.setExit("track", bifurcation1);
        
        bifurcation1.setExit("forest", forest);
        bifurcation1.setExit("valley", valley);
        bifurcation1.setExit("back", underworld);
        
        store1.setExit("back", underworld);
        store2.setExit("back", bifurcation2);
        
        forest.setExit("track", bifurcation2);
        
        valley.setExit("track", bifurcation2);
        
        bifurcation2.setExit("dungeon", dungeon);
        bifurcation2.setExit("castle", castleFront);
        bifurcation2.setExit("store", store2);
        
        dungeon.setExit("back", bifurcation2);
        
        castleFront.setExit("back", bifurcation2);  
        castle.setExit("backroom", backroom);
        
        //Enemys
        Character elf = new Enemy("elf", 10, 2, 250);
        Character tree = new Enemy("tree", 20, 3, 750);
        Boss mushroom = new Boss("mushroom", 30, 5, new Consumable("allucinogen", "use it... you'll see", 1, -5));
        
        Character skull = new Enemy("skull", 40, 1, 100);
        Character goblin = new Enemy("goblin", 30, 3, 300);
        Boss skeleton = new Boss("skeleton", 50, 10,  new Weapon("bone", "a leg bone to use as a weapon", 3, 100));                          
        
        Boss cthulhu = new Boss("cthulhu", 1000, 1000, new Item("staff", "staff of universal omniscience!\nYou can use it to discover where is your controller", 4));
        
        forest.setEnemy(elf);
        forest.setEnemy(tree);
        forest.setEnemy(mushroom);
        
        dungeon.setEnemy(skeleton);
        dungeon.setEnemy(goblin);
        dungeon.setEnemy(skull);
        
        castle.setEnemy(cthulhu);
        
        //Items and Gold
        
        Item plunger = new Weapon("plunger", "a plunger that should be used just in case shit happens", 3, 8);
        bathroom.setItem(plunger);
       
        Item hoodie = new Armor("hoodie", "a hoodie your grandma gave you on last christmas", 6, 30);
        bedroom.setItem(hoodie);
        bedroom.addGold(160);

        Item controller = new Item("controller", "your so beloved controller, CONGRATULATIONS, you've beaten the game", 0);
        backroom.setItem(controller);
        
        Item pie = new Consumable("pie", "food used to restore your miserable life", 1, 10);
        kitchen.setItem(pie);

        Item coke = new Consumable("coke", "drink a lot, it's just give a cancer", 2, 5);
        kitchen.setItem(coke);        
                 
        //Keys
        Item can= new Key ("can", "a coke can dated back to the 80s, use it, just do it", 1, basement, underworld, "portal", "That can actually opened a portal, who know what is inside of it!");
        basement.setItem(can);
         
        Item key= new Key ("key", "a key to the basement", 1, basementFront, basement, "in", "You've opened the door!");
        kitchen.setItem(key);    
        
        Item lever= new Key ("lever", "a lever to the castle", 1, castleFront, castle, "in", "You've opened the castle!");
        dungeon.setItem(lever);
        
        currentRoom = living;  // começa o jogo na sala de estar
  
        
    }

    /**
     *  Rotina play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            
            //testa se ta na sala q acaba o jogo ou pegou o controle
           if("GAME OVER".equals(currentRoom.getShortDescription()))
               finished = true;
           if(hero.getItem("controller")!=null)
               finished = true;
        }
        System.out.println("That's all Folks!");
    }

    /**
     * Imprime a mensagem de boas vindas ao jogador.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the Mighty Andventures of the Regular Everyday Normal Dude!");
        System.out.println("The controller for your TV is missing, today's mission is to find it.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println(currentRoom.getLongDescription());
        System.out.println(hero.getInventoryString());
    }

    /**
     * Dá e processa os comandos do jogo.
     * @param command
     * @return Verdadeiro se o comando encerra o jogo, falso em outras situações.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(null != commandWord) switch (commandWord) {
            case UNKNOWN:
                System.out.println("Dafuq you said?");
                return false;
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case ATTACK:
                attack(command);
                break;
            case PICK:
                pickItem(command);
                break;
            case USE:
                useItem(command);
                break;
            case DROP:
                dropItem(command);
                break;
            default:
                break;
        }
        return wantToQuit;
    }
    
    /**
     * Pega item da sala.
     * @param command 
     */
    private void pickItem(Command command){
        
        if (!command.hasSecondWord()) {
    		System.out.println("Pick what?");
    		return;
    	}
        
        String itemName = command.getSecondWord();
        if("gold".equals(itemName)){
            hero.addGold(currentRoom.getGold());
            System.out.println(currentRoom.getLongDescription());
            System.out.println(hero.getInventoryString());
            return;
        }
        
        Item item;
        if("STORE".equals(currentRoom.getShortDescription())){
            Buyable buyable = (Buyable) store.get(itemName);
            if(buyable != null){
                item=buyable.getItem();
                if(buyable.getPrice()>hero.getGold()){
                    System.out.println("You don't have that much gold");
                }
                else{
                    if(hero.calculateWeight() + item.getWeight() <= hero.maxWeight){
                        hero.addGold(-(buyable.getPrice()));
                        hero.setItem(item, currentRoom);
                        store.remove(itemName);
                        System.out.println(hero.getInventoryString());
                        String returnString = "\nStore:";
                        for(String name : store.keySet()) {
                            returnString += "\nItem: " + name + "\nPrice: " + store.get(name).getPrice() +"\n";
                        }
                        System.out.println(returnString);
                    }
                    else
                        System.out.println("You are too heavy, drop your stuff outside and comeback!");
                }
            }
            else
                System.out.println("There's no '"+ command.getSecondWord() +"' for you to buy here.");
        }
        else{
            item=currentRoom.getItem(itemName);
            if (item != null) 
                hero.setItem(item, currentRoom);            
            else
                System.out.println("There's no '"+ command.getSecondWord() +"' in the current room.");
        }
    }
    
    /**
     * Dropa o item na sala,
     * @param command 
     */
    private void dropItem(Command command){
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
    	}
        
        if("STORE".equals(currentRoom.getShortDescription()))
            System.out.println("You can't drop things here, it's a store, think a little bit for god's sake!");
        else{        
            String itemName = command.getSecondWord();
            Item item =hero.getItem(itemName);

            if (item != null) {
                System.out.println("You've dropped " + item.getDescription());
                if("class Armor".equals(item.getClass().toString())){
                    hero.setDefaultArmor();
                } else if("class Weapon".equals(item.getClass().toString())){
                    hero.setDefaultDamage();
                }
                currentRoom.setItem(item);
                hero.removeItem(itemName);
            }
        }
    }
    
    /**
     * Usa item.
     * @param command 
     */
    private void useItem(Command command){
        if (!command.hasSecondWord()) {
            System.out.println("Use what?");
            return;
    	}
        
        String itemName = command.getSecondWord();        
        Item item = hero.getItem(itemName);
        
        if (item != null) {
            if(null != item.getClass().toString())switch (item.getClass().toString()) {
                case "class Key":
                    hero.useKey((Key) item, currentRoom);
                    break;
                case "class Armor":
                    hero.useArmor((Armor) item);
                    break;
                case "class Weapon":
                    hero.useWeapon((Weapon) item);
                    break;
                case "class Consumable":
                    hero.useConsumable((Consumable) item);
                    break;
                default:
                    System.out.println("Your controller is in the next room, omniscience rules!");
                    break;
            }
        }
    }
    
    /**
     * Imprime na tela as informações de ajuda.
     */
    
    private void printHelp(){
        System.out.println("You are desperated to watch TV!");
        System.out.println("Find your controller.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Vai para a nova sala ou exibe uma mensagem de erro.
     */
    private void goRoom(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There's nothing with that name that you can go from here!");
        }
        else {            
            if(!hero.isDead()){
                if(!"[]".equals(currentRoom.getEnemiesMap().keySet().toString())){
                    System.out.println("You must first fight the enemies!");
                    return;
                }
            }
            
            currentRoom.getEnemiesMap().keySet().toString();
            currentRoom = nextRoom;
            
            if("STORE".equals(currentRoom.getShortDescription())){
                System.out.println("\nYou are in a store, capitalism in underworld is a thing too!");
                System.out.println("For you to pick items here you must have enough gold (oh really?).\n");
                System.out.println(hero.getInventoryString());
                String returnString = "\nStore:";
                for(String name : store.keySet()) {
                    returnString += "\nItem: " + name + "\nPrice: " + store.get(name).getPrice() +"\n";
                }
                System.out.println(returnString);
            }
            else if("GAME OVER".equals(currentRoom.getShortDescription())){
                System.out.println("\n"+ currentRoom.getShortDescription());
                System.out.println("\nYou chose to go out and get a life!\n"
                        + "This game is not intended for you!\nNext time just search for the damn controller!");
            }
            else if("DEAD".equals(currentRoom.getShortDescription())){
                hero.kill();
                System.out.println("\nThat death word in Death valley actually means DEATH!\nSo as you may have detucted already:");
                System.out.println("You are dead!\nBut the upworld rules means nothing here, so go on, enjoy 'life' without a body!");
                System.out.println("Just reminding you again:");
                System.out.println(currentRoom.getLongDescription());
                System.out.println(hero.getInventoryString());                
            }
            else{
                System.out.println(currentRoom.getLongDescription());
                System.out.println(hero.getInventoryString());
            }
            
        }
    }

    /** 
     * Sai do jogo.
     * @return Verdadeiro se o comando for de quit.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
 
    /**
     * Ataca um inimigo.
     * @param command 
     */
    private void attack(Command command) {
        
    	Character enemy;
    	if(hero.isDead()){
            System.out.println("You can't attack anyone, you're dead, have you ever seen a ghost doing anything?");
        }else{
            if (!command.hasSecondWord()) {
    		System.out.println("Attack who?");
    		return;
            }
    	
            enemy = currentRoom.getEnemy(command.getSecondWord());
            if (enemy != null) {
                    hero.fight(enemy);

                    if(enemy.isDead()){
                        enemy.whenDies(currentRoom);
                        currentRoom.removeEnemy(command.getSecondWord());
                        System.out.println("\nThat enemy of yours, " + command.getSecondWord() + " is dead!\n");
                        if(hero.isDead()){
                            System.out.println("\nBut you died in the 'process' of killing him.\nAnyway, the upworld rules means nothing here, so go on, enjoy 'life' without a body\n");
                        }
                        System.out.println(currentRoom.getLongDescription());
                        System.out.println(hero.getInventoryString());
                    }else if(hero.isDead()){
                        System.out.println("\nYou are dead!\nBut the upworld rules means nothing here, so go on, enjoy 'life' without a body\n");
                        System.out.println(currentRoom.getLongDescription());
                        System.out.println(hero.getInventoryString());
                    }else{
                        hero.print();
                        enemy.print();  
                    }

            } 
            else {
                System.out.println("The enemy '"+ command.getSecondWord() +"' is not in the current room.");
            }
        }
    }
    
    /**
     * Método main.
     * @param args
     */
    public static void main(String[] args) {
	Game game = new Game();
	game.play();
    }
	
}
