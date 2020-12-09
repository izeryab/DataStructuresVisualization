package LinkedLists;

import Main.Menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SList extends Application{
/** Singly linked list with nodes of type Node */
    protected int size;
    // number of elements
    protected SNode head, tail;
   static double x=100,y=100;
   static double xl=x+130;
    void addFirst(SNode n,Group root){
       if (head==null) {
            head = tail = n;
                n.setNext(null);
            }
            else {
            	
            	head.setTranslateX(x+130);
              	SNode a= head.getNext();
            	while(a!=null){
            	  	a.setTranslateX(a.getTranslateX()+130);
            		a=a.getNext();
            	}
            	n.setNext(head);
            	n.t.setText(n.t.getText()+""+n.getNext().toString());
                head = n;
            }
           Alert a1 = new Alert(AlertType.INFORMATION); 
           a1.setContentText("\n"+n.getElement()+" Added in Singly Linked List\n");
           a1.show();
           n.setTranslateX(100);
           n.setTranslateY(y);
         
           root.getChildren().add(n);
    }
    
    void Display(){
    //    VBox V = new VBox();
        Text t1 = new Text("head - > "+head);
        Text t2 = new Text("tail - > "+tail);
        Alert a1 = new Alert(AlertType.INFORMATION); 
        a1.setContentText(""+t1.getText()+"\n"+t2.getText());

//        V.getChildren().add(t1);
  //      V.getChildren().add(t2);
        
        if(head != null)
        {
        	Text t3 = new Text("head.getNext() - > "+head.getNext());
        	Text t4 = new Text("head.getElement() - > "+head.getElement());
            a1.setContentText(a1.getContentText()+"\n"+t3.getText());
            a1.setContentText(a1.getContentText()+"\n"+t4.getText());

            //V.getChildren().add(t3);
            //V.getChildren().add(t4);

        }
        
        if(tail != null)
        {
        	Text t5 = new Text("tail.getNext() - > "+tail.getNext());
        	Text t6 = new Text("tail.getElement() - > "+tail.getElement());
            a1.setContentText(a1.getContentText()+"\n"+t5.getText());
            a1.setContentText(a1.getContentText()+"\n"+t6.getText());

        	//   V.getChildren().add(t5);
         //   V.getChildren().add(t6);
          //  V.setTranslateX(x);
           // V.setTranslateY(y);
        }
//        root.getChildren().add(V);
        a1.show();

    }
    
    void addLast(SNode n,Group root) {
    xl=xl+130;
    tail.setNext(n); 
    n.setNext(null);
    tail = n; size++;

    n.setTranslateX(xl);
    n.setTranslateY(y);
    root.getChildren().add(n);
    }
   
    void deleteFirst(){
        Alert a1 = new Alert(AlertType.INFORMATION); 
        a1.setContentText("\nfirst element "+head.getElement()+" delete  Singly Linked List");
        a1.show();


    	if (head==null) {
            Alert a2 = new Alert(AlertType.INFORMATION); 
            a2.setContentText("error empty list");
            a2.show();
        }
        else {
        	head=head.getNext();
        	head.setOpacity(0.0);
        	
        }
        
}

    void deleteLast(){
        Alert a1 = new Alert(AlertType.INFORMATION); 
        a1.setContentText("\nLast element "+head.getElement()+" delete  Doubly Linked List");
        a1.show();

    	if (tail==null) {
            Alert a2 = new Alert(AlertType.INFORMATION); 
            a2.setContentText("error empty list");
            a2.show();
        }
        else {
        SNode x=head;
        while(x.getNext().getNext()!=null) {
        	x=x.getNext();
        }
        tail=x;
        tail.t.setText("Element "+tail.getElement()+"\nNext ");
        tail.getNext().setOpacity(0.0);
        tail.setNext(null);
        }
         
}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Image i = new Image("file:src/images/List.jpg",600,600,false,false);
		root.getChildren().add(new ImageView(i));
	
		SList s1 = new SList();
		HBox h1 = new HBox();
		
		TextField t =new TextField();
		Button AddF = new Button("AddFirst");
		Button AddL = new Button("AddLast");
		Button RemF = new Button("RemFirst");
		Button RemL = new Button("RemLast");	
		Button Dis	= new Button("Display");
		Button Main	= new Button("Back to Main");

		h1.getChildren().add(t);
		h1.getChildren().add(AddF);
		h1.getChildren().add(AddL);
		h1.getChildren().add(RemF);
		h1.getChildren().add(RemL);
		h1.getChildren().add(Dis);
		AddF.setOnAction(e->{
			s1.addFirst(new SNode(t.getText(), null, 100, 100),root);	
		});
		AddL.setOnAction(e->{
			s1.addLast(new SNode(t.getText(), null, 100, 100),root);	
		});
		RemF.setOnAction(e->{
			s1.deleteFirst();
			});

		RemL.setOnAction(e->{
			s1.deleteLast();
		});

		Dis.setOnAction(e->{
			s1.Display();
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
		Main.setTranslateX(500);
root.getChildren().addAll(h1,Main);
	
		Scene scene = new Scene(root);		
stage.setScene(scene);
	stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
