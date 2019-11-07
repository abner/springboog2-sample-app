package io.abner.gradle.apps.app1;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
public EmployeeDAOImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
NamedParameterJdbcTemplate template;  

@PersistenceContext EntityManager em;


@Override
// @Transactional(propagation = Propagation.REQUIRES_NEW)
// @Lock(LockModeType.PESSIMISTIC_WRITE)
public List<Employee> findAll() {
//return template.query("select * from employee for update;", new EmployeeRowMapper());
TypedQuery<Employee> q = em.createQuery("select c from Employee c where employeeid = '1168178281'", Employee.class);
q.setLockMode(LockModeType.PESSIMISTIC_READ);
return q.getResultList();
}
@Override
public void insertEmployee(Employee emp) {
 final String sql = "insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values(:employeeId,:employeeName,:employeeEmail,:employeeAddress)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
.addValue("employeeId", emp.getEmployeeId())
.addValue("employeeName", emp.getEmployeeName())
.addValue("employeeEmail", emp.getEmployeeEmail())
.addValue("employeeAddress", emp.getEmployeeAddress());
        template.update(sql,param, holder);
}
@Override
public void updateEmployee(Employee emp) {
 final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
.addValue("employeeId", emp.getEmployeeId())
.addValue("employeeName", emp.getEmployeeName())
.addValue("employeeEmail", emp.getEmployeeEmail())
.addValue("employeeAddress", emp.getEmployeeAddress());
        template.update(sql,param, holder);
}
@Override
public void executeUpdateEmployee(Employee emp) {
 final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";
 Map<String,Object> map=new HashMap<String,Object>();  
 map.put("employeeId", emp.getEmployeeId());
 map.put("employeeName", emp.getEmployeeName());
 map.put("employeeEmail", emp.getEmployeeEmail());
 map.put("employeeAddress", emp.getEmployeeAddress());
 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
    @Override  
    public Object doInPreparedStatement(PreparedStatement ps)  
            throws SQLException, DataAccessException {  
        return ps.executeUpdate();  
    }  
});  
}
@Override
public void deleteEmployee(Employee emp) {
 final String sql = "delete from employee where employeeId=:employeeId";
 Map<String,Object> map=new HashMap<String,Object>();  
 map.put("employeeId", emp.getEmployeeId());
 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
    @Override  
    public Object doInPreparedStatement(PreparedStatement ps)  
            throws SQLException, DataAccessException {  
        return ps.executeUpdate();  
    }  
});  
}
}