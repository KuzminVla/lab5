package Commands;

import Stuff.CommandWithObject;
import Stuff.Commandable;
import Stuff.Commands;
import Stuff.LabWorkCollection;
import Utility.CreateLab;
import Utility.ReaderFromFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExecuteScript implements Commandable {
    String name = "execute_script";
    LabWorkCollection collection = new LabWorkCollection();
    ReaderFromFile reader = new ReaderFromFile();
    Commands invoker = new Commands();

    @Override
    public void execute(Object arg) {
        try {
            String data = reader.readFromFile((String) arg);
            Commands command = new Commands();
            if (data != null) {
                String[] commands = data.split("\n|\r\n");
                for (int i = 0; i < commands.length; i++) {
                    if (!(commands[i].equals(""))) {
                        if (!(commands[i].equals("execute_script " + arg))) {
                            try {
                                String[] commandAndName = commands[i].split(" ");
                                CommandWithObject commandWithObject = (CommandWithObject) invoker.getCommand(commandAndName[0]);
                                if (commandWithObject != null) {
                                    ArrayList<String> params = new ArrayList<>();
                                    try {
                                        for (int j = 0; j <8; j++) {
                                            i++;
                                            params.add(commands[i]);
                                        }
                                        CreateLab.isFromScript = true;
                                        CreateLab creater = new CreateLab();
                                        creater.createFromFile(params);
                                        System.out.println("\nКоманда \"" + commands[i-8] + "\":");
                                        command.executeCommand(commands[i-8]);
                                        CreateLab.isFromScript = false;
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Недостаточно параметров");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Команда \"" + commands[i] + "\":");
                                command.executeCommand(commands[i]);
                                System.out.println();
                            }

                        } else System.out.println("Команда \"" + commands[i] + "\": невыполнима.");
                    }
                }
            } else System.out.println("Указанный файл не найден.");
        } catch (NullPointerException | FileNotFoundException e) {

        }
    }

    @Override
    public String getName() {
        return name;
    }
}