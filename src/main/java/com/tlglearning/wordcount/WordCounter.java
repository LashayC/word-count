package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public final class WordCounter { //NOTE final here will prevent the class from being extended so its methods can't be overriden. You've intentionally decided to make the stuff here immutable and so don't want any instances created that could override this (That would break the code)
  //TIP When creating classes, plan around inheritance. Either make it possible or intentionally stop it. Questions will always en the consideration that goes into this.

  //FIELD------------------------------------
  private final Map<String, Integer> counts;

  //METHODS---------------------------------
  public WordCounter(String text) {

    //NOTE we the the methods below into their own methods because we want each of them to have one responsibility. Part of SOLID programming:
    //NOTE The act of taking a complex method and breaking it into simpler points is Deconstruction
    String[] words = splitWords(text);
    counts = Collections.unmodifiableMap(countWords(words)); //NOTE unmodifiable... is a Collection utility method that stops the counts map from be changed

  }

  //HELPER methods ------------------------
  public Set<String> words(){//NOTE This will return the words for the consumer. (Consumer refers to other code using this, not an actual user)
    return counts.keySet();
  }

  public int getCount(String word){
    return counts.getOrDefault(word, 0);//TIP getORDefault says that if the keyword being passed in isn't there, it'll return a set default
  }

  public Map<String, Integer> getCounts() {//NOTE this gets the entire Map for consumer
    return counts;
  }

  @Override
  public String toString() {
    return counts.toString();
  }

  String[] splitWords(String text) {
    return text
        .toLowerCase()
        .split(
            "[\\W_]+");//NOTE the regex for splitting around all nonword(no numbers or punct) characters with a space. \W = nonword character, _ = an underscore character, [] = find anything in these brackets, + = one or more of something, " " = replace with a space
    //.split("\\s+");//NOTE: Regex says One or more consecutive white spaces
  }
  Map<String, Integer> countWords(String[] words) {

    Map<String, Integer> counts = new HashMap<>();

    for (String word : words) {
      //DONE Check if word is already present as a key in counts:
      // if its not present, add it to counts with a value of 1;
      // otherwise, get the current value, add 1 to it, and update the map with the new value
      if (!counts.containsKey(word)) {
        counts.put(word, 1);
      } else {
        int previousCount = counts.get(word);
        counts.put(word, previousCount + 1);
      }
    }
    return counts;
  }


}
