/**
 * Gerencia os comandos do jogo
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Command
{
    private CommandWord commandWord;
    private String secondWord;

    /**
     * Método construtor de Command
     * @param commandWord
     * @param secondWord 
     */
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * Pega a palavra de comando.
     * @return commandWord
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * Pega a segunda palavra de comando, ou seja, nome do item, sala ou inimigo a ser atacado.
     * @return secondWord.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return Verdadeiro se a palavra de comando é desconhecida.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * @return Verdadeiro se há segunda palavra.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

