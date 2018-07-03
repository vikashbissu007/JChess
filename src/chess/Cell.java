package chess;

import java.awt.*;
import javax.swing.*;

import pieces.*;

/**
 * This is the Cell Class. It is the token class of our GUI.
 * There are total of 64 cells that together makes up the Chess Board
 *
 */
public class Cell extends JPanel implements Cloneable{
	
	//Member Variables
	private static final long serialVersionUID = 1L;
	private boolean ispossibledestination;
	private JLabel content;
	private Piece piece;
	int x,y;                             //is public because this is to be accessed by all the other class
	private boolean isSelected=false;
	private boolean ischeck=false;
	
	//Constructors
	public Cell(int x,int y,Piece p) {
		this.x=x;
		this.y=y;
		
		setLayout(new BorderLayout());
	
	 if((x+y)%2==0)
	  setBackground(new Color(113,198,113));
	
	 else
	  setBackground(Color.white);
	 
	 if(p!=null)
		 setPiece(p);
	}
	
	//A constructor that takes a cell as argument and returns a new cell will the same data but different reference
	public Cell(Cell cell) throws CloneNotSupportedException {
		this.x=cell.x;
		this.y=cell.y;
		setLayout(new BorderLayout());
		if((x+y)%2==0)
			setBackground(new Color(113,198,113));
		else
			setBackground(Color.white);
		if(cell.getpiece()!=null) {
			setPiece(cell.getpiece().getcopy());
		}
		else
			piece=null;
	}

	//Function to inflate a cell with a piece
	public void setPiece(Piece p) {
		piece=p;
		ImageIcon img=new ImageIcon(this.getClass().getResource(p.getPath()));
		content=new JLabel(img);
		this.add(content);
	}

	//Function to remove a piece from the cell
	public void removePiece() {
		if (piece instanceof King) {
			piece=null;
			this.remove(content);
		}
		else {
			piece=null;
			this.remove(content);
		}
	}

	//Function to access piece of a particular cell
	public Piece getpiece() {
		return this.piece;
	}

	//Function to mark a cell indicating it's selection
	public void select() {
		this.setBorder(BorderFactory.createLineBorder(Color.red,6));
		this.isSelected=true;
	}

	//Function to return if the cell is under selection
	public boolean isselected() {
		return this.isSelected;
	}

	//Function to delselect the cell
	public void deselect() {
		this.setBorder(null);
		this.isSelected=false;
	}

	//Function to highlight a cell to indicate that it is a possible valid move
	public void setpossibledestination() {
		this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
		this.ispossibledestination=true;
	}

	//Remove the cell from the list of possible moves
	public void removepossibledestination() {
		this.setBorder(null);
		this.ispossibledestination=false;
	}

	//Function to check if the cell is a possible destination
	public boolean ispossibledestination() {
		return this.ispossibledestination;
	}

	//Function to highlight the current cell as checked (For King)
	public void setcheck() {
		this.setBackground(Color.RED);
		this.ischeck=true;
	}

	//Function to deselect check
	public void removecheck() {
		this.setBorder(null);
		if((x+y)%2==0)
			setBackground(new Color(113,198,113));
		else
			setBackground(Color.white);
		this.ischeck=false;
	}

	//Function to check if the current cell is in check
	public boolean ischeck() {
		return ischeck;
	}
}