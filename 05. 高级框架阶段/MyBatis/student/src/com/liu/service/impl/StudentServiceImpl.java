package com.liu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.liu.mapper.StudentMapper;
import com.liu.mapper.TeacherMapper;
import com.liu.pojo.PageInfo;
import com.liu.pojo.Student;
import com.liu.pojo.Teacher;
import com.liu.service.StudentService;
import com.liu.util.MyBatisUtil;

public class StudentServiceImpl implements StudentService {

	@Override
	public PageInfo selByPage(String pageSizeStr, String pageNumberStr, String sname, String tname) {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		int pageSize = 2, pageNumber = 1;
		if (pageSizeStr!=null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if (pageNumberStr!=null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		PageInfo pi = new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		pi.setPageStart(pageSize*(pageNumber-1));
		pi.setSname(sname);
		pi.setTname(tname);
		List<Student> list = studentMapper.selByPage(pi);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		for (Student student : list) {
			student.setTeacher(teacherMapper.selById(student.getTid()));
		}
		pi.setList(list);
		long count = studentMapper.selCount(pi);
		pi.setTotal(count%pageSize==0?count/pageSize:(count/pageSize+1));
		return pi;
	}

}
