package controllers;
import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Application extends Controller{	
	

    public static void index() {   
        
        render();
    }
    
    public static void yonetim() {
    	render();
    }
    
    public static void getVote2() {
    	List<Object[]> votes = Vote.find("select location, category, counter from Vote group by location, category order by location, category")
                .fetch();
    	int count=0;
    	ArrayList<ArrayList<Long>> lists = new ArrayList<ArrayList<Long>>();
    	ArrayList<Long> liste = null;
    	for(int i=0;i<81;i++){
    	liste =new ArrayList<Long>();
    	for(int j=0;j<4;j++){
        String vote =votes.get(count)[2]+"";
        	  liste.add(Long.parseLong(vote));
    	count++;
    	}
        
    	lists.add(liste);
    	  }
    	renderJSON(lists);
    }

    public static void getVote(String il) {
    	ArrayList<Long> liste;
    	liste =new ArrayList<Long>();
    
    	liste.add(Vote.count("category=? and location=?", il));
    	liste.add(Vote.count("category=? and location=?", il)) ;
    	liste.add(Vote.count("category=? and location=?", il)) ;
    	liste.add(Vote.count("category=? and location=?", il));
    	renderJSON(liste);
    }  

    public static void kategori() {

   	HashMap<String,List<String>> map = new HashMap<String,List<String>>();
   	List<String> data = new ArrayList<String>();

   	data.add("%36");
   	data.add("%12");
   	data.add("%5");
   	data.add("%10");
   	data.add("%7");
   	data.add("%2");
   	map.put("Balıkesir",data);
data = new ArrayList<String>();
   	data.add("%34");
   	data.add("%12");
   	data.add("%5");
   	data.add("%10");
   	data.add("%7");
   	map.put("Ankara",data);

   	renderJSON(map);
    }
    
    
}