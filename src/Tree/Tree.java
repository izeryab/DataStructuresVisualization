package Tree;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class Tree<T>
{
Text t = new Text("");	
Alert a1 = new Alert(AlertType.INFORMATION);

private TNode root; 
static double x=500,y=100;
static double tl=100;
static double tr=100;

public Tree() 
{
	root = null; 
}

public TNode find(int key) 
{ 
	TNode n = root; 
while(n.key != key)
{
if(key < n.key)		n = n.leftChild;
else				n = n.rightChild;
if(n == null) 		return null; 
}
return n; 
}

public void insert(TNode node,Group g)
{
	node.setTranslateX(500);
	node.setTranslateY(100);


	if(root==null) 
{
root = node;
g.getChildren().add(node);
}
	else if(root.key==node.key)return;

else
{
	TNode n = root; 
	TNode parent;
	while(true) 
{
	parent = n;
	if(node.key < n.key) 
{
n = n.leftChild;
if(n == null)
{
	if(tl<30)tl=tl+60;
	parent.leftChild = node;
node.c.setFill(Color.AQUA);
node.setTranslateX(parent.getTranslateX()-tl);
node.setTranslateY(parent.getTranslateY()+40);
tl=tl-30;
break;
}
}
else
{n =n.rightChild;
if(n == null) {
	if(tr<30)tr=tr+60;	
parent.rightChild = node;
node.c.setFill(Color.BISQUE);
node.setTranslateX(parent.getTranslateX()+tr);
node.setTranslateY(parent.getTranslateY()+50);
tr=tr-30;
break;
	}
		} 
	if(node.key==n.key)break;

	}
	g.getChildren().add(node);

}
}
public boolean delete(int key) 
{ 
TNode current = root;
TNode parent = root;
boolean isLeftChild = true;
while(current.key != key) // search for node
{
parent = current;
if(key < current.key) // go left?
{
isLeftChild = true;
current = current.leftChild;
}
else
{
isLeftChild = false;
current = current.rightChild;
}
if(current == null) 
return false;
}
if(current.leftChild==null &&current.rightChild==null)
{
if(current == root)				root = null;else if(isLeftChild)
	parent.leftChild = null; 
	else						parent.rightChild = null;
	}
	else if(current.rightChild==null)
	if(current == root)			root = current.leftChild;
	else if(isLeftChild)		parent.leftChild = current.leftChild;
	else						parent.rightChild = current.leftChild;
	else if(current.leftChild==null)if(current == root)	root = current.rightChild;
	else if(isLeftChild)		parent.leftChild = current.rightChild;
	else						parent.rightChild = current.rightChild;
    return true; 
}

public void traverse(int x)
{

switch(x)
{
case 1:
a1.setHeaderText("preorder");
t.setText("");
preOrder(root);
break;
case 2:
	a1.setHeaderText("inorder");
	t.setText("");
	inOrder(root);
break;
case 3:
	a1.setHeaderText("postorder");
	t.setText("");
	postOrder(root);
break;
}

a1.setContentText(""+t.getText());
a1.show();
}
private void preOrder(TNode root)
{

	if(root != null)
{
t.setText(t.getText()+root.key + " ");
preOrder(root.leftChild);
preOrder(root.rightChild);
}
}
private void inOrder(TNode root)
{
	if(root != null)
{
inOrder(root.leftChild);
t.setText(t.getText()+root.key + " ");
inOrder(root.rightChild);
}
}
private void postOrder(TNode root)
{
	if(root != null)
{
postOrder(root.leftChild);
postOrder(root.rightChild);
t.setText(t.getText()+root.key + " ");
}
}

}