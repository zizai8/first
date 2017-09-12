package cn.itcast.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.BaseDict;
import cn.itcast.service.BaseDictService;

public class Interceptor implements HandlerInterceptor {
	@Autowired
	private BaseDictService baseDictService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		//客户来源
		List<BaseDict> sourceType = baseDictService.getDictItemCode("002");
		//所属行业
		List<BaseDict> industryType = baseDictService.getDictItemCode("001");
		//客户级别
		List<BaseDict> levelType = baseDictService.getDictItemCode("006");
				
		modelAndView.addObject("sourceType", sourceType);
		modelAndView.addObject("industryType", industryType);
		modelAndView.addObject("levelType", levelType);
		
//		model.addAttribute("sourceType", sourceType);
//		model.addAttribute("industryType", industryType);
//		model.addAttribute("levelType", levelType);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
