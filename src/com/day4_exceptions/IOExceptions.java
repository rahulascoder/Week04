package com.day4_exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptions {

    public static void main(String[] args) {
        //file
        String fileName = "data.txt";
        //try catch block to handle IOExceptions
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            //printing lines if found in file
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (IOException e ){
            System.out.println("an error occured while reading files");
        }
    }
}
