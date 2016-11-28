package fileservice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileService {
    private TextReaderStrategy reader;
    private TextWriterStrategy writer;
    
    public FileService(){
        
    }
    
    public FileService(TextReaderStrategy reader){
        this.reader = reader;
    }
    public FileService(TextWriterStrategy writer){
        this.writer = writer;
    }
    public FileService(TextReaderStrategy reader, TextWriterStrategy writer){
        this.reader = reader;
        this.writer = writer;
    }

    public TextReaderStrategy getReader() {
        return reader;
    }

    public void setReader(TextReaderStrategy reader) {
        this.reader = reader;
    }

    public TextWriterStrategy getWriter() {
        return writer;
    }

    public void setWriter(TextWriterStrategy writer) {
        this.writer = writer;
    }
    
    public String writeFile(List<Map<String, String>> dataFromApp)throws IOException {
        return writer.writeFile(dataFromApp);
    }
    
    public List<Map<String,String>> readFile() throws IOException{
        return reader.readFile();
    }
    
    
}
