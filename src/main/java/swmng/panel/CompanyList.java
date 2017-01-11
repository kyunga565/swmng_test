package swmng.panel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import swmng.dto.Company;
import swmng.service.CompanyService;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyList extends JPanel implements ActionListener, ListInterface {
	private JTable table;
	private JPanel BtnPanel;
	private JButton addbtn;
	private JButton delbtn ;
	private JButton updbtn ;
	private JScrollPane js;
	/**
	 * Create the panel.
	 */
	public CompanyList() {
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		table.setBounds(50, 50, 200, 150);
		table.setBorder(new EmptyBorder(10, 10, 10, 10));
		table.setModel(new DefaultTableModel(row(), col()));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		
		js = new JScrollPane(table);
		add(js, BorderLayout.CENTER);

		BtnPanel = new JPanel();
		add(BtnPanel, BorderLayout.SOUTH);

		addbtn = new JButton("등록");
		addbtn.addActionListener(this);
		BtnPanel.add(addbtn);

		delbtn = new JButton("수정");
		delbtn.addActionListener(this);
		BtnPanel.add(delbtn);

		updbtn = new JButton("삭제");
		updbtn.addActionListener(this);
		BtnPanel.add(updbtn);
	}

	public void getValue() {
		String no = (String) table.getValueAt(table.getSelectedRow(), 0);
		String coName = (String) table.getValueAt(table.getSelectedRow(), 1);
		String address = (String) table.getValueAt(table.getSelectedRow(), 2);
		String tel = (String) table.getValueAt(table.getSelectedRow(), 3);
		JOptionPane.showMessageDialog(null, no + coName + " " + address + " " + tel + "을 수정하시겠습니까?");
	}

	private String[] col() {
		return new String[] { "회사번호", "회사명", "주소", "전화번호" };
	}

	private String[][] row() {
		List<Company> list = CompanyService.getInstance().selectList();
		String[][] rowD = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			String[] arr = list.get(i).toArray();
			rowD[i] = arr;
		}
		return rowD;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("등록")) {
			remove(js);
			remove(BtnPanel);
			add(new ComAddpanel(0, e.getActionCommand()), BorderLayout.CENTER);
			revalidate();
			repaint();
		} else if (e.getActionCommand().equals("수정")) {
			if(table.getSelectedRow() == -1){
				JOptionPane.showMessageDialog(null, "수정할항목을선택해주세여");
			}else{
				int flag = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + "");
				refresh(new ComAddpanel(flag, e.getActionCommand()));
			}
		} else {
			if(table.getSelectedRow() == -1){
				JOptionPane.showMessageDialog(null, "삭제할항목을선택해주세여");
			}else{
				delAction(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + ""));
			}
		}
	}

	@Override
	public void delAction(int no) {
		if (JOptionPane.showConfirmDialog(null, "선택한 항목을 삭제하시겠습니까?") == 0) {
			CompanyService.getInstance().deleteList(no);
			JOptionPane.showMessageDialog(null, "삭제되었습니다");
			refresh(new CompanyList());
		} else {
			JOptionPane.showMessageDialog(null, "취소하였습니다");
		}
	}

	@Override
	public void refresh(JPanel j) {
		remove(js);
		remove(BtnPanel);
		add(j);
		revalidate();
		repaint();
	}
}
