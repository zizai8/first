package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao  customerDao;
	
	@Override
	public List<Customer> getCustomerByQueryVo(CustomerQueryVo vo) {
		List<Customer> customers = customerDao.getCustomerByQueryVo(vo);
		return customers;
	}

	@Override
	public Integer getTotal(CustomerQueryVo vo) {
		Integer total = customerDao.getTotal(vo);
		return total;
	}

	@Override
	public Customer findCustoemrById(Long id) {
		Customer customer = customerDao.findCustoemrById(id);
		return customer;
	}

	@Override
	public void updateCustoemr(Customer customer) {
		customerDao.updateCustoemr(customer);
		
	}

	@Override
	public void deleteCustoemr(Long id) {
		customerDao.deleteCustoemr(id);
		
	}

}
