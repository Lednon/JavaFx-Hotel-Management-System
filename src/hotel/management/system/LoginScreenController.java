/*
 * <stylesheets>
        <URL value="@loginscreen.css"/>
    </stylesheets>
 */
package hotel.management.system;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Bassey Oddy
 */
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
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
    private void loginButton(MouseEvent event) {
        
        if(username.getText().toString().equals("")){
            
            Image image = new Image("img/delete.png");
            Notifications notification = Notifications.create()
                    .title("Error")
                    .text("Username is empty")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.BOTTOM_LEFT)
                    .graphic(new ImageView(image))
                    .darkStyle();
            notification.show();
        }else if(password.getText().toString().equals("")){
            
            Image image = new Image("img/delete.png");
            Notifications notification = Notifications.create()
                    .title("Error")
                    .text("Password is empty")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.BOTTOM_LEFT)
                    .graphic(new ImageView(image))
                    .darkStyle();
            notification.show();
        }else{
            boolean isExist = false;
            String userPass = "", userType = "";
            Connection connect = DBConnection.getConnection();
            String sql = "select * from users_table where username = '"+username.getText().trim()+"'";

            try {
                PreparedStatement ps = connect.prepareStatement(sql);
                ResultSet result = ps.executeQuery();

                while(result.next()){
                    isExist = true;
                    userPass = result.getString(3);
                    userType = result.getString(9);
                }

                if(isExist){

                    if(password.getText().toString().trim().equals(userPass)){

                        if(userType.equals("admin")){
                            Stage adminScreen =  new Stage();
                            Parent root = null;

                            try {
                                root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
                            } catch (IOException ex) {
                                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage currentStage = (Stage)username.getScene().getWindow();
                            Scene scene = new Scene(root, 1366, 730);

                            adminScreen.setScene(scene);
                            adminScreen.initStyle(StageStyle.TRANSPARENT);

                            currentStage.hide();
                            adminScreen.show();

                        }else{
                            Stage homeScreen =  new Stage();
                            Parent root = null;

                            try {
                                root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
                            } catch (IOException ex) {
                                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage currentStage = (Stage)username.getScene().getWindow();
                            Scene scene = new Scene(root, 1366, 730);

                            homeScreen.setScene(scene);
                            homeScreen.initStyle(StageStyle.TRANSPARENT);

                            currentStage.hide();
                            homeScreen.show();
                        }
                    }else {
            
                        Image image = new Image("img/delete.png");
                        Notifications notification = Notifications.create()
                                .title("Error")
                                .text("Wrong password for user "+username.getText().toString())
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.BOTTOM_LEFT)
                                .graphic(new ImageView(image))
                                .darkStyle();
                        notification.show();
                    }
                }else {
            
                    Image image = new Image("img/delete.png");
                    Notifications notification = Notifications.create()
                            .title("Error")
                            .text("Please check your username and password again.!")
                            .hideAfter(Duration.seconds(3))
                            .position(Pos.BOTTOM_LEFT)
                            .graphic(new ImageView(image))
                            .darkStyle();
                    notification.show();
                }

            } catch (SQLException ex) {
                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @FXML
    private void cancelButton(MouseEvent event) {
        
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
