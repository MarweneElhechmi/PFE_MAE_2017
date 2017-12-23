// JavaScript Document
var IB = new Object;
var isIE = document.all;
var xMousePos = 0;
var yMousePos = 0;
var UserDatas = '';
var UserArray = new Array();
// Global variables
document.onmousemove = pointeurDeplace

var EVAL_PRODUCT_ID = function(obj) {
	alert(obj.responseText);
}

function pointeurDeplace(e) {
	xMousePos = pointeurX(e);
	yMousePos = pointeurY(e);

}

function AffBulle(texte) {
	document.onmousemove = pointeurDeplace
	var contenu = texte;
	document.getElementById('PopUpInfos').innerHTML = "<div style='padding:5px;text-color:#00000;text-align:left;font-size:16px;font-family:\"Trebuchet MS\";'>"
			+ contenu + "</div>";
	document.getElementById('PopUpInfos').style.width = 'auto';
	document.getElementById('PopUpInfos').style.height = 'auto';
	document.getElementById('PopUpInfos').style.top = (yMousePos + 10) + 'px';
	document.getElementById('PopUpInfos').style.left = (xMousePos + 10) + 'px';
	document.getElementById('PopUpInfos').style.visibility = "visible";
	document.getElementById('PopUpInfos').style.backgroundColor = "#3366FF";

	document.getElementById('PopUpInfos').style.zIndex = "5000";
}
function HideBulle() {
	document.onmousemove = pointeurDeplace
	document.getElementById('PopUpInfos').style.visibility = "hidden";
	document.getElementById('PopUpInfos').style.border = "none";
	document.getElementById('PopUpInfos').style.padding = "0";
	document.getElementById('PopUpInfos').style.backgroundColor = "#FFFFFF";
	document.getElementById('PopUpInfos').style.zIndex = '0';

}