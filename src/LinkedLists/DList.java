package LinkedLists;

import Main.Menu;
import SandQ.Stack;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DList extends Application{
    protected int size;
    protected DNode head, tail;
   static double x=100,y=100;
   static double xl=x+130;
   
    void addFirst(DNode n,Group root){
        if (head==null) {
            head = tail = n;
            n.setPrev(null);
            n.setNext(null);
        }
        else {
//            n.t.setText();
            n.setNext(head);
            n.setPrev(null);
            head.setPrev(n);
            head = n;
    
    /*    	Platform.runLater(new Runnable() {
                
                @Override
                public void run() {
                  
                }
    		});
      */      
        	  
            head.setTranslateX(x+130);
          	DNode a= head.getNext();
        	while(a!=null){
        	  	a.setTranslateX(a.getTranslateX()+130);
        		a=a.getNext();
        	}
        	n.t.setText(n.t.getText()+""+n.getNext().toString());
        	n.getNext().t.setText(n.getNext().t.getText()+"\nPrev "+n.getNext().getPrev().toString());
            
        }
        
        Alert a1 = new Alert(AlertType.INFORMATION); 
        a1.setContentText("\n"+n.getElement()+" Added in Singly Linked List\n");
        a1.show();
        n.setTranslateX(100);
        n.setTranslateY(y);
        
        root.getChildren().add(n);     
        size++;
    }
    
    void Display(){
        Text t1 = new Text("head - > "+head);
        Text t2 = new Text("tail - > "+tail);
        Alert a1 = new Alert(AlertType.INFORMATION); 
        a1.setContentText(""+t1.getText()+"\n"+t2.getText());

        
        if(head != null)
        {
        	Text tx = new Text("head.getPrev() - > "+head.getPrev());
        	Text t3 = new Text("head.getNext() - > "+head.getNext());
        	Text t4 = new Text("head.getElement() - > "+head.getElement());
        	a1.setContentText(a1.getContentText()+"\n"+tx.getText());
        	a1.setContentText(a1.getContentText()+"\n"+t3.getText());
            a1.setContentText(a1.getContentText()+"\n"+t4.getText());


        }
        
        if(tail != null)
        {
           	Text ty = new Text("tail.getPrev() - > "+tail.getPrev());
        	Text t5 = new Text("tail.getNext() - > "+tail.getNext());
        	Text t6 = new Text("tail.getElement() - > "+tail.getElement());
        	a1.setContentText(a1.getContentText()+"\n"+ty.getText());
        	a1.setContentText(a1.getContentText()+"\n"+t5.getText());
            a1.setContentText(a1.getContentText()+"\n"+t6.getText());
        }
        a1.show();

    }
    
    void addLast(DNode n,Group root) {
    	 xl=xl+130;
    	   tail.setNext(n); 
    n.setPrev(tail);
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
        	head.setOpacity(0.0);
        	head=head.getNext();
        	head.setPrev(null);
        	head.t.setText("Element "+head.getElement()+"\nNext "+head.getNext());
        }
        size--;

        
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
               		tail.setOpacity(0.0);
                    tail=tail.getPrev();tail.setNext(null);
                    }
               	tail.t.setText("Element "+tail.getElement()+"\nNext "+"\nPrev"+tail.getPrev());
                tail.setNext(null);
                
        	   
               size--;


         
}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		DList s1 = new DList();
		HBox h1 = new HBox();
		Image i = new Image("file:src/images/List.jpg",600,600,false,false);
		root.getChildren().add(new ImageView(i));
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
			s1.addFirst(new DNode(t.getText(), null,null, 100, 100),root);	
		});
		AddL.setOnAction(e->{
			s1.addLast(new DNode(t.getText(), null,null, 100, 100),root);	
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
