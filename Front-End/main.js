var ourRequest = new XMLHttpRequest();
ourRequest.open('GET','http://localhost:8080/fetchall');
ourRequest.onload = function(){
	var data = JSON.parse(ourRequest.responseText);
};
ourRequest.send();


$(document).ready(function(){
$.getJSON("http://localhost:8080/fetchall",function(obj){
	
$.each(obj,function(key,value){
var Html='<tr class="t'+value.id+'"><td>'+value.id+'</td><td id="ed">'+value.name+'</td><td id="ed">'+value.city+'</td><td id="ed"><button id="upd" class="btn btn-success">Update</button></td><td><button id="one" value='+value.city+' class="btn btn-danger">Delete</button></td></tr>';
            $('#tbody').append(Html);
});

});



$(document).on("click","#one",function($button){
var id = $(this).attr("value");
var urls="http://localhost:8080/delete/?id="+id;
$.ajax({
    url: urls,
    type: 'DELETE',
    success: function(result) {
		location.reload();
    }
});
});

$(document).on("click","#add",function($button){
	var id = $('#id').val();
	var name = $('#name').val();
	var city = $('#city').val();
	var urls="http://localhost:8080/create/?id="+id+"&name="+name+"&city="+city;
	$.ajax({
    url: urls,
    type: 'POST',
    success: function(result) {
		window.location.href= "index.html";
    }
});
		
});

$(document).on("click","#addf",function($button){
		window.location.href= "addform.html";
});

$(document).on("click","#usspd",function($button){	
   window.location.href="updateForm.html?text1=test";
});

$(document).on("click","#upwd",function($button){
var id = $(this).attr("value");
var urls="http://localhost:8080/delete/?id="+id;
$.ajax({
    url: urls,
    type: 'GET',
    success: function(result) {
		location.reload();
    }
});
});

$(document).on("click","#upd",function($button){
var trtr='<tr class="trr"><td><input id="id" type="text"> </td><td id="ed"><input id="id" type="text"> </td><td id="ed"><input id="id" type="text"> </td><td id="ed"><button id="upd" class="btn btn-success">Update</button></td><td><button id="one" class="btn btn-danger">Delete</button></td>';
	$("tr#t13").parent().replaceWith(trtr);
});

$(document).on("click","#uwpd",function($button){
	var id = $('#id').val();

	var urls="http://localhost:8080/fetchone/34";
$.getJSON(urls,function(obj){
	$.each(obj,function(key,value){
var Html='<div class="form-group"><label>Enter ID:</label><input class="form-control" type="text" id="id" value="" ></div>';
            $('#tbody1').append(Html);
});

});
		window.location.href= "updateForm.html";
});

$(document).on("click","#upsave",function($button){
		window.location.href= "index.html";
});

});