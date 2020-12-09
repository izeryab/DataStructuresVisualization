package LinkedLists;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class SNode<T> extends Group{
Text t= new Text();
Rectangle c = new Rectangle(100,40);
	protected T element;
    protected SNode next=null;
    public SNode(T e, SNode n,double x,double y) {
    	super();
        element = e;
        next = n;
        t.setText("Element "+e+"\nNext ");
       c.setFill(Color.AQUA);
        super.getChildren().add(c);
        super.getChildren().add(t);
        super.setTranslateX(x);
        super.setTranslateY(y);
    }

    public T getElement() { return element; }
    public SNode getNext() { return next; }
    public void setElement(T newElem) { element = newElem; }
    public void setNext(SNode newNext) { next = newNext; }
	
}
