package gameControllers;



import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VäljSpelController implements Initializable {
    @FXML
    private Button loggaUt;
    @FXML
    private ComboBox comboBox;
    @FXML
    private ComboBox comboBox2;
    ObservableList<String> ronderList = FXCollections.observableArrayList(new String[]{"1", "2", "3", "4", "5", "6"});
    Utilities utilities = new Utilities();

    public VäljSpelController() {
    }

    public void myBox(ActionEvent event) {
        if (this.comboBox.getItems() != null) {
            System.out.println(this.comboBox.getSelectionModel().selectedItemProperty().getValue());
        }

    }

    public void loggaUtKnappenOnAction(ActionEvent event) {
        Stage stage = (Stage)this.loggaUt.getScene().getWindow();
        stage.close();
    }

    public void initialize(URL url, ResourceBundle rb) {
        this.comboBox2.getItems().addAll(Utilities.getProperty("Fragor:").split(","));
        this.comboBox.getItems().addAll(Utilities.getProperty("Ronder:").split(","));
    }
    public void startaSpel() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("category-view.fxml")));
            Stage spelStage = new Stage();
            spelStage.initStyle(StageStyle.UNDECORATED);
            spelStage.setScene(new Scene(root, 520.0D, 400.0D));
            spelStage.show();
        } catch (IOException var3) {
            var3.printStackTrace();
            var3.getCause();
        }

    }
}
