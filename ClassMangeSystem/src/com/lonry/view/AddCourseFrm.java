package com.lonry.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lonry.dao.CourseDao;
import com.lonry.dao.TeacherDao;
import com.lonry.model.Course;
import com.lonry.model.Teacher;
import com.lonry.util.StringUtil;

public class AddCourseFrm extends JInternalFrame {
	private JTextField courseNameTextField;
	private JTextField studentNumTextField;
	private JComboBox teacherListComboBox;
	private JTextArea courseInfoTextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourseFrm frame = new AddCourseFrm();
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
	public AddCourseFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setBounds(100, 100, 415, 337);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		lblNewLabel.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u7A0B\u5BB9\u91CF\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseNameTextField = new JTextField();
		courseNameTextField.setColumns(10);
		
		teacherListComboBox = new JComboBox();
		
		studentNumTextField = new JTextField();
		studentNumTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseInfoTextArea = new JTextArea();
		
		JButton addCourseButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addCourseAct(ae);
			}
		});
		addCourseButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		addCourseButton.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(studentNumTextField)
								.addComponent(teacherListComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(courseNameTextField, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(courseInfoTextArea)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(addCourseButton)
							.addGap(27)
							.addComponent(resetButton)))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(teacherListComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(studentNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(courseInfoTextArea, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCourseButton)
						.addComponent(resetButton))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setTeacherCombox();
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		courseNameTextField.setText("");
		courseInfoTextArea.setText("");
		studentNumTextField.setText("");
		teacherListComboBox.setSelectedIndex(0);
	}

	protected void addCourseAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String courseName = courseNameTextField.getText().toString();
		String courseInfo = courseInfoTextArea.getText().toString();
		Teacher selectedTeacher = (Teacher)teacherListComboBox.getSelectedItem();
		int studentMaxNum = 0;
		try{
			studentMaxNum = Integer.parseInt(studentNumTextField.getText());
		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "学生人数只能输入数字！");
			return;
		}
		if(StringUtil.isEmpty(courseName)) {
			JOptionPane.showMessageDialog(this, "请输入课程名称！");
			return;
		}
		if(studentMaxNum <= 0) {
			JOptionPane.showMessageDialog(this, "学生人数不能为负数！");
			return;
		}
		Course course = new Course();
		course.setName(courseName);
		course.setMax_student_num(studentMaxNum);
		course.setInfo(courseInfo);
		course.setTeacher_id(selectedTeacher.getId());
		CourseDao courseDao = new CourseDao();
		if(courseDao.addCourse(course)) {
			JOptionPane.showMessageDialog(this, "添加成功！");
		}else {
			JOptionPane.showMessageDialog(this, "添加失败！");
		}
		courseDao.closeDao();
		resetValue(ae);
		
	}
	private void setTeacherCombox() {
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teacherList = teacherDao.getTeacherList(new Teacher());
		teacherDao.closeDao();
		for(Teacher teacher : teacherList) {
			teacherListComboBox.addItem(teacher);
			
		}
	}
}
