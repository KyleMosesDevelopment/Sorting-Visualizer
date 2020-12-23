package asg8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SortController extends JPanel
{
	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	private SortEngine engine;
	private Thread sortThread;
	private JComboBox <String> sortBox;
	private SortView sortView;
	private ChangeListener sortListener;
	private String [] mySorts = {"Quick Sort", "MergeSort", "Insertion Sort", "Selection Sort"};
	private JPanel buttonPanel;
	
	public SortController (SortEngine aEngine)
	{
		super();
		this.setPreferredSize(new Dimension(SortFrame.MYWIDTH - 10, SortFrame.MYHEIGHT -20));
		//construct buttons, button Panel
		//construct sortBox
		this.startButton = new JButton("Start");
		this.stopButton = new JButton("Stop");
		this.resetButton = new JButton("Reset");
				
		this.sortBox = new JComboBox <String>(mySorts);
		this.setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(sortBox);
		//constuct view
		this.sortView = new SortView(aEngine);
		this.engine = aEngine;
		//create a ChangeListener for the sort Engine, (asg 7)
		this.sortListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e)
			{
				update();
			}

		};
		//sort engine
		//add that to the sortEngine
		this.engine.addChangeListener(sortListener);
		this.add(buttonPanel,BorderLayout.NORTH);
		this.add(sortView, BorderLayout.SOUTH);
		init();
	}//end of contsructor
	
	private void update() 
	{
		// repaint all models (engines)
		// need delay
		try
		{
			Thread.sleep(35);
		}
		catch(InterruptedException e)
		{
			System.out.println("Error in Sleep...");
		}
		repaint();
	}
	
	private void init()
	{

		this.stopButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				while(sortThread != null && sortThread.isAlive())
				{
					engine.setStopFlag(true);
				}
			}
		});
		this.resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				while(sortThread != null && sortThread.isAlive())
				{
					engine.setStopFlag(true);
					
				}
				engine.shuffleList();
			}
		});
		this.startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				while(sortThread != null && sortThread.isAlive())
				{
					engine.setStopFlag(true);
				}
				sortThread = new Thread(new Runnable()
				{
					public void run()
					{
						engine.setStopFlag(false);
						int index = sortBox.getSelectedIndex();
						switch(index)
						{
							case 0: engine.quickSort();
								break;
							case 1: engine.mergeSort();
								break;
							case 2: engine.insertionSort();
								break;
							case 3: engine.selectionSort();
						}
					}
				});
				sortThread.start(); // put this process into process queue
			}
		});

	}
	
	


}
