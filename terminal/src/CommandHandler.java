public class CommandHandler {

    private DirectoryManager directoryManager;
    private FileManager fileManager;
    private HistoryManager history;

    public CommandHandler(DirectoryManager directoryManager, FileManager fileManager, HistoryManager history) {
        this.directoryManager = directoryManager;
        this.fileManager = fileManager;
        this.history = history;
    }
//asdasdasdasdasdad//
    public void executeCommand(String comand){

        String[] commandParts = comand.split(" ",2);
        String command = commandParts[0];
        String argument = commandParts.length > 1 ? commandParts[1] : null;

        switch(command){
            case "pwd":
                executePwd();
                break;
            case "cd":
                executeCd(argument);
                break;
            case "ls":
                executeLs();
                break;
            case "touch":
                executeTouch(argument);
                break;
            case "cat":
                executeCat(argument);
                break;
            case "echo":
                executeEcho(argument);
                break;
            case "history":
                executeHistory();
                break;
            case "mkdir":
                executeMkdir(argument);
                break;
            case "rm":
                executeRm(argument);
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Command not found");
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
        if(textParts.length == 2){
            fileManager.writeToFile(textParts[1], textParts[0]);
        } else {
            System.out.println("Syntax error. Try: echo <text> > <filename>");
        }
    }

    private void executeHistory(){
        history.showHistory();
    }
}