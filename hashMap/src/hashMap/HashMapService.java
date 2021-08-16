package hashMap;

public class HashMapService {
	
	
	
	
	String[] key;
	String[] value;
		
	String[] tempKey;
	String[] tempValue;
		
	
	public HashMapService() {
	key= new String[0];
	value= new String[0];
	}
	
	
	
	
	public void add(String keys , String values) {
		tempKey = key;
		tempValue = value;
		

		key=new String[tempKey.length+1];
		value=new String[tempKey.length+1];
		
	
		for(int i=0;i<tempKey.length;i++) {
			tempKey[i]=key[i];
			tempValue[i]=value[i];
		}
		
		key[key.length-1]=keys;
		value[value.length-1]=values;
		System.out.println("Eklendi");	
		
	}
	
	public String[] getKnowledge() {
		
		String[] list = new String[key.length];
		for(int i=0;i<key.length;i++) {
		list[i] =	key[i]+  "=" + value[i];
		System.out.println("Key="+key[i]+"Value="+value[i]);
		}
		return list;
		
	}
	
	
	
	
	


}