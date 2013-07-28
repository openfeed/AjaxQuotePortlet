function of_ajaxquote(nameSpace, scriptIdsuffix, scriptContainerSuffix,tickers, dataTable, showDates) {	
	this.stock_table=dataTable,
	this.q = tickers, 
	this.red_font="<font color='red'>",
	this.green_font="<font color='green'>", 
	this.font_end="</font>";
	this.ajaxUpdateTable=function(){
						if(this.q.length!=0){
							$("#"+nameSpace+scriptIdsuffix).remove();
							var g = document.createElement('script'); g.type = 'text/javascript'; g.async = true; g.id = nameSpace+scriptIdsuffix;
    						g.src = ('https:' == document.location.protocol ? 'https://' : 'http://www') + '.google.com/finance/info?client=ig&q='+this.q+'&callback=of_'+nameSpace+'.processData';
							$("#"+nameSpace+scriptContainerSuffix).append(g);
						}			
					};
	this.processData=function(jsondata){
					this.stock_table.fnClearTable();
					for ( var i=0 ; i<jsondata.length ; i++ )
						{
							var arr=showDates?new Array(8):new Array(6);
							arr[0]= jsondata[i]["t"]?jsondata[i]["t"]:"none";
							arr[1]= jsondata[i]["e"]?jsondata[i]["e"]:"none";
							arr[2]= jsondata[i]["l"]?jsondata[i]["l"]:"none";
							arr[3]= jsondata[i]["l_cur"]?jsondata[i]["l_cur"]:"none";
							if(jsondata[i]["c"]>=0){
								arr[4] = this.green_font+jsondata[i]["c"]+this.font_end;
							}else if (jsondata[i]["c"]<0){
								arr[4] = this.red_font+jsondata[i]["c"]+this.font_end;
							}
							if(jsondata[i]["c"]>=0){
								arr[5] = this.green_font+jsondata[i]["cp"]+this.font_end;
							}else if (jsondata[i]["c"]<0){
								arr[5] = this.red_font+jsondata[i]["cp"]+this.font_end;
							}
							arr[6]= jsondata[i]["ltt"]?jsondata[i]["ltt"]:"none";
							arr[7]= jsondata[i]["lt"]?jsondata[i]["lt"]:"none";
							this.stock_table.fnAddData(arr);
						}
					}
};