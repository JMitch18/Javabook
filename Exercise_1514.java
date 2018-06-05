/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise_15.pkg14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author home
 */
public class Exercise_1514 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        //pane
	Pane pane = new Pane();

	//polygon
	Polygon polygon = new Polygon();
	pane.getChildren().add(polygon);
        polygon.setFill(Color.WHITE);
	polygon.setStroke(Color.BLACK);
        
	ObservableList<Double> list = polygon.getPoints();
	list.addAll(100.0, 28.0, 45.0, 78.0, 56.0, 49.0, 67.0, 90.0, 26.0, 49.0);
	

	//event handler
	pane.setOnMouseMoved(e -> {
            pane.getChildren().clear();
            Text text = new Text(e.getX(), e.getY(), "Mouse point is " + (polygon.contains(e.getX(), e.getY()) ? "inside " : "outside ") + "the polygon");
            pane.getChildren().addAll(polygon, text);
        });

        //scene & stage
        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("inside a polygon?"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
	}
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
