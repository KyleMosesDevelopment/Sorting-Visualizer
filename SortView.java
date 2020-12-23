package asg8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SortView extends JPanel
{
	private int [] list;
	private SortEngine engine;
	public final static int MYWIDTH = SortFrame.MYWIDTH - 50;
	public final static int MYHEIGHT = SortFrame.MYHEIGHT - 100;
		
	public SortView (SortEngine aEngine)
	{
		super();
		this.engine = aEngine;
		this.list = this.engine.getList();
		this.setPreferredSize(new Dimension(MYWIDTH, MYHEIGHT));
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		this.list = engine.getList();
		
		for(int i = 0; i < list.length; i++)
		{
				if(i%2 == 0)
				{
					g.setColor(Color.RED);
				}
				else
				{
					g.setColor(Color.CYAN);
				}
				int value = list[i];
				int x1 = i +1;
				int x2 = i + 1;
				int y1 = MYHEIGHT;
				int y2 = MYHEIGHT - value;
				g.drawLine(x1,y1,x2,y2);
		}
	}

	

}
