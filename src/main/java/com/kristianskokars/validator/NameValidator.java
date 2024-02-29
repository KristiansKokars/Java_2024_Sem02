package com.kristianskokars.validator;

public class NameValidator {
    public static boolean isValidLatvianName(String name) {
        return name.matches("[A-ZŽĒŪĪĻĶĢŠĀČŅ]{1}[a-zžēūīļķģšāčņ]+");
    }
}
