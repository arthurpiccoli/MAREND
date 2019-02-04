import java.util.Scanner;

/**
 * Lê a entrada do usuário e analiza no contexto do jogo.
 * @author Arthur Piccoli, Ítalo Nolasco
 */
public class Parser 
{
    private CommandWords commands; 
    private Scanner reader;         

    /**
     * Método construtor de Parser.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Lê o comando do usuário.
     * @return O próximo comando do usuário
     */
    public Command getCommand() 
    {
        String inputLine;   // Armazanea a linha inteira.
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Escaneia as duas palavras escritas na tela.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // Pega a primeira palavra
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // Pega a segunda palavra.
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * Printa na tela todos os comandos válidos.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
