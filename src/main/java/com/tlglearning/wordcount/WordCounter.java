package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class WordCounter { //NOTE remove final here because the class willl no longer be immutable
  //TIP When creating classes, plan around inheritance. Either make it possible or intentionally stop it. Questions will always en the consideration that goes into this.

  //FIELD------------------------------------
  private final Map<String, Integer> counts = new HashMap<>();
  private int totalWords;

  //METHODS---------------------------------
      //NOTE removed the constructor bc it wasn't doing anything anymore. Hashmap is initialized above

  //ACCESSOR methods ------------------------
  public Set<String> words(){//NOTE This will return the words for the consumer. (Consumer refers to other code using this, not an actual user)
    return counts.keySet();
  }

  public int get(String word){
    return counts.getOrDefault(word, 0);//TIP getORDefault says that if the keyword being passed in isn't there, it'll return a set default
  }

  public Map<String, Integer> getCounts() {//NOTE this now gets the unmodifiable map of counts so it can only be read.
    return Collections.unmodifiableMap(counts);
  }

  public void add(String text){
    String trimmedLine = text.trim(); //NOTE makes sure that blank lines are trimmed from lines
    if (!trimmedLine.isEmpty()) {
      String[] words = splitWords(trimmedLine);
      countWords(words);
    }
  }

  public int size(){
    return counts.size();
  }

  public int total(){
    return totalWords;
  }

  @Override
  public String toString() {
    return counts.toString();
  }

  String[] splitWords(String text) {
    return text
        .toLowerCase()
        .split("[\\W_]+");//NOTE the regex for splitting around all nonword(whitespace or punct) characters with a space. \W = nonword character, _ = an underscore character, [] = find anything in these brackets, + = one or more of something

    //.split("\\s+");//NOTE: Regex says One or more consecutive white spaces
  }

 void countWords(String[] words) { //NOTE changing this method bc count above already creates the Hashmap. Now this method will just add to it.

    for (String word : words) {
      counts.put(word, get(word) +1); //NOTE get method here created above gets the previous count. Overall this is adding each key value pair for the fies words to the hashmap
      totalWords++; //This will get the total number of words.
    }
  }

  //TIP When debugging, if you click the red dot then right click, you can add an additional condition to break around. When it hits that it'll actually stop. We used word.isEmpty() this time
  //NOTE earlier we were getting empty strings bc we're getting text line by line and sometimes its a blank line.

}
