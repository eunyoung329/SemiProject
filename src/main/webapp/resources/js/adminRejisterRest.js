//카테고리선택 none


function AdminValidateForm(){
 var formData=new FormData();
 formData.append('rest_category', $('#rest_category option:selected').val());
 formData.append('rest_name', $('#rest_name').val());
 formData.append('rest_img', $('#rest_img').prop('files')[0]); formData.append('rest_x', $('#rest_x').val());
 formData.append('rest_y', $('#rest_y').val());
 formData.append('rest_tel', $('#rest_tel').val());
formData.append('rest_time', $('#rest_time').val());
formData.append('rest_sns', $('#rest_sns').val());
formData.append('rest_Addr', $('#rest_Addr').val());
formData.append('rest_contents', $('#rest_contents').val());


 $.ajax ({
  url:"adminRegisterRest",
  type:"post",
  data:formData,
  processData:false,
  contentType:false,
  success: function(result){
  console.log(result);
  if(result==0){ 
    console.log("등록 실패");


  }else {
    return true;
  }
},error:function(result){
  console.log(result);
}
 });



  }



