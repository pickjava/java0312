import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.StudentDao;
import com.offcn.pojo.Student;
import com.offcn.service.StudentService;

public class JunitTest {

	@Test
	public void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		StudentDao bean = ac.getBean(StudentDao.class);
		List<Student> student = bean.getAllStudent();
		for(Student s:student){
		System.out.println(s.getSname());
		}
	}
	@Test
	public void test02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-dao.xml","classpath:spring-service.xml");
		StudentService bean = ac.getBean(StudentService.class);
		List<Student> student = bean.getAllStudent();
		for(Student s:student){
		System.out.println(s.getSname());
		}
	}
}
