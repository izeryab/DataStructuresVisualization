package Main;

import LinkedLists.SList;
import SandQ.Queue;
import SandQ.Stack;
import Tree.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Menu extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Text M = new Text("   Visualization of Data Structure");
		Image i = new Image("file:src/images/menu.jpg",1400,800,false,false);
		ImageView iv =new ImageView(i);
		iv.setOpacity(0.5);
		root.getChildren().add(iv);
		VBox v = new VBox();
		Button Stack = new Button("  Stack ");
		Button Queu = new Button(" Queue");
		Button SList = new Button("  SList  ");
		Button DList = new Button("  DList  ");
		Button Tre   = new Button("   Tree  ");
		Stack.setFont(Font.font(null, FontWeight.BOLD, 15));
		Queu.setFont(Font.font(null, FontWeight.BOLD, 15));
		SList.setFont(Font.font(null, FontWeight.BOLD, 15));
		DList.setFont(Font.font(null, FontWeight.BOLD, 15));
		Tre.setFont(Font.font(null, FontWeight.BOLD, 15));
	     v.setStyle("-fx-font: bold 40px 'serif' ");       
	     M.setFill(Color.BLACK);
	     v.getChildren().add(M);
		 
		Stack.setOnAction(e->{
			Stack s = new Stack();
			try {
				s.start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Queu.setOnAction(e->{
			Queue s = new Queue();
			try {
				s.start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		SList.setOnAction(e->{
			SList s = new SList();
			try {
				s.start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		DList.setOnAction(e->{
			LinkedLists.DList d = new LinkedLists.DList();
			try {
				d.start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Tre.setOnAction(e->{
			Main s = new Main();
			try {
				s.start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	v.getChildren().addAll(Stack,Queu,SList,DList,Tre);
	root.getChildren().add(v);
 	stage.setTitle("Visualization");

    stage.setScene(new Scene(root,600,500));
	stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
