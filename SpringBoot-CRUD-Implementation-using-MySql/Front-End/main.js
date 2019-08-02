$(document).ready(function(){
$.getJSON("http://localhost:8080/fetchall",function(obj){
$.each(obj,function(key,value){
var Html='<tr><td>'+value.id+'</td><td>'+value.name+'</td><td>'+value.city+'</td><td><button id="'+value.id+'" value="1" class="upd btn btn-success">Update</button></td><td><button id="del" value='+value.id+' class="btn btn-danger">Delete</button></td></tr>';
            $('#tbody').append(Html);
});
});

$(document).on("click","#del",function($button){
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

/*$(document).on("click","#add",function($button){
	var id = $('#id').val();
	var name = $('#name').val();
	var city = $('#city').val();
	var temp = {
		"id":id,
		"name": name,
		"city":city
	};
	var urls="http://localhost:8080/create";
	$.ajax({
    url: urls,
	type: 'POST',
	data: JSON.stringify(temp),
	dataType:'json',
	contentType: "application/json; charset=utf-8",
	complete: function(result) {
            window.location.href= "index.html";
        }
});	
});*/

$(document).on("click","#addf",function($button){
		window.location.href= "addform.html";
});

$(document).on("click",".upd",function($button){
	var id=this.id;
	console.log(id);

var parameter;
$.ajax({
	'async':false,
    url: "http://localhost:8080/fetch/"+id,
    type: 'GET',
	dataType : "json",
    success: function(result) {
		parameter = result;
    }
});

	window.location="updateForm.html?id="+parameter[0].id+"&name="+parameter[0].name+"&city="+parameter[0].city;

});
});$(document).ready(function(){
$.getJSON("http://localhost:8080/fetchall",function(obj){
$.each(obj,function(key,value){
var Html='<tr class="t'+value.id+'"><td>'+value.id+'</td><td id="ed">'+value.name+'</td><td id="ed">'+value.city+'</td><td id="ed"><button id="'+value.id+'" value="1" class="upd btn btn-success">Update</button></td><td><button id="del" value='+value.id+' class="btn btn-danger">Delete</button></td></tr>';
            $('#tbody').append(Html);
});
});

$(document).on("click","#del",function($button){
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
	var temp = {
		"id":id,
		"name": name,
		"city":city
	};
	var urls="http://localhost:8080/create";
	$.ajax({
    url: urls,
	type: 'POST',
	data: JSON.stringify(temp),
	dataType:'json',
	contentType: "application/json; charset=utf-8",
	complete: function(result) {
            window.location.href= "index.html";
        }
});	
});

$(document).on("click","#addf",function($button){
		window.location.href= "addform.html";
});

$(document).on("click",".upd",function($button){
	var id=this.id;
	console.log(id);

var parameter;
$.ajax({
	'async':false,
    url: "http://localhost:8080/fetch/"+id,
    type: 'GET',
	dataType : "json",
    success: function(result) {
		parameter = result;
    }
});

	window.location="updateForm.html?id="+parameter[0].id+"&name="+parameter[0].name+"&city="+parameter[0].city;

});
});