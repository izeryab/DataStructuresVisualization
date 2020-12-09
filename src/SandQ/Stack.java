package SandQ;
import Main.Menu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Stack extends Application{
	private Node[] stack;
	private int top;
	private int size;
static double x = 100;
static final double y = 100;
	
	public Stack() {
		top=-1;
		size =50;
		stack= new Node[50];
	}

	public Stack(int size)
	{
		top=-1;
		this.size= size;
		stack= new Node[size];	
	}

	public void push(Node item,Group root) {
		if(!isFull()) {
		x=x+100;
		stack[++top]=item;
		root.getChildren().add(stack[top]);
		}
	}

	public boolean isFull() {
		return (top==stack.length-1);
	}

	public  void pop() {
	if(top!=-1) {	
	stack[top--].setOpacity(0.0);
	x=x-100;}
	if(top==-1) {
		x=100;
	}
	}

	
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Stack s = new Stack(10);
		Image i = new Image("file:src/images/SQ.jpg",600,600,false,false);
		root.getChildren().add(new ImageView(i));

		HBox h1 = new HBox();
		TextField t =new TextField();
		Label Peak= new Label();
		Button Push = new Button("Push");
		Button Pop = new Button("Pop");

		Button Main = new Button("Back to Main");
		h1.getChildren().add(t);
		h1.getChildren().add(Push);
		h1.getChildren().add(Pop);

		Push.setOnAction(e->{
			s.push(new Node(t.getText(),x,y),root);	t.setText("");
			Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    Peak.setText("Peak	: "+s.top);
                }
			});
		});
		Pop.setOnAction(e->{
			s.pop();
			 Platform.runLater(new Runnable() {

	                @Override
	                public void run() {
	                    Peak.setText("Peak	: "+s.top);
	                }
				});
		});	
			
	   	Main.setOnAction(e->{
			Menu X = new Menu();
			try {
				
				X.start(stage);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Main.setTranslateX(400);
	
		h1.getChildren().add(Peak);
		root.getChildren().addAll(h1,Main);
		Scene scene = new Scene(root,500,500);
		stage.setScene(scene);
		stage.show();
	
	}
	
public static void main(String[] args) {
	launch(args);
}
}
