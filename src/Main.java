import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            usageInformation();
        } else {
            File fileTasks = new File("C:\\Users\\anmal\\greenfox\\AndyM22-todo-app\\src\\tasks.txt");
            try {
                if (fileTasks.canRead()) {
                    List listTasks = new ArrayList<List>();
                    for (String line : Files.readAllLines(Paths.get("C:\\Users\\anmal\\greenfox\\AndyM22-todo-app\\src\\tasks.txt"))) {
                        listTasks.add(line);
                    }
                    switch (args[0]) {
                        case "-l":
                            for (int i = 0; i < listTasks.size(); i++) {
                                System.out.println(i + 1 + " - " + listTasks.get(i));
                            }
                            if (listTasks.size() == 0){
                                System.out.println("No todos for today! :)");
                            }
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("File doesn't exist");
            }
        }

    }

    private static void usageInformation() {
        System.out.println("\nCommand Line Todo application");
        System.out.println("=============================");
        System.out.println("\nCommand line arguments:");
        System.out.println("    -l  Lists all the tasks");
        System.out.println("    -a  Adds a new task");
        System.out.println("    -r  Removes an task");
        System.out.println("    -c  Completes an task");
    }

}
