package cloudxweb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class ClientApp {
public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		try
		{
			Configuration cfg=new Configuration();
			cfg.configure("cloudxweb/hibernate.cfg.xml");
			sf=cfg.buildSessionFactory();
			session=sf.openSession();
			Transaction tx=session.beginTransaction();
			Employee emp=new Employee();
			//session.delete(emp);
			emp=(Employee)session.get("cloudxweb.Employee",342);
			//emp.setEno(111);
			tx.commit();
			//System.out.println("989 user Sucessfully deleted");
			System.out.println(emp.getEno()+emp.getEname()+emp.getEsal()+emp.getEaddr());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sf.close();
		}
	}

}
