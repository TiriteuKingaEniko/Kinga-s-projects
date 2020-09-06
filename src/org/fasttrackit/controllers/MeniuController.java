package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.dao.DayDAO;
import org.fasttrackit.dao.ReceiptDAO;
import org.fasttrackit.dao.ReceiptIngredientDAO;
import org.fasttrackit.pojo.DayOfTheWeek;
import org.fasttrackit.pojo.Ingredient;
import org.fasttrackit.pojo.Receipt;
import org.fasttrackit.pojo.ReceiptIngredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeniuController {

	@RequestMapping(value = "to-buy-list.htm")
	public ModelAndView toBuyList(Model model) throws SQLException {
		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();

		model.addAttribute("receiptIngredientList", ridao.getToBuyList());
		return new ModelAndView("WEB-INF/Ingredients/editToBuyList.jsp", "model", model);
	}

	@RequestMapping(value = "reset.htm")
	public ModelAndView resetWeek() throws SQLException {
		DayDAO ddao = new DayDAO();
		ddao.reset();
		return new ModelAndView("redirect:/index.html");
	}

	@RequestMapping(value = "display-week.htm")
	public ModelAndView displayWeek(Model model) throws SQLException {
		DayDAO ddao = new DayDAO();
		int dayId = ddao.getLastMondayId();

		model.addAttribute("mondayId", dayId);
		model.addAttribute("monday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("monday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("monday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("tuesdayId", dayId);
		model.addAttribute("tuesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("tuesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("tuesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("wednesdayId", dayId);
		model.addAttribute("wednesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("wednesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("wednesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("thursdayId", dayId);
		model.addAttribute("thursday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("thursday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("thursday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("fridayId", dayId);
		model.addAttribute("friday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("friday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("friday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("saturdayId", dayId);
		model.addAttribute("saturday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("saturday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("saturday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("sundayId", dayId);
		model.addAttribute("sunday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("sunday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("sunday3", ddao.getReceiptsForAMeal(3, dayId));
		return new ModelAndView("WEB-INF/Meniu/displayWeek.jsp", "model", model);
	}

	@RequestMapping(value = "start-week.htm")
	public ModelAndView startWeek(@RequestParam("id") int receiptId, Model model) throws SQLException {
		DayDAO ddao = new DayDAO();
		int dayId = ddao.getLastMondayId();
		model.addAttribute("receiptId", receiptId);
		model.addAttribute("mondayId", dayId);
		model.addAttribute("monday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("monday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("monday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("tuesdayId", dayId);
		model.addAttribute("tuesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("tuesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("tuesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("wednesdayId", dayId);
		model.addAttribute("wednesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("wednesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("wednesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("thursdayId", dayId);
		model.addAttribute("thursday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("thursday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("thursday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("fridayId", dayId);
		model.addAttribute("friday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("friday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("friday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("saturdayId", dayId);
		model.addAttribute("saturday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("saturday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("saturday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("sundayId", dayId);
		model.addAttribute("sunday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("sunday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("sunday3", ddao.getReceiptsForAMeal(3, dayId));
		return new ModelAndView("WEB-INF/Meniu/startWeek.jsp", "model", model);
	}

	@RequestMapping(value = "add-receipt-for-this-meal.htm")
	public ModelAndView addReceiptForThisMeal(@RequestParam("dayId") int dayId, @RequestParam("type") int type,
			@RequestParam("receiptId") int receiptId, Model model) throws SQLException {
		DayDAO ddao = new DayDAO();
		ddao.addReceiptForAMeal(type, receiptId, dayId);

		ReceiptDAO rdao = new ReceiptDAO();
		Receipt receipt = rdao.findReceipt(receiptId);
		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();
		ridao.addIngredientsOnToBuyListbyReceipt(receipt);

		dayId = ddao.getLastMondayId();

		model.addAttribute("mondayId", dayId);
		model.addAttribute("monday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("monday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("monday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("tuesdayId", dayId);
		model.addAttribute("tuesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("tuesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("tuesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("wednesdayId", dayId);
		model.addAttribute("wednesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("wednesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("wednesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("thursdayId", dayId);
		model.addAttribute("thursday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("thursday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("thursday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("fridayId", dayId);
		model.addAttribute("friday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("friday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("friday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("saturdayId", dayId);
		model.addAttribute("saturday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("saturday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("saturday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("sundayId", dayId);
		model.addAttribute("sunday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("sunday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("sunday3", ddao.getReceiptsForAMeal(3, dayId));

		return new ModelAndView("WEB-INF/Meniu/displayWeek.jsp", "model", model);
	}

	@RequestMapping(value = "delete-this-receipt.htm")
	public ModelAndView deleteThisReceipt(@RequestParam("dayId") int dayId, @RequestParam("type") int type,
			@RequestParam("receiptId") int receiptId, Model model) throws SQLException {
		DayDAO ddao = new DayDAO();
		ddao.deleteReceiptForAMeal(type, receiptId, dayId);

		ReceiptDAO rdao = new ReceiptDAO();
		Receipt receipt = rdao.findReceipt(receiptId);
		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();
		ridao.deleteIngredientsOnToBuyListbyReceipt(receipt);

		dayId = ddao.getLastMondayId();

		model.addAttribute("mondayId", dayId);
		model.addAttribute("monday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("monday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("monday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("tuesdayId", dayId);
		model.addAttribute("tuesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("tuesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("tuesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("wednesdayId", dayId);
		model.addAttribute("wednesday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("wednesday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("wednesday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("thursdayId", dayId);
		model.addAttribute("thursday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("thursday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("thursday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("fridayId", dayId);
		model.addAttribute("friday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("friday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("friday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("saturdayId", dayId);
		model.addAttribute("saturday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("saturday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("saturday3", ddao.getReceiptsForAMeal(3, dayId));
		dayId++;
		model.addAttribute("sundayId", dayId);
		model.addAttribute("sunday1", ddao.getReceiptsForAMeal(1, dayId));
		model.addAttribute("sunday2", ddao.getReceiptsForAMeal(2, dayId));
		model.addAttribute("sunday3", ddao.getReceiptsForAMeal(3, dayId));

		return new ModelAndView("WEB-INF/Meniu/displayWeek.jsp", "model", model);
	}

}
