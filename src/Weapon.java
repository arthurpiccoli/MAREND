/**
 * Armas do personagem.
 * @author Arthur Piccoli, Ítalo Nolasco.
 */

public class Weapon extends Item{
    private final int damage;
    
    /**
     * Método construtor de Weapon.
     * @param name
     * @param description
     * @param weight
     * @param damage 
     */
    public Weapon(String name, String description, int weight, int damage) {
        super(name, description, weight);
        this.damage = damage;
    }

    /**
     * Pega o dano concedido pela arma.
     * @return damage
     */
    public int getDamage(){
        return damage;
    }
}
