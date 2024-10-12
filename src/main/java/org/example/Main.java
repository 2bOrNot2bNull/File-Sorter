package org.example;

import java.io.IOException;
import java.util.Scanner;

import static org.example.FileUtility.checkIfPathIsValid;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to file sorter");
        System.out.println("Enter the system path to sort files(Absolute path):");
        String downloadPathString = scn.nextLine();

        ExtensionSortImpl sorter = new ExtensionSortImpl();
        sorter.extensionBasedSort(downloadPathString);
    }
}