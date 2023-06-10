import java.io.*;
import java.util.Scanner;

class Y implements Serializable {
    int x;
    public Y(int x) {
        this.x = x;
    }
    public double getY() {
        return x - Math.sin(x);
    }
    public static void saveY(Y y) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Y.txt"))) {
            System.out.println("save");
            oos.writeObject(y);
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
    public static Y uploadY() {
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream("Y.txt"))) {
            System.out.println("upload");
            return (Y) ios.readObject();
        } catch (Exception ex) {
            System.out.println("error");
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input y: ");
        Y y1 = new Y(scanner.nextInt());
        Y.saveY(y1);
        Y y_upload = Y.uploadY();
        System.out.println(y_upload.getY());
    }
}
