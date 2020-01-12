package proj.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proj.com.DAO.CategoryDAO;
import proj.com.Model.Category;

@Controller
public class CategoryController
{
	@Autowired
	CategoryDAO categoryDao;

	@RequestMapping("admin/category")
	public String showCategory(Model m)
	{
		Category category=new Category();
		//List<Category> listcategories=categoryDao.listCategories();
		m.addAttribute(category);
		//m.addAttribute("categoryList", listcategories);
		
		return "category";
	}
	@RequestMapping("admin/addcategory")
	public String addcategory(@RequestParam("catname") String catName, @RequestParam("catdesc")String catDes,Model m)
	{
		Category category=new Category();
         category.setCatname(catName);
         category.setDesc(catDes);
         categoryDao.addCategory(category);
		
	
		List<Category> listcategories=categoryDao.listCategories();
		m.addAttribute("categoryList", listcategories);
		
		return "category";

		
	}
	
}
