
import java.io.File;

public class DirectoryManager {
    private File currentDirectory;

    public DirectoryManager() {
        currentDirectory = new File(System.getProperty("user.dir"));
    }

    public String getCurrentDirectory() {
        return currentDirectory.getAbsolutePath();
    }

    public void listDirectory() {
        File[] files = currentDirectory.listFiles();
        
        if(files != null) {
            for(File file : files) {
                System.out.println(file.getName());
            }
        }else{
            System.out.println("Directory is empty");
        }
    }

    public void changeDirectory(String path){
        File newDirectory;
        if(path.equals("..")){
            newDirectory = currentDirectory.getParentFile();
        }else{
            newDirectory = new File(currentDirectory, path);
        }

        if(newDirectory != null && newDirectory.isDirectory()&& newDirectory.exists()){
            currentDirectory = newDirectory;
        }else{
            System.out.println("Directory not found");
        }
    }

    public void createDirectory(String dirName){
        File newDirectory = new File(currentDirectory, dirName);
        if(!newDirectory.exists()){
            if(newDirectory.mkdir()){
                System.out.println("Directory created"+newDirectory);
            }else{
                System.out.println("Failed to create directory");
            }
        }else{
            System.out.println("Directory already exists");
        }
    }
        
}
