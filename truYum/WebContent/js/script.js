// Include truYum form validation functions here
function validateMenuItemForm(){
	var name  =  document.getElementById("user-Name").value;
	var price  =  document.getElementById("cost").value;
	var date  =  document.getElementById("date").value;
	var category  =  document.getElementById("dropList").value;
	var alerts = "";
	var validationFlag = 't';
	
	if(name.length  == 0)	{
		alerts += "Title is required.\n";
		validationFlag = 'f';
	}	
	if(name.length < 2 || name.length > 65)	{
		alerts += "Title should have 2 to 65 characters.\n";
		validationFlag = 'f';
	}
	if(price == "")	{
		alerts += "Price is required.\n";
		validationFlag = 'f';
	}
	if(!(/[0-9]/.test(price)))	{
		alerts += "Price has to be a number\n";
		validationFlag = 'f';
	}
	if(date.length == '0')	{
		alerts += "Date of Lunch is required\n";
		validationFlag = 'f';
	}
	if( date.length != '10' || date[2] != '/' || (date[2] != date[5] ) || !(/[0-9]/.test(date[9]) ))	{
		alerts += "date format error syntax: 'DD/MM/YYYY'";
		validationFlag = 'f';
	}	
	if(category == "")	{
		alerts += "Select one category";
		validationFlag = 'f';
	}
	if(alerts.length != 0)	{
	alert(alerts);
	} 
	if( validationFlag == 'f')
		return false;
	else
		return true;
	//window.location.href = "edit-menu-item-status.html";

}