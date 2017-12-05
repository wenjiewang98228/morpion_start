package morpion.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import morpion.model.Player;
import morpion.view.GameView;

/**
 * 游戏控制器，用于响应玩家的鼠标操作
 *
 */
public class GameController implements MouseListener {
	/** 棋盘视图的引用 */
	private GameView gv;
	
	public GameController(GameView gv){
		this.gv = gv;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// 如果当前游戏仍未结束
				if(!this.gv.getGame().isGameEnded()){
					// 获取光标所在棋盘格
					int block_id = gv.getBv().getSelectedBlockId(arg0.getX(), arg0.getY());
					int index_x = block_id/gv.getBv().getBoard().getSize();
					int index_y = block_id%gv.getBv().getBoard().getSize();
					// 如果当前光标所在block没有棋子
					if(gv.getBv().getBoard().getBlock(index_x, index_y) == 0) {
						// 在棋盘格中填充当前玩家对应的棋子
						gv.getGame().getCurrentPlayer().setMove(index_x, index_y);
						gv.getGame().getCurrentPlayer().play(gv.getBv().getBoard());
						// 重画棋盘
						gv.getBv().paint(gv.getBv().getGraphics());
						// 更新游戏状态，并判断游戏是否结束
						gv.getGame().switchPlayer();
						int w_id = gv.getGame().checkWinner();
						if(w_id!=-1) {
							gv.showEndGameView(w_id);
						}
					}
				}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(!this.gv.getGame().isGameEnded() && gv.getGame().getGameMode() == 1 && gv.getGame().getCurrentPlayer().getPid() == 1) {
			gv.getGame().getCurrentPlayer().play(gv.getBv().getBoard());
			// 重画棋盘
			gv.getBv().paint(gv.getBv().getGraphics());
			// 更新游戏状态，并判断游戏是否结束
			gv.getGame().switchPlayer();
			int w_id = gv.getGame().checkWinner();
			if(w_id!=-1) {
				gv.showEndGameView(w_id);
			}
		}
	}

}
