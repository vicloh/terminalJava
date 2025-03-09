
import java.io.File;

public class DirectoryManager {
    private File currentDirectory;

    public DirectoryManager() {
        currentDirectory = new File(System.getProperty("user.dir"));
    }
}
