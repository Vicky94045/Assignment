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
 	    	 dat=dat+"<tr><th>Emp No</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Email Id</th><th>Address</th><th>Birthday</th><th>Salary</th><th>Gender</th><th>Mobile No</th><th>Hire Date</th><th>company Name</th></tr>"
 	    	 //console.log=result.Employee[0];    	 	    	 
 	    	 $.each(result, function(index) { 	    		
 	    		console.log(result[index].EmpNo); 	    		
 	    		dat=dat+"<tr id="+result[index].EmpNo+"><td id=\"eno"+result[index].EmpNo+"\">"+result[index].EmpNo+"</td>";
 	    		console.log(result[index].First_Name);
 	    		dat=dat+"<td id=\"efname"+result[index].EmpNo+"\">"+result[index].First_Name+"</td>";
 	    		console.log(result[index].Last_Name);
 	    		dat=dat+"<td id=\"elname"+result[index].EmpNo+"\">"+result[index].Last_Name+"</td>";
 	    		console.log(result[index].Age);
 	    		dat=dat+"<td id=\"eage"+result[index].EmpNo+"\">"+result[index].Age+"</td>";
 	    		console.log(result[index].mailId);
 	    		dat=dat+"<td id=\"email"+result[index].EmpNo+"\">"+result[index].mailId+"</td>";
 	    		console.log(result[index].Address);
 	    		dat=dat+"<td id=\"eaddr"+result[index].EmpNo+"\">"+result[index].Address+"</td>";
 	    		console.log(result[index].Birthdate);
 	    		dat=dat+"<td id=\"ebdate"+result[index].EmpNo+"\">"+result[index].Birthdate+"</td>";
 	    		console.log(result[index].Salary);
 	    		dat=dat+"<td id=\"esal"+result[index].EmpNo+"\">"+result[index].Salary+"</td>";
 	    		console.log(result[index].Gender);
 	    		dat=dat+"<td id=\"egender"+result[index].EmpNo+"\">"+result[index].Gender+"</td>";
 	    		console.log(result[index].Mobile_No);
 	    		dat=dat+"<td id=\"emob"+result[index].EmpNo+"\">"+result[index].Mobile_No+"</td>";
 	    		console.log(result[index].Hire_date);
 	    		dat=dat+"<td id=\"ehdate"+result[index].EmpNo+"\">"+result[index].Hire_date+"</td>";
 	    		console.log(result[index].Company_id);   
 	    		//dat=dat+"<td>"+result[index].Company_id+"</td>"; 	    		
 	    		dat=dat+"<td id=\"ecname"+result[index].EmpNo+"\">"+result[index].Company_Name+"</td>";
 	    		dat=dat+"<td><button type=\"button\" id="+result[index].EmpNo +" onclick=\"deletee(this)\">Delete</button></td>"
 	    		dat=dat+"<td><button type=\"button\" id=edit"+result[index].EmpNo+" onclick=\"editableemp("+result[index].EmpNo+")\">Edit</button></td>" 	    		
 	    		dat=dat+"</tr>"    		
 	      });
 	    	dat=dat+"</table>"
 	    	dat=dat+"<button type=\"button\" id\"createemp\" onclick=\"createemp()\">Add Employee</button>"
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