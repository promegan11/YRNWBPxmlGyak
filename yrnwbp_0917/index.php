<!DOCTYPE html>
<html>
<style>
table,th,td {
  border : 2px solid black;
  border-collapse: collapse;
}
th,td {
  padding: 5px;
}
</style>
<body>
<table id="MainTable">
	<tbody id="BodyRows"></tbody>
</table>

<script>
  window.addEventListener("load", function() {
			getRows();
		});

		function getRows() {
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("get", "FurediGabor_orarend.xml", true);
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					showResult(this);
				}
			};
			xmlhttp.send(null);
		}

		function showResult(xmlhttp) {
			var xmlDoc = xmlhttp.responseXML.documentElement;
			removeWhitespace(xmlDoc);
			var outputResult = document.getElementById("BodyRows");
			var rowData = xmlDoc.getElementsByTagName("ora");

			addTableRowsFromXmlDoc(rowData,outputResult);
			var theTable = outputResult.parentNode;
			newRow = outputResult.insertRow(0);
			newRow.className = (5%2) ? "OddRow" : "EvenRow";
			newCell = newRow.insertCell(newRow.cells.length);
			newCell.innerHTML = "Tárgy";
			theTable.appendChild(outputResult);
			newCell = newRow.insertCell(newRow.cells.length);
			newCell.innerHTML = "Időpont";
			theTable.appendChild(outputResult);
			newCell = newRow.insertCell(newRow.cells.length);
			newCell.innerHTML = "Helyszín";
			theTable.appendChild(outputResult);
			newCell = newRow.insertCell(newRow.cells.length);
			newCell.innerHTML = "Oktató";
			theTable.appendChild(outputResult);
			newCell = newRow.insertCell(newRow.cells.length);
			newCell.innerHTML = "Szak";
			theTable.appendChild(outputResult);
		}

		function addTableRowsFromXmlDoc(xmlNodes,tableNode) {
			var theTable = tableNode.parentNode;
			var newRow, newCell, i;
			console.log ("Number of nodes: " + xmlNodes.length);
			
			for (i=0; i<xmlNodes.length; i++) {
				newRow = tableNode.insertRow(i);
				newRow.className = (i%2) ? "OddRow" : "EvenRow";

				for (j=0; j<xmlNodes[i].childNodes.length; j++) {
					newCell = newRow.insertCell(newRow.cells.length);
					if (xmlNodes[i].childNodes[j].firstChild) {
						newCell.innerHTML = xmlNodes[i].childNodes[j].firstChild.nodeValue;
						
						
						
						if(xmlNodes[i].childNodes[j].childNodes.length==3)		
						{
							var xmlsub = xmlNodes[i].childNodes[j] ;
							
							var rowstring=xmlsub.childNodes[0].firstChild.nodeValue +": ";
							console.log(xmlsub.childNodes.length);
							
							for (k=1; k<xmlsub.childNodes.length; k++) {
								if (xmlsub.childNodes[k]) {
									if(k!=xmlsub.childNodes.length-1){
										rowstring += xmlsub.childNodes[k].firstChild.nodeValue+"-";
									}else{
										rowstring += xmlsub.childNodes[k].firstChild.nodeValue;
									}
									console.log(xmlsub.childNodes[k].firstChild.nodeValue);
								} else {
									newCell.innerHTML = "-";
								}
								newCell.innerHTML = rowstring;
							}
						}
					}
					else {
					 	newCell.innerHTML = "-";
					}
							console.log("cell: " + newCell);

				}
			}

				theTable.appendChild(tableNode);
		}

		function removeWhitespace(xml) {
			var loopIndex;
			for (loopIndex = 0; loopIndex < xml.childNodes.length; loopIndex++)
			{
				var currentNode = xml.childNodes[loopIndex];
				if (currentNode.nodeType == 1)
				{
					removeWhitespace(currentNode);
				}
				if (!(/\S/.test(currentNode.nodeValue)) && (currentNode.nodeType == 3))
				{
					xml.removeChild(xml.childNodes[loopIndex--]);
				}
			}
		}

</script>

</body>
</html>