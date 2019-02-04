/**
 * Chaves das salas do jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Key extends Item {
    private final Room entry, destiny;
    private final String destinyName, message;
    
    /**
     * Método construtor de Key
     * @param name
     * @param description
     * @param weight
     * @param entry
     * @param destiny
     * @param destinyName
     * @param message 
     */
    public Key(String name, String description, int weight, Room entry, Room destiny, String destinyName, String message){
        super(name, description, weight);
        this.entry = entry; //sala q tem q estar pra abrir
        this.destiny = destiny; // oq abre
        this.destinyName = destinyName; // nome q vai aparecer pra entrar na sala q abriu
        this.message = message; //pra printar na tela q funcionou
    }
    
    /**
     * Pega a sala em que a chave será usada.
     * @return entry
     */
    public Room getEntry(){
        return entry;
    }
    
    /**
     * Pega a sala destino da porta que será aberta
     * @return desiny
     */
    public Room getDestiny(){
        return destiny;
    }
    
    /**
     * Pega o nome da sala destino.
     * @return destinyName
     */
    public String getDestinyName(){
        return destinyName;
    }
    
    /**
     * Mensagem que será impressa na tela após o uso da chave
     * @return message
     */
    public String getMessage(){
        return message;
    }    
}
