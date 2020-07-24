package com.lonry.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.lonry.dao.CourseDao;
import com.lonry.dao.SelectedCourseDao;
import com.lonry.dao.StudentDao;
import com.lonry.model.Course;
import com.lonry.model.SelectedCourse;
import com.lonry.model.Student;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageSelectedCourseFrm extends JInternalFrame {
	private JTable selectedCourseListTable;
	private JComboBox searchCourseComboBox;
	private JComboBox searchStudentComboBox;
	private JComboBox editSelectedStudentComboBox;
	private JComboBox editSelectedCourseComboBox;
	private List<Student> studentList = new ArrayList<Student>();
	private List<Course> courseList = new ArrayList<Course>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSelectedCourseFrm frame = new ManageSelectedCourseFrm();
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
	public ManageSelectedCourseFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u751F\u9009\u8BFE");
		setBounds(100, 100, 579, 466);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u5B66\u751F1.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchStudentComboBox = new JComboBox();
		searchStudentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				studentChangeAct(ie);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u8BFE\u7A0B1.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchCourseComboBox = new JComboBox();
		
		JButton confirmSelectedButton = new JButton("\u786E\u8BA4\u9009\u8BFE");
		confirmSelectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmSelectedCourse(ae);
			}
		});
		confirmSelectedButton.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u786E\u8BA41.png")));
		confirmSelectedButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u9009\u8BFE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchCourseComboBox, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(confirmSelectedButton)
					.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(78, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addGap(71))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(searchCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmSelectedButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(23))
		);
		
		selectedCourseListTable = new JTable();
		selectedCourseListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedCourse(me);
			}
		});
		selectedCourseListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9009\u8BFE\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(selectedCourseListTable);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u5B66\u751F1.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSelectedStudentComboBox = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFE\u7A0B\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u8BFE\u7A0B1.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSelectedCourseComboBox = new JComboBox();
		
		JButton confirmEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		confirmEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editSelectedCourseAct(ae);
			}
		});
		confirmEditButton.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u786E\u8BA41.png")));
		confirmEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton deleteCourseButton = new JButton("\u8BFE\u7A0B\u9000\u9009");
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteSelectedCourse(ae);
			}
		});
		deleteCourseButton.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u5220\u96642.png")));
		deleteCourseButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editSelectedStudentComboBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editSelectedCourseComboBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(38)
							.addComponent(confirmEditButton)
							.addGap(46)
							.addComponent(deleteCourseButton)))
					.addGap(30))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(editSelectedStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(editSelectedCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmEditButton)
						.addComponent(deleteCourseButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		setStudentCombox();
		setCourseCombox();
		initTable();
		setAuthority();
	}


	protected void deleteSelectedCourse(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = selectedCourseListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		int selected_id = Integer.parseInt(selectedCourseListTable.getValueAt(row, 0).toString());
		String courseName = selectedCourseListTable.getValueAt(row, 2).toString();
		SelectedCourse sc = new SelectedCourse();
		sc.setId(selected_id);
		SelectedCourseDao scDao = new SelectedCourseDao();
		CourseDao courseDao = new CourseDao();
		if(scDao.delete(selected_id)) {
			if(courseDao.updateSelectedNum(getCourseIdByName(courseName),-1)) {
				JOptionPane.showMessageDialog(this, "退选成功！");
			}else {
				JOptionPane.showMessageDialog(this, "退选成功，更新课程信息失败！");
			}
		}else {
			JOptionPane.showMessageDialog(this, "退选失败！");
		}
		scDao.closeDao();
		courseDao.closeDao();
		initTable();
	}

	protected void editSelectedCourseAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = selectedCourseListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		int selected_id = Integer.parseInt(selectedCourseListTable.getValueAt(row, 0).toString());
		String studentName = selectedCourseListTable.getValueAt(row, 1).toString();
		String courseName = selectedCourseListTable.getValueAt(row, 2).toString();
		Student student = (Student) editSelectedStudentComboBox.getSelectedItem();
		Course course = (Course) editSelectedCourseComboBox.getSelectedItem();
		if(studentName.equals(student.getName())&&courseName.equals(course.getName())) {
			JOptionPane.showMessageDialog(this, "数据还未修改！");
			return;
		}
		CourseDao courseDao = new CourseDao();
		if(!courseDao.selectedEnable(course.getId())) {
			JOptionPane.showMessageDialog(this, "该课程已经选满，不能再选！");
			return;
		}

		SelectedCourse sc = new SelectedCourse();
		sc.setId(selected_id);
		sc.setStudent_id(student.getId());
		sc.setCourse_id(course.getId());
		SelectedCourseDao scDao = new SelectedCourseDao();
		if(scDao.isSelected(sc)) {
			JOptionPane.showMessageDialog(this, "已经选过该课程！");
			return;
		}
		if(scDao.updateSelectedCourse(sc)) {
			if(courseDao.updateSelectedNum(sc.getCourse_id(),1)) {
				if(courseDao.updateSelectedNum(getCourseIdByName(courseName), -1)) {
					JOptionPane.showMessageDialog(this, "修改成功！");
				}
			}else {
				JOptionPane.showMessageDialog(this, "修改成功，课程信息更新失败！");
			}
		}
		courseDao.closeDao();
		scDao.closeDao();
		initTable();
	}

	protected void selectedCourse(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = selectedCourseListTable.getSelectedRow();
		String studentName = selectedCourseListTable.getValueAt(row, 1).toString();
		String courseName = selectedCourseListTable.getValueAt(row, 2).toString();
		for(int i=0;i<editSelectedStudentComboBox.getItemCount();i++) {
			Student student = (Student) editSelectedStudentComboBox.getItemAt(i);
			if(studentName.equals(student.getName())) {
				editSelectedStudentComboBox.setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<editSelectedCourseComboBox.getItemCount();i++) {
			Course course = (Course) editSelectedCourseComboBox.getItemAt(i);
			if(courseName.equals(course.getName())) {
				editSelectedCourseComboBox.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void studentChangeAct(ItemEvent ie) {
		// TODO Auto-generated method stub
		if(ie.getStateChange() == ItemEvent.SELECTED) {
			initTable();	
		}

		
	}

	protected void confirmSelectedCourse(ActionEvent ae) {
		// TODO Auto-generated method stub
		Student student = (Student) searchStudentComboBox.getSelectedItem();
		Course scourse = (Course) searchCourseComboBox.getSelectedItem();
		SelectedCourse sc = new SelectedCourse();
		sc.setStudent_id(student.getId());
		sc.setCourse_id(scourse.getId());
		CourseDao courseDao = new CourseDao();
		if(!courseDao.selectedEnable(scourse.getId())) {
			JOptionPane.showMessageDialog(this, "该课程已经选满，不能再选！");
			return;
		}
		SelectedCourseDao scDao = new SelectedCourseDao();
		if(scDao.isSelected(sc)) {
			JOptionPane.showMessageDialog(this, "已经选过该课程！");
			return;
		}
		if(scDao.addSelectedCourse(sc)) {
			if(courseDao.updateSelectedNum(sc.getCourse_id(),1)) {
				JOptionPane.showMessageDialog(this, "选课成功！");
			}else {
				JOptionPane.showMessageDialog(this, "选课成功，课程信息更新失败！");
			}
		}else {
			JOptionPane.showMessageDialog(this, "选课失败！");
		}
		courseDao.closeDao();
		scDao.closeDao();
		initTable();
	}

	private void setStudentCombox() {
		StudentDao studentDao = new StudentDao();
		studentList = studentDao.getStudentList(new Student());
		studentDao.closeDao();
		for (Student student : studentList) {
			searchStudentComboBox.addItem(student);
			editSelectedStudentComboBox.addItem(student);
		}
		if("学生".equals(MainFrm.userType.getName())){
			Student user = (Student) MainFrm.userObject;
			for(int i = 0; i < searchStudentComboBox.getItemCount();i++){
				Student student = (Student) searchStudentComboBox.getItemAt(i);
				if(student.getId() == user.getId()){
					searchStudentComboBox.setSelectedIndex(i);
					editSelectedStudentComboBox.setSelectedIndex(i);
					break;
				}
			}
		}
		
	}
	private void setCourseCombox() {
		CourseDao courseDao = new CourseDao();
		courseList = courseDao.getCourseList(new Course());
		courseDao.closeDao();
		for (Course course : courseList) {
			searchCourseComboBox.addItem(course);
			editSelectedCourseComboBox.addItem(course);
		}
	}
	private void getSelectedCourse(SelectedCourse selectedCourse) {
		SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
		List<SelectedCourse> selectedCourseList = selectedCourseDao.getSelectedCourseList(selectedCourse);
		DefaultTableModel dft = (DefaultTableModel) selectedCourseListTable.getModel();
		dft.setRowCount(0);
		for(SelectedCourse sc : selectedCourseList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(getStudentNameById(sc.getStudent_id()));
			v.add(getCourseNameById(sc.getCourse_id()));
			dft.addRow(v);
		}
		selectedCourseDao.closeDao();
	}
	private void initTable(){
		Student student = (Student) searchStudentComboBox.getSelectedItem();
		SelectedCourse sc = new SelectedCourse();
		sc.setStudent_id(student.getId());
		getSelectedCourse(sc);
	}
	private String getStudentNameById(int id) {
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getId() == id)
				return studentList.get(i).getName();
		}
		return "";
	}
	private String getCourseNameById(int id) {
		for(int i=0;i<courseList.size();i++) {
			if(id == courseList.get(i).getId())
				return courseList.get(i).getName();
		}
		return "";
	}
	private int getCourseIdByName(String name) {
		for(int i=0;i<courseList.size();i++) {
			if(name.equals(courseList.get(i).getName()))return courseList.get(i).getId();
		}
		return 0;
	}
	private void setAuthority() {
		if("学生".equals(MainFrm.userType.getName())) {
			searchStudentComboBox.setEnabled(false);
			editSelectedStudentComboBox.setEnabled(false);
			
			
		}
	}
	
}
