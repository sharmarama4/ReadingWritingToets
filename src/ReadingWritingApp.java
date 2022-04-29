import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingWritingApp {
    public static void main(String[] args) {
        Path pathOfFile = Paths.get("../../FromRambaToPearl/message.txt");
        try {
            if (Files.notExists(pathOfFile.getParent())) {
                Files.createDirectory(pathOfFile.getParent());
            }

            if (Files.notExists(pathOfFile)) {
                Files.createFile(pathOfFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(pathOfFile.getParent());

        System.out.println("This is the message for you Pearl");

        try (FileWriter fileWriter = new FileWriter(pathOfFile.toString());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            bufferedWriter.write("Java is really difficult for me\n");
            bufferedWriter.write("But you present the lessen easiest way so that everyone can fast understand\n ");
            bufferedWriter.write("You are so friendly en clear\n");
            bufferedWriter.write("You are the best programmer\n");
            bufferedWriter.write("ThankYou so much");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(pathOfFile.toString());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------");
        System.out.println("Here are my favourite Animals ");
        Animal animal = new Animal("Dog",false);
        Animal animal1=new Animal("Cat",false);
        Animal animal2 =new Animal("Horse",true);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new FileOutputStream("../../FromRambaToPearl/animal.txt"))) {
            objectOutputStream.writeObject(animal);
            objectOutputStream.writeObject(animal1);
            objectOutputStream.writeObject(animal2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream("../../FromRambaToPearl/animal.txt"))) {
            /* Animal someone=(Animal) objectInputStream.getObjectInputFilter();
               System.out.println(someone);This is for one Animal*/
           Animal someone;
            while ((someone = (Animal) objectInputStream.readObject()) != null) {
                System.out.println(someone);//This for more Animal
            }
        } catch (EOFException e){
            System.out.println("Happy ending of my File");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
