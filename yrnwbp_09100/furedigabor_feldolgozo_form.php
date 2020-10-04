<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	 
</head>
<style>
	.slider {
  
  width: 40%;
  height: 15px;
  border-radius: 5px;  
  background: #d3d3d3;
  outline: none;
  opacity: 0.7;
  -webkit-transition: .2s;
  transition: opacity .2s;
}
.texter {

	font-size: 20px;
	font-weight: bold;
	 font-family: sans-serif;
}
.buttons{
	font-size: 20px;
	 font-family: sans-serif;
}
</style>
<body>

<?php
 echo "<label class=\"texter\">Név: </label>", $_POST["name"],"<br>";
 echo "<label class=\"texter\">PIN kód: </label>", $_POST["pinid"],"<br>" ;
 echo "<label class=\"texter\">Kedvenc Gyümölcs: </label>", $_POST["favfruit"],"<br>" ;
 echo "<label class=\"texter\">Életkor: </label>", $_POST["age"],"<br>" ;
 echo "<label class=\"texter\">Lábméret: </label>", $_POST["footsize"],"<br>" ;
 echo "<label class=\"texter\">Önbizalom: </label>", $_POST["selfconfidence"],"<br>","<br>";"<br>";"<br>" ;
?>
<form action="./furedigabor_form.html"method="post">
<input type="submit" name="back"  value="Vissza">
</form>
</body>
</html>

