import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  
class file1 {  
	public static void main(String args[])  
	{  
		String initialData = "{\r\n"
				+ "	\"SubmissionData\": {\r\n"
				+ "		\"name\": \"SubmissionData\",\r\n"
				+ "		\"dataType\": \"Obejct\",\r\n"
				+ "		\"Properties\": {";
		System.out.println(initialData);
		try  
		{  
			File file=new File("C:\\Users\\91814\\eclipse-workspace2\\Json\\src\\Demo.txt");    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;
			List<String> list = new ArrayList<String>();
			List<String> list3 = new ArrayList<String>();

			while((line=br.readLine())!=null)  
			{  
				list.add(line);

				sb.append(line);      //appends line to string buffer  
				sb.append("\n");     //line feed   
			}  
			fr.close();

			for (String string : list) {
				string = string.trim();
				list3.add(string);
			}
			for (String string : list3) {

				//if(string.equals("{") || string.equals("[")|| string.equals("]")|| string.equals("}"))
				if(string.equals("[")|| string.equals("]")|| string.equals("}"))
				{
					if(string.equals("]"))
					{
						string="}";
						System.out.println(string);
					}
					System.out.print(string);
				}
				else {
					String[] splited = string.split(":");
					for (int i = 0; i < splited.length; i++) {
						String string2 = splited[i];
						String value = null;
						if(i==0)
						{
							//if(string2!="{"||string2!="}"||string2!="["||string2!="]"||
							//		string2!="\"{\""||string2!="\"}\""||string2!="\"[\"" || string2!="\"]\""||!string2.equals("},"))
							//{
							if(!string2.equals("},") && !string2.equals("{")) 
							{
								String doubleCoteRemovedString = string2.replaceAll("\"", "");
								value =  "\"" + doubleCoteRemovedString+ "\""+":" +"{\n" + "\"" +"name" + "\"" +":"+"\""+ doubleCoteRemovedString +"\""+",";
								System.out.println(value);
							}
							else if (string2.equals("},") ) {
								value =  ",";
								System.out.println(value);
							}
							else {
								break;
							}
						}
						else {
							if(!string2.contains("\""))
							{
								string2= string2.trim();
								if(string2.contains("true")||string2.contains("True") || string2.contains("TRUE")) {
									if(string2.equals("true,")||string2.equals("True,")||string2.equals("TRUE,"))
										System.out.println("\""+"dataType"+"\":"+"\""+"True"+"\""+"\n},");
									else {
										System.out.println("\""+"dataType"+"\":"+"\""+"True"+"\""+"\n}");
									}
								}
								else if(string2.contains("false")||string2.contains("False")||string2.contains("FASLE")) {
									if(string2.equals("false,")||string2.equals("False,")||string2.equals("FALSE,"))
										System.out.println("\""+"dataType"+"\":"+"\""+"False"+"\""+"\n},");
									else {
										System.out.println("\""+"dataType"+"\":"+"\""+"False"+"\""+"\n}");
									}
								}
								else if(string2.equals("[{")) {
									String s="\"properties\":{";
									System.out.println("\""+"dataType"+"\":"+"\""+"Array"+"\",\n"+s);
								}
								else if(string2.equals("},")) {
									System.out.println(",");
								}
								else if(string2.equals("{")) {
									String s="\"properties\":{";
									System.out.println("\""+"dataType"+"\":"+"\""+"Object"+"\","+"\n"+s);

								}
								else {
									if(string2.contains(","))
										System.out.println("\""+"dataType"+"\":"+"\""+"Number"+"\""+"\n},");
									else {
										System.out.println("\""+"dataType"+"\":"+"\""+"Number"+"\""+"\n}");

									}
								}
							}
							else if (!string2.contains(",")) {
								System.out.print("\""+"dataType"+"\":"+"\""+"Text"+"\""+"\n}");
							}
							else {
								System.out.println("\""+"dataType"+"\":"+"\""+"Text"+"\""+"\n},");
							}
						}
					}


				}
			}
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  
		System.out.println("}}");
	} 
}