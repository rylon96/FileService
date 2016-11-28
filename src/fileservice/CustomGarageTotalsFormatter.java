package fileservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomGarageTotalsFormatter implements TextFormatStrategy {
    private final String CRLF = "\n";
    private final String TOTAL_HOURS_KEY = "totalHours";
    private final String TOTAL_FEES_KEY = "totalFee";
    
    @Override
    public final  String encode(List<Map<String,String>> dataFromApp){
        if(dataFromApp == null || dataFromApp.isEmpty()){
            throw new IllegalArgumentException();
        }
        Map<String,String> sourceData = dataFromApp.get(0);
        String sTotalHours = sourceData.get(TOTAL_HOURS_KEY);
        String sTotalFees = sourceData.get(TOTAL_FEES_KEY);
    
        return sTotalHours + CRLF + sTotalFees + CRLF;
        
    }
    
    @Override
    public final  List<Map<String,String>> decode(List<String> dataFromFile){
        String sTotalHours = dataFromFile.get(0);
        String sTotalFees = dataFromFile.get(1);
        
        List<Map<String, String>> appData = new ArrayList<>();
        Map<String,String> record = new HashMap<>();
        record.put(TOTAL_HOURS_KEY, sTotalHours);
        record.put(TOTAL_FEES_KEY, sTotalFees);
        appData.add(record);
        return appData;
    }
    

    
}
