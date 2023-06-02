package fr.amu.iut.cc3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    public TextField sourceOfEvent;

    public TextField comp1;
    public TextField comp2;
    public TextField comp3;
    public TextField comp4;
    public TextField comp5;
    public TextField comp6;
    @FXML
    private Circle Circle1;
    @FXML
    private Circle Circle2;
    @FXML
    private Circle Circle3;
    @FXML
    private Circle Circle4;
    @FXML
    private Circle Circle5;
    @FXML
    private Circle Circle6;

    @FXML
    private Button trace;
    @FXML
    private Button vide;

    private ListView<Circle> lesCercles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lesCercles = new ListView<Circle>();
        lesCercles.getItems().addAll(Circle1, Circle2, Circle3, Circle4, Circle5, Circle6);
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    @FXML
    public void HandlerActionOnField(ActionEvent event){
        sourceOfEvent = (TextField) event.getSource();
        int axe = GridPane.getRowIndex(sourceOfEvent);
        double value = Integer.parseInt(sourceOfEvent.getText());
        int centerX = getXRadarChart(value, axe);
        int centerY = getYRadarChart(value, axe);
        Circle leCircle = lesCercles.getItems().get(axe);
        leCircle.setCenterX(centerX);
        leCircle.setCenterY(centerY);
        leCircle.setVisible(true);
    }
}
