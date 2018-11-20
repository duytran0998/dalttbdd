

<?php
header('Content-Type: application/json');
include("../apiqlsv/lib/data.php");
include("../apiqlsv/lib/dbconn.php");
$res=null;

/**
 * 
 */
if (isset($_POST['idStudent'])&&isset($_POST['idSubject'])&&isset($_POST['score'])) {
  
   
    $idStudent   =$_POST["idStudent"];
    $idSubject   =$_POST["idSubject"];
    $score       =$_POST["score"];
    $sql = "INSERT INTO studentscore VALUES ('$idStudent', '$idSubject', '$score')";
    // ket noi database
    $dbconnection = new databaseqlsv("");
    $result = $dbconnection->execute($sql);
    
        if($result!==null){
            $res=new Result(0,"sccuess");

           }    
        else{
            $res=new Result(-2,"Error excute");

          }  
           echo json_encode($res);

  }
   
?>