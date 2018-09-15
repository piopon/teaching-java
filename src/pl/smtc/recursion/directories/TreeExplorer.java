package pl.smtc.recursion.directories;

import pl.smtc.menu.ConsoleExample;

import java.io.File;
import java.nio.file.Paths;

public class TreeExplorer implements ConsoleExample {
    TreeFormatter formatter = new TreeFormatter();

    @Override
    public void execute() {
        String currentPath = Paths.get(new File("").getAbsolutePath())
                .resolve("src")
                .resolve("pl")
                .resolve("smtd")
                .resolve("recursion")
                .toString();
        System.out.println(currentPath);
        scanDirectory(currentPath);
    }

    @Override
    public String getName() {
        return "Directory explorer";
    }

    public void scanDirectory(String filePath) {
        File currItem = new File(filePath);

        if (!currItem.exists()) {
            return;
        } else if (currItem.isFile()) {
            System.out.println(formatter.printFile(currItem.getName()));
            return;
        } else {
            System.out.println(formatter.printDir(currItem.getName()));
            System.out.println(formatter.goLevelDown());
            for (String item : currItem.list()) {
                scanDirectory(currItem + File.separator + item);
            }
            System.out.println(formatter.goLevelUp());
        }
    }
}
