package com.urise.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File file = new File("./src/com/urise/webapp");
        printDirectory(file);
    }
    public static void printDirectory(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File dir : files) {
                if (dir.isFile()) {
                    System.out.println("File: " + dir.getName());
                } else if (dir.isDirectory()) {
                    printDirectory(dir);
                }
            }
        }
    }
}
