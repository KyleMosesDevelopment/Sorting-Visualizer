package asg8;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class SortFrame 
{
	public static final int MYWIDTH=1200;
	public static final int MYHEIGHT=900;
	public static void main(String[]args)
	{
	SortEngine sortEngine = new SortEngineImpl(SortEngine.MAX_SIZE);
	
	SortController controller = new SortController(sortEngine);
	JFrame frame = new JFrame("Sorting Gui -- KYLE MOSES");
	frame.setLayout(new FlowLayout());
	frame.addWindowListener( new WindowAdapter() {
		public void windowClosing(WindowEvent windowEvent)
		{
			System.exit(0);
		}
	});
	frame.getContentPane().add(controller);
	frame.setSize(SortFrame.MYWIDTH, SortFrame.MYHEIGHT);
	frame.setVisible(true);
   }


}
