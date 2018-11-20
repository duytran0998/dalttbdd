<?php
header('Content-Type: application/json');
	include("../apiqlsv/lib/dbconn.php");

	include("../apiqlsv/lib/data.php");
	$db = new databaseqlsv("");
	$idStudent = $_POST['idStudent'];
	$oldPW = $_POST['oldPW'];
	$newPW = $_POST['newPW'];
	if(isset($idStudent) && isset($oldPW) && isset($newPW)){
		$res=null;
	$sql = "SELECT * FROM student WHERE passWord = '$oldPW' and idStudent = '$idStudent'";

	$retval = $db->select($sql);
	
	if(mysqli_num_rows($retval)>0)
	{
	/* while($data = mysqli_fetch_array($retval){
		$data->passWord=
		break;
	  }*/
	  $sql_change_pass = "UPDATE student set passWord = '$newPW' WHERE idStudent = '$idStudent'";
	  $update = $db->execute($sql_change_pass);
	  if($update!==null){
	  	$res=new Result(Constant::SUCCESS,'Update success');
	  	$db->close();
	  }else{
	  	  $res= new Result(Constant::GENERAL_ERROR, 'There was an error while processing request. Please try again later.');
	  }

	  
	}
	else{
       
         $res= new Result(Constant::INVALID_PASSWORD, 'Password is wrong');
	    }
}
	
	
	echo json_encode($res);

?>