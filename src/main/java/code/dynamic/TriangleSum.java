package code.dynamic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by hernan on 01-04-14.
 * Problem Dynamic Programming
 */
public class TriangleSum {

    public static void main(String[] args) throws IOException {
        String path = "/home/hernan/Documentos/triangle.txt";
        int triangle[][] = fileRead(path);
        int lines = triangle.length;
        for (int i = lines - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        System.out.println( "Suma maxima en el triangulo: " + triangle[0][0]);
    }


    public static int[][] fileRead(String filePath) throws IOException {
        int lines = getNumberLinesFile(filePath);
        int triangle[][] = new int[lines][lines];
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        try {
            String s;
            int l = 0;
            while ((s = br.readLine()) != null) {
                String[] stringLines = s.split(" ");
                for (int i = 0; i < stringLines.length; i++) {
                    triangle[l][i] = Integer.parseInt(stringLines[i]);
                }
                l++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error accediendo al archivo : " + filePath);
        } finally {
            br.close();
            fr.close();
        }
        return triangle;
    }

    private static int getNumberLinesFile(String filePath) throws IOException {
        int lines = 0;
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        try {
            while (br.readLine() != null) {
                lines++;
            }
        } finally {
            br.close();
            fr.close();
        }
        return lines;
    }
}
