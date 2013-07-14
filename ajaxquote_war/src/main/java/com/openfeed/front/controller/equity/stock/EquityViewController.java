package com.openfeed.front.controller.equity.stock;

import java.util.List;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openfeed.backend.sl.equity.EquityUIService;
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
@RequestMapping("VIEW")
public class EquityViewController {

	private static final String HTML_FONT_GREEN_START = "<font color='green'>";
	private static final String HTML_FONT_RED_START = "<font color='red'>";
	private static final String HTML_FONT_END = "</font>";
	private static final String COMMA = ",";
	private static final String PERCENTAGE_CHAR = "%";

	// spring beans
	private EquityUIService equityUIService;

	@Autowired
	public void setEquityUIService(EquityUIService equityUIService) {
		this.equityUIService = equityUIService;
	}

	@RequestMapping
	public String listStocks(RenderRequest request,RenderResponse resp, Model model) {
		User user = (User)request.getPortletSession().getAttribute(IFrontOpenfeedContants.OPENFEED_USER, PortletSession.APPLICATION_SCOPE);
		WidgetEntity widgetEntity = equityUIService.addWidgetEntity(user.getUserId(), resp.getNamespace());
		List<MarketEntity> list = equityUIService.getEquitiesByUserUIId(widgetEntity.getId());
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
/*
	@ResourceMapping(value = "js")
	public void resourceGet(ResourceRequest request, ResourceResponse response)
			throws Exception {
		User user = (User)request.getPortletSession().getAttribute(IFrontOpenfeedContants.OPENFEED_USER, PortletSession.APPLICATION_SCOPE);
		Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		List<MarketEntityQuote> listQuotes = marketEntityService.listQuotesByUserIdType(user.getUserId(), IOpenfeedConstants.MARKET_ENTITY_EQUITY_TYPE);
		map.put("aaData",covert2jqueryDataTable(listQuotes));
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		mapper.writeValue(response.getWriter(), map);
	}

	private List<String[]> covert2jqueryDataTable(List<MarketEntityQuote> listQuotes) {
		List<String[]> list = new ArrayList<String[]>(listQuotes.size());
		DecimalFormat priceFormatter = new DecimalFormat("#.##");
		String lastPriceDecor = null;
		for (MarketEntityQuote e : listQuotes) {
			if (e.getLastPrice() > e.getPreviousClosePrice()) {
				lastPriceDecor = new StringBuilder().append(
						HTML_FONT_GREEN_START)
						.append(
								String.valueOf(priceFormatter.format(e
										.getLastPrice())))
						.append(HTML_FONT_END).toString();
			} else if (e.getLastPrice() < e.getPreviousClosePrice()) {
				lastPriceDecor = new StringBuilder()
						.append(HTML_FONT_RED_START).append(
								String.valueOf(priceFormatter.format(e
										.getLastPrice())))
						.append(HTML_FONT_END).toString();
			} else {
				lastPriceDecor = String.valueOf(priceFormatter.format(e
						.getLastPrice()));
			}
			list.add(new String[] { e.getSymbol(),
					String.valueOf(priceFormatter.format(e.getBidPrice())),
					String.valueOf(e.getBidSize()),
					String.valueOf(priceFormatter.format(e.getAskPrice())),
					String.valueOf(e.getAskSize()), lastPriceDecor,
					String.valueOf(priceFormatter.format(e
							.getChange())),
					String.valueOf(priceFormatter.format(e
							.getChangePercentage()))+PERCENTAGE_CHAR,
					String.valueOf(e.getLastSize()),
					String.valueOf(e.getVolume()) });
			}
		return list;
	}
	*/
}
