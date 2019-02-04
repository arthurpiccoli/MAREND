/**
 * Classe de itens compráveis.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Buyable {
    int price;
    Item item;
    
    /**
     * Método construtor de Buyable
     * @param item
     * @param price 
     */
    public Buyable(Item item, int price){
        this.price = price;
        this.item = item;
    }
    
    /**
     * Pega preço referente ao item.
     * @return price
     */
    public int getPrice(){
        return price;
    }
    
    /**
     * Pega item Buyable.
     * @return item
     */
    public Item getItem(){
        return item;
    }
}
