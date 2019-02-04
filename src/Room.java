import java.util.Set;
import java.util.HashMap;

/**
 * Sala do jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;      
    private HashMap<String, Character> enemies;
    private HashMap<String, Item> itens;
    private int gold;
    
    /**
     * Método construtor de Room.
     * @param description
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        enemies = new HashMap<String, Character>();
        itens = new HashMap<String, Item>();
        gold = 0;
    }

    /**
     * Seta a saída da sala atual.
     * @param direction
     * @param neighbor
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Pega o nome da sala.
     * @return description
    */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Adiciona gold à sala.
     * @param gold 
     */
    public void addGold(int gold) 
    {
        this.gold+=gold;
    }
    
    /**
     * Pega gold da sala.
     * @return auxGold (gold)
     */
    public int getGold() 
    {
        int auxGold = gold;
        gold =0;
        return auxGold;
    }
    /**
     * Pega a sala e imprime no seguinte formato:
     * @return Descrição completa da sala.
     */
    public String getLongDescription()
    {
        return "\nYou are " + description + "!\n"
                + "\nRoom:\n"
                + getExitString() + "\n"
                + getEnemiesString() + "\n"
                + getItens() + "\n"
                + "Gold: " + gold+"\n";
    }

    /**
     * Pega as saídas da sala atual em forma de String.
     * @return String com as saídas disponíveis.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Seta um inimigo na sala.
     * @param personagem 
     */
    public void setEnemy(Character personagem) {
    	enemies.put(personagem.getName(), personagem);
    }
    
    /**
     * Seta um item na sala.
     * @param item 
     */
    public void setItem(Item item) {
    	itens.put(item.getName(), item);
    }
    
    /**
     * Pega uma String com todos inimigos da sala.
     * @return String com inimigos.
     */
    private String getEnemiesString() {
    	String returnString = "Enemies:";
    	for(String nome : enemies.keySet()) {
    		returnString += " " + nome;
    	}
    	return returnString;
    }
    
    /**
     * Pega um Map de inimigos.
     * @return enemies
     */
    public HashMap getEnemiesMap() {
    	return enemies;
    }
    
    /**
     * Pega um objeto tipo Character referente ao inimigo passado como parâmetro.
     * @param name
     * @return Character do inimigo.
     */
    public Character getEnemy(String name) {
    	return enemies.get(name);
    }
    /**
     * Entra com o nome do inimigo e remove-o
     * @param name 
     */
    public void removeEnemy(String name) {
    	enemies.remove(name);
    }
    
    /**
     * Pega uma String com os itens da sala.
     * @return lista
     */
    private String getItens() {
    	String lista = "Itens:";
    	for(String nome : itens.keySet()) {
    		lista += " " + nome;
    	}
    	return lista;
    }
    
    /**
     * Pega um objeto tipo Item correspondente ao item passado por parâmetro.
     * @param name
     * @return O item que foi removido
     */
    public Item getItem(String name) {
    	return itens.remove(name);
    }
    
  
}

