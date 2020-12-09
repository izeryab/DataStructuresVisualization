package LinkedLists;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class DNode<T> extends Group{
Text t= new Text();
Rectangle c = new Rectangle(100,40);
	protected T element;
    protected DNode next=null;
    protected DNode prev=null;

    public DNode(T e, DNode n,DNode p,double x,double y) {
    	super();
        element = e;
        next = n;
        prev = p;

        t.setText("Element "+e+"\nNext ");
                
        c.setFill(Color.AQUA);
        super.getChildren().add(c);
        super.getChildren().add(t);
        super.setTranslateX(x);
        super.setTranslateY(y);
    }

    /** Returns the element of this node */
    public T getElement() { return element; }
    /** Returns the previous node of this node */
    public DNode getPrev() { return prev; }
    /** Returns the next node of this node */
    public DNode getNext() { return next; }
    /** Sets the element of this node */
    public void setElement(T newElem) { element = newElem; }
    /** Sets the previous node of this node */
    public void setPrev(DNode newPrev) { prev = newPrev; }
    /** Sets the next node of this node */
    public void setNext(DNode newNext) { next = newNext; }

}
