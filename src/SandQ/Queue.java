package SandQ;

import Main.Menu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Queue extends Application{
	private Node[] queue;
	private int front;
	private int rear;
	private int size;
static double x = 100;
static final double y = 100;
	
	public Queue() {
		front=0;
		rear=0;
		size =50;
		queue= new Node[50];
	}

	public Queue(int size)
	{
		rear=0;
		front=0;
		this.size= size;
		queue= new Node[size];	
	}

	public void enqueue(Node item,Group root) {
		if(!isFull()) {
		x=x+100;
		if(queue[front]!=null)queue[front].setOpacity(0.0);
		queue[front]=item;
		root.getChildren().add(item);
		front++;
		//System.out.println(front);
		}
		if(isFull()) {
		front=0;
		x=100;
		}
		
	}

	public boolean isFull() {
		return (front==queue.length);
	}

	public  void dequeue() {
		if(rear==size)rear=0;
		if(queue[rear]!=null)
		queue[rear++].setOpacity(0.0);
		//System.out.println(rear);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Image i = new Image("file:src/images/SQ.jpg",600,600,false,false);
		root.getChildren().add(new ImageView(i));
	
		Queue q = new Queue(10);
		HBox h1 = new HBox();
		Label Front = new Label();
		Label Rear = new Label();

		TextField t =new TextField();
		Button En = new Button("Enqueue");
		Button De = new Button("Dequeue");
		Button Main = new Button("Back to Main");
		
		h1.getChildren().add(t);
		h1.getChildren().add(En);
		h1.getChildren().add(De);
		//q.dequeue();
		//q.dequeue();
		En.setOnAction(e->{
			q.enqueue(new Node(t.getText(),x,y),root);	
			t.setText("");
			 // Update the GUI on the JavaFX Application Thread
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    Front.setText("Front value "+q.front);
                    Rear.setText("Rear Value "+q.rear);
                }
		});
            
		});
		
            De.setOnAction(e->{
			q.dequeue();	
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    Front.setText("Front value "+q.front);
                    Rear.setText("Rear Value "+q.rear);
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
    		Main.setTranslateX(420);
    	
        h1.getChildren().add(Front);
		h1.getChildren().add(Rear);
		root.getChildren().addAll(h1,Main);
	    	Scene scene = new Scene(root,500,500);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
