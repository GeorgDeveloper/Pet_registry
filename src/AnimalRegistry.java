import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            Scanner scanner = new Scanner(System.in);
            List<Animal> animals = new ArrayList<>();

            boolean exit = false;
            while (!exit) {
                System.out.println("=== Animal Registry Menu ===");
                System.out.println("1. Add a new animal");
                System.out.println("2. Identify animal class");
                System.out.println("3. Show animal commands");
                System.out.println("4. Train animal with new command");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter animal name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter animal type: ");
                        String type = scanner.nextLine();

                        Animal animal = new Animal(name, type);
                        animals.add(animal);
                        counter.add();

                        System.out.println("Animal added to the registry.");
                        break;
                    case 2:
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter animal name: ");
                        String searchName = scanner.nextLine();

                        Animal foundAnimal = null;
                        for (Animal a : animals) {
                            if (a.getName().equalsIgnoreCase(searchName)) {
                                foundAnimal = a;
                                break;
                            }
                        }

                        if (foundAnimal != null) {
                            System.out.println("Animal type: " + foundAnimal.getType());
                        } else {
                            System.out.println("Animal not found in the registry.");
                        }
                        break;
                    case 3:
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter animal name: ");
                        String animalName = scanner.nextLine();

                        Animal selectedAnimal = null;
                        for (Animal a : animals) {
                            if (a.getName().equalsIgnoreCase(animalName)) {
                                selectedAnimal = a;
                                break;
                            }
                        }

                        if (selectedAnimal != null) {
                            selectedAnimal.showCommands();
                        } else {
                            System.out.println("Animal not found in the registry.");
                        }
                        break;
                    case 4:
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter animal name: ");
                        String trainAnimalName = scanner.nextLine();

                        Animal trainingAnimal = null;
                        for (Animal a : animals) {
                            if (a.getName().equalsIgnoreCase(trainAnimalName)) {
                                trainingAnimal = a;
                                break;
                            }
                        }

                        if (trainingAnimal != null) {
                            System.out.print("Enter new command to train the animal: ");
                            String newCommand = scanner.nextLine();
                            trainingAnimal.train(newCommand);
                        } else {
                            System.out.println("Animal not found in the registry.");
                        }
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
