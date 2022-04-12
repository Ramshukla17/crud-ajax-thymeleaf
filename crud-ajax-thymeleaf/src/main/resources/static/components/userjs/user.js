
//add student data 
$(document).ready(function(){
	
	$(document).on('click','#add-button',function() {
		
		if($.trim($('#name').val()).length == 0){
		error_name = 'Please Enter FullName';
		$('#error_name').text(error_name);
	}else{
		error_name = '';
		$('#error_name').text(error_name);
	}

	if($.trim($('#course').val()).length == 0){
		error_course = 'Please Enter Course Name';
		$('#error_course').text(error_course);
	}else{
		error_course = '';
		$('#error_course').text(error_course);
	}
	if($.trim($('#fee').val()).length == 0){
		error_fee = 'Please Enter fees';
		$('#error_fee').text(error_fee);

	}else{
		error_fee = '';
		$('#error_fee').text(error_fee);
	}
	
	if(error_name !='' || error_course !='' || error_fee !='')
	{
		return false;
	}
	else
	{
		//ajax call for insert operation
		var id = $('#id').val();
		var name=$('#name').val();
		var course=$('#course').val();
		var fee=$('#fee').val();		
		$.ajax({
			url:"/app/saveStudent",
			method: "POST",
			data: {id : id , name : name , course : course , fee : fee},
			success:function(data){
				console.log(data);
				//form clear here
					$(':input','#myForm')
				     .not(':button, :submit, :reset, :hidden')
				     .val('')
				     .removeAttr('checked')
				     .removeAttr('selected');
					//data load here
					fetchStudent();	
			}	
		});
	}
	});
});
//delete student data
function deleteStd(id)
{
	$.ajax({
		url : "/app/deleteStudent/"+id,
		method : "Get",
		success : function(data){
			$(this).closest("tr").fadeOut();
			fetchStudent();
		}
	});
}
//getting data from database
function fetchStudent(){
	 tableData = ""; 
	 $.ajax({
		 url : "/app/viewStudent",
		 method: "GET",
		 success : function(data){
			// console.log(student);
			 if(data){x = data;}else{x = "";}
				for(var i=0 ; i<x.length; i++ )
				{tableData += "<tr align=><td>" + x[i].id + "</td><td>" + x[i].name + "</td><td>" + x[i].course + "</td><td>" + x[i].fee + 
						"</td><td> <button class='btn btn-warning btn-sm btn-edit mr-2' onclick=editStd(" + x[i].id + ")>Edit</button> <button class='btn btn-danger btn-sm btn-delete' onclick=deleteStd(" + x[i].id + ")>Delete</button>"
						"</td></tr>"	 
				}
			 $("#tbody").html(tableData);
		 },
		 error : function (student){
			 console.log(student);
		 }
	 });
} fetchStudent();  	//function call for loading data
//edit Student
	function editStd(id)
	{

		$.ajax({
			url : "/app/editStudent/"+id,
			method : "GET",
			datType : "JSON",
			success : function(data){
				console.log(data);
				
				$(':input','#myForm')
			     .not(':button, :submit, :reset, :hidden')
			     .val('')
			     .removeAttr('checked')
			     .removeAttr('selected');
				
				fetchStudent();
					
				$("#id").val(data.id);
				$("#name").val(data.name);
				$("#course").val(data.course);
				$("#fee").val(data.fee);
				
			},
		});
		
	}
