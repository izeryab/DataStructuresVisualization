package SandQ;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Node<T> extends Group{
public T Value;
Circle c ;
Label l ;	

public Node(T value,double X,double Y) {
	super();
	c= new Circle(20);
	l= new Label(""+value);
	c.setFill(Color.RED);
	l.setTextFill(Color.WHITE);

	super.getChildren().add(c);
	super.getChildren().add(l);
	super.setTranslateX(X);
	super.setTranslateY(Y);
	this.Value = value;
	
}


}
