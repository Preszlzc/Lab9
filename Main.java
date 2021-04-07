import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

class Main {
  static ArrayList<Person> people;
  static String filename;
  static FileReader myFile;

  public static void main(String[] args) {

    people = new ArrayList<Person>();
    people.add(new Person("Zachary", 21,"green"));
    people.add(new Person("A", 87, "pink"));
    people.add(new Person("B", 13, "yellow"));
    people.add(new Person("C", 55, "black"));
    people.add(new Person("D", 4, "green"));
    
    FileWriter toWriteFile;
    try {
      toWriteFile = new FileWriter("data.txt");

      BufferedWriter output = new BufferedWriter(toWriteFile);
      
      for(int i=0; i<people.size(); i++) {
        output.write(people.get(i).getName());
        output.newLine();
        output.write(Integer.toString(people.get(i).getAge()));
        output.newLine();
        output.write(people.get(i).getColor());
        output.newLine();
        output.flush();
      }
      output.close();
    }
    catch (IOException excpt)
    {
      excpt.printStackTrace();
    }
    try {
      myFile = new FileReader("data.txt");
      BufferedReader reader = new BufferedReader(myFile);

      while (reader.ready()) {
        String name = reader.readLine();
        String age = reader.readLine();
        String color =reader.readLine();
        System.out.printf("%-10s %-10s %-10s %n", name, age, color);
      }
      reader.close();
    }

    catch (IOException excpt)
    {
      excpt.printStackTrace();
    }
    }
  }