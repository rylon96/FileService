/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ryan
 */
public interface TextReaderStrategy {

    List<Map<String, String>> readFile() throws IOException;
    
}
