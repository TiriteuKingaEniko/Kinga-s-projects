package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.dao.IngredientDAO;
import org.fasttrackit.dao.ReceiptDAO;
import org.fasttrackit.dao.ReceiptIngredientDAO;
import org.fasttrackit.dao.ReceiptTypeDAO;
import org.fasttrackit.pojo.Ingredient;
import org.fasttrackit.pojo.Receipt;
import org.fasttrackit.pojo.ReceiptIngredient;
import org.fasttrackit.pojo.ReceiptType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReceiptController {

	@RequestMapping(value = "search.htm")
	public ModelAndView searchWhat(@RequestParam("what") String receiptName, Model model)
			throws SQLException {
		ReceiptDAO rdao = new ReceiptDAO();
		model.addAttribute("receiptList", rdao.findWhat(receiptName));
		return new ModelAndView("WEB-INF/Receipt/receiptList.jsp", "model", model);
	}

	@RequestMapping(value = "add-otherReceiptIngredient.htm")
	public ModelAndView addOtherReceiptIngredient(@RequestParam("id") int id, Model model) throws SQLException {
		ReceiptDAO rdao = new ReceiptDAO();
		Receipt receipt = rdao.returnReceipt(id);
		ReceiptIngredient receiptIngredient = new ReceiptIngredient();
		receiptIngredient.setReceipt(receipt);
		receiptIngredient.setReceiptId(receipt.getId());

		model.addAttribute("receiptIngredient", receiptIngredient);
		IngredientDAO idao = new IngredientDAO();
		model.addAttribute("ingredientDropDown", idao.getIngredientList());
		model.addAttribute("receipt", receipt);

		return new ModelAndView("WEB-INF/Receipt/formAddIngredients.jsp", "model", model);
	}

	@RequestMapping(value = "edit-receipt-list.htm")
	public ModelAndView editReceiptList(Model model) throws SQLException {
		ReceiptDAO rdao = new ReceiptDAO();
		ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
		receiptList = rdao.returnAllReceipts();
		model.addAttribute("receiptList", receiptList);

		return new ModelAndView("WEB-INF/Receipt/editReceiptList.jsp", "model", model);
	}

	@RequestMapping(value = "delete-receipt-list.htm")
	public ModelAndView deleteReceiptList(Model model) throws SQLException {
		ReceiptDAO rdao = new ReceiptDAO();
		ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
		receiptList = rdao.returnAllReceipts();
		model.addAttribute("receiptList", receiptList);

		return new ModelAndView("WEB-INF/Receipt/deleteReceiptList.jsp", "model", model);
	}

	@RequestMapping(value = "edit-receipt.htm")
	public ModelAndView editReceipt(@RequestParam("id") int id, Model model) throws SQLException {

		ReceiptDAO rdao = new ReceiptDAO();
		Receipt receipt = rdao.returnReceipt(id);
		ReceiptTypeDAO rtdao = new ReceiptTypeDAO();

		model.addAttribute("typeList", rtdao.receiptTypeList());
		model.addAttribute("receipt", receipt);

		return new ModelAndView("WEB-INF/Receipt/editFormReceipt.jsp", "model", model);
	}

	@RequestMapping(value = "delete-receipt.htm")
	public ModelAndView deleteReceipt(@RequestParam("id") int id, Model model) throws SQLException {

		ReceiptDAO rdao = new ReceiptDAO();
		Receipt receipt = rdao.returnReceipt(id);
		rdao.deleteReceipt(receipt.getId());
		
		ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
		receiptList = rdao.returnAllReceipts();
		model.addAttribute("receiptList", receiptList);

		return new ModelAndView("WEB-INF/Receipt/deleteReceiptList.jsp", "model", model);

	}

	@RequestMapping(value = "edit-save-receipt.htm")
	public ModelAndView editIngredient(@ModelAttribute("receipt") Receipt receipt, BindingResult result)
			throws SQLException {

		ReceiptDAO rdao = new ReceiptDAO();
		ReceiptTypeDAO rtdao = new ReceiptTypeDAO();
		receipt.setType(rtdao.getReceiptTypeByName(receipt.getType().getName()));
		int i = 0;
		while (i < receipt.getIngredientList().size()) {
			receipt.getIngredientList().get(i).setReceiptId(receipt.getId());
			receipt.getIngredientList().get(i)
					.setIngredientId(receipt.getIngredientList().get(i).getIngredient().getId());
			i++;
		}
		rdao.updateReceipt(receipt);

		return new ModelAndView("redirect:/index.html");
	}

	@RequestMapping(value = "save-receipt-and-add-receiptIngredient.htm")
	public ModelAndView setIngredient(@ModelAttribute("receipt") Receipt receipt, Model model, BindingResult result)
			throws SQLException {

		ReceiptDAO rdao = new ReceiptDAO();
		ReceiptTypeDAO rtdao = new ReceiptTypeDAO();
		receipt.setType(rtdao.getReceiptTypeByName(receipt.getType().getName()));
		rdao.addReceipt(receipt);
		receipt = rdao.findReceiptByName(receipt.getName());
		ReceiptIngredient receiptIngredient = new ReceiptIngredient();
		receiptIngredient.setReceipt(receipt);
		receiptIngredient.setReceiptId(receipt.getId());

		model.addAttribute("receiptIngredient", receiptIngredient);
		IngredientDAO idao = new IngredientDAO();
		model.addAttribute("ingredientDropDown", idao.getIngredientList());
		model.addAttribute("receipt", receipt);

		return new ModelAndView("WEB-INF/Receipt/formIngredients.jsp", "model", model);
	}

	@RequestMapping(value = "save-receiptIngredient.htm")
	public ModelAndView saveReceipt(@ModelAttribute("receiptIngredient") ReceiptIngredient receiptIngredient,
			Model model, BindingResult result) throws SQLException {
		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();
		IngredientDAO idao = new IngredientDAO();
		ReceiptDAO rdao = new ReceiptDAO();
		receiptIngredient.setIngredient(idao.findIngredient(receiptIngredient.getIngredient().getName()));
		receiptIngredient.setIngredientId(idao.findIngredient(receiptIngredient.getIngredient().getName()).getId());
		receiptIngredient.setReceipt(rdao.findReceipt(receiptIngredient.getReceiptId()));
		if (idao.findIngredient(receiptIngredient.getIngredient().getName()).getId() == 999) {
			model.addAttribute("receiptId", receiptIngredient.getReceiptId());
			model.addAttribute("ingredient", new Ingredient());
			return new ModelAndView("WEB-INF/Ingredients/inputNewIngredient.jsp", "model", model);
		} else {
			ridao.addReceiptIngredient(receiptIngredient);
			model.addAttribute("receiptIngredient", receiptIngredient);
			model.addAttribute("ingredientDropDown", idao.getIngredientList());
			return new ModelAndView("WEB-INF/Receipt/formIngredients.jsp", "model", model);
		}

	}

	@RequestMapping(value = "save-addReceiptIngredient.htm")
	public ModelAndView saveAddReceipt(@ModelAttribute("receiptIngredient") ReceiptIngredient receiptIngredient,
			Model model, BindingResult result) throws SQLException {
		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();
		IngredientDAO idao = new IngredientDAO();
		ReceiptDAO rdao = new ReceiptDAO();
		receiptIngredient.setIngredient(idao.findIngredient(receiptIngredient.getIngredient().getName()));
		receiptIngredient.setIngredientId(idao.findIngredient(receiptIngredient.getIngredient().getName()).getId());
		receiptIngredient.setReceipt(rdao.findReceipt(receiptIngredient.getReceiptId()));
		if (idao.findIngredient(receiptIngredient.getIngredient().getName()).getId() == 999) {
			model.addAttribute("receiptId", receiptIngredient.getReceiptId());
			model.addAttribute("ingredient", new Ingredient());
			return new ModelAndView("WEB-INF/Ingredients/inputNewIngredient.jsp", "model", model);
		} else {
			ridao.addReceiptIngredient(receiptIngredient);
			model.addAttribute("receiptIngredient", receiptIngredient);
			model.addAttribute("ingredientDropDown", idao.getIngredientList());
			return new ModelAndView("WEB-INF/Receipt/formAddIngredients.jsp", "model", model);
		}

	}

	@RequestMapping(value = "add-receipt.htm")
	public ModelAndView addReceipt(Model model) throws SQLException {

		ReceiptTypeDAO rtdao = new ReceiptTypeDAO();
		Receipt receipt = new Receipt();
		model.addAttribute("receipt", receipt);
		model.addAttribute("typeList", rtdao.receiptTypeList());
		return new ModelAndView("WEB-INF/Receipt/formReceipt.jsp", "model", model);
	}

	@RequestMapping(value = "display-receipt-list.htm")
	public ModelAndView displayReceiptList(@RequestParam("typeId") int typeId, Model model) throws SQLException {
		ReceiptDAO rdao = new ReceiptDAO();
		ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
		receiptList = rdao.returnAllReceiptsbyType(typeId);
		model.addAttribute("receiptList", receiptList);

		return new ModelAndView("WEB-INF/Receipt/receiptList.jsp", "model", model);
	}

	@RequestMapping(value = "find-receipt.htm")
	public ModelAndView findReceipt(@RequestParam("id") int id, Model model) throws SQLException {

		ReceiptDAO rdao = new ReceiptDAO();
		Receipt receipt = rdao.returnReceipt(id);
		model.addAttribute("nume", receipt.getName());
		model.addAttribute("description", receipt.getDescription());
		model.addAttribute("preparingMinutes", receipt.getPreparingMinutes());
		model.addAttribute("ingredientList", receipt.getIngredientList());
		model.addAttribute("receiptType", receipt.getType().getName());
		model.addAttribute("id", id);
		return new ModelAndView("WEB-INF/Receipt/findReceipt.jsp", "model", model);
	}

}
