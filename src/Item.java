/**
 * Itens do jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Item {
	private final String name;
	private final String description;
	private final int weight;
	
        /**
         * Método construtor de Item.
         * @param name
         * @param description
         * @param weight 
         */
	public Item(String name, String description, int weight) {
		this.name = name;
		this.description = description;
		this.weight = weight;
	}
	
        /**
         * Pega o nome do item.
         * @return name
         */
	public String getName() {
		return name;
	}
        
        /**
         * Pega a descrição do item.
         * @return description
         */
        public String getDescription() {
		return description;
	}
	
        /**
         * Pesa peso do item.
         * @return weight
         */
	public int getWeight() {
		return weight;
	}       
}
