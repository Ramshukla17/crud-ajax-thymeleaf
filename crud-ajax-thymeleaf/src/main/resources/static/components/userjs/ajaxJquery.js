//insert data
$(document).ready(function() {
	//save user data here
	 $("#add-button").on('click', function(e){
		e.preventDefault();
		console.log("add-button click");
		var name=$('#name').val();
		var course=$('#course').val();
		var fee=$('#fee').val();
		//data store in object
		myData = {name : name , course : course , fee : fee};
		if(myData == "")
			{
				$("#error").html("All Fields are Requered").slideDown();
				$("#success").slideUp();
			}
		else
			{
			console.log(myData);
	//ajax call for insert operation		
		$.ajax({
			url:"/app/saveStudent",
			method: "POST",
			data: {name : name , course : course , fee : fee},
			success:function(data){
				console.log(data);
				if(data == true)
					{
					$("#myForm").trigger("reset");
					$("#success").html("Record Inserted Successfully !").slideDown(); //message pass to html page
					$("#error").slideUp();
					fetchStudent();
					}
				else
					{
					$("#error").html("All Fields are Requered").slideDown();
					$("#success").slideUp();
					}
				},
			});		
			}
		
	});
	
//here target delete button by tbody and btn-delete class
	/*$("#tbody").on("click", ".btn-delete" , function(){
			
			console.log("delete btn clicked");
		let id = $(this).attr("data-sid"); 
		myData = {id : id};
		mythis = this;
		$.ajax({
			url : "/app/deleteStudent/"+id,
			method : "Get",
			data : JSON.stringify(myData),
			success : function(data){
				alert ("recorde deleted successfully");
				$(mythis).closest("tr").fadeOut();
			}
		});
	});			*/
	
/*	 
	*update data here
*/ /*	$("tbody").on("click", ".btn-edit" , function(){
		let id = $(this).attr("data-sid");
		myData = {id : id};
		mythis = this;
		$.ajax({
			url : "/app/updateStudent/"+id,
			method : "POST",
			datType : "JSON",
			data : JSON.stringify(myData), 
			success : function(data){
				$("#name").val(data.name);
				$("#course").val(data.course);
				$("#fee").val(data.fee);
			},
		});
	});*/
});
