/**
 * Palavras de comando.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public enum CommandWord
{
    //Palavras referentes aos seus comandos.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"),
    ATTACK("attack"), PICK("pick"), USE("use"), DROP("drop");
    
    // A string de comando.
    private String commandString;
    
    /**
     * Inicializa com a palavra de comando correspondente.
     * @param commandWord
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return A palavra de comando como String.
     */
    public String toString()
    {
        return commandString;
    }
}
