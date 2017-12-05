package morpion.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import morpion.model.Board;

/**
 * 棋盘视图类，用于画出棋盘
 *
 */
public class BoardView extends JPanel {
	/** 棋盘一格的大小 */
	public static final int GRID_SIZE = 100;
	/** 棋盘的引用 */
	private Board board;
	
	public BoardView(Board b){
		this.board = b;
		this.setPreferredSize(new Dimension(GRID_SIZE*b.getSize(),
				GRID_SIZE*b.getSize()));
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
	    Graphics2D g2 = (Graphics2D) g;
		this.makeLines(g2);
		this.makeMarks(g2);
	}
	
	/**
	 * 画出棋子（标记）
	 * @param g 画图对象
	 */
	public void makeMarks(Graphics2D g){
		g.setFont(new Font("SansSerif", Font.PLAIN, 120));
		for(int i=0; i<this.board.getSize(); i++){
			for(int j=0; j<this.board.getSize(); j++){
				if(this.board.getBlocks()[i][j] == 1)
					g.drawString("O", j*GRID_SIZE+GRID_SIZE/20, i*GRID_SIZE+GRID_SIZE*9/10);
				else if(this.board.getBlocks()[i][j] == 2)
					g.drawString("X", j*GRID_SIZE+GRID_SIZE/10, i*GRID_SIZE+GRID_SIZE*9/10);
			}
		}
	}
	
	/**
	 * 画出棋盘线
	 * @param g 画图对象
	 */
	public void makeLines(Graphics2D g){
		int size =this.board.getSize();
		for(int i = 1 ;i<size;i++) {
			g.drawLine(i*GRID_SIZE, 0, i*GRID_SIZE, size*GRID_SIZE);
			g.drawLine( 0, i*GRID_SIZE, size*GRID_SIZE,i*GRID_SIZE);
		}
	}

	/**
	 * 根据光标的坐标返回当前被选中的棋盘格子对应的ID
	 * @param x 光标x坐标
	 * @param y 光标y坐标
	 * @return 被选中的棋盘格子对应的ID，ID=格子所在列号 + 格子所在行号*棋盘大小 （行列号均从0开始）
	 */
	public int getSelectedBlockId(int x, int y){
		// TODO
		int index_x = x/GRID_SIZE;
		int index_y = y/GRID_SIZE;
		return index_y*this.board.getSize() + index_x;
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
}
