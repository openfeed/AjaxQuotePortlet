function of_ajaxquote(nameSpace, scriptIdsuffix, scriptContainerSuffix, tickers) {
	this.stock_table = {}, this.q = tickers,
	this.ajaxUpdateTable = function() {
		if (this.q.length != 0) {
			$("#" + nameSpace + scriptIdsuffix).remove();
			var g = document.createElement('script');
			g.type = 'text/javascript';
			g.async = true;
			g.id = nameSpace + scriptIdsuffix;
			g.src = ('https:' == document.location.protocol ? 'https://'
					: 'http://www')
					+ '.google.com/finance/info?client=ig&q='
					+ this.q
					+ '&callback=of_' + nameSpace + '.processData';
			$("#" + nameSpace + scriptContainerSuffix).append(g);
		}
	};
	this.processData = function(jsondata) {
		this.stock_table.fnClearTable();
		this.stock_table.fnAddData(jsondata);
	};

	this.setTable = function(datatable) {
		this.stock_table = datatable
	};
	this.rowCallback = function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
		if (aData.c >= 0) {
			$('td.pr', nRow).addClass("green");
		} else {
			$('td.pr', nRow).addClass("red");
		}
	}
};