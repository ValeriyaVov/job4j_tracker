package ru.job4j.inheritance;

public class JSONReport extends TextReport {

   @Override
   public String generate(String name, String body) {
      String in = System.lineSeparator();
      return "{" + in
              + "\t\"name\"" + " : " + "\"" + name + "\"" + "," + in
              + "\t\"body\"" + " : " + "\"" + body + "\"" + in
              + "}";
   }
}
