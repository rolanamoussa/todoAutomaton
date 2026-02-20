package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class jsonDataReader {

    private static final ObjectMapper objectMapper =new ObjectMapper();
private jsonDataReader(){

}

public static List<Map<String ,Object>> readJsonnListOfMaps(String filepath){
    try {
        return objectMapper.readValue(
                new File(filepath),
                new TypeReference<List<Map<String, Object>>>() {}
        );
    }catch (IOException e){
        throw new RuntimeException("Faild to read JSON file: "+filepath,e);
    }
}
}
