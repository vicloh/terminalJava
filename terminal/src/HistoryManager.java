public class HistoryManager {
        private static final String HISTORY_FILE = "history.txt";
        private List<String> history;
    
        public HistoryManager() {
            this.history = new ArrayList<>();
            loadHistory();
        }
    
        public void addCommand(String command) {
            if (command == null || command.trim().isEmpty()) {
                return;
            }
            history.add(command);
            saveHistory();
        }
    
        public void showHistory() {
            if (history.isEmpty()) {
                System.out.println("not a command in history.");
                return;
            }
    
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + " " + history.get(i));
            }
        }
    
        private void saveHistory() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE))) {
                for (String command : history) {
                    writer.write(command);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("error for save history: " + e.getMessage());
            }
        }
    
        private void loadHistory() {
            File file = new File(HISTORY_FILE);
            if (!file.exists()) {
                return;
            }
    
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    history.add(line);
                }
            } catch (IOException e) {
                System.out.println("error for loading history: " + e.getMessage());
            }
        }
    }    