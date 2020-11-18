package Stuff;
import java.time.LocalDate;
import java.util.HashSet;

public class LabWorkCollection {
    private static HashSet<LabWork> collection;
    private static LocalDate dateCreation;

    public static HashSet<LabWork> getCollection() {
        return collection;
    }
    public static void setCollection(HashSet<LabWork> collection){
        LabWorkCollection.collection = collection;
    }
    public static LocalDate getDateCreation() {
        return dateCreation;
    }

    public static void setDateCreation(LocalDate dateCreation) {
        LabWorkCollection.dateCreation = dateCreation;
    }
    public void clear() {
        collection.clear();
    }
    public void insert(LabWork labWork) {
       collection.add(labWork);
    }
    public void update(Long ind, LabWork labWork) {
        if (!this.isKeyFree(ind)) {
            HashSet <LabWork> set = new HashSet<>();
            for (LabWork labWork1 : LabWorkCollection.getCollection()) {
                if (labWork1.getId() != ind) set.add(labWork1);
            }
            set.add(labWork);
            collection=set;
        }
    }

    public boolean isKeyFree(Long ind) {
        try {
            for (LabWork labWork : LabWorkCollection.getCollection())
                if (labWork.getId()==ind) return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    public void remove(Long id){
        HashSet <LabWork> set = new HashSet<>();
        for (LabWork labWork1 : LabWorkCollection.getCollection()) {
            if (labWork1.getId() != id) set.add(labWork1);
        }
        collection=set;
    }
    public int getSize() {
        return collection.size();
    }
    public String getInfo() {
        return "Тип коллекции: HashSet;\nKоличество элементов коллекции: " + this.getSize() + ";\nДата создания кол"
                + "лекции: " + this.getDateCreation() + ".";
    }
}
