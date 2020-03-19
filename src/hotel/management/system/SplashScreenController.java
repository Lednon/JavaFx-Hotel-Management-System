/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Bassey Oddy
 */
public class SplashScreenController implements Initializable {
    
    private Label label;
    @FXML
    private ImageView image;
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000), image);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loginScreen = new Stage();
                Parent root = null;
                
                try{
                    root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(root, 720, 600);
                Stage currentStage = (Stage) image.getScene().getWindow();
                
                loginScreen.setScene(scene);
                loginScreen.initStyle(StageStyle.TRANSPARENT);
                loginScreen.initStyle(StageStyle.DECORATED);
                
                currentStage.hide();
                loginScreen.show();
            }
        });
        
        fadeTransition.play();
    }    
    
}
