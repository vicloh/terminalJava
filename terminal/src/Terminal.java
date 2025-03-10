
import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        DirectoryManager directoryManager = new DirectoryManager();
        FileManager fileManager = new FileManager(directoryManager);
        HistoryManager historyManager = new HistoryManager();
        CommandHandler commandHandler = new CommandHandler(directoryManager, fileManager, historyManager); 

        System.out.println("Welcome to the terminal!");
        System.out.println("Type 'help' to see the available commands.");
        System.out.println("Enter a command or type 'exit' to quit.");

        while (true) { 
            String input = scan.nextLine();

            if(input.equalsIgnoreCase("exit")){
                break;
            }

            commandHandler.executeCommand(input);
        }
        scan.close();
    }
}
