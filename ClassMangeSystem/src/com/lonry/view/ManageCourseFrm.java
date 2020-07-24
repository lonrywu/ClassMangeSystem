package com.lonry.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.lonry.dao.CourseDao;
import com.lonry.dao.TeacherDao;
import com.lonry.model.Course;
import com.lonry.model.Teacher;
import com.lonry.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageCourseFrm extends JInternalFrame {
	private JTextField searchCourseNameTextField;
	private JTable courseListTable;
	private JTextField editCourseTextField;
	private JTextField editCourseStudentNumTextField;
	private JComboBox editCourseTeacherComboBox;
	private JComboBox searchTeacherComboBox;
	private JTextArea editCourseInfoTextArea;
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCourseFrm frame = new ManageCourseFrm();
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
	public ManageCourseFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 803, 669);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B\u5217\u8868.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchCourseNameTextField = new JTextField();
		searchCourseNameTextField.setColumns(10);
		
		JLabel label = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		label.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchTeacherComboBox = new JComboBox();
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchCourse(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7F16\u8F91\u8BFE\u7A0B\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchCourseNameTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchTeacherComboBox, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(searchButton))))
					.addGap(122))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(searchTeacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(searchButton))
							.addGap(41))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(43))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(searchCourseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(42)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B\u5217\u8868.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editCourseTextField = new JTextField();
		editCourseTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editCourseTeacherComboBox = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFE\u7A0B\u5BB9\u91CF\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editCourseStudentNumTextField = new JTextField();
		editCourseStudentNumTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editCourseInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editCourseSubmit(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton deleteCourseButton = new JButton("\u5220\u9664\u8BFE\u7A0B");
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteCourse(ae);
			}
		});
		deleteCourseButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u5220\u9664.png")));
		deleteCourseButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCourseTextField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCourseStudentNumTextField)))
							.addGap(23)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(6)
									.addComponent(editCourseTeacherComboBox, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCourseInfoTextArea, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(120)
							.addComponent(submitEditButton)
							.addGap(89)
							.addComponent(deleteCourseButton)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(editCourseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2)
						.addComponent(editCourseTeacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(editCourseStudentNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_4))
						.addComponent(editCourseInfoTextArea, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(submitEditButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(deleteCourseButton)))
					.addGap(30))
		);
		panel.setLayout(gl_panel);
		
		courseListTable = new JTable();
		courseListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedCourse(me);
			}
		});
		courseListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u6559\u5E08", "\u8BFE\u7A0B\u5BB9\u91CF", "\u5DF2\u9009\u4EBA\u6570", "\u8BFE\u7A0B\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		courseListTable.getColumnModel().getColumn(1).setPreferredWidth(99);
		courseListTable.getColumnModel().getColumn(5).setPreferredWidth(209);
		scrollPane.setViewportView(courseListTable);
		getContentPane().setLayout(groupLayout);
		setTeacherCombox();
		setCourseListTable(new Course());
	}
	protected void editCourseSubmit(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = courseListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		int course_id = Integer.parseInt(courseListTable.getValueAt(row, 0).toString());
		Teacher teacher = (Teacher) editCourseTeacherComboBox.getSelectedItem();
		String courseName = editCourseTextField.getText().toString();
		if(StringUtil.isEmpty(courseName)) {
			JOptionPane.showMessageDialog(this, "课程名称不能为空！");
			return;
		}
		int max_student_num = 0;
		try {
			max_student_num = Integer.parseInt(editCourseStudentNumTextField.getText().toString());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "学生人数请输入大于0的整数！");
			return;
		}
		if(max_student_num <= 0) {
			JOptionPane.showMessageDialog(this, "学生人数请输入大于0的整数！");
			return;
		}
		String courseInfo = editCourseInfoTextArea.getText().toString();
		Course course = new Course();
		course.setId(course_id);
		course.setName(courseName);
		course.setTeacher_id(teacher.getId());
		course.setMax_student_num(max_student_num);
		course.setInfo(courseInfo);
		CourseDao courseDao = new CourseDao();
		if(courseDao.update(course)) {
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		courseDao.closeDao();
		setCourseListTable(new Course());
		
	}

	protected void selectedCourse(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = courseListTable.getSelectedRow();
	
		String couseName = courseListTable.getValueAt(row, 1).toString();
		int teacher_id = getTeacherIdByName(courseListTable.getValueAt(row, 2).toString());
		int max_student_num = Integer.parseInt(courseListTable.getValueAt(row, 3).toString());
		String couseInfo = courseListTable.getValueAt(row, 5).toString();
		editCourseTextField.setText(couseName);
		editCourseStudentNumTextField.setText(max_student_num+"");
		editCourseInfoTextArea.setText(couseInfo);
		for(int i=0;i<editCourseTeacherComboBox.getItemCount();i++) {
			Teacher t = (Teacher)editCourseTeacherComboBox.getItemAt(i);
			if(t.getId() == teacher_id) {
				editCourseTeacherComboBox.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void searchCourse(ActionEvent ae) {
		// TODO Auto-generated method stub
		String searchCourseName = searchCourseNameTextField.getText().toString(); 
		Teacher teacher = (Teacher) searchTeacherComboBox.getSelectedItem();
		Course course = new Course();
		course.setName(searchCourseName);
		course.setTeacher_id(teacher.getId());
		setCourseListTable(course);
	}

	protected void deleteCourse(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = courseListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		int course_id = Integer.parseInt(courseListTable.getValueAt(row, 0).toString());
		CourseDao courseDao = new CourseDao();
		if(courseDao.delete(course_id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		courseDao.closeDao();
		setCourseListTable(new Course());
	}

	private void setCourseListTable(Course course) {
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.getCourseList(course);
		DefaultTableModel dft = (DefaultTableModel) courseListTable.getModel();
		dft.setRowCount(0);
		for(Course c : courseList) {
			Vector v = new Vector();
			v.add(c.getId());
			v.add(c.getName());
			v.add(getTeacherNameById(c.getTeacher_id()));
			v.add(c.getMax_student_num());
			v.add(c.getSelected_num());
			v.add(c.getInfo());
			dft.addRow(v);
		}
		courseDao.closeDao();
	}
	private void setTeacherCombox() {
		TeacherDao teacherDao = new TeacherDao();
		teacherList = teacherDao.getTeacherList(new Teacher());
		teacherDao.closeDao();
		for(Teacher teacher : teacherList) {
			editCourseTeacherComboBox.addItem(teacher);
			searchTeacherComboBox.addItem(teacher);
		}
	}
	private String getTeacherNameById(int teacher_id) {
		String retString = "";
		for(Teacher teacher : teacherList) {
			if(teacher.getId() == teacher_id) {
				retString = teacher.getName();
				break;
			}
		}
		return retString;
	}
	private int getTeacherIdByName(String teacher_name) {
		int retId= -1;
		for(Teacher teacher : teacherList) {
			if(teacher_name.equals(teacher.getName())) {
				retId = teacher.getId();
				break;
			}
		}
		return retId;
	}
}
