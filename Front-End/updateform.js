$(document).ready(function(){
	console.log("Onload");
	var parameters = getUrlVars();
	console.log(JSON.stringify(parameters));
	$("#ide").attr("value",parameters.id);
	$("#namee").attr("value",parameters.name);
	$("#citye").attr("value",parameters.city);
	
$(document).on("click","#update",function($button){
	var id = $('#ide').val();
	var name = $('#namee').val();
	var city = $('#citye').val();
	var temp = {
		"id":id,
		"name": name,
		"city":city
	};
	var urls="http://localhost:8080/update";
	$.ajax({
    url: urls,
	data: JSON.stringify(temp),
	dataType:'json',
	contentType: "application/json; charset=utf-8",
    type: 'PUT',
    complete: function(result) {
            window.location.href= "index.html";
        }
});	
});
	
});

function getUrlVars() {
   var vars = {};
   var link = decodeURI(window.location.href);
   var parts = link.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
       vars[key] = value;
   });
   return vars;
}