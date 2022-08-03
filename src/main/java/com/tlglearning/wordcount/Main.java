package com.tlglearning.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Demonstrates the practice of word counting, used (for example) in authorship studies. This
 * demonstration uses (in the included methods) implementations of the {@link java.util.Map},
 * {@link java.util.Map.Entry}, and {@link java.util.stream.Stream} interfaces.
 */
public final class Main {

  public static final String TEST_FIlE_NAME = "hound-of-the-baskervilles.txt"; //TIP this constant was by clicking on file name > Refactor> Extract > Constant > Then change the name and create.
  //NOTE everything below is a complete javadoc comment for the main method below.

  private Main(){
    //NOTE javadocs only generates external documentation for things that are protected or public, not private?
  }

  /**
   * Creates an instance of {@link WordCounter}, using it to process the contents of "The Hound of
   * the Baskervilles", by Arthur Conan Doyle. After processing, the word counts (excluding short words) are
   * listed in descending order.
   * <p>You can use HTML tags here! the documentation in the ratingAnalyzer is html!!!
   * This method assumes that a text file named {@code hound-of-the-baskervilles.text} is loacted
   * on the classpath; otherwise (or if that file cannnot be read for some reason), an instance of
   * {@link IOException} is thown</p>
   *
   * @param args Command-line arguments (currently ignored).
   * @throws IOException Thrown if input file cannot be located or read.
   */
  public static void main(String[] args) throws IOException {

    try (
        //NOTE all of the reference types below must implement Closeable so that it closes resources when code stops.
        InputStream input = Main.class.getClassLoader().getResourceAsStream(TEST_FIlE_NAME);
        Reader reader = new InputStreamReader(input); //NOTE Use the general Type for the reference type then the specific class for the instance
        BufferedReader buffer = new BufferedReader(reader) //TIP you don't need a semi colon on the last param.
    ) {
      WordCounter counter = new WordCounter();
      String line;
      while ((line = buffer.readLine()) != null) {
        //TODO Pass line to a method of WordCounter.
        counter.add(line);
      }

      counter
          .getCounts()
          .entrySet()
          .stream()
          .sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed())
          .limit(10)
          .forEach((entry) -> System.out.println(entry));


    }

  }
}