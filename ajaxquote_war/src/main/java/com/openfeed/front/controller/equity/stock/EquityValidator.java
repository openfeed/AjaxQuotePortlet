package com.openfeed.front.controller.equity.stock;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.openfeed.backend.vo.stocks.MarketEntity;

@Component("equityValidator")
public class EquityValidator implements Validator {

	private static final String ERROR_REQUIRED = "error.required.field";
	private static final String ERROR_DUPLICATE = "error.already.exists";
	private static final String FIELD_SYMBOL = "symbol";
	private static final String FIELD_DESCR = "companyName";

	public boolean supports(Class<?> klass) {
		return MarketEntity.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		MarketEntity stock = (MarketEntity) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_SYMBOL,
				ERROR_REQUIRED, new Object[] { FIELD_SYMBOL });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_DESCR,
				ERROR_REQUIRED, new Object[] { FIELD_DESCR });

	}
}