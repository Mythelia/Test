package fr.formation.inti.entities;
// Generated 8 avr. 2019 14:51:15 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "department", catalog = "bd2", uniqueConstraints = @UniqueConstraint(columnNames = "DEPT_NO"))
public class Department implements java.io.Serializable {

	private int deptId;
	private String deptName;
	private String deptNo;
	private String location;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Department() {
	}

	public Department(int deptId, String deptName, String deptNo) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptNo = deptNo;
	}

	public Department(int deptId, String deptName, String deptNo, String location, Set<Employee> employees) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptNo = deptNo;
		this.location = location;
		this.employees = employees;
	}

	@Id

	@Column(name = "DEPT_ID", unique = true, nullable = false)
	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Column(name = "DEPT_NAME", nullable = false)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "DEPT_NO", unique = true, nullable = false, length = 20)
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name = "LOCATION")
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Department(String deptName) {

		this.deptName = deptName;
	}
	

}