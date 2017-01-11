package swmng.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import swmng.dto.Company;
import swmng.service.CompanyService;

import javax.swing.JButton;

public class ComAddpanel extends JPanel implements ComAddInterface, ActionListener {
	private JTextField tfNo;
	private JTextField tfcoName;
	private JTextField tfaddress;
	private JTextField tftel;
	private JPanel mainpanel;
	private JLabel lblNo;
	private JLabel lblcoName;
	private JLabel lbladdress;
	private JLabel lbltel;
	private JPanel btnpanel;
	private JButton btnadd;
	private JButton btncancel;

	/**
	 * Create the panel.
	 */
	public ComAddpanel(int flag,String e) {
		setLayout(new BorderLayout(0, 0));
		
		mainpanel = new JPanel();
		add(mainpanel);
		mainpanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNo = new JLabel("회사번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		mainpanel.add(lblNo);
		
		tfNo = new JTextField();
		mainpanel.add(tfNo);
		tfNo.setColumns(10);
		
		lblcoName = new JLabel("회사명");
		lblcoName.setHorizontalAlignment(SwingConstants.RIGHT);
		mainpanel.add(lblcoName);
		
		tfcoName = new JTextField();
		tfcoName.setColumns(10);
		mainpanel.add(tfcoName);
		
		lbladdress = new JLabel("주소");
		lbladdress.setHorizontalAlignment(SwingConstants.RIGHT);
		mainpanel.add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setColumns(10);
		mainpanel.add(tfaddress);
		
		lbltel = new JLabel("전화번호");
		lbltel.setHorizontalAlignment(SwingConstants.RIGHT);
		mainpanel.add(lbltel);
		
		tftel = new JTextField();
		tftel.setColumns(10);
		mainpanel.add(tftel);
		
		btnpanel = new JPanel();
		add(btnpanel, BorderLayout.SOUTH);
		
		btnadd = new JButton("등록확인");
		btnadd.addActionListener(this);
		btnpanel.add(btnadd);
		
		btncancel = new JButton("등록취소");
		btncancel.addActionListener(this);
		btnpanel.add(btncancel);

		if (e.equals("수정")) {
			updateAction(flag);
			
		}else if(e.equals("등록")){
			tfNo.setText(CompanyService.getInstance().IncNo().getNo()+"");
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "등록확인") {
			CompanyService.getInstance().insertList(new Company(Integer.parseInt(tfNo.getText()), tfcoName.getText(),
					tfaddress.getText(), tftel.getText()));
			remove(mainpanel);
			remove(btnpanel);
			add(new CompanyList(),BorderLayout.CENTER);
			revalidate();
			repaint();
		} else if (e.getActionCommand() == "수정확인") {
			CompanyService.getInstance().updateList(new Company(Integer.parseInt(tfNo.getText()), tfcoName.getText(),
					tfaddress.getText(), tftel.getText()));
			remove(mainpanel);
			remove(btnpanel);
			add(new CompanyList());
			revalidate();
			repaint();
		} else if (e.getActionCommand() == "등록취소") {
			refresh(new CompanyList());
		} else if (e.getActionCommand() == "수정취소") {
			refresh(new CompanyList());
		}
		
	}

	@Override
	public void updateAction(int no) {
		btnadd.setText("수정확인");
		btncancel.setText("수정취소");
		
		Company list = CompanyService.getInstance().selectNo(no);
		tfNo.setText(list.getNo()+"");
		tfcoName.setText(list.getCoName());
		tfaddress.setText(list.getAddress());
		tftel.setText(list.getTel());
		revalidate();
		repaint();
		
	}

	@Override
	public void refresh(JPanel j) {
		remove(mainpanel);
		remove(btnpanel);
		add(j);
		revalidate();
		repaint();
		
	}

}
