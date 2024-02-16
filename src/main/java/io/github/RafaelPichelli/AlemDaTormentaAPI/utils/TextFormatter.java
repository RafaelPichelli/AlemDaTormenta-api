package io.github.RafaelPichelli.AlemDaTormentaAPI.utils;

public class TextFormatter {

    public static String formatInput(String input){
        String formatedInput = input.replaceAll("\n"," ").trim();
        return formatedInput;
    }
}
