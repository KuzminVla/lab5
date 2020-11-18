package Commands;

import Stuff.CommandWithObject;
import Stuff.LabWork;
import Stuff.LabWorkCollection;
import Utility.CreateLab;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class AddIfMax implements CommandWithObject {
    String name = "add_if_max";
    LabWorkCollection labWorkCollection = new LabWorkCollection();
    CreateLab createLab = new CreateLab();
    @Override
    public boolean check(Object arg) {
        return labWorkCollection.isKeyFree((Long) arg);
    }

    @Override
    public LabWork getNewlabwork(Object params) {
        if (!CreateLab.isFromScript) return createLab.create();
        else return CreateLab.labFromScript;
    }

    @Override
    public void execute(Object o)  {
        try {
            long id = Long.parseLong((String) o);
            if (this.check(id)) {
                LabWork labWork = this.getNewlabwork(null);
                labWork.setId(id);
                LabWork maxlab = LabWorkCollection.getCollection().iterator().next();
                for (LabWork labWork1 : LabWorkCollection.getCollection()){
                    if (labWork1.compareTo(maxlab)>=0){
                        maxlab = labWork1;
                    }
                }
                if (labWork.compareTo(maxlab)>0) {
                    labWorkCollection.insert(labWork);
                    System.out.println("Лабораторная работа добавлена в коллекцию!");
                }else System.out.println("Заданный элемент меньше максимального,добавить не удалось");
            } else System.out.println("Указанный ключ занят");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Аргумент команды должен быть типа \"long\"");
        }
        catch (NullPointerException e){
            System.out.println("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
