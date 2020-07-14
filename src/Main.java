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
        } else if (args[0].equals("-l") || args[0].equals("-a") || args[0].equals("-r") || args[0].equals("-c")) {
            File fileTasks = new File("C:\\Users\\anmal\\greenfox\\AndyM22-todo-app\\src\\tasks.txt");
            Path pathTasks = Paths.get("C:\\Users\\anmal\\greenfox\\AndyM22-todo-app\\src\\tasks.txt");
            try {
                if (fileTasks.canRead()) {
                    List listTasks = Files.readAllLines(pathTasks);
                    ArrayList checkTasks = new ArrayList<Task>();
                    for (int i = 0; i < listTasks.size(); i++) {
                        checkTasks.add(new Task((String) listTasks.get(i)));
                    }
                    boolean completed = false;
                    switch (args[0]) {
                        case "-l":
                            if (listTasks.size() == 0) {
                                System.out.println("No todos for today! :)");
                            } else if (completed == false) {
                                for (int i = 0; i < listTasks.size(); i++) {
                                    System.out.println(i + 1 + " - [ ] " + listTasks.get(i));
                                }
                            } else {
                                for (int i = 0; i < listTasks.size(); i++) {
                                    System.out.println(i + 1 + " - [X] " + listTasks.get(i));
                                }
                            }
                            break;
                        case "-a":
                            String newTask = args[1];
                            listTasks.add(newTask);
                            Files.write(pathTasks, listTasks);
                            break;
                        case "-c":
                            int checkTask = Integer.parseInt(args[1]);
                            Task newCheckTask = new Task((String) listTasks.get(1));
                            newCheckTask.complete();
                            break;
                        case "-r":
                            int removeTask = Integer.parseInt(args[1]);
                            listTasks.remove(removeTask - 1);
                            Files.write(pathTasks, listTasks);
                    }
                }
            } catch (Exception e) {
                System.out.println("File doesn't exist");
            }
        } else {
            System.out.println("Unsupported argument");
            usageInformation();
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
