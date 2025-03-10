public class CommandHandler {

    private final DirectoryManager directoryManager;
    private final FileManager fileManager;
    private final HistoryManager history;

    public CommandHandler(DirectoryManager directoryManager, FileManager fileManager, HistoryManager history) {
        this.directoryManager = directoryManager;
        this.fileManager = fileManager;
        this.history = history;
    }

    public void executeCommand(String comand){
        history.addCommand(comand);
        String[] commandParts = comand.split(" ",2);
        String command = commandParts[0];
        String argument = commandParts.length > 1 ? commandParts[1] : null;

        switch(command)
        {
            case "pwd" -> executePwd();
            case "cd" -> executeCd(argument);
            case "ls" -> executeLs();
            case "touch" -> executeTouch(argument);
            case "cat" -> executeCat(argument);
            case "echo" -> executeEcho(argument);
            case "history" -> executeHistory();
            case "mkdir" -> executeMkdir(argument);
            case "rm" -> executeRm(argument);
            case "exit" -> System.exit(0);
            default -> System.out.println("Command not found");
            case "help" -> System.out.println
                (
                    "Available commands: \n" +
                    "\n   -pwd -- Displays the current directory.\n" +
                    "   -ls -- Lists the files and directories in the current directory.\n" +
                    "   -cd <directory> -- Navigates between directories.\n" +
                    "   -mkdir <name> -- Creates a new directory.\n" +
                    "   -touch <file> -- Creates a new empty file.\n" +
                    "   -rm <file/directory> -- Removes a file or directory.\n" +
                    "   -cat <file> -- Displays the contents of a file.\n" +
                    "   -echo <text> > <file> -- Writes text to a file.\n" +
                    "   -history -- Shows the history of entered commands.\n" +
                    "   -exit -- Exits the program."
                );
        }
    }

    private void executePwd(){
        System.out.println(directoryManager.getCurrentDirectory());
    }

    private void executeCd(String path){
        directoryManager.changeDirectory(path);
    }

    private void executeLs(){
        directoryManager.listDirectory();
    }

    private void executeMkdir(String dirName){
        directoryManager.createDirectory(dirName);
    }

    private void executeTouch(String fileName){
        fileManager.createFile(fileName);
    }

    private void executeRm(String name){
        fileManager.removeFile(name);
    }

    private void executeCat(String filename){
        fileManager.showFileContent(filename);
    }

    private void executeEcho(String text){
        String[] textParts = text.split(" > ",2);
        if(textParts.length == 2)
        {
            fileManager.writeToFile(textParts[1], textParts[0]);
        } 
        else 
        {
            System.out.println("Syntax error. Try: echo <text> > <filename>");
        }
    }

    private void executeHistory(){
        history.showHistory();
    }
}