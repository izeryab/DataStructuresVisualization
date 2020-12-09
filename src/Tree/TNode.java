package Tree;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class TNode<T> extends Group
{
	Text t= new Text();
	Circle c = new Circle(20);
public int key; 
public T data;
public TNode leftChild;
public TNode rightChild;


public TNode(int key, T data) {
	super();
	this.key = key;
	this.data = data;
	this.leftChild = null;
	this.rightChild = null;
//	t.setText("{"+key+" , "+data+"}");
	t.setText(""+key);
	
	c.setFill(Color.LIGHTSKYBLUE);
     t.setTranslateX(c.getTranslateX()-10);
	 super.getChildren().add(c);
     super.getChildren().add(t);
 
}


public T getElement() { return data; }
public TNode getLeft() { return leftChild; }
public TNode getRight() { return rightChild; }

public void setElement(T newElem) { data = newElem; }
public void setRight(TNode newNext) { rightChild = newNext; }
public void setLeft(TNode newNext) { leftChild = newNext; }

}
