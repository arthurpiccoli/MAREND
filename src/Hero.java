import java.util.HashMap;
import java.util.Map;

/**
 * Personagem principal, herói.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Hero extends Character {
	private int maxEnergy =10;
	public int maxWeight = 15;
	private Map<String, Item> inventory;
	
        /**
         * Método construtor de Hero.
         * @param name
         * @param energy
         * @param damage
         * @param gold 
         */
	public Hero(String name, int energy, int damage, int gold) {
		super(name, energy, damage, gold);
		inventory = new HashMap();
	}
        
        /**
         * Pega uma string contendo o inventário do herói.
         * @return returnString
         */
        public String getInventoryString() {
            String returnString = "You:\nInventory:";
            for(String name : inventory.keySet()) {
                    returnString += " " + name;
            }
            returnString += "\nGold: " + gold;
            returnString += "\nEnergy: " + energy;
            returnString += "\nWeight: " + calculateWeight();
            return returnString;
        }
	
        /**
         * Calacula o peso do inventário.
         * @return Peso total.
         */
	public int calculateWeight() {
		int totalWeight = 0 ,goldWeight =0 ;
		for(Item item : inventory.values()) {
			totalWeight += item.getWeight();
		}
                if(gold!=0)
                goldWeight = (gold/1000)+1;
		return (totalWeight + goldWeight);
	}
	
        /**
         * Adiciona um item ao inventário.
         * @param item
         * @param room 
         */
	public void setItem(Item item, Room room) {
            if("store".equals(room.getShortDescription())){
                inventory.put(item.getName(), item);
            }else{
		if (calculateWeight() + item.getWeight() <= maxWeight) {
			inventory.put(item.getName(), item);
                        System.out.println(room.getLongDescription());
                    System.out.println(getInventoryString());
            System.out.println("\nYou've got " + item.getDescription() + "!");
		} else {
                    
                    room.setItem(item);
                    
                    System.out.println(room.getLongDescription());
                    System.out.println(getInventoryString());
			System.out.println("You can't carry more items, you're too heavy!\n"
                                + "Like a diet is not in your plans drop something from your inventory.");
                        
		}
            }
        }
	
        /**
         * Remove item do inventário
         * @param nome
         * @return item
         */
	public Item removeItem(String nome) {
		Item item = inventory.get(nome);
		if (item != null)
			inventory.remove(nome);
		else
			System.out.println("'" + nome + "' is not in your inventory!\n");
		return item;
	}
        
        /**
         * Pega item do inventário.
         * @param nome
         * @return item
         */
        public Item getItem(String nome) {
		Item item = inventory.get(nome);
		if (item == null)
                    if(!"controller".equals(nome))
			System.out.println("'" + nome + "' is not in your inventory!\n");
		return item;
	}
	
        /**
         * Restaura a vida do herói.
         * @param energyRestore 
         */
        public void setEnergyRestore(int energyRestore) {
            energy += energyRestore;
            System.out.println("You've restored your energy in " + energyRestore + " points!");
            if(energy >= getMaxEnergy()){
                energy = getMaxEnergy();
                System.out.println("Your energy is full!");
            }else{
                System.out.println("Your energy is now " + energy + "!");
            } 
	}
        
        /**
         * Seta o novo dano do herói
         * @param damage 
         */
        public void setDamage(int damage){
            this.damage = damage;
        }
	
        /**
         * Método que desenvolve a luta entre heróis e inimigos.
         * @param enemy 
         */
	public void fight(Character enemy) {
            enemy.decrease(getDamage());
            int heroData = luck(6);
            int enemyData = luck(6);
            if (heroData < enemyData)  // Quando o oponente vence
		decrease(enemy.getDamage()); // Na energy do proprio heroi
	} 
        
        /**
         * Equipa arma no personagem.
         * @param weapon 
         */
        public void useWeapon(Weapon weapon){            
            setDamage(weapon.getDamage());
            System.out.println("Now you are using a " + weapon.getName() + " as your weapon!");        
            System.out.println("Your damage is now " + weapon.getDamage() + ".");
        }
        
        /**
         * Usa uma chave.
         * @param key
         * @param currentRoom 
         */
        public void useKey(Key key, Room currentRoom){
            String message;
            if(currentRoom==key.getEntry()){
                message=key.getMessage();
                currentRoom.setExit(key.getDestinyName(), key.getDestiny());
                System.out.println(currentRoom.getLongDescription());
                removeItem(key.getName());
                System.out.println(getInventoryString());
                System.out.println(message);

            }else
                System.out.println("The "+ key.getName() +" cannot be used here.");
        }
	
        /**
         * Equipa a armardura no herói.
         * @param armor 
         */
        public void useArmor(Armor armor){
            setMaxEnergy(armor.getNewMaxEnergy());
            System.out.println("Now you are using a " + armor.getName() + " as your armor!");
            System.out.println("Your max energy is now " + armor.getNewMaxEnergy() + ".");
        }
        
        /**
         * Usa um item consumível.
         * @param consumable 
         */
        public void useConsumable(Consumable consumable){
            setEnergyRestore(consumable.getEnergyRestore());
            removeItem(consumable.getName());
        }
        
        /**
         * Seta a energia inicial do herói.
         */
        public void setDefaultArmor(){
            setMaxEnergy(10);
            if(energy > getMaxEnergy())
                energy = getMaxEnergy();
            System.out.println("Your energy is now " + energy + "!");
        }
        
        /**
         * Seta o dano inicial do herói.
         */
        public void setDefaultDamage(){
            setDamage(1);
            System.out.println("Your damage is now 1!");
        }
        
        /**
         * Imprime os dados do herói na tela.
         */
        @Override
	public void print() {
		System.out.println("#####################");
		System.out.println("# Hero's Data");
		super.print();
	}
        
	/**
         * Pega a energia máxima do herói.
         * @return maxEnergy
         */
        @Override
	public int getMaxEnergy() {
		return maxEnergy;
        }
        
        /**
         * Define a energia máxima do herói.
         * @param maxEnergy 
         */
        public void setMaxEnergy(int maxEnergy){
            this.maxEnergy=maxEnergy;
        }
}
