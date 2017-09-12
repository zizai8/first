package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;

public interface CustomerDao {

	//根据条件查询客户
	public List<Customer> getCustomerByQueryVo(CustomerQueryVo vo);
	
	//查询总数
	public Integer getTotal(CustomerQueryVo vo);
	
	//根据id查询客户
	public Customer findCustoemrById(Long id);

	//修改
	public void updateCustoemr(Customer customer);

	//删除
	public void deleteCustoemr(Long id);
		
	
}
