package Commands;

import Stuff.CommandWithoutArg;
import Stuff.LabWork;
import Stuff.LabWorkCollection;

import java.io.FileNotFoundException;

public class AverageOfTuned implements CommandWithoutArg {
    String name = "average_of_tuned_in_works";
    LabWorkCollection collection = new LabWorkCollection();
    @Override
    public void execute(Object o) {
        try{
            if (collection.getSize() == 0) System.out.println("Коллекция пустая.");
            else {
                double result = 0;
                int size = LabWorkCollection.getCollection().size();
                for (LabWork labWork1 : LabWorkCollection.getCollection())
                {
                    result+=labWork1.getTunedInWorks();
                    }
                System.out.println("Средний настрой на работу: "+result/size);
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
