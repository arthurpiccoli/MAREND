/**
 * Itens consumíveis.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Consumable extends Item {
    private final int energyRestore;
    
    /**
     * Método construtor de Consumable
     * @param name
     * @param description
     * @param weight
     * @param energyRestore 
     */
    public Consumable(String name, String description, int weight, int energyRestore){
        super(name,description,weight);
        this.energyRestore = energyRestore;
    }        
    
    /**
     * Pega a energia a ser restaurada.
     * @return energyRestore
     */
    public int getEnergyRestore(){
        return energyRestore;
    }    
}
