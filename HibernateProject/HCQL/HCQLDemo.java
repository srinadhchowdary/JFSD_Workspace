package com.klef.jfsd.HCQL;


import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class HCQLDemo 
{
	
	
	
	public static void main(String [] args)
	{
		
		HCQLDemo demo = new HCQLDemo();
		//demo.insertproduct();
		//demo.restrictionsdemo();
		//demo.ProjectionswithAggregateFunctions();
		//demo.ProjectionswithProperties();
		//demo.multiplerestrictions();
		//demo.orderdemo();
		//demo.HCQLAll();
		demo.pagination();
		
	}
	
	public void insertproduct()
	{
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Product product = new Product();
	       product.setId(1007);
	       product.setCategory("Toys");
	       product.setName("minnie");
	       product.setVendor("dmart");
	       product.setCost(45000.00);
	       product.setStock(5);
	       product.setReview("Nice Product. undali ilantivi andhari dhagara.");
	       
	       Transaction t = session.beginTransaction();
	       session.save(product);
	       t.commit();
	       
	       System.out.println("Product Object Saved Successfully");
	       
	       session.close();
	       sf.close();
	}
	
	public void restrictionsdemo()
	{
		
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       
	       
	       Criteria c1 = session.createCriteria(Product.class);
	       List<Product> plist1 = c1.list();
	       System.out.println("*****All Products*****");
	       System.out.println("Total Products : "+plist1.size());
	       if(plist1.size() > 0)
	       {
	    	   for(Product p :plist1)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       
	       
	       Criteria c2 = session.createCriteria(Product.class);
	       c2.add(Restrictions.eq("category", "Electronics"));
	       // category = "Electronics", where category is property name
	       List<Product> plist2 = c2.list();
	       System.out.println("*****eq restriction*****");
	       System.out.println("Total Products : "+plist2.size());
	       if(plist2.size() > 0)
	       {
	    	   for(Product p :plist2)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       
	       
	       Criteria c3 = session.createCriteria(Product.class);
	       c3.add(Restrictions.lt("cost", 20000.00 ));
	       // cost = 20000.00, where cost is property name
	       List<Product> plist3 = c3.list();
	       System.out.println("*****lt restriction*****");
	       System.out.println("Total Products : "+plist3.size());
	       if(plist3.size() > 0)
	       {
	    	   for(Product p :plist3)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       
	       
	       Criteria c4 = session.createCriteria(Product.class);
	       c4.add(Restrictions.gt("cost", 10000.00 ));
	       // cost = 20000.00, where cost is property name
	       List<Product> plist4 = c4.list();
	       System.out.println("*****gt restriction*****");
	       System.out.println("Total Products : "+plist4.size());
	       if(plist4.size() > 0)
	       {
	    	   for(Product p :plist4)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       
	       
	       Criteria c5 = session.createCriteria(Product.class);
	       c5.add(Restrictions.le("stock", 10 ));
	       // stock = 10, where stock is property name
	       List<Product> plist5 = c5.list();
	       System.out.println("*****le restriction*****");
	       System.out.println("Total Products : "+plist5.size());
	       if(plist5.size() > 0)
	       {
	    	   for(Product p :plist5)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       
	       Criteria c6 = session.createCriteria(Product.class);
	       c6.add(Restrictions.ge("cost", 15000.00 ));
	       // cost = 15000.00, where cost is property name
	       List<Product> plist6 = c6.list();
	       System.out.println("*****ge restriction*****");
	       System.out.println("Total Products : "+plist6.size());
	       if(plist6.size() > 0)
	       {
	    	   for(Product p :plist6)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       
	       
	       Criteria c7 = session.createCriteria(Product.class);
	       c7.add(Restrictions.between("cost", 2000.00,20000.00 ));
	       // cost >= 2000.00 and cost <= 20000.00, where cost is property name
	       List<Product> plist7 = c7.list();
	       System.out.println("*****between restriction*****");
	       System.out.println("Total Products : "+plist7.size());
	       if(plist7.size() > 0)
	       {
	    	   for(Product p :plist7)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       
	       
	       Criteria c8 = session.createCriteria(Product.class);
	         //c8.add(Restrictions.in("stock", new Integer[] {10,20,30}));
	         //  stock=10 or stock=20 or stock=30, where stock is a property name
	         
	        // c8.add(Restrictions.in("category", new String[] {"Furniture","Clothes"}));
	         //  category="Furniture" or category="Clothes"
	         c8.add(Restrictions.in("stock",10,20,30));
	        //stock=10 or stock=20 or stock=30, where stock is a property name
	         
	         List<Product> plist8 = c8.list();
	         System.out.println("*****in restriction*****");
	         System.out.println("Total Products="+plist8.size());
	         if(plist8.size()>0)
	         {
	           for(Product p : plist8)
	           {
	             System.out.println(p.toString());
	           }
	         }
	         else
	         {
	           System.out.println("Product Data Not Found");
	         }
	         
	         Criteria c9 = session.createCriteria(Product.class);
             c9.add(Restrictions.idEq(1003));
             //id equals to 1003
             List<Product> plist9 = c9.list();
             System.out.println("*****idEQ Restriction*****");
             System.out.println("Total products ="+plist9.size());
             if(plist9.size()>0)
             {
                 for( Product p  :  plist9) 
                 {
                	 System.out.println(p.toString());
                 }
             
             }
             else
             {
            	 System.out.println("Product Data Not Found");
             }
             
             Criteria c10 = session.createCriteria(Product.class);

             c10.add(Restrictions.like("name", "s%"));
             
             List<Product> plist10 = c10.list();
             System.out.println("*****like Restriction*****");
             System.out.println("Total products ="+plist10.size());
             if(plist10.size()>0)
             {
                 for( Product p  :  plist10) 
                 {
                	 System.out.println(p.toString());
                 }
             
             }
             else
             {
            	 System.out.println("Product Data Not Found");
             }
             
             Criteria c11 = session.createCriteria(Product.class);
             
             c11.add(Restrictions.isNull("review"));
             //review is property name
             List<Product> plist11 = c11.list();
             System.out.println("*****isNull Restriction*****");
             System.out.println("Total products ="+plist11.size());
             if(plist11.size()>0)
             {
                 for( Product p  :  plist11) 
                 {
                	 System.out.println(p.toString());
                 }
             
             }
             else
             {
            	 System.out.println("Product Data Not Found");
             }
	       
	       
	       
	       session.close();
	       sf.close();
		
	}
	
	
	public void ProjectionswithAggregateFunctions()
	  {
	    Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	           
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        
	        System.out.println("*****Projections with Aggregate Functions*****");
	        
	        Criteria c1 = session.createCriteria(Product.class);
	        c1.setProjection(Projections.rowCount()); // count(*)
	        List list1 = c1.list();
	        System.out.println("*****count(*)*****");
	        System.out.println("Total Products = "+list1.get(0));
	        
	        Criteria c2 = session.createCriteria(Product.class);
	        c2.setProjection(Projections.count("category")); // count(*)
	        List list2 = c2.list();
	        System.out.println("*****count(category)*****");
	        System.out.println("Total Products = "+list2.get(0));
	        
	        Criteria c3 = session.createCriteria(Product.class);
	        c3.setProjection(Projections.sum("cost")); // count(*)
	        List list3 = c3.list();
	        System.out.println("*****sum(cost)*****");
	        System.out.println("Total Products = "+list3.get(0));
	        
	        Criteria c4 = session.createCriteria(Product.class);
	        c4.setProjection(Projections.avg("cost")); // count(*)
	        List list4 = c4.list();
	        System.out.println("*****avg(cost)*****");
	        System.out.println("Total Average Product's Cost = "+list4.get(0));
	        
	        Criteria c5 = session.createCriteria(Product.class);
	        c5.setProjection(Projections.min("stock")); // count(*)
	        List list5 = c5.list();
	        System.out.println("*****min(stock)*****");
	        System.out.println("Minimum Product Stock = "+list5.get(0));
	        
	        Criteria c6 = session.createCriteria(Product.class);
	        c6.setProjection(Projections.max("stock")); // count(*)
	        List list6 = c6.list();
	        System.out.println("*****max(stock)*****");
	        System.out.println("Maximum Product Stock = "+list6.get(0));
	        
	        
	        Criteria c7 = session.createCriteria(Product.class);
	        c7.setProjection(Projections.countDistinct("category")); // count(*)
	        List list7 = c7.list();
	        System.out.println("*****countDistinct(Category)*****");
	        System.out.println("Maximum Product Stock = "+list7.get(0));
	        
	        
	        session.close();
	        sf.close();
	  }
	  
	  public void ProjectionswithProperties()
	  {
		  	Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	           
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        
	        
	        System.out.println("*****Projections with Properties*****");
	        
	        Criteria c1 = session.createCriteria(Product.class);
	        c1.setProjection(Projections.id());
	        List plist1 = c1.list();
	        System.out.println("****Id Property****");
	        if(plist1.size() > 0)
	        {
	        	for(int i = 0;i<plist1.size();i++)
	        	{
	        		System.out.println(plist1.get(i));
	        	}
	        }
	        else
	        {
	        	System.out.println("Product Data Not Found");
	        }
	        
	        Criteria c2 = session.createCriteria(Product.class);
	        c2.setProjection(Projections.property("name"));
	        List plist2 = c2.list();
	        System.out.println("****Name Property****");
	        if(plist2.size() > 0)
	        {
	        	for(int i = 0;i<plist2.size();i++)
	        	{
	        		System.out.println(plist2.get(i));
	        	}
	        }
	        else
	        {
	        	System.out.println("Product Data Not Found");
	        }
	        
	        Criteria c3 = session.createCriteria(Product.class);
	        c3.setProjection(Projections.property("cost"));
	        c3.addOrder(Order.desc("cost"));
	        List plist3 = c3.list();
	        System.out.println("****Cost Property****");
	        if(plist3.size() > 0)
	        {
	        	for(int i = 0;i<plist3.size();i++)
	        	{
	        		System.out.println(plist3.get(i));
	        	}
	        }
	        else
	        {
	        	System.out.println("Product Data Not Found");
	        }
	        
	        Criteria c4 = session.createCriteria(Product.class);
	        c4.setProjection(Projections.projectionList().add(Projections.property("id")).add(Projections.property("name")).add(Projections.property("cost")));
	        List<Object[]> plist4 = c4.list();
	        System.out.println("****Multiple Property****");
	        if(plist4.size() > 0)
	        {
	        	for(Object[] obj :plist4)
	        	{
	        		System.out.println("Product ID : "+obj[0]);
	        		System.out.println("Product Name : "+obj[1]);
	        		System.out.println("Product Cost : "+obj[2]);
	        		System.out.println();
	        	}
	        }
	        else
	        {
	        	System.out.println("Product Data Not Found");
	        }
	        
	        
	        Criteria c5 = session.createCriteria(Product.class);
	        
	        c5.setProjection(Projections.distinct(Projections.property("category")));
	        
	        List plist5 = c5.list();
	        System.out.println("****Distinct Category Property****");
	        if(plist5.size() > 0)
	        {
	        	for(int i = 0;i<plist5.size();i++)
	        	{
	        		System.out.println(plist5.get(i));
	        	}
	        }
	        else
	        {
	        	System.out.println("Product Data Not Found");
	        }
	        
	        
	        session.close();
	        sf.close();
	  }
	  
	  public void multiplerestrictions()
	  {
	    Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	           
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        
	        
	        Criteria c1 = session.createCriteria(Product.class);
	        c1.add(Restrictions.and(Restrictions.eq("stock", 10), Restrictions.lt("stock", 20)));
		       List<Product> plist1 = c1.list();
		       System.out.println("*****and restriction*****");
		       System.out.println("Total Products : "+plist1.size());
		       if(plist1.size() > 0)
		       {
		    	   for(Product p :plist1)
		    	   {
		    		   System.out.println(p.toString());
		    	   }
		       }
		       else
		       {
		    	   System.out.println("Product Data Not Found");
		       }
		       
		       Criteria c2 = session.createCriteria(Product.class);
		        c2.add(Restrictions.or(Restrictions.eq("stock", 15), Restrictions.gt("cost", 30000.0)));
			       List<Product> plist2 = c2.list();
			       System.out.println("*****or restriction*****");
			       System.out.println("Total Products : "+plist2.size());
			       if(plist2.size() > 0)
			       {
			    	   for(Product p :plist2)
			    	   {
			    		   System.out.println(p.toString());
			    	   }
			       }
			       else
			       {
			    	   System.out.println("Product Data Not Found");
			       }
			       
			       
			       Criteria c3 = session.createCriteria(Product.class);
			       c3.add(Restrictions.not(Restrictions.gt("cost", 10000.0)));
			       List<Product> plist3 = c3.list();
			       System.out.println("*****not restriction*****");
			       System.out.println("Total Products : "+plist3.size());
				       if(plist3.size() > 0)
				       {
				    	   for(Product p :plist3)
				    	   {
				    		   System.out.println(p.toString());
				    	   }
				       }
				       else
				       {
				    	   System.out.println("Product Data Not Found");
				       }
	        
	        
	        session.close();
	        sf.close();
	  }
	  
	  public void orderdemo()
	  {
	    Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	           
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        
	        System.out.println("****Order demo****");
	        
	        Criteria c1 = session.createCriteria(Product.class);
	        //c1.addOrder(Order.asc("cost"));
	        c1.addOrder(Order.desc("cost"));
		       List<Product> plist1 = c1.list();
		       System.out.println("*****All Products*****");
		       System.out.println("Total Products : "+plist1.size());
		       if(plist1.size() > 0)
		       {
		    	   for(Product p :plist1)
		    	   {
		    		   System.out.println(p.toString());
		    	   }
		       }
		       else
		       {
		    	   System.out.println("Product Data Not Found");
		       }
		       
		       
	        session.close();
	        sf.close();
	  }
	  
	  public void HCQLAll()
	  {
		  
		  
		  Configuration cfg = new Configuration();
	      cfg.configure("hibernate.cfg.xml");
	           
	      SessionFactory sf = cfg.buildSessionFactory();
	      Session session = sf.openSession();
	        
	      System.out.println("****HCQL with Restrictions + Projections + Order****");
	      
	      
	      Criteria c = session.createCriteria(Product.class);
	      
	      c.add(Restrictions.gt("cost", 10000.0));	      
	      c.setProjection(Projections.property("vendor")); // vendor is a property
	      c.addOrder(Order.desc("cost")); // descending order
	      
	      List plist = c.list();
	      System.out.println("****Name Property****");
	      if(plist.size() > 0)
	      {
	    	  for(int i = 0;i<plist.size();i++)
	    	  {
	        		System.out.println(plist.get(i));
	    	  }
	      }
	      else
	      {
	    	  System.out.println("Product Data Not Found");
	      }
	      
	      
	      session.close();
	      sf.close();
		  
		  
	  }
	  
	  public void pagination()
	     {
	       Configuration cfg = new Configuration();
	         cfg.configure("hibernate.cfg.xml");
	         
	         SessionFactory sf = cfg.buildSessionFactory();
	         Session session = sf.openSession();
	         
	         Criteria c = session.createCriteria(Product.class);
	         c.setFirstResult(2); // starts from 3rd record
	         c.setMaxResults(10);  // 10 Max Records
	         List<Product> plist = c.list();
	         System.out.println("*****Pagination*****");      
	         System.out.println("Number of Products="+plist.size());
	         if(plist.size()>0)
	         {
	           for(Product p : plist)
	           {
	             System.out.println(p.toString());
	           }
	         }
	         else
	         {
	           System.out.println("Product Data Not Found");
	         }
	         
	        
	         session.close();
	         sf.close();
	     }
	  
	  
	
	
}
