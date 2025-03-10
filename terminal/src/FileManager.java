import java.io.*;

public class FileManager {
    private final DirectoryManager directoryManager;

    public FileManager(DirectoryManager directoryManager) {
        this.directoryManager = directoryManager;
    }

    public void createFile(String fileName){
        File file = new File(directoryManager.getCurrentDirectory(),fileName);

        try 
        {
            if(file.createNewFile())
            {
                System.out.println("File created: " + file.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error: "+e);
        }
    }

    public void removeFile(String fileName){
        File file = new File(directoryManager.getCurrentDirectory(),fileName);

        if(file.exists())
        {
            if(file.delete())
            {
                System.out.println("File deleted: " + file.getName());
            }
            else
            {
                System.out.println("File not found.");
            }
        }
        else
        {
            System.out.println("File not found.");
        }    
    }

    public void writeToFile(String fileName, String text){
        File file = new File(directoryManager.getCurrentDirectory(),fileName);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            writer.write(text);
            System.out.println("Text written to file.");
        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }
    }

    public void showFileContent(String fileName){
        File file = new File(directoryManager.getCurrentDirectory(),fileName);

        if(file.exists())
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                while((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
            catch(IOException e)
            {
                System.out.println("An error occurred.");
            }
        }
        else
        {
            System.out.println("File not found.");
        }
    }
}
