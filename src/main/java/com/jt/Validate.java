package com.jt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jt.details.Details;


@Controller
public class Validate {
	
	@RequestMapping("/validate")
	public ModelAndView index(@RequestParam ("User-id")int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		 PrintWriter out = response.getWriter();

		Details details = new Details();
        details.setId(id);
   	 Configuration con = new Configuration().configure().addAnnotatedClass(Details.class);
     ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
     		.buildServiceRegistry();
     
     SessionFactory sf = con.buildSessionFactory(reg);
     
     Session session =sf.openSession();
     Transaction tx = session.beginTransaction();
     // start a transaction
	 response.setContentType("text/html");
		ModelAndView mv = new ModelAndView();

         
         
//         try  {
//        
//             // get an user object
//        
//
//
//      	        out.println("<div align=\"center\">");
//      	        out.println("Id is " +details.getId());
//      	        out.println("</div>");                   
//             // commit transaction
//             
//     
//         } catch (HibernateException e) {
//             
//             e.printStackTrace();
//             session.getTransaction().rollback();
//         }
//         
         id = details.getId();
         
         
         try {
             tx.commit();

             session.beginTransaction();
              
             Details d = (Details) session.get(Details.class, id);
             String name= d.getFullName();
             String uname= d.getUserName();
           String password= d.getPassword();
           String email= d.getEmail();

             mv.setViewName("edit.jsp");
        	 
        	 mv.addObject("id", id);
        	 mv.addObject("name", name);
        	 mv.addObject("UserName", uname);
        	 mv.addObject("email", email);

        	 mv.addObject("password", password);

             session.getTransaction().commit();
             
         }
         catch (Exception e) {
        	 
        	 mv.setViewName("display.jsp");
        	 
        	 mv.addObject("id", id);
        	 
        	 
         }
          
    	 return mv;

         
         
         
         

	
	}
}
