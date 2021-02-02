package com.jt;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class update {
	@RequestMapping("update")

	public static ModelAndView index(@RequestParam ("i")int id, @RequestParam ("n")String name, @RequestParam ("u")String uname, 
			@RequestParam ("e")String email, @RequestParam("p") String password,
			HttpServletRequest request, HttpServletResponse response) throws IOException {


		Details details = new Details();

       details.setFullName(name);
       details.setEmail(email);
       details.setUserName(uname);
       details.setPassword(password);
       


  	 Configuration con = new Configuration().configure().addAnnotatedClass(Details.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
    		.buildServiceRegistry();
    
    SessionFactory sf = con.buildSessionFactory(reg);
    
    Session session =sf.openSession();
    Transaction tx = session.beginTransaction();
    
    

     
    session.save(details);
    tx.commit();

	   
		ModelAndView mv = new ModelAndView();
     

        mv.setViewName("edit.jsp");
   	 
   	 mv.addObject("id", id);
   	 mv.addObject("name", name);
   	 mv.addObject("UserName", uname);
   	 mv.addObject("email", email);

   	 mv.addObject("password", password);
         
     
	 return mv;

	 
}
}
