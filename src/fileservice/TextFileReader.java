/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ryan
 */
public class TextFileReader implements TextReaderStrategy {
    private TextFormatStrategy formatter;
    private String filePath;
    public TextFileReader(String filePath){
        setFilePath(filePath);
    }

    public TextFileReader(String filePath, TextFormatStrategy formatter) {
        setFilePath(filePath);
        setFormatter(formatter);
    }
    
    @Override
    public List<Map<String,String>> readFile() throws IOException{
        File file = new File(filePath);
        BufferedReader in = null;
        List<String> lines = new ArrayList<>();
        in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while(line != null){
                System.out.println(line);
                line = in.readLine();   
            }
            in.close();
            return formatter.decode(lines);
        
    }
    
    

    public final  TextFormatStrategy getFormatter() {
        return formatter;
    }

    public final void setFormatter(TextFormatStrategy formatter) {
        this.formatter = formatter;
    }

    public final  String getFilePath() {
        return filePath;
    }

    public final  void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
