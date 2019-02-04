import java.util.Random;

/**
 * Personagens do jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public abstract class Character {
	private String name;
	int energy, damage, gold;

	private static Random data = new Random();
	
        /**
         * Método construtor de Character.
         * @param name
         * @param energy
         * @param damage
         * @param gold 
         */
	public Character(String name, int energy, int damage, int gold) {
		this.name = name;
                this.damage = damage;
		this.energy = energy;
                this.gold = gold;
	}
	
        /**
         * Pega nome do personagem.
         * @return name
         */
	public String getName() {
		return name;
	}
        
        /**
         * Pega dano causado pelo persoangem.
         * @return damage
         */
        public int getDamage(){
            return damage;
        }
        
        /**
         * Pega a quantidade de Gold do personagem.
         * @return gold
         */
        public int getGold() {
		return gold;
	}
        
        /**
         * Adiciona gold ao personagem.
         * @param gold 
         */
        public void addGold(int gold) {
		this.gold+=gold;
	}
	
        /**
         * Pega energia atual do personagem.
         * @return energy
         */
	public int getEnergy() {
		return energy;
	}
	
        /**
         * Flag para saber se o personagem está morto.
         * @return true ou falso
         */
	public boolean isDead() {
		if (energy == 0)
			return true;
		else
		    return false;
	}
	
        /**
         * Método abstrato para pegar a energia máxima do personagem.
         * @return Energia máxima
         */
	public abstract int getMaxEnergy();
	
        /**
         * Decrementa a energia do personagem dependendo do dano.
         * @param dano 
         */
	public void decrease(int dano) {
		if (energy > 0)
			energy-= dano;
		if (energy < 0)
                    energy = 0;
	}
	
        /**
         * Sorte utilizada para o método luta.
         * @param valorMaximo
         * @return Valor aleatório
         */
	public int luck(int valorMaximo) {
		return data.nextInt(valorMaximo) + 1;
	}
        
        /**
         * Mata o personagem.
         */
        public void kill(){
            energy=0;
        }
        
        /**
         * Método que define o que acontece quando o personagem morre.
         * @param currentRoom 
         */
        public void whenDies(Room currentRoom){}
	
        /**
         * Printa nome e energia do personagem.
         */
 	public void print() {
		System.out.println("#####################");
		System.out.println("# Name: " + name);
		System.out.println("# Energy: " + energy);
		System.out.println("#####################");
	}
}
