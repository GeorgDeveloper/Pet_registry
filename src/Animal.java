import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name;
    private String type;
    private List<String> commands;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void showCommands() {
        System.out.println("Commands for " + name + ":");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }

    public void train(String newCommand) {
        System.out.println("Training " + name + " to perform command: " + newCommand);
        commands.add(newCommand);
        System.out.println(name + " is now trained to perform the new command.");
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count > 0) {
            throw new Exception("Counter resource not properly closed");
        }
    }
}




