funtion calRate(nowData, lastData) {
    var res = "--";
    if (lastData != null && (lastData != "" || lastData != 0))
    {
    	var val = (nowData - lastData)/lastData*100;
    	var val = val.toFixed(2);
    	if (val > 0) {
    		res = "<font color='red'>+" + val + "</font>";
    	} else if (val < 0) {
    		res = "<font color='green'>" + val + "</font>";
    	} else {
    		res = val;
    	}
    }
    
    return res;
}