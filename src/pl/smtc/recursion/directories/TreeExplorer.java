package pl.smtc.recursion.directories;

import pl.smtc.menu.ConsoleExample;

import java.io.File;
import java.nio.file.Paths;

public class TreeExplorer implements ConsoleExample {
    TreeFormatter formatter = new TreeFormatter();

    @Override
    public void execute() {
        String currentPath = getCurrentDirectory();
        System.out.println(currentPath);
        scanDirectory(currentPath);
    }

    @Override
    public String getName() {
        return "Directory explorer";
    }

    public String getCurrentDirectory() {
        return Paths.get(new File("").getAbsolutePath())
                .resolve("src")
                .resolve("pl")
                .resolve("smtc")
                .resolve("recursion")
                .toString();
    }

    public void scanDirectory(String filePath) {
        File currItem = new File(filePath);
        if (currItem.exists()) {
            if (currItem.isFile()) {
                System.out.println(formatter.printFile(currItem.getName()));
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
}
