package fileservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Startup {
    public static void main(String[] args) throws IOException {
        
        
        String filePath = "src/test.txt";
        TextFormatStrategy fmt = new CustomGarageTotalsFormatter();
        TextReaderStrategy reader = new TextFileReader(filePath, fmt);
        TextWriterStrategy writer = new TextFileWriter(filePath, fmt);
        FileService srv = new FileService(reader, writer);
        
        //Test Decode
        List<Map<String,String>> expected = srv.readFile();
        System.out.println(expected);
       
        //Test Encode
        List<Map<String, String>> dataFromApp = new ArrayList<>();
        Map<String,String> record = new HashMap<>();
        record.put("totalHours", "20.50");
        record.put("totalFees", "33.75");
        dataFromApp.add(record);
        
        String formatted = fmt.encode(dataFromApp);
        System.out.println(formatted);
        
        
    }
    
}
