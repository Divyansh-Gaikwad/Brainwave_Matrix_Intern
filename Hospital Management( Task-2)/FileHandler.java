import java.io.*;
import java.util.*;

class FileHandler {

    static <T> void saveData(Object data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (Exception e) {
            System.out.println("Error saving " + filename);
        }
    }

    static Map<String, Patient> loadPatients(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Map<String, Patient>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    static <T> List<T> loadList(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
