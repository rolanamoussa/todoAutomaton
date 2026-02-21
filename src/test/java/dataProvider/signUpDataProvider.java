package dataProvider;

import org.testng.annotations.DataProvider;
import utils.jsonDataReader;
import java.util.List;
import java.util.Map;

public class signUpDataProvider {


    private static final String VALID_DATA_PATH = "src/test/resourcess/signupData.json";
    private static final String INVALID_DATA_PATH = "src/test/testData/invalidSignupData.json";


    @DataProvider(name = "ValidSignupData")
    public static Object[][] getValidData() {
        List<Map<String, Object>> dataList = jsonDataReader.readJsonnListOfMaps(VALID_DATA_PATH);
        Object[][] data = new Object[dataList.size()][5];

        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i).get("firstName");
            data[i][1] = dataList.get(i).get("lastName");
            data[i][2] = dataList.get(i).get("email");
            data[i][3] = dataList.get(i).get("password");
            data[i][4] = dataList.get(i).get("confirmPassword");
        }
        return data;
    }


    @DataProvider(name = "InvalidLoginData")
    public static Object[][] getInvalidData() {
        List<Map<String, Object>> dataList = jsonDataReader.readJsonnListOfMaps(INVALID_DATA_PATH);
        Object[][] data = new Object[dataList.size()][7];

        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i).get("scenario");
            data[i][1] = dataList.get(i).get("description");
            data[i][2] = dataList.get(i).get("firstName");
            data[i][3] = dataList.get(i).get("lastName");
            data[i][4] = dataList.get(i).get("email");
            data[i][5] = dataList.get(i).get("password");
            data[i][6] = dataList.get(i).get("confirmPassword");

        }
        return data;
    }
}