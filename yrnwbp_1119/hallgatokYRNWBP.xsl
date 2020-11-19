<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	  <html>
	  <body>
	    <h2>Hallgatok</h2>
	    <table border="1">
	      <tr bgcolor="#9acd32">
	        <th>Vezetek</th>
	        <th>Keresztnev</th>
	        <th>Becenev</th>
	        <th>Fizetes</th>
	      </tr>
	      <xsl:for-each select="osztaly/alkalmazott">
	        <tr>
	          <td><xsl:value-of select="vezeteknev"/></td>
	          <td><xsl:value-of select="keresztnev"/></td>
	          <td><xsl:value-of select="becenev"/></td>
	          <td><xsl:value-of select="fizetes"/></td>
	        </tr>
	      </xsl:for-each>
	    </table>
	    <xsl:for-each select="osztaly/alkalmazott">
	       <h3>
		        <br>
		         <br> Vezeteknev: <xsl:value-of select="vezeteknev"/></br>
		         <br> Keresztnev: <xsl:value-of select="keresztnev"/></br>
		         <br> Bevcenev: <xsl:value-of select="becenev"/></br>
		         <br> Fizetesek: <xsl:value-of select="fizetes"/></br>
		        </br>
	        </h3>
	      </xsl:for-each>
	    
	  </body>
	  </html>		
	</xsl:template>
</xsl:stylesheet>