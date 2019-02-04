/**
 * Armaduras do personagem.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Armor extends Item{
    private final int newMaxEnergy;
    
    /**
     * Método construtor de Armor.
     * @param name
     * @param description
     * @param weight
     * @param maxEnergy 
     */
    public Armor(String name, String description, int weight, int maxEnergy) {
        super(name,description,weight);
        this.newMaxEnergy = maxEnergy;
    }
    
    /**
     * Pega a nova energia máxima concedida pela armadura.
     * @return newMaxEnergy 
     */
    public int getNewMaxEnergy(){
        return newMaxEnergy;
    }       
}
