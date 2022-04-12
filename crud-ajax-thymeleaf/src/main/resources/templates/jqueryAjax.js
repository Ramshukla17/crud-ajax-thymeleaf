 $(document).ready(function(){
/**
 *Ajax Request for Retrieving data 
 */
	function showData(){
		output = "" ;		//data store in output variable
		$.ajax({
			url : "/app/viewStudent",
			method : "GET",
			dataType : "JSON",
			success : function (data){
		//condition data store in x variable
				if(data){x = data;}else{x = "";}
				for(var i=0 ; i<x.length; i++ )
				{output += "<tr><td>" + x[i].id + 
						"</td><td>" + x[i].name + 
						"</td><td>" + x[i].course +
						"</td><td>" + x[i].fee + 
						"</td><td> <button class='btn btn-warning btn-sm btn-edit' data-sid=" + x[i].id +  ">Edit</button><button class='btn btn-danger btn-sm btn-delete' data-sid=" + x[i].id + ">Delete</button>"
						"</td></tr>"	 
				}
				//tbody
				$("#tbody").html(output);
			},
			
		});
	}
/**
 *Ajax Request for insert data 
 */	
	 $("#add-button").click(function(e){
		e.preventDefault();
		var id=$('#id').val();
		var name=$('#name').val();
		var course=$('#course').val();
		var fee=$('#fee').val();
		//data store in object
		myData = {id :id , studentName:name , course:course , fee:fee};
		console.log(myData);
//ajax call for insert operation		
	$.ajax({
		url:"/app/saveStudent",
		method: "POST",
		data: JSON.stringify(myData),
		success:function(data){
			msg = "<div class='alert alert-dark mt-3' style='color:green;'>" + data + "</div>"; //html id target here
			$("#msg").html(msg); //message pass to html page
			$("#myFormId")[0].reset();
			showData();
			},
		});
	});
/*	
*delete data from database
*/ 
//here target delete button by tbody and btn-delete class
	$("tbody").on("click, .btn-delete" , function(){
		
		let id = $(this).attr("data-sid"); 
		myData = {sid : id};
		mythis = this;
		$.ajax({
			url : "/app/deleteStudent",
			method : "POST",
			data : JSON.stringify(myData),
			success : function(data){
				msg = "<div class='alert alert-dark mt-3' style='color:green;'>" + data + "</div>"; //html id target here
				$("#msg").html(msg); //message pass to html page
				//showData();// data Display function call here but its call all data 
				$(mythis).closest("tr").fadeOut();
			}
		});
	});		
/*	
*update data here
*/ 	$("tbody").on("click, .btn-edit" , function(){
		let id = $(this).attr("data-sid");
		myData = {id : id};
		mythis = this;
		$.ajax({
			url : "/app/updateStudent",
			method : "POST",
			datType : "JSON",
			data : JSON.stringify(myData), 
			success : function(data){
				$("#name").val(data.name);
				$("#course").val(data.course);
				$("#fee").val(data.fee);
			},
		});
	});
});
