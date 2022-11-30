
public class TreeNode<T> {
 
/*
 * Parameters
 */
 private T data;
 TreeNode<T> leftChild;
 TreeNode<T> rightChild;
 /*
  * constructors
  */
 public TreeNode(T data) {
	 this.data = data;
	 leftChild = null;
	 rightChild = null;
 }
 
 public TreeNode(TreeNode<T> node) {
	 this(node.leftChild,node.rightChild, node.getData());
 }
 
 public TreeNode(TreeNode<T> leftChild, TreeNode<T> rightChild, T data) {
	 this.data=data;
	 this.leftChild=new TreeNode<T>(leftChild);
	 this.rightChild= new TreeNode<T>(rightChild);
	 
 }
 
 /*
  * Methods
  */
 public T getData() {
	 return this.data;
 }
 
}
