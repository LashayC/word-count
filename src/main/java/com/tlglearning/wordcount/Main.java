package com.tlglearning.wordcount;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

  public static final String TEST_FINAL_NAME = "hound-of-the-baskervilles.txt"; //TIP this constant was by clicking on file name > Refactor> Extract > Constant > Then change the name and create.

  public static void main(String[] args) throws IOException, URISyntaxException {
    //NOTE at runtime it won't be in classloarder
    //Use classloader to look at classpath and get resources

    URI uri = Main.class.getClassLoader().getResource(TEST_FINAL_NAME).toURI();
    Path path = Paths.get(uri);//NOTE this gets the URI and creates an instance of path
    String text = Files.readString(path); //NOTE Reads the contents of a file into a string
    WordCounter counter = new WordCounter(text);
    //TODO Do something with counter.
    System.out.println(counter);
  }

}
