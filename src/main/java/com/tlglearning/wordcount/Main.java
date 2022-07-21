package com.tlglearning.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  public static final String TEST_FIlE_NAME = "hound-of-the-baskervilles.txt"; //TIP this constant was by clicking on file name > Refactor> Extract > Constant > Then change the name and create.

  public static void main(String[] args) throws IOException {

    try (
        //NOTE all of the reference types below must implement Closeable so that it closes resources when code stops.
        InputStream input = Main.class.getClassLoader().getResourceAsStream(TEST_FIlE_NAME);
        Reader reader = new InputStreamReader(input); //NOTE Use the general Type for the reference type then the specific class for the instance
        BufferedReader buffer = new BufferedReader(reader) //TIP you don't need a semi colon on the last param.
    ) {
        WordCounter counter = new WordCounter();
        String line;
        while((line = buffer.readLine()) != null){
          //TODO Pass line to a method of WordCounter.
          counter.add(line);
        }
        //TODO Do something with the WordCounter.
      System.out.println(counter);
    }

  }
}