package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;
import cn.itcast.service.BaseDictService;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String toCustomer(Model model,CustomerQueryVo vo) throws Exception{
//		//客户来源
//		List<BaseDict> sourceType = baseDictService.getDictItemCode("002");
//		//所属行业
//		List<BaseDict> industryType = baseDictService.getDictItemCode("001");
//		//客户级别
//		List<BaseDict> levelType = baseDictService.getDictItemCode("006");
		
		//get乱码
		if(vo != null){
			String custName = vo.getCustName();
			if(custName !=null && !"".equals(custName)){
				vo.setCustName(new String(custName.getBytes("iso8859-1"),"utf-8"));
			}
		}
		
		//查询客户
		List<Customer> custoemrs = customerService.getCustomerByQueryVo(vo);
		Integer total = customerService.getTotal(vo);
		Page page = new Page();
		page.setSize(vo.getSize());
		page.setRows(custoemrs);
		page.setTotal(total);
		//查询显示
		model.addAttribute("page", page);
		
		
		// 查询条件的回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		
		
		
//		model.addAttribute("sourceType", sourceType);
//		model.addAttribute("industryType", industryType);
//		model.addAttribute("levelType", levelType);
		return "customer";
	}
	
	//修改回显
	@RequestMapping("/toEdit")
	@ResponseBody
	public Customer findCustoemrById(Long id){
		Customer customer = customerService.findCustoemrById(id);
		return customer;
	} 
	
	//修改
	@RequestMapping("/update")
	@ResponseBody
	public String updateCustoemr(Customer customer)throws Exception{
		
		customerService.updateCustoemr(customer);
		
		return "ok";
	}
	//修改
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteCustoemr(Long id)throws Exception{
		
		customerService.deleteCustoemr(id);
		
		return "ok";
	}
}
