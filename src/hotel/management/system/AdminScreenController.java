/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Bassey Oddy
 */
public class AdminScreenController implements Initializable {

    @FXML
    private Pane pane_1;
    @FXML
    private Pane pane_2;
    @FXML
    private Pane pane_4;
    @FXML
    private Pane pane_3;
    @FXML
    private Pane pane_5;
    @FXML
    private StackPane stackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mouse_exit_1(MouseEvent event) {
        pane_1.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_1(MouseEvent event) {
        pane_1.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_2(MouseEvent event) {
        pane_2.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_2(MouseEvent event) {
        pane_2.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_4(MouseEvent event) {
        pane_4.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_4(MouseEvent event) {
        pane_4.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_3(MouseEvent event) {
        pane_3.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_3(MouseEvent event) {
        pane_3.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_5(MouseEvent event) {
        pane_5.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_5(MouseEvent event) {
        pane_5.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void homeClicked(MouseEvent event) {
        Stage homeStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage currentStage = (Stage) pane_1.getScene().getWindow();
        Scene scene = new Scene(root);
        
        homeStage.setScene(scene);
        homeStage.initStyle(StageStyle.TRANSPARENT);
        
        currentStage.hide();
        homeStage.show();
    }

    @FXML
    private void employeeClicked(MouseEvent event) {
        Stage employeeStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("EmployeeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage currentStage = (Stage) pane_1.getScene().getWindow();
        Scene scene = new Scene(root);
        
        employeeStage.setScene(scene);
        employeeStage.initStyle(StageStyle.TRANSPARENT);
        
        currentStage.hide();
        employeeStage.show();
    }

    @FXML
    private void logoutClicked(MouseEvent event) {
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Alert"));
        dialogLayout.setBody(new Text("Do you want to Logout !"));
        
        JFXButton okButton = new JFXButton("Ok");
        JFXButton cancelButton = new JFXButton("Cancel");
        
        JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loginStage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Stage currentStage = (Stage) pane_1.getScene().getWindow();
                Scene scene = new Scene(root);

                loginStage.setScene(scene);
                loginStage.initStyle(StageStyle.TRANSPARENT);

                currentStage.hide();
                loginStage.show();
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        dialogLayout.setActions(okButton, cancelButton);
        dialog.show();
    }

    @FXML
    private void customerClicked(MouseEvent event) {
        Stage CustomerStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage currentStage = (Stage) pane_1.getScene().getWindow();
        Scene scene = new Scene(root);
        
        CustomerStage.setScene(scene);
        CustomerStage.initStyle(StageStyle.TRANSPARENT);
        
        currentStage.hide();
        CustomerStage.show();
    }

    @FXML
    private void exitClcked(MouseEvent event) {
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Alert"));
        dialogLayout.setBody(new Text("Do you want to exit !"));
        
        JFXButton okButton = new JFXButton("Ok");
        JFXButton cancelButton = new JFXButton("Cancel");
        
        JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        dialogLayout.setActions(okButton, cancelButton);
        dialog.show();
    }
    
}
