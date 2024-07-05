package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File_Interaction {


    public static List<Integer> getData() throws IOException {

        List<Integer> numbers = new ArrayList<>();

        try (Scanner myReader = new Scanner(new File("10m.txt"))) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return numbers;

    }

}
