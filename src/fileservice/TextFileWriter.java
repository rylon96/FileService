package fileservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextFileWriter implements TextWriterStrategy{
    private TextFormatStrategy formatter;
    private String filePath;
    private boolean append = false;
    public TextFileWriter(String filePath){
        setFilePath(filePath);
    }
    
    public TextFileWriter(String filePath, TextFormatStrategy formatter){
        setFilePath(filePath);
        setFormatter(formatter);
    }
    

    @Override
    public String writeFile(List<Map<String, String>> dataFromApp)throws IOException {
        File file = new File(filePath);
        PrintWriter out = null;
        List<String>  lines = new ArrayList<>();
        out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        for(Map<String, String> line: dataFromApp){
            out.println(line);
        }
        out.close();
        return formatter.encode(dataFromApp);
    }

    public TextFormatStrategy getFormatter() {
        return formatter;
    }

    public final void setFormatter(TextFormatStrategy formatter) {
        this.formatter = formatter;
    }

    public String getFilePath() {
        return filePath;
    }

    public final void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
}
