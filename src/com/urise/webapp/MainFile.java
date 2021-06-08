package com.urise.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File file = new File("G:\\Users\\basejava");
        printDirectory(file,"");
    }
    public static void printDirectory(File file, String offset) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File dir : files) {
                if (dir.isFile()) {
                    System.out.println(offset + "File: " + dir.getName());
                } else if (dir.isDirectory()) {
                    System.out.println(offset + "Directory: " + dir.getName());
                    printDirectory(dir, offset + " ");
                }
            }
        }
    }
}
