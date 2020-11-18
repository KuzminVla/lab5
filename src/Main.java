import Stuff.*;
import Utility.Collection;
import Utility.Console;
import Utility.ReaderFromFile;
import Utility.WriterToFile;
import Commands.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "";
        if (args.length != 0) filename = args[0];
        ReaderFromFile readerFromFile = new ReaderFromFile();
        Collection collection = new Collection();
        collection.fillCollection(readerFromFile.readFromFile(filename));
        Commands commands = new Commands();
        Show show = new Show();
        Info info = new Info();
        Help help = new Help();
        Clear clear = new Clear();
        Exit exit = new Exit();
        Add add = new Add();
        Save save = new Save();
        UpdateId update = new UpdateId();
        History history = new History();
        ExecuteScript executeScript = new ExecuteScript();
        AddIfMax addIfMax = new AddIfMax();
        AverageOfTuned averageOfTuned = new AverageOfTuned();
        MinByTuned minByTuned = new MinByTuned();
        PrintDescending printDescending = new PrintDescending();
        RemoveGreater removeGreater = new RemoveGreater();
        RemoveId removeId = new RemoveId();
        commands.regist(show, history, info, help, clear, exit, save, update, add, executeScript, addIfMax, averageOfTuned, minByTuned, printDescending, removeGreater, removeId);

        while (true) {
            System.out.println("Введите команду,для справки введите help.");
            try{
                String commandName = Console.read();
                if (!commandName.equals(""))
                    commands.executeCommand(commandName);
                }
            catch(NoSuchElementException e){
                System.out.println("Вы прервали работу приложения.");
                System.exit(0);
            }
            }
        }
    }


