$(document).ready(function(){
$.getJSON("http://localhost:8080/fetchall",function(obj){
$.each(obj,function(key,value){
var Html='<tr class="t'+value.id+'"><td>'+value.id+'</td><td id="ed">'+value.name+'</td><td id="ed">'+value.city+'</td><td id="ed"><button id="upd" value="1" class="btn btn-success">Update</button></td><td><button id="del" value='+value.id+' class="btn btn-danger">Delete</button></td></tr>';
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

$(document).on("click","#upd",function($button){
	var id=$('#id').val();
	window.location.href= "updateForm.html";
	$.getJSON("http://localhost:8080/fetch/1",function(obj){
$.each(obj,function(key,value){
var valid='<p>'+value.name+'</p>';
			$('#onee').append(valid);
});
});
});

});