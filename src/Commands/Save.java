package Commands;

import Stuff.CommandWithoutArg;
import Stuff.LabWorkCollection;
import Utility.WriterToFile;

import java.io.FileNotFoundException;

public class Save implements CommandWithoutArg {
    String name = "save";
    LabWorkCollection collection = new LabWorkCollection();

    @Override
    public void execute(Object o) throws FileNotFoundException {
        WriterToFile.writeLabToFile(collection.getCollection());
        System.out.println("Коллекция успешно сохранена.");
    }


    @Override
    public String getName() {
        return name;
    }
}