package edu.daffodils.studentmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.daffodils.studentmanagement.model.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private DataSource dataSource;
	
	Logger logger = Logger.getLogger(StudentDAOImpl.class.getName());
	
	public StudentDAOImpl(){
		
	}
	 
	public StudentDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	@Override
	public long save(Student student) {
		String query = "insert into student (regid, first_name, last_name, birthdate) values (?,?,?,?)";
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
         
        Object[] args = new Object[] {student.getRegID(), student.getFirstName(), student.getLastName(), student.getBirthDate()};
         
        if(jdbcTemplate.update(query, args) !=0){
            logger.info("Student saved with id = "+student.getRegID());
            return student.getRegID();
        }else {
        	logger.info("Student save failed with id="+student.getRegID());
        	return -1;
        }
    }

	@Override
	public Student getById(String regID) {
		
	    String query = "select regid, first_name, last_name, birthdate from student where regid = ?";
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Student student = jdbcTemplate.queryForObject(query, new Object[]{regID}, new RowMapper<Student>(){
 
            @Override
            public Student mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	Student student = new Student();
            	student.setRegID(rs.getLong("regID"));
            	student.setFirstName(rs.getString("first_name"));
            	student.setBirthDate(rs.getDate("birthdate"));
            return student;
        }});
	     
	    return student;
	}

	@Override
	public long update(Student student) {
		String query = "update student set first_name=?, last_name=?, birthdate=? where regid=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[] {student.getFirstName(), student.getLastName(), student.getBirthDate(), student.getRegID()};
        if(jdbcTemplate.update(query, args) != 0){
            logger.info("Student updated with id="+student.getRegID());
            return student.getRegID();
        }else {
        	logger.info("No student found with id="+student.getRegID());
        	return student.getRegID();
        }
	}

	@Override
	public long deleteById(int regID) {
		String query = "delete from student where regid=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        if(jdbcTemplate.update(query, regID) !=0){
        	logger.info("Student deleted with id="+regID);
        	return regID;
        }else {
        	logger.info("No student found with id="+regID);
        	return regID;
        }

	}

	@Override
	public List<Student> getAll() {
		 String query = "select regid, first_name, last_name, cast(birthdate as date) from student";
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        List<Student> stdList = new ArrayList<Student>();	        
	 
	        List<Map<String,Object>> stdRows = jdbcTemplate.queryForList(query);
	         
	        for(Map<String,Object> stdRow : stdRows){
	        	
	        	Student student = new Student();
	        	student.setRegID(Long.parseLong(String.valueOf(stdRow.get("regid"))));
	        	student.setFirstName(String.valueOf(stdRow.get("first_name")));	        	
	        	student.setLastName(String.valueOf(stdRow.get("last_name")));
	        	try {
					student.setBirthDate(new SimpleDateFormat("yyyy-mm-dd").parse(String.valueOf(stdRow.get("birthdate"))));					
				} catch (ParseException e) {
					logger.info("Date parsing error: " + e.getMessage());
				}
	            stdList.add(student);
	        }
	        return stdList;
	}

}
