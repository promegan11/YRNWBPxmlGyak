Êþº¾   :   javagyak/DomYRNWBP  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Ljavagyak/DomYRNWBP; main ([Ljava/lang/String;)V
    (javax/xml/parsers/DocumentBuilderFactory   newInstance ,()Ljavax/xml/parsers/DocumentBuilderFactory;
     newDocumentBuilder %()Ljavax/xml/parsers/DocumentBuilder;  java/io/File  *\Git/YRNWBPxmlGyak/YRNWBPxml/szemelyek.xml
      (Ljava/lang/String;)V
 " $ # !javax/xml/parsers/DocumentBuilder % & parse &(Ljava/io/File;)Lorg/w3c/dom/Document; ( * ) org/w3c/dom/Document + , getDocumentElement ()Lorg/w3c/dom/Element; . 0 / org/w3c/dom/Element 1  	normalize	 3 5 4 java/lang/System 6 7 out Ljava/io/PrintStream; 9 java/lang/StringBuilder ; GyÃ¶kÃ©r elem: 
 8  . > ? @ getNodeName ()Ljava/lang/String;
 8 B C D append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 8 F G @ toString
 I K J java/io/PrintStream L   println N szemely . P Q R getElementsByTagName *(Ljava/lang/String;)Lorg/w3c/dom/NodeList; T V U org/w3c/dom/NodeList W X item (I)Lorg/w3c/dom/Node; Z \ [ org/w3c/dom/Node ] ^ getNodeType ()S ` id . b c d getAttribute &(Ljava/lang/String;)Ljava/lang/String; f id:  h    Z j k l getChildNodes ()Lorg/w3c/dom/NodeList; Z > o :  Z q r @ getTextContent T t u v 	getLength ()I
 x z y java/lang/Exception {  printStackTrace } .javax/xml/parsers/ParserConfigurationException  org/xml/sax/SAXException  java/io/IOException args [Ljava/lang/String; documentBuilderFactory *Ljavax/xml/parsers/DocumentBuilderFactory; documentBuilder #Ljavax/xml/parsers/DocumentBuilder; document Lorg/w3c/dom/Document; rootElement Lorg/w3c/dom/Element; 
childNodes Lorg/w3c/dom/NodeList; i I node Lorg/w3c/dom/Node; element Ljava/lang/String; j e Ljava/lang/Exception; StackMapTable   java/lang/String 
SourceFile DomYRNWBP.java !               /     *· ±    
                    	      y    ¸ L+¶ M,» Y· ¶ !N-¹ ' ¹ - -¹ ' :² 2» 8Y:· <¹ = ¶ A¶ E¶ HM¹ O :6§ ¢¹ S :¹ Y   À .:_¹ a :	² 2» 8Ye· <	¶ A¶ E¶ H6
§ I² 2» 8Yg· <¹ i 
¹ S ¹ m ¶ An¶ A¹ i 
¹ S ¹ p ¶ A¶ E¶ H

¹ i ¹ s ¡ÿ¬¹ s ¡ÿX§ L+¶ w±    |   ~     
   R       	    "  *  F  Q  W  b  m  t     !  # ß ! ó  ( )
 +    z         þ    	 ù     ë    * Ø    Q ±    T ®    b     t      t `  	  Z   
        l ÿ W    " ( . T  ÿ D    " ( . T Z .   û Eÿ     " ( . T  ÿ     x      