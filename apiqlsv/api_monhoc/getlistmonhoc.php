<?php
include("../lib/dbconn.php");
  $db = new databaseqlsv("");
  class subject{
	  function subject($idSubject,$subjectName,$numberCredit){
		  $this->idSubject=$idSubject;
		  $this->subjectName=$subjectName;
		  $this->numberCredit=$numberCredit;
		  }
	  }
  $arrSubject=array();
  while($data=mysqli_fetch_array($db->select("SELECT * FROM subject"))){
	  array_push($arrSubject,new subject($data['idSubject'],$data['subjectName'],$data['numberCredit'])); 
	  }
  echo json_encode($arrSubject);
 
 
?>