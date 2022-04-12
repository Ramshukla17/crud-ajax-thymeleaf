$(document).ready(function(){
	
	fetchStudent();
	$('')
	
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
		error_fee = 'Please Enter FullName';
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
		alert("success");
		//ajax call for insert operation
		var name=$('#name').val();
		var course=$('#course').val();
		var fee=$('#fee').val();		
		$.ajax({
			url:"/app/saveStudent",
			method: "POST",
			data: {name : name , course : course , fee : fee},
			success:function(data){

					
					fetchStudent();
					$("#myForm").trigger("#reset");
			}	
		});
	}
	});
});
