package swmng.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import swmng.dto.Company;
import swmng.service.CompanyService;

public class Companel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Companel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.NORTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(row(),col()));
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		add(table, BorderLayout.CENTER);
		setVisible(true);
	}

	private String[][] row() {
		List<Company> list = CompanyService.getInstance().selectList();
		String [][] rowD = new String[list.size()][];
		for(int i =0;i<list.size();i++){
			String [] arr = list.get(i).toArray();
			rowD[i] = arr;
		}
		return rowD;
	}

	private String[] col() {
		return new String[]{"회사번호", "회사명", "주소", "전화번호"};
	}


}
