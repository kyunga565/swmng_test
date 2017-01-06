package swmng.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ComAddPanel extends JPanel {
	private JTextField tfNo;
	private JTextField tfcoName;
	private JTextField tfaddress;
	private JTextField tftel;

	/**
	 * Create the panel.
	 */
	public ComAddPanel() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));
		
		JPanel MainPanel = new JPanel();
		add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNo = new JLabel("회사번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		MainPanel.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setEnabled(false);
		MainPanel.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblcoName = new JLabel("회사명");
		lblcoName.setHorizontalAlignment(SwingConstants.RIGHT);
		MainPanel.add(lblcoName);
		
		tfcoName = new JTextField();
		MainPanel.add(tfcoName);
		tfcoName.setColumns(10);
		
		JLabel lbladdress = new JLabel("주소");
		lbladdress.setHorizontalAlignment(SwingConstants.RIGHT);
		MainPanel.add(lbladdress);
		
		tfaddress = new JTextField();
		MainPanel.add(tfaddress);
		tfaddress.setColumns(10);
		
		JLabel lbltel = new JLabel("전화번호");
		lbltel.setHorizontalAlignment(SwingConstants.RIGHT);
		MainPanel.add(lbltel);
		
		tftel = new JTextField();
		MainPanel.add(tftel);
		tftel.setColumns(10);
		
		JPanel BtnPanel = new JPanel();
		add(BtnPanel, BorderLayout.SOUTH);
		
		JButton btnadd = new JButton("등록확인");
		BtnPanel.add(btnadd);
		
		JButton btncancel = new JButton("등록취소");
		BtnPanel.add(btncancel);

	}

}
