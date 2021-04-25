package dustbin;

public abstract class Calculator implements BaseInterface{

	public abstract void mul();
	public abstract void div();
	
	public void add() {
		System.out.println("I am Add");
		
	}
}
