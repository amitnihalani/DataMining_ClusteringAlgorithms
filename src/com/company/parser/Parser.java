package com.company.parser;

import com.company.beans.Gene;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amit on 10/31/2015.
 */
public class Parser {

    public static List<Gene> readDataSet(String filePath) {
        BufferedReader bufferedReader = getReader(filePath);
        List<Gene> dataSet = new ArrayList<>();
        String geneData;
        try {
            while ((geneData = bufferedReader.readLine()) != null) {
                dataSet.add(getGeneObject(geneData));
            }
        } catch (IOException e) {
            System.out.println("Exception while reading line");
            e.printStackTrace();
        }
        return dataSet;
    }

    private static BufferedReader getReader(String filePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect file path! Please enter the correct path for input file");
            System.exit(1);
        }
        return bufferedReader;
    }

    private static Gene getGeneObject(String geneData) {
        String[] geneInformation = geneData.split("\t");
        return new Gene(Integer.parseInt(geneInformation[0]), Integer.parseInt(geneInformation[1]), Arrays.copyOfRange(geneInformation, 2, geneInformation.length));
    }


}

