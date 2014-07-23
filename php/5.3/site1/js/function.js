ifcheck = true;
function CheckAll(form)
{
	for (var i=0;i<form.elements.length-2;i++)
	{
		var e = form.elements[i];
		if(e.type!='radio') e.checked = ifcheck;
	}
	ifcheck = ifcheck == true ? false : true;
}

function setcookie(c_name,value,expiredays)
{
	var exdate=new Date();
	exdate.setDate(exdate.getDate()+expiredays);
	document.cookie=c_name+ "=" +value+((expiredays==null) ? "" : "; expires="+exdate.toGMTString());
}

function getcookie(c_name)
{
	var arrstr=document.cookie.split("; ");
	for(var i=0;i<arrstr.length;i++)
	{
	    var temp=arrstr[i].split("=");
	    if(temp[0]==c_name) return unescape(temp[1]);
	}
	return null;
}

function setstyle(stylename)
{
    setcookie('userstyle',stylename,365);
	window.location.reload();
}

function tab(group,count,index)
{
	for(i=1;i<=count;i++)
	{
		if(i==index)
		{
			$('#a'+group+'_'+i).addClass('sel');
			$('#c'+group+'_'+i).show();			
		}
		else
		{
			$('#a'+group+'_'+i).removeClass('sel');
			$('#c'+group+'_'+i).hide();
		}		
	}
}

function str_rot13(str)
{
    return (str + '').replace(/[a-z]/gi, function (s) {
        return String.fromCharCode(s.charCodeAt(0) + (s.toLowerCase() < 'n' ? 13 : -13));
    });
}