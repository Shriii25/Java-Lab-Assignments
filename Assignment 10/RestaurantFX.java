import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class RestaurantFX extends Application {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    static final String USER = "root";
    static final String PASSWORD = "Shriya@25";

    TableView<MenuItem> table = new TableView<>();

    TextField idField = new TextField();
    TextField nameField = new TextField();
    TextField priceField = new TextField();
    TextField resIdField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Columns
        TableColumn<MenuItem, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<MenuItem, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MenuItem, Integer> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<MenuItem, Integer> resCol = new TableColumn<>("ResId");
        resCol.setCellValueFactory(new PropertyValueFactory<>("resId"));

        table.getColumns().addAll(idCol, nameCol, priceCol, resCol);

        // Input fields
        idField.setPromptText("ID");
        nameField.setPromptText("Name");
        priceField.setPromptText("Price");
        resIdField.setPromptText("ResId");

        HBox inputs = new HBox(10, idField, nameField, priceField, resIdField);

        // Buttons (NO VIEW BUTTON)
        Button insertBtn = new Button("Insert");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");

        insertBtn.setOnAction(e -> insertItem());
        updateBtn.setOnAction(e -> updateItem());
        deleteBtn.setOnAction(e -> deleteItem());

        HBox buttons = new HBox(10, insertBtn, updateBtn, deleteBtn);

        VBox layout = new VBox(10, inputs, buttons, table);
        layout.setPadding(new Insets(15));

        stage.setScene(new Scene(layout, 700, 400));
        stage.setTitle("Restaurant Management System");
        stage.show();

        // 🔥 AUTO LOAD DATA (IMPORTANT)
        loadTable();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // INSERT
    private void insertItem() {
        try (Connection con = connect()) {

            if (idField.getText().isEmpty() || nameField.getText().isEmpty()) {
                showAlert("Fields cannot be empty");
                return;
            }

            String sql = "INSERT INTO MenuItem VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, nameField.getText());
            ps.setInt(3, Integer.parseInt(priceField.getText()));
            ps.setInt(4, Integer.parseInt(resIdField.getText()));

            ps.executeUpdate();

            loadTable(); // auto refresh
            clearFields();

        } catch (Exception e) {
            showAlert(e.getMessage());
        }
    }

    // LOAD TABLE
    private void loadTable() {
        ObservableList<MenuItem> list = FXCollections.observableArrayList();

        try (Connection con = connect()) {

            String query = "SELECT * FROM MenuItem";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new MenuItem(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)));
            }

            table.getItems().clear();
            table.setItems(list);
            table.refresh();

        } catch (Exception e) {
            showAlert(e.getMessage());
        }
    }

    // UPDATE
    private void updateItem() {
        try (Connection con = connect()) {

            String sql = "UPDATE MenuItem SET Price=? WHERE Id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(priceField.getText()));
            ps.setInt(2, Integer.parseInt(idField.getText()));

            ps.executeUpdate();

            loadTable();
            clearFields();

        } catch (Exception e) {
            showAlert(e.getMessage());
        }
    }

    // DELETE
    private void deleteItem() {
        try (Connection con = connect()) {

            String sql = "DELETE FROM MenuItem WHERE Id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(idField.getText()));

            ps.executeUpdate();

            loadTable();
            clearFields();

        } catch (Exception e) {
            showAlert(e.getMessage());
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        priceField.clear();
        resIdField.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.show();
    }
}