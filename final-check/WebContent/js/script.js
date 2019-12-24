// Include form validation functions here
function checkValidate()	{

var movieName = document.getElementById("user-name").value;
var profit = document.getElementById("amount").value;
var date = document.getElementById("launchdate").value;
var category = document.getElementById("dropList").value;
var alerts = "";
var errorFlag = 't';

document.getElementById("titleError").innerHTML ="";
document.getElementById("grossError").innerHTML = "";
document.getElementById("dateError").innerHTML = "";
document.getElementById("genreError").innerHTML = "";

	if(movieName.length == 0)	{
		var error = "Title required.";
		error = error.fontcolor("#ff0000");
		document.getElementById("titleError").innerHTML = error;
		errorFlag = 'f';
		//alerts += "Title is required.\n";
	}	
	
	if(((movieName.length>=1 && movieName.length <= 2) || movieName.length > 100))	{
		var error = "Title should have 2 to 65 characters.";
		error = error.fontcolor("#ff0000");
		document.getElementById("titleError").innerHTML = error;
		errorFlag = 'f';
		//alerts += "Title should have 2 to 65 characters.\n";
	}
	
	if(profit.length == 0)	{
		errorFlag = 'f';
		var error = "Price is required";
		error = error.fontcolor("#ff0000");
		document.getElementById("grossError").innerHTML = error;
		//alerts += "Price is required.\n";
	}
	
	if( (profit.length != 0) && !(/[0-9]/.test(profit)))	{
		errorFlag = 'f';
		var error = "Price has to be number";
		error = error.fontcolor("#ff0000");
		document.getElementById("grossError").innerHTML = error;
		//alerts += "Price has to be a number\n";
	}
	
	if(date.length == '0')	{
		errorFlag = 'f';
		var error = "date is required"
		error = error.fontcolor("#ff0000");
		document.getElementById("dateError").innerHTML = error;
		//alerts += "Date of Lunch is required\n";
	}
	
	if( (date.length != '0') && (date.length != '10' || date[2] != '/' || (date[2] != date[5] ) || !(/[0-9]/.test(date[9]) )))	{
		errorFlag = 'f';
		var error = "date format error syntax: 'DD/MM/YYYY'"
		error = error.fontcolor("#ff0000");
		document.getElementById("dateError").innerHTML = error;
		//alerts += "date format error syntax: 'DD/MM/YYYY'";
	}	
	
	if(category == "")	{
		errorFlag = 'f';
		var error = "Select genre";
		error = error.fontcolor("#ff0000");
		document.getElementById("genreError").innerHTML = error;
		//alerts += "Select one category";
	}
	
	if(alerts.length != 0)	{
	//alert(alerts);
	} else	{
		if(errorFlag == 'f')
			return false;
		else
			return true;
		//window.location.href = "edit-movie-status.html";
	}

}