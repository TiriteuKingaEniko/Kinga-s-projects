package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.dao.DayDAO;
import org.fasttrackit.dao.IngredientDAO;
import org.fasttrackit.dao.ReceiptDAO;
import org.fasttrackit.dao.ReceiptIngredientDAO;
import org.fasttrackit.pojo.Ingredient;
import org.fasttrackit.pojo.ReceiptIngredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IngredientController {

	@RequestMapping(value = "salvare-ingredient-cantitate.htm")
	public ModelAndView salvareIngredientCantitate(
			@ModelAttribute("receiptIngredient") ReceiptIngredient receiptIngredient, Model model, BindingResult result)
			throws SQLException {

		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();
		ridao.updateQuantity(receiptIngredient.getIngredient().getName(), receiptIngredient.getQuantity(),
				receiptIngredient.getIngredient().getUnit());

		model.addAttribute("receiptIngredientList", ridao.getToBuyList());
		return new ModelAndView("WEB-INF/Ingredients/editToBuyList.jsp", "model", model);
	}

	@RequestMapping(value = "editare-ingredient-cantitate.htm")
	public ModelAndView editareIngredientQuantity(@RequestParam("name") String ingredientName,
			@RequestParam("quantity") float quantity, @RequestParam("unit") String unit, Model model)
			throws SQLException {
		ReceiptIngredient ri = new ReceiptIngredient();
		ri.setIngredient(new Ingredient(0, ingredientName, unit));
		ri.setQuantity(quantity);
		model.addAttribute("receiptIngredient", ri);
		return new ModelAndView("WEB-INF/Ingredients/editCantitate.jsp", "model", model);
	}

	@RequestMapping(value = "delete-ingredient.htm")
	public ModelAndView deleteIngredient(@RequestParam("name") String ingredientName) throws SQLException {
		IngredientDAO idao = new IngredientDAO();
		if (idao.findIngredient(ingredientName).getId() != 999) {
			idao.deleteIngredient(idao.findIngredient(ingredientName));
		}

		ArrayList<Ingredient> ingredient = idao.getIngredients();
		ModelMap model = new ModelMap();
		model.put("ingredient", ingredient);

		return new ModelAndView("WEB-INF/Ingredients/deleteList.jsp", "model", model);
		

	}

	@RequestMapping(value = "salvare-ingredient.htm")
	public ModelAndView salvareIngredient(@ModelAttribute("ingredient") Ingredient ingredient, Model model,
			BindingResult result) throws SQLException {
		IngredientDAO idao = new IngredientDAO();
		idao.updateIngredient(ingredient);

		return new ModelAndView("redirect:/index.html");
	}

	@RequestMapping(value = "editare-ingredient.htm")
	public ModelAndView editareIngredient(@RequestParam("name") String ingredientName, Model model)
			throws SQLException {
		IngredientDAO idao = new IngredientDAO();
		Ingredient ingredient = idao.findIngredient(ingredientName);

		model.addAttribute("ingredient", ingredient);

		return new ModelAndView("WEB-INF/Ingredients/edit.jsp", "model", model);
	}

	@RequestMapping(value = "sterge-ingredient.htm")
	public ModelAndView stergeListaIngredients() throws SQLException {

		IngredientDAO idao = new IngredientDAO();
		ArrayList<Ingredient> ingredient = idao.getIngredients();
		ModelMap model = new ModelMap();
		model.put("ingredient", ingredient);

		return new ModelAndView("WEB-INF/Ingredients/deleteList.jsp", "model", model);
	}

	@RequestMapping(value = "edit-ingredient.htm")
	public ModelAndView editListaIngredients() throws SQLException {

		IngredientDAO idao = new IngredientDAO();
		ArrayList<Ingredient> ingredient = idao.getIngredients();
		ModelMap model = new ModelMap();
		model.put("ingredient", ingredient);

		return new ModelAndView("WEB-INF/Ingredients/editList.jsp", "model", model);
	}

	@RequestMapping(value = "input-ingredient.htm")
	public ModelAndView inputIngredient(Model model) {
		model.addAttribute("ingredient", new Ingredient());

		return new ModelAndView("WEB-INF/Ingredients/inputIngredient.jsp", "model", model);

	}

	@RequestMapping(value = "add-new-ingredient.htm")
	public ModelAndView addNewIngredient(@ModelAttribute("ingredient") Ingredient ingredient,
			@RequestParam("receiptId") int receiptId, Model model, BindingResult result) throws SQLException {
		IngredientDAO idao = new IngredientDAO();
		idao.addIngredient(ingredient);
		ReceiptIngredient receiptIngredient = new ReceiptIngredient();
		receiptIngredient.setReceiptId(receiptId);
		ReceiptDAO rdao = new ReceiptDAO();
		receiptIngredient.setReceipt(rdao.findReceipt(receiptId));
		model.addAttribute("receiptIngredient", receiptIngredient);
		model.addAttribute("ingredientDropDown", idao.getIngredientList());
		return new ModelAndView("WEB-INF/Receipt/formAddIngredients.jsp", "model", model);
	}

	@RequestMapping(value = "add-ingredient.htm")
	public ModelAndView addIngredient(@ModelAttribute("ingredient") Ingredient ingredient, Model model,
			BindingResult result) throws SQLException {
		IngredientDAO idao = new IngredientDAO();
		idao.addIngredient(ingredient);

		return new ModelAndView("redirect:/index.html");
	}

}
