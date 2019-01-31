/**
 * 
 */

function progress()
{
	if(document.getElementById('loader').style.visibility=="hidden")
	  document.getElementById('loader').style.visibility="visible";
	else if(document.getElementById('loader').style.visibility=="visible")
		document.getElementById('loader').style.visibility="hidden";
	}
