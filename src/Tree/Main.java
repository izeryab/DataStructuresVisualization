package Tree;

import Main.Menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application
{
		
	public static void main(String[] args) {
		launch();
	}
	@Override
	public void start(Stage s) throws Exception {
		Group root = new Group();
		Image i = new Image("file:src/images/bst.gif",1400,600,false,false);
		root.getChildren().add(new ImageView(i));

		Button Main = new Button("Back to Main");

		Tree t= new Tree();
	HBox h = new HBox();
	TextField data  = new TextField();
	data.setPromptText("data");
	TextField key  = new TextField();
	key.setPromptText("key");
	Button add = new Button("Add");
	TextField D = new TextField();
	D.setPromptText("Enter key to delete");
	Button del = new Button("Delete");
	TextField tr = new TextField();
	tr.setPromptText("1 for PRE 2 IN or 3 POST");
	Button Tra = new Button("Traverse");

	add.setOnAction(e->{
		t.insert(new TNode(Integer.parseInt(key.getText()),data.getText()), root);
	});
	del.setOnAction(e->{
		t.delete(Integer.parseInt(D.getText()));
	});
	Tra.setOnAction(e->{
		t.traverse(Integer.parseInt(tr.getText()));
	});
	
   	Main.setOnAction(e->{
			Menu X = new Menu();
			try {
				
				X.start(s);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Main.setTranslateX(500);
	
	h.getChildren().add(data);
	h.getChildren().add(key);
	h.getChildren().add(add);
	h.getChildren().add(D);
	h.getChildren().add(del);
	h.getChildren().add(tr);
	h.getChildren().add(Tra);
	h.getChildren().add(Main);

	root.getChildren().add(h);
	Scene sc= new Scene(root);
	s.setScene(sc);
	s.show();
	}
	}


/*public static void main(String[] args)
{
	Scanner s= new Scanner(System.in);
	
int value;
Tree theTree = new Tree();

while(true)
{
System.out.print("Enter first letter of show, ");
System.out.print("insert, find, delete, or traverse: ");
int choice = s.next().charAt(0);
switch(choice)
{
case 's':
theTree.traverse(1);
break;
case 'i':
System.out.print("Enter value to insert: ");
value = s.nextInt();
theTree.insert(value, value + 0.9);
break;
case 'f':
System.out.print("Enter value to find: ");
value = s.nextInt();
TNode found = theTree.find(value);
if(found != null)
{
System.out.print("Found: ");
found.displayNode();
System.out.print("\n");}
else
	System.out.print("Could not find ");
	System.out.print(value + '\n');
	break;
	case 'd':
	System.out.print("Enter value to delete: ");
	value = s.nextInt();
	boolean didDelete = theTree.delete(value);
	if(didDelete)
	System.out.print("Deleted " + value + '\n');
	else
	System.out.print("Could not delete ");
	System.out.print(value + '\n');
	break;
	case 't':
	System.out.print("Enter type 1, 2 or 3: ");
	value = s.nextInt();
	theTree.traverse(value);
	break;
	default:
	System.out.print("Invalid entry\n");
}
s.close();

}*/
