//Akash Raj Palamalayil
//200562507
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.List;

public class CustomerTableView extends Application {

    private TableView<Customer> tableView = new TableView<>();
    private ObservableList<Customer> customerData = FXCollections.observableArrayList();
    private Label rowsInTableLabel = new Label();
    private static final String JSON_FILE_PATH = "path/to/your/customers.json"; // Update this path

    @Override
    public void start(Stage primaryStage) {
        // Set up the TableView columns
        TableColumn<Customer, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Customer, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Customer, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customer, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Customer, String> totalPurchasesColumn = new TableColumn<>("Total Purchases");
        totalPurchasesColumn.setCellValueFactory(cellData -> {
            double total = cellData.getValue().getTotalPurchases();
            String formattedTotal = formatAsCurrency(total);
            return new javafx.beans.property.SimpleStringProperty(formattedTotal);
        });

        // Add columns to TableView
        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, phoneColumn, totalPurchasesColumn);

        // Load data
        loadCustomerData();

        // Set up layout and update label
        VBox vbox = new VBox(rowsInTableLabel, tableView);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer Table View");
        primaryStage.show();
    }

    // Load customer data from JSON file
    private void loadCustomerData() {
        List<Customer> customers = JsonParser.readCustomersFromJson(JSON_FILE_PATH);
        if (customers != null) {
            customerData.addAll(customers);
            tableView.setItems(customerData);
        } else {
            rowsInTableLabel.setText("Failed to load customer data.");
        }

        // Update the label with the number of rows
        updateRowsLabel();
    }

    // Update the label to show the total number of rows
    private void updateRowsLabel() {
        rowsInTableLabel.setText("Rows returned: " + tableView.getItems().size());
    }

    // Format double as currency with exactly 2 decimal places
    private String formatAsCurrency(double amount) {
        DecimalFormat df = new DecimalFormat("$#.00");
        return df.format(amount);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
