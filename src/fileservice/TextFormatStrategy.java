/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Ryan
 */
public interface TextFormatStrategy {

    List<Map<String, String>> decode(List<String> dataFromFile);

    String encode(List<Map<String, String>> dataFromApp);
    
}
