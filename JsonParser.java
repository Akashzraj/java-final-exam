//Akash Raj Palamalayil
//200562507
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {
    public static List<Customer> readCustomersFromJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type customerResponseType = new TypeToken<CustomerResponse>() {}.getType();
            CustomerResponse response = gson.fromJson(reader, customerResponseType);
            return response.getCustomers();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
