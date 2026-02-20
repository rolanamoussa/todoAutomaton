package dataProvider;

import org.testng.annotations.DataProvider;
import utils.jsonDataReader;

import java.util.List;
import java.util.Map;

public class loginDataProviders {
    //Data Provider
    private static final String VALID_LOGIN_PATH = "src/test/resourcess/loginData.json";
    private static final String INVALID_LOGIN_PATH = "src/test/testData/invalifLogindData.json";

    //data valid for login

    @DataProvider(name="validLoginData")
    public static Object[][]getValidLoginData() {
        List<Map<String, Object>> dataList = jsonDataReader.readJsonnListOfMaps(VALID_LOGIN_PATH);

        Object[][] data = new Object[dataList.size()][3];

        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i).get("username");
            data[i][1] = dataList.get(i).get("password");
            data[i][2] = dataList.get(i).get("expectedErrorMessage");
        }
        return data;
    }

    //invalid data for login
    @DataProvider(name = "invalidLoginData")
    public static Object[][]getInvalidLoginData() {
        List<Map<String,Object>> dataList=jsonDataReader.readJsonnListOfMaps(INVALID_LOGIN_PATH);

        Object[][] data = new Object[dataList.size()][3];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i).get("email");
            data[i][1] = dataList.get(i).get("password");
            data[i][2] = dataList.get(i).get("expectedErrorMessage");
        }
        return data;
    }
}



