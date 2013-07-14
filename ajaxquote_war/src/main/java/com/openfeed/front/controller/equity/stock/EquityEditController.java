package com.openfeed.front.controller.equity.stock;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.openfeed.backend.common.IOpenfeedConstants;
import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.sl.equity.EquityUIService;
import com.openfeed.backend.sl.user.UserService;
import com.openfeed.backend.vo.stocks.Companies;
import com.openfeed.backend.vo.stocks.MarketEntity;
import com.openfeed.backend.vo.user.User;
import com.openfeed.backend.vo.widget.WidgetEntity;
import com.openfeed.front.controller.portal.IFrontOpenfeedContants;

/**
 * 
 * @author sy
 * @author jb
 * 
 */

@Controller
@RequestMapping("EDIT")
@SessionAttributes(types = MarketEntity.class)
public class EquityEditController {
	private static final String ERROR_DUPLICATE = "error.already.exists";
	private static final String FIELD_SYMBOL = "symbol";

	private EquityUIService equityUIService;
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setEquityUIService(EquityUIService equityUIService) {
		this.equityUIService = equityUIService;
	}

	@Autowired
	@Qualifier("equityValidator")
	private Validator equityValidator;

	@RenderMapping
	public String listEquities(RenderRequest request, RenderResponse resp, Model model) {
		User user = (User) request.getPortletSession().getAttribute(
				com.openfeed.front.controller.portal.IFrontOpenfeedContants.OPENFEED_USER,
				PortletSession.APPLICATION_SCOPE);
		WidgetEntity widgetEntity = equityUIService.addWidgetEntity(user.getUserId(), resp.getNamespace());
		model.addAttribute("stocks", equityUIService.getEquitiesByUserUIId(widgetEntity.getId()));
		return "equity_edit";
	}

	@ModelAttribute("stock")
	public MarketEntity getCommandObject() {
		return new MarketEntity();
	}

	@RenderMapping(params = "action=add")
	public String addSetupStocks(Model model) {
		return "equity_add";
	}

	@ActionMapping(params = "action=addSubmit")
	// action phase
	public void addSubmit(@ModelAttribute(value = "stock") MarketEntity stock,
			BindingResult bindingResult, ActionRequest request,
			ActionResponse response, SessionStatus sessionStatus) {
		User user = (User) request.getPortletSession().getAttribute(
				IFrontOpenfeedContants.OPENFEED_USER,
				PortletSession.APPLICATION_SCOPE);
		WidgetEntity widgetEntity = equityUIService.addWidgetEntity(user.getUserId(), response.getNamespace());
		equityValidator.validate(stock, bindingResult);
		if (!bindingResult.hasErrors()) {
			try {
				userService.addUserMarketEntity(widgetEntity.getId(),
						IOpenfeedConstants.MARKET_ENTITY_EQUITY_TYPE, stock.getSymbol(), stock.getExchange(), stock
								.getCompanyName());
				sessionStatus.setComplete();
			} catch (DuplicateRecordException e) {
				bindingResult.rejectValue(FIELD_SYMBOL, ERROR_DUPLICATE,
						new Object[] { FIELD_SYMBOL }, "duplicate");
				response.setRenderParameter("action", "add");
			}
		} else {
			response.setRenderParameter("action", "add");
		}

	}

	@ActionMapping(params = "action=delete")
	// action phase
	public void remove(@RequestParam long id, ActionRequest request,
			ActionResponse response, Model model) {
		User user = (User) request.getPortletSession().getAttribute(
				IFrontOpenfeedContants.OPENFEED_USER,
				PortletSession.APPLICATION_SCOPE);
		WidgetEntity widgetEntity = equityUIService.addWidgetEntity(user.getUserId(), response.getNamespace());
		userService.removeUserMarketEntity(widgetEntity.getId(), id);

	}


	@ResourceMapping(value = "js")
	public void resourceGet(@RequestParam String term, ResourceRequest request,
			ResourceResponse response) throws Exception {
		List<Companies> list = equityUIService.searchCompanies(term);
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		mapper.writeValue(response.getWriter(), list);
	}

}
