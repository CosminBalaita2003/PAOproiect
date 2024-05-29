package services;

import java.io.File;
import java.io.FileWriter;

public class AuditService {
    FileWriter writer;

    public AuditService() {
        try {
            String path_to_file = "src/files/activityLog.csv";
            String directory = "src/files";
            File file = new File(path_to_file);
            File dir = new File(directory);
            this.writer = new FileWriter(file, true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        }
    public void addLog(String action) throws Exception {
       String path_to_file = "src/files/activityLog.csv";
       try (FileWriter writer = new FileWriter(path_to_file, true)) {
           long timestamp = System.currentTimeMillis();
           writer.write(action + "," + timestamp + "\n");
       }
    }
}

