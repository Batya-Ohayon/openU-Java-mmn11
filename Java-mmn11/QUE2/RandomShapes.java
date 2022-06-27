import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class RandomShapes extends Application {
	Random rand = new Random();
	Group root = new Group();
	
	public void start(Stage primaryStage) {
	Button btn = new Button();
	btn.setText("Draw Shapes");
	btn.setLayoutX(0);
	btn.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event) {
			root.getChildren().clear();
			root.getChildren().add(btn);
			for(int i=0; i<10; i++) {
				int x = rand.nextInt(600);
				int y = rand.nextInt(600);
				Shape temp = randomShape(x,y);
				root.getChildren().add(temp);
				}
			}
		});
	
	root.getChildren().add(btn);
	Scene scene = new Scene(root,600,600);
	primaryStage.setTitle("Random Shapes Generator");
	primaryStage.setScene(scene);
	primaryStage.show();
	}

	public Shape randomShape(double x, double y) {
		int s = rand.nextInt(3);
		int z = rand.nextInt(150);
		int p = rand.nextInt(150);
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		Color c = Color.rgb(r,g,b);

		if(s==0) {
			Shape t = new Rectangle(x,y,z,p);
			t.setFill(c);
			return t;
			}
		else if(s==1) {
			Shape el = new Ellipse(x,y,z,p);
			el.setFill(c);
			return el;
			}
		else {
			while(Math.sqrt((Math.pow(Math.abs(x-z), 2)+Math.pow(Math.abs(y-p), 2)))>150) {
				x = rand.nextInt(600);
				y = rand.nextInt(600);
				z = rand.nextInt(600);
				p = rand.nextInt(600);
				}
			Shape li = new Line(x,y,z,p);
			li.setStroke(c);
			return li;
			}
	}

	public static void main(String[] args) {
		launch(args);
		}
}