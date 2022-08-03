package com.tlglearning.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class WordCounter {


  private static final Set<String> BORING_WORDS = Set.of("and", "the", "in", "on", "i", "then", "than", "out", "a");
  private final Map<String, Integer> counts = new HashMap<>();

  private int totalWords;

  public Set<String> words() {
    return counts.keySet();
  }

  public int get(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add(String text) {
    String trimmedLine = text.trim();
    if (!trimmedLine.isEmpty()) {
      String[] words = splitWords(trimmedLine);
      countWords(words);
    }
  }

  public int size() {
    return counts.size();
  }

  public int total() {
    return totalWords;
  }

  @Override
  public String toString() {
    return counts.toString();
  }

  String[] splitWords(String text) {
    return text
        .toLowerCase()
        .split("[\\W_]+");
  }

  void countWords(String[] words) {
    //NOTE how to make a stream from an array: Arrays.stream  orrrr Stream.of
//    Arrays
//        .stream(words)
    Stream
        .of(words)
        .map((s) -> s.trim()) //NOTE this will remove spaces from the beginning and end of each string while mapping
        .filter((s) -> !s.isEmpty()) //NOTE either filter will filter empty strings.
        .filter((word) -> word.length() > 5)
//        .filter(Predicate.not(String::isEmpty))
//        .filter((s) -> !BORING_WORDS.contains(s)) //NOTE this filter would remove these words before hitting forEach to terminate.
        .forEach((word) -> counts.put(word, 1 + counts.getOrDefault(word, 0))); //NOTE getOrDefault gets the (key)word and number associated with it then adds 1 to it, but if the key(word) isn't in the map, give me 0 instead and add 1.
    }
  }


