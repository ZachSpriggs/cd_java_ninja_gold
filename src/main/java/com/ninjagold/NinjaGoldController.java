package com.ninjagold;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class NinjaGoldController {
	int min;
	int max;
	int gold;
	Random r = new Random();
	ArrayList<String> activities = new ArrayList<String>();
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("MMMM d yyyy hh:mm:a");
	
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", activities);
		}
		return "index.jsp";
	}
	
	@RequestMapping(value = "/process_money", method = RequestMethod.POST)
	public String processMoney(HttpSession session, @RequestParam(value = "action") String action) {
		if(action.equals("farm")) {
			min = 10;
			max = 20;
			int earnings = (r.nextInt(max-min)+ min);
			session.getAttribute("gold"); 
			gold += earnings;
			session.setAttribute("gold", gold);
			activities.add("Earned " + Integer.toString(earnings) + " gold from the farm! (" + ft.format(date) + ")");
			if(activities.size() > 8) {
				activities.remove(0);
			}
		}
		
		if(action.equals("cave")) {
			min = 5;
			max = 10;
			int earnings = (r.nextInt(max-min)+ min);
			session.getAttribute("gold"); 
			gold += earnings;
			session.setAttribute("gold", gold);
			activities.add("Earned " + Integer.toString(earnings) + " gold from the cave! (" + ft.format(date) + ")");
			if(activities.size() > 8) {
				activities.remove(0);
			}
		}
		
		if(action.equals("house")) {
			min = 2;
			max = 5;
			int earnings = (r.nextInt(max-min)+ min);
			session.getAttribute("gold"); 
			gold += earnings;
			session.setAttribute("gold", gold);
			activities.add("Earned " + Integer.toString(earnings) + " gold from the house! (" + ft.format(date) + ")");
			if(activities.size() > 8) {
				activities.remove(0);
			}
		}
		
		if(action.equals("casino")) {
			min = -50;
			max = 50;
			int earnings = (r.nextInt(max-min)+ min);
			if(earnings < 0) {
				session.getAttribute("gold"); 
				gold += earnings;
				session.setAttribute("gold", gold);
				activities.add("Entered a casino and lost " + Integer.toString(earnings) + " gold.... Ouch! (" + ft.format(date) + ")");
				if(activities.size() > 8) {
					activities.remove(0);
				}
			} else {
				session.getAttribute("gold"); 
				gold += earnings;
				session.setAttribute("gold", gold);
				activities.add("Earned " + Integer.toString(earnings) + " gold from the casino! (" + ft.format(date) + ")");
				if(activities.size() > 8) {
					activities.remove(0);
				}
			}
		}
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.getAttribute("gold");
		gold = 0;
		session.setAttribute("gold", gold);
		activities.clear();
		return "redirect:/";
	}
	
}
