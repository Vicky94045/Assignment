$(document).ready(function(){
	$("#emp").on('click', function () {
	//alert("workingEmp");	
    $.ajax({	        	
    	  type : 'GET',
    	  //dataType: 'json',	              
          contentType: 'application/json',	              
          url: 'EmployeeRetrive',	              
 	      success: function(result){
 	    	 //alert(result[0].EmpNo); 
 	    	 var dat="<table border=1 id=customers>"
 	    	 dat=dat+"<tr><th>Emp No</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Email Id</th><th>Address</th><th>Birthday</th><th>Salary</th><th>Gender</th><th>Mobile No</th><th>Hire Date</th><th>company Id</th><th>company Name</th></tr>"
 	    	 //console.log=result.Employee[0];    	 	    	 
 	    	 $.each(result, function(index) { 	    		
 	    		console.log(result[index].EmpNo); 	    		
 	    		dat=dat+"<tr id=\""+result[index].EmpNo+"\"><td>"+result[index].EmpNo+"</td>";
 	    		console.log(result[index].First_Name);
 	    		dat=dat+"<td>"+result[index].First_Name+"</td>";
 	    		console.log(result[index].Last_Name);
 	    		dat=dat+"<td>"+result[index].Last_Name+"</td>";
 	    		console.log(result[index].Age);
 	    		dat=dat+"<td>"+result[index].Age+"</td>";
 	    		console.log(result[index].mailId);
 	    		dat=dat+"<td>"+result[index].mailId+"</td>";
 	    		console.log(result[index].Address);
 	    		dat=dat+"<td>"+result[index].Address+"</td>";
 	    		console.log(result[index].Birthdate);
 	    		dat=dat+"<td>"+result[index].Birthdate+"</td>";
 	    		console.log(result[index].Salary);
 	    		dat=dat+"<td>"+result[index].Salary+"</td>";
 	    		console.log(result[index].Gender);
 	    		dat=dat+"<td>"+result[index].Gender+"</td>";
 	    		console.log(result[index].Mobile_No);
 	    		dat=dat+"<td>"+result[index].Mobile_No+"</td>";
 	    		console.log(result[index].Hire_date);
 	    		dat=dat+"<td>"+result[index].Hire_date+"</td>";
 	    		console.log(result[index].Company_id);   
 	    		dat=dat+"<td>"+result[index].Company_id+"</td>"; 	    		
 	    		dat=dat+"<td>"+result[index].Company_Name+"</td>";
 	    		dat=dat+"<td><button type=\"button\" id="+result[index].EmpNo +" onclick=\"deletee(this)\">Delete</button></td>"
 	    		//dat=dat+"<td><button type=\"button\" id=\"button\">Delete</button></td>"
 	    		dat=dat+"</tr>"	    		
 	      });
 	    	dat=dat+"</table>"
 	    	document.getElementById("span").innerHTML=dat;
 	      },
		error:function(data,status,er) {
			alert('error occurred');
			console.log(data);
			console.log("Status: "+status+" er:"+er);
		  }
	});
});	

	
});