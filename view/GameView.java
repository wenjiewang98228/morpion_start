package morpion.view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import morpion.controller.GameController;
import morpion.model.Game;

/**
 * 游戏视图类，为游戏主窗口
 *
 */
public class GameView extends JFrame {
	/** 游戏对象的引用 */
	private Game game;
	/** 棋盘视图的引用 */
	private BoardView bv;
	
	public GameView(String name, Game g){
		super(name);
		this.game = g;
		
		// 设置窗体属性
		this.setSize(new Dimension(300, 300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(500, 400);
		
		// 添加成员组件
		this.bv = new BoardView(this.game.getBoard());
		this.bv.addMouseListener(new GameController(this));
		this.setContentPane(this.bv);
		
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * 当游戏结束时展示的视图
	 * @param w_id 获胜玩家的ID或-2
	 */
	public void showEndGameView(int w_id){
		JDialog jd = new JDialog();
		jd.setTitle("Game over");
		jd.setPreferredSize(new Dimension(200,100));
		jd.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		jd.setLocationRelativeTo(this);
		
		if(w_id == -2){
			jd.add(new JLabel("Draw game", JLabel.CENTER));
		}
		else{
			// say congrats to the winner
			jd.add(new JLabel("Player "+this.game.getPlayerById(w_id).getName()+" wins!", JLabel.CENTER));
		}
		
		this.game.endGame(w_id);
		jd.pack();
		jd.setVisible(true);
	}
	
	public BoardView getBv() {
		return bv;
	}

	public void setBv(BoardView bv) {
		this.bv = bv;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameView g = new GameView("Morpion", new Game(3,1));
		
	}
}
