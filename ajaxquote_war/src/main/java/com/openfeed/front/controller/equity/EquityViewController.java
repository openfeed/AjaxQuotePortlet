package com.openfeed.front.controller.equity;

import java.util.List;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openfeed.backend.sl.equity.EquityUIService;
import com.openfeed.backend.vo.equity.MarketEntity;
import com.openfeed.backend.vo.user.User;
import com.openfeed.backend.vo.userui.UserUI;

/**
 * 
 * @author sy
 * @author jb
 * 
 */

@Controller
@RequestMapping("VIEW")
public class EquityViewController {

	private static final String COMMA = ",";

	// spring beans
	private EquityUIService equityUIService;

	@Autowired
	public void setEquityUIService(EquityUIService equityUIService) {
		this.equityUIService = equityUIService;
	}

	protected String sessionUserParamName;

	@Autowired
	public void setSessionUserParamName(String sessionUserParamName) {
		this.sessionUserParamName = sessionUserParamName;
	}

	
	@RequestMapping
	public String listStocks(RenderRequest request,RenderResponse resp, Model model) {
		User user = (User)request.getPortletSession().getAttribute(sessionUserParamName, PortletSession.APPLICATION_SCOPE);
		UserUI userui = equityUIService.addUserUI(user.getUserId(), resp.getNamespace());
		List<MarketEntity> list = equityUIService.getEquitiesByUserUIId(userui.getUserUIId());
		model.addAttribute("stocks", list.isEmpty()?"":this.getSymbolString(list));
		return "equity";
	}
	private String getSymbolString(List<MarketEntity> list){
		StringBuilder sb = new StringBuilder();
		for (MarketEntity entity : list){
			sb.append(entity.getSymbol());
			sb.append(COMMA);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
