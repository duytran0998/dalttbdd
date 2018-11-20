<?php

	header('Content-Type: application/json');
	include("../apiqlsv/lib/data.php");
	include("../apiqlsv/lib/dbconn.php");
		
		
		$db = new databaseqlsv("");
		$sql ="SELECT * FROM studentscore";
	   
		if(isset($_POST['idStudent'])){
			$idStudent = $_POST['idStudent'];
		

		class studentscore{
			function studentscore($idStudent,$subjectName,$Score){
				$this->idStudent = $idStudent;
				$this->subjectName = $subjectName;
				$this->Score = $Score;
			}
		}
		$retval = $db->select($sql);
		$arrScore = array();
		if(! $retval )
	   {
	      die('Không thể lấy dữ liệu: ' . mysql_error());
	   }
		while($data = mysqli_fetch_array($retval)){
			$idSubject = $data['idSubject'];
			 
		    $sql2 = "SELECT * FROM subject Where idSubject=$idSubject";
		    $result=$db->select($sql2);
			while ($subject = mysqli_fetch_array($result)) {
				
				 array_push($arrScore,new studentscore($data['idStudent'],$subject['subjectName'],$data['Score']));
				
		}

			   
			
			
		}
		 echo json_encode($arrScore);
	}


?>