package fr.formation.init;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fr.formation.init.hibernateUtil.HibernateUtils;
import fr.formation.inti.entities.Department;
import fr.formation.inti.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory em = HibernateUtils.getSessionFactory();
		Session session = em.getCurrentSession();

		session.getTransaction().begin();

		// Get all

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
//		Root<Employee> root = query.from(Employee.class);
//		query.select(root);
//		Query<Employee> q = session.createQuery(query);
//		List<Employee> employees = q.getResultList();
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}

		// GetById

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
//		Root<Employee> root = query.from(Employee.class);
//		query.select(root).where(builder.equal(root.get("empId"), 7499l));
//		Query<Employee> q = session.createQuery(query);
//		Employee Employee = q.getSingleResult();
//		System.out.println(Employee);

		// Compte le nombre d'employee

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
//        Root<Employee> root = criteriaQuery.from(Employee.class);
//        criteriaQuery.select(builder.count(root));
//        Query<Long> query = session.createQuery(criteriaQuery);
//        long count = query.getSingleResult();
//        System.out.println("Count = " + count);

		// Order by salary

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
//		Root<Employee> root = criteriaQuery.from(Employee.class);
//		criteriaQuery.select(root);
//		criteriaQuery.orderBy(builder.asc(root.get("empName")));
//		Query<Employee> query = session.createQuery(criteriaQuery);
//		List<Employee> list = query.getResultList();
//		for (Employee employee : list) {
//			System.out.println("EMP NAME=" + employee.getEmpName() + "\t SALARY=" + employee.getSalary());
//		}

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
//        Root<Employee> empRoot = criteriaQuery.from(Employee.class);
//        Root<Department> deptRoot = criteriaQuery.from(Department.class);
//        criteriaQuery.multiselect(empRoot, deptRoot);
//        criteriaQuery.where(builder.equal(empRoot.get("department"), deptRoot.get("deptName")));
//
//        Query<Object[]> query=session.createQuery(criteriaQuery);
//        List<Object[]> list=query.getResultList();
//        for (Object[] objects : list) {
//           Employee employee=(Employee)objects[0];
//           Department department=(Department)objects[1];
//           System.out.println("EMP NAME="+employee.getEmpName()+"\t DEPT NAME="+department.getDeptName());
//        }

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Integer> criteriaQuery2 = builder.createQuery(Integer.class);
//		Root<Employee> root2 = criteriaQuery2.from(Employee.class);
//		criteriaQuery2.multiselect(builder.max(root2.get("salary")));
//		Query<Integer> query2 = session.createQuery(criteriaQuery2);
//		Integer maxSalary = query2.getSingleResult();
//		System.out.println("Max Salary = " + maxSalary);

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Department> query = builder.createQuery(Department.class);
//		Root<Department> root = query.from(Department.class);
//		query.multiselect(root.get("deptName"));
//		Query<Department> q = session.createQuery(query);
//		List<Department> Department = q.getResultList();
//		for (Department dept : Department) {
//			System.out.println(dept.getDeptName());		
//		}

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
//        Root<Department> root = criteriaQuery.from(Department.class);
//		criteriaQuery.select(builder.count(root));
//		Query<Long> query = session.createQuery(criteriaQuery);
//		long count = query.getSingleResult();
//		System.out.println("Count = " + count);

		// getDept by emp (Join)

//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
//		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
//		Root<Department> deptRoot = criteriaQuery.from(Department.class);
//		criteriaQuery.select(builder.count(empRoot));
//		criteriaQuery.where(builder.equal(empRoot.get("department"), deptRoot.get("deptId")));
//		Query<Long> query = session.createQuery(criteriaQuery);
//		List<Long> list = query.getResultList();
//		System.out.println("Count = " + list);

//		CriteriaBuilder qb = session.getCriteriaBuilder();
//		CriteriaQuery<Department> cq = qb.createQuery(Department.class);
//		CriteriaQuery<Long> query = qb.createQuery(Long.class);
//		Root<Employee> empRoot = cq.from(Employee.class);
//		Root<Department> deptRoot = cq.from(Department.class);
//	
//		cq.multiselect(deptRoot.get("deptName"));
//		Query<Department> q = session.createQuery(cq);
//		List<Department> Department = q.getResultList();
//		for (Department department2 : Department) {
//			query.select(qb.count(cq.from(Employee.class)));
//			query.where(qb.equal(empRoot.get("department"),department2.getDeptId()));
//			Long id = session.createQuery(query).getSingleResult();
//			System.out.println("Depar: "+ department2.getDeptName() + " = "+id);
//			
//		}

		 CriteriaBuilder builder = session.getCriteriaBuilder();

         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Employee> root = criteriaQuery.from(Employee.class);
         criteriaQuery.multiselect(builder.count(root.get("empName")), root.get("salary"),
               root.get("department"));
         criteriaQuery.groupBy(root.get("department"));

         Query<Object[]> query = session.createQuery(criteriaQuery);
         List<Object[]> list = query.getResultList();
         for (Object[] objects : list) {
            long count = (Long) objects[0];
     
            Department department = (Department) objects[2];
            System.out.println("Number of Employee = " + count + "\t DEPT NAME=" + department.getDeptName());
         }
         
         

		session.getTransaction().commit();
		em.close();
	}
}
