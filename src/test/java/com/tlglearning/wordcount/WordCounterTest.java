package com.tlglearning.wordcount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordCounterTest {

  @Test
  void splitWords() {
    WordCounter counter = new WordCounter();
    String input = "The quick brown fox jumps over a lazy dog. Then it runs away";
    String[] expected   = {"the", "quick", "brown", "fox", "jumps", "over", "a", "lazy", "dog", "then", "it", "runs", "away"};

    String[] actual = counter.splitWords(input);
    assertArrayEquals(expected, actual); //The assertion will check what you expected to be output against what'll actually be output using the method you selected for this test class
  }

}



