$(document).ready(function(){
	$("#comp").on('click', function () {
	//alert("workingCOMP");	
    $.ajax({	        	
    	  type : 'GET',
    	  //dataType: 'json',	              
          contentType: 'application/json',	              
          url: 'CompanyRetrive',	              
 	      success: function(result){
 	    	 //alert(result[0].EmpNo); 
 	    	 var dat="<table border=1 id=customers>"
 	    	 dat=dat+"<tr><th>Company Name</th><th>Address</th><th>Number</th><th>Type</th></tr>"
 	    	 //console.log=result.Employee[0];    	 	    	 
 	    	$.each(result, function(index) { 	    		
 	    		console.log(result[index].Company_id); 	    		
 	    		//dat=dat+"<tr><td>"+result[index].Company_id+"</td>";
 	    		console.log(result[index].Company_Name);
 	    		dat=dat+"<tr id="+result[index].Company_id+"><td id=\"cname"+result[index].Company_id+"\">"+result[index].Company_Name+"</td>";
 	    		console.log(result[index].Company_Address);
 	    		dat=dat+"<td id=\"cadd"+result[index].Company_id+"\">"+result[index].Company_Address+"</td>";
 	    		console.log(result[index].Company_Contact_No);
 	    		dat=dat+"<td id=\"contno"+result[index].Company_id+"\">"+result[index].Company_Contact_No+"</td>";
 	    		console.log(result[index].Type); 	    		
 	    		dat=dat+"<td id=\"type"+result[index].Company_id+"\">"+result[index].Type+"</td>";
 	    		dat=dat+"<td><button type=\"button\" id="+result[index].Company_id+" onclick=\"deleteecomp(this)\">Delete</button></td>"
 	    		dat=dat+"<td><button type=\"button\" id=edit"+result[index].Company_id+" onclick=\"editable("+result[index].Company_id+")\">Edit</button></td>"
 	    		dat=dat+"</tr>"	    		
 	      });
 	    	dat=dat+"</table>"
 	    	dat=dat+"<button type=\"button\" id\"createcomp\" onclick=\"createcompany()\">Add Company</button>"
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