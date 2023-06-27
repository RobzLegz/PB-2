import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Ccircle {

  private double x;
  private double y;
  private double radius;

  public static Scanner input = new Scanner(System.in);

  public Ccircle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public Ccircle(Ccircle other) {
    this.x = other.x;
    this.y = other.y;
    this.radius = other.radius;
  }

  public void printAttributes() {
    System.out.println("X: " + x);
    System.out.println("Y: " + y);
    System.out.println("Radius: " + radius);
  }

  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  public static Ccircle[] writeData() {
    Ccircle[] circleArr = new Ccircle[5];

    for (int i = 0; i < circleArr.length; i++) {
      System.out.println("Enter details for Circle " + i);
      System.out.print("X: ");
      double x = input.nextDouble();
      System.out.print("Y: ");
      double y = input.nextDouble();
      System.out.print("Radius: ");
      double radius = input.nextDouble();

      circleArr[i] = new Ccircle(x, y, radius);
    }

    return circleArr;
  }

  public static void printData(Ccircle[] circleArr) {
    for (Ccircle circle : circleArr) {
      circle.printAttributes();
      System.out.println();
    }
  }

  public static void printArea(Ccircle[] circleArr) {
    for (Ccircle circle : circleArr) {
      System.out.println("Area: " + circle.calculateArea() + "\n");
    }
  }

  public static void saveData(Ccircle[] circleArr) {
    try (FileWriter fileWriter = new FileWriter("output.txt")) {
      for (Ccircle circle : circleArr) {
        fileWriter.write("X: " + circle.x + "\n");
        fileWriter.write("Y: " + circle.y + "\n");
        fileWriter.write("Radius: " + circle.radius + "\n");
        fileWriter.write("Area: " + circle.calculateArea() + "\n" + "\n");
      }

      System.out.println("Data written to output.txt");

      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Ccircle[] circleArr = writeData();

    while (true) {
      System.out.println("What would You like to do?");
      System.out.println("[a] - write data");
      System.out.println("[b] - print data");
      System.out.println("[c] - print area");
      System.out.println("[d] - save data");
      System.out.println("[e] - end work" + "\n");

      String option = input.nextLine();

      if (option.equals("a")) {
        circleArr = writeData();
      } else if (option.equals("b")) {
        printData(circleArr);
      } else if (option.equals("c")) {
        printArea(circleArr);
      } else if (option.equals("d")) {
        saveData(circleArr);
      } else if (option.equals("e")) {
        break;
      }
    }

    input.close();
  }
}
