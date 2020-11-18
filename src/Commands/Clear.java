package Commands;

import Stuff.CommandWithoutArg;
import Stuff.LabWorkCollection;

import java.io.FileNotFoundException;

public class Clear implements CommandWithoutArg {
    String name = "clear";
    LabWorkCollection collection = new LabWorkCollection();

    @Override
    public void execute(Object o) {
        if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
        else {
            collection.clear();
            System.out.println("Коллекция очищена");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
