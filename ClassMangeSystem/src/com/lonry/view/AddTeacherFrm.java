package com.lonry.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lonry.dao.TeacherDao;
import com.lonry.model.Teacher;
import com.lonry.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddTeacherFrm extends JInternalFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherAgeTextField;
	private JRadioButton teacherSexManRadioButton;
	private JRadioButton teacherSexFemalRadioButton;
	private JPasswordField teacherPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrm frame = new AddTeacherFrm();
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
	public AddTeacherFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u6559\u5E08");
		setBounds(100, 100, 450, 341);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u8001\u5E08.png")));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u6027\u522B.png")));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		teacherSexManRadioButton = new JRadioButton("\u7537");
		teacherSexManRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		teacherSexManRadioButton.setSelected(true);
		
		teacherSexFemalRadioButton = new JRadioButton("\u5973");
		teacherSexFemalRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		buttonGroup.add(teacherSexManRadioButton);
		buttonGroup.add(teacherSexFemalRadioButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u804C\u79F0\u8BC4\u5B9A.png")));
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u5E74\u9F84.png")));
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addTeacherAct(ae);
			}
		});
		submitButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		submitButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u786E\u8BA4.png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		resetButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		
		JLabel lblNewLabel_4 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u5BC6\u7801.png")));
		lblNewLabel_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		teacherPasswordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherAgeTextField, 133, 133, 133))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherTitleTextField, 133, 133, 133))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(teacherSexManRadioButton)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(teacherSexFemalRadioButton))))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherPasswordField))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(111)
							.addComponent(submitButton)
							.addGap(18)
							.addComponent(resetButton)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(teacherSexManRadioButton)
						.addComponent(teacherSexFemalRadioButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(teacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherAgeTextField.setText("");
		teacherSexManRadioButton.setSelected(true);
		teacherPasswordField.setText("");
	}

	protected void addTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String teacherName = teacherNameTextField.getText().toString();
		String teacherSex = teacherSexManRadioButton.isSelected() ? teacherSexManRadioButton.getText().toString() : teacherSexFemalRadioButton.getText().toString();
		String teacherTitle = teacherTitleTextField.getText().toString();
		String teacherPassword = teacherPasswordField.getText().toString();
		int teacherAge = 0;
		try {
			teacherAge = Integer.parseInt(teacherAgeTextField.getText().toString());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "ƒÍ¡‰÷ª‘ –Ì ‰»Î ˝◊÷£°");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)) {
			JOptionPane.showMessageDialog(this, "ΩÃ ¶–’√˚±ÿ–ÎÃÓ–¥£°");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)) {
			JOptionPane.showMessageDialog(this, "ΩÃ ¶÷∞≥∆±ÿ–ÎÃÓ–¥£°");
			return;
		}
		if(teacherAge == 0 || teacherAge < 0) {
			JOptionPane.showMessageDialog(this, "ΩÃ ¶ƒÍ¡‰±ÿ–Î¥Û”⁄0£°");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)) {
			JOptionPane.showMessageDialog(this, "ΩÃ ¶µ«¬º√‹¬Î≤ªƒ‹Œ™ø’£°");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.addTeacher(teacher)) {
			JOptionPane.showMessageDialog(this, "ΩÃ ¶ÃÌº”≥…π¶£°");
		}else {
			JOptionPane.showMessageDialog(this, "ΩÃ ¶ÃÌº” ß∞‹£°");
		}
		resetValue(ae);	  
	}
}
