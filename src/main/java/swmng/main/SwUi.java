package swmng.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swmng.panel.CompanyList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SwUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwUi frame = new SwUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel MainPanel = new JPanel();
		contentPane.add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar mBar = new JMenuBar();
		contentPane.add(mBar, BorderLayout.NORTH);
		
		JMenu mMenu = new JMenu("고객관리");
		mBar.add(mMenu);
		
		JMenuItem mMenuItem = new JMenuItem("공급회사");
		mMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	MainPanel.removeAll();
				MainPanel.add(new CompanyList(), BorderLayout.CENTER);
				revalidate();
				repaint();
				remove(MainPanel);
			}
		});
		mMenu.add(mMenuItem);
	
	}

}
