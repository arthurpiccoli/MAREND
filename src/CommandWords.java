import java.util.HashMap;

/**
 * Mapa com todas as palavras de controle 
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class CommandWords
{
    private HashMap<String, CommandWord> validCommands;

    /**
     * Método construtor da classe CommandWords.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Encontra o comando associado a CommandWord.
     * @param commandWord
     * @return O comando correspondente ao CommandWord, ou UNKNOWN se for desconhecido.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Checa se é um comando válido
     * @return Verdadeiro se for um comando válido.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Printa na tela todos os comandos válidos.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
