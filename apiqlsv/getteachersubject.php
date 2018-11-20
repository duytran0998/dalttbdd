<?php
header('Content-Type: application/json');
include("../apiqlsv/lib/data.php");
include("../apiqlsv/lib/dbconn.php");


/**
 * 
 */class Subject{
      function Subject($idTeacher,$subjectID,$subjectName,$note){
            $this->idTeacher=$idTeacher;
            $this->idSubject=$subjectID;
            $this->subjectName=$subjectName;
            $this->note=$note;
          
      }
 }
if (isset($_POST["idTeacher"])) {
  
    $idTeacher = $_POST["idTeacher"];
    $sql = "SELECT * FROM subjectteacher  WHERE idTeacher='$idTeacher'";
    // ket noi database
    $dbconnection = new databaseqlsv("");
    $result = $dbconnection->select($sql);
        if($result!==null){
          $arraySubject=array();
            $idSubjcet=0;
          //add element to arrUser
            while ($row=mysqli_fetch_assoc($result)) 
                 {
                     ///get subject name
                     $idSubject= $row['idSubject'];
                    
                     $sql_get_subjcet_name="SELECT * FROM subject WHERE idSubject='$idSubject'";
                     $res= $dbconnection->select($sql_get_subjcet_name);

                     $subjectname=null;
                     while($subj=mysqli_fetch_array($res))
                     {
                      $subjectname= $subj['subjectName'];
                         
                     }
                     ///
                     array_push($arraySubject, 
                                new Subject(
                                            $row['idTeacher'],
                                            $row['idSubject'],
                                            $subjectname,
                                            $row['note'])
                              );
                 }
                      
    // Chuyen dinh dang cua mang thanh JSON
           echo json_encode($arraySubject);

        }
        else{
          
        }
  }
   
?>

