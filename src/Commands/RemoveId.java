package Commands;

import Stuff.Commandable;
import Stuff.LabWork;
import Stuff.LabWorkCollection;

import java.io.FileNotFoundException;

public class RemoveId implements Commandable {
    String name = "remove";
    LabWorkCollection collection = new LabWorkCollection();
    @Override
    public void execute(Object o) throws FileNotFoundException {
        try{
        boolean tumb = false;
        if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
        else {
            for (LabWork labWork1 : LabWorkCollection.getCollection())
                if (labWork1.getId() == Long.parseLong((String) o)) {
                    tumb = true;
                    collection.remove(labWork1.getId());
                    System.out.println("Элемент с id[" + o + "] успешно удален.");
                }
            if (!tumb) System.out.println("Лабораторная работа с указанным id не найдена.");
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
