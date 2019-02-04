/**
 * Chefes do jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Boss extends Character {
	private static final int maxEnergy = 1000;
        Item item;
        
        /**
         * Método construtor de Boss.
         * @param name
         * @param energy
         * @param damage
         * @param item 
         */
	public Boss(String name, int energy, int damage, Item item) {
            super(name, energy, damage, 0);
            this.item = item;
	}
	
        /**
         * Pega a máxima energia do chefe.
         * @return maxEnergy
         */
        @Override
	public int getMaxEnergy() {
            return maxEnergy;
	}

        /**
         * Printa os dados do chefe.
         */    
	@Override
	public void print() {
            System.out.println("#####################");
            System.out.println("# Boss' Data");
            super.print();
	}
        
        /**
         * Dropa o item do chefe na sala.
         * @param currentRoom 
         */
        @Override
        public void whenDies(Room currentRoom){
            currentRoom.setItem(item);
        }
}
