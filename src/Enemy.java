/**
 * Inimigos do jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Enemy extends Character {
	private static final int maxEnergy = 20;
        
        /**
         * Método construtor de Enemy
         * @param name
         * @param energy
         * @param damage
         * @param gold 
         */
	public Enemy(String name, int energy, int damage, int gold) {
            super(name, energy, damage, gold);
	}
	
        /**
         * Pega a máxima energia do inimigo.
         * @return maxEnergy
         */
        @Override
	public int getMaxEnergy() {
            return maxEnergy;
	}
        
        /**
         * Printa os dados do inimigo.
         */
	@Override
	public void print() {
            System.out.println("#####################");
            System.out.println("# Enemy's Data");
            super.print();
	}
        
        /**
         * Quando o inimigo morre adiciona sua quantidade de gold na sala.
        */
        @Override
        public void whenDies(Room currentRoom){
            currentRoom.addGold(getGold());
        }
}
