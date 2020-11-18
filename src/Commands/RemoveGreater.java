package Commands;

import Stuff.*;
import Utility.CreateLab;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.InputMismatchException;

public class RemoveGreater implements Commandable {
    String name = "remove_greater";
    LabWorkCollection collection = new LabWorkCollection();
    @Override
    public void execute(Object o) throws FileNotFoundException {
        try{
            boolean tumb = false;
            if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
            else {
                LabWork labWork = new LabWork();
                for (LabWork labWork1 : LabWorkCollection.getCollection())
                    if ((labWork1.getId() == Long.parseLong((String) o))) {
                        tumb = true;
                        labWork = labWork1;
                    }
                if (!tumb) System.out.println("Лабораторная работа с указанным id не найдена.");
                else {
                    boolean somethingdeleted = false;
                    for (LabWork labWork1 : LabWorkCollection.getCollection()) {
                        if (labWork.compareTo(labWork1) < 0) {
                            collection.remove(labWork1.getId());
                            somethingdeleted = true;
                            System.out.println("Элемент с id[" + labWork1.getId() + "] успешно удален.");
                        }
                    }
                    if (!somethingdeleted) System.out.println("Элементов,больше заданного нету в коллекции,ничего не удалено.");
                }
            }
        } catch (Exception e) {
            System.out.println("Аргумент команды должен быть типа \"long\"");
        }
    }

    @Override
    public String getName() {
        return name;
    }

}
