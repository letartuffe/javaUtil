/**
 * 
 */
package javaUtil.url;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author green
 *
 */
public class URLUtil {
	
	/**
	 * return Map(parameters of GET request)   
	 * @param query URL string include ?
	 * @return Map<String, String> 
	 */
	public static Map<String, String> getQueryMap(String query) {  

	    Map<String, String> map = new HashMap<String, String>(); 

	    String name = "";
		String value = "";
		
		
		Pattern paramPattern = Pattern.compile("[^&?]*?=[^&?]*" ); 
		Matcher mc = paramPattern.matcher(query);
		
			
		while (mc.find()){
			
			name = mc.group().split("=")[0] ;
			
			
			try{
				value = mc.group().split("=")[1] ;
			}catch(ArrayIndexOutOfBoundsException e){ //if don't have value...
				value = "";
			}
			
	        map.put(name, value);  
		}
		
	    return map;  
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/product.do?AAAA_CD=&DDD_CD=HS123123GE&KEY=&REFERER=http%3A%2F%2Flocalhost%3A9904%2Fyuddds.do%3Fcmd%3DgetAAAAAAAMain%26CAT_GB%3D10000%26menuid%3D10103&tempKey=CAT_GB%3D10000%26TCAT_CD%3D10000%26MAA_CD%3D%26S7T_CD%3D%26DC88T_CD%3D%26JODWRDDG%3DB%26VSDFGRE%3D%26CADFGRPE%3DS%26KEY%3D%26CURDFG_AGE%3D1%26LINE_NUMBERS%3D36%26KIDSI_YN%3D%26TGGG_CD%3D%26FFF_YN%3D%26CAT_M_SELECT%3D%26ORDFLAG_SELECT%3DB%26INDEX%3D2%26type%3DCAT&MDFCAT_CD=&CWEE_TYPE=S&TCAT_CD=10000&DCAT_CD=&LINKSITE_CD=&type=CAT&SCAT_CD=&VIEW_MODE=&menuid=30100&CAT_GB=10000&MEM_CLASS_CD=&LINE_NUMBERS=36&CURRENT_PAGE=1&mode=1&LGF_YN=&CAT_M_SELECT=&ORDFLAG_SELECT=B&KIDSI_YN=&cmd=getProductDetailCore&cmd=getProductDetail&MEMID=&DFDR=&INDEX=2&GGGFR=&RRR_ID=FDOomu9MtYlUlQ2ccJxrehCDiyaCbJuha1GmaOXfXoAei3aeSeZ0XRLG8HUjiQaW&FEQKKY=B";
		
		String reffer = getQueryMap(url).get("REFERER");
		System.out.println(reffer);
	}

}
