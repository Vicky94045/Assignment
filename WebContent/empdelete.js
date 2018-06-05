function deletee(obj) {
	//alert(obj.id)
	var id=obj.id;
	$.ajax({	        	
  	  type : 'GET',
  	  //dataType: 'json',	 
  	  	data: { ide: id} ,
        contentType: 'application/json',	              
        url: 'DeleteEmployee',	              
	      success: function(result){
	    	  alert("Record deleted");
	    	  $("tr").remove("#"+id);
	    	  document.getElementById(id).style.display = 'none';	    	  
	    	  console.log(result);	    	  
	      },
		error:function(data,status,er) {
			alert('error occurred');
			console.log(data);
			console.log("Status: "+status+" er:"+er);
		  }
	});
}