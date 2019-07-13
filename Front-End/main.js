var ourRequest = new XMLHttpRequest();
ourRequest.open('GET','http://localhost:8080/fetchall');
ourRequest.onload = function(){
	var data = JSON.parse(ourRequest.responseText);
	console.log(data[0]);
};
ourRequest.send();


$(document).ready(function(){
$.getJSON("http://localhost:8080/fetchall",function(obj){
$.each(obj,function(key,value){
var Html='<tr><td>'+value.id+'</td><td>'+value.name+'</td><td>'+value.city+'</td><td><button class="btn btn-success">Update</button></td><td><button id="one" value='+value.city+' class="btn btn-danger">Delete</button></td></tr>';
            $('#tbody').append(Html);
});
});
});


$(document).on("click","#one",function($button){
var id = $(this).attr("value");
var urls="http://localhost:8080/delete/"+id;
$.ajax({
    url: urls,
    type: 'DELETE',
    success: function(result) {
		location.reload();
    }
});
});