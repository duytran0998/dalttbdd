

<?php
header('Content-Type: application/json');
include("../apiqlsv/lib/data.php");
include("../apiqlsv/lib/dbconn.php");


/**
 * 
 */class TeacherClass{
      function TeacherClass($idClass,$idTeacher,$subject,$classname,$note){
            $this->idClass=$idClass;
            $this->idTeacher=$idTeacher;
            $this->idSubject=$subject;
            $this->className=$classname;
            $this->note=$note;
       
      }
 }
if (isset($_POST["idSubject"])&&isset($_POST['idTeacher'])) {
  
   
    $idTeacher   =$_POST["idTeacher"];
    $idSubject   =$_POST["idSubject"];
    $sql = "SELECT * FROM class_subject_teacher WHERE idTeacher='$idTeacher' AND idSubject='$idSubject'";
    // ket noi database
    $dbconnection = new databaseqlsv("");
    $result = $dbconnection->select($sql);
        if($result!==null){
          $array=array();
          //add element to arrUser
            while ($row=mysqli_fetch_assoc($result)) 
                 {

                   $idClass= $row['idClass'];
                    
                     $sql_get_class_name="SELECT * FROM class WHERE idClass='$idClass'";
                     $res= $dbconnection->select($sql_get_class_name);

                   
                     while($subj=mysqli_fetch_array($res))
                     {
                      $name_class= $subj['className'];
                         
                     }
                     array_push($array, new TeacherClass(
                                                         $row['idClass'],
                                                         $row['idTeacher'],
                                                         $row['idSubject'],
                                                         $name_class,
                                                         $row['note']));
                 }
                      
    // Chuyen dinh dang cua mang thanh JSON
           echo json_encode($array);

        }
        else{
          
        }
  }
   
?>