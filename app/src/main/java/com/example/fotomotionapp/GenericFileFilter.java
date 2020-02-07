package com.example.fotomotionapp;

import java.io.File;
import java.io.FilenameFilter;

public class GenericFileFilter implements FilenameFilter {

    private String validExtension;
    private boolean isRegex;

    public GenericFileFilter(String extension) {
        this.validExtension = extension;

        // is regex is false
    }

    private GenericFileFilter(String extension, boolean isRegex) {
        this(extension);
        this.isRegex = isRegex;
    }


    // returns true if pathName ends with the given extension
    // pathName in lowercase to ensure matching is correct
    public boolean accept(File directory, String pathName) {

        // check to make sure that the filter is using a regex
        if(isRegex) {

            // check to see if the pathName matches the regex "validExtension"
            return pathName.matches(validExtension);
        } else {

            // check to see if pathName ends with "validExtension"
            return pathName.endsWith(validExtension);
        }
    }
}