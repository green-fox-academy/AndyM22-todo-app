public class Task {

    private boolean completed;
    private String string;

    Task(String string) {
        this.completed = false;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void complete(){
        this.completed = true;
    }

}
