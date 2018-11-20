

<?php
header('Content-Type: application/json');
include("../apiqlsv/lib/data.php");
include("../apiqlsv/lib/dbconn.php");


/**
 * 
 */class Student{
      function Student($idStudent,$nameStudent,$score){
            $this->idStudent=$idStudent;
            $this->nameStudent=$nameStudent;
            $this->score=$score;
       
      }
 }
if (isset($_POST['idClass'])&&isset($_POST['idSubject'])) {
  
   
    $idClass   =$_POST["idClass"];
    $idSubject=$_POST['idSubject'];
    $sql = "SELECT * FROM student WHERE idClass='$idClass'";
    // ket noi database
    $dbconnection = new databaseqlsv("");
    $result = $dbconnection->select($sql);
        if($result!==null){
          $array=array();
          //add element to arrUser
            while ($row=mysqli_fetch_assoc($result)) 
                 {

                  
                     $idStudent= $row['idStudent'];
                     $sql_score="SELECT * FROM studentscore where idStudent='$idStudent' AND idSubject='$idSubject'";
                     $res= $dbconnection->select($sql_score);
                     $score=0;
                     while($subj=mysqli_fetch_array($res))
                     {
                      $score= $subj['Score'];
                         
                     }
                     array_push($array, new Student(
                                                         $row['idStudent'],
                                                         $row['studentName'],
                                                         $score));
                 }
                      
    // Chuyen dinh dang cua mang thanh JSON
           echo json_encode($array);

        }
        else{
          
        }
  }
   
?>