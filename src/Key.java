

/**----------------------------------------------------------------------------------------------------
 * Purpose:				Key class stores key file to score the test. A key has the following instance
 * 						variables: item number (e.g. i1-i92), key, domain Key file item order should
 * 						be the same as the item order in the response file
 * 
 * @author 				axie
 *
 * 	Revised 11/2/2019	TJT
 * 	Modification:		Formatting & Descriptions
 *
 ----------------------------------------------------------------------------------------------------**/

public class Key {
	
	private String item;
	private String key;
	private String domain;

	/**------------------------------------------------------------------------
	 * Purpose:				Key constructor
	 * 
	 * @param item			Item, String
	 * @param key			Key, String
	 * @param domain		Domain, String
	 ------------------------------------------------------------------------**/
	public Key(String item, String key, String domain) {
		this.item = item;
		this.key = key;
		this.domain = domain;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getItem
	 * @return			Item
	 ------------------------------------------------------------------------**/
	public String getItem() {
		return item;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getKey
	 * @return			Key
	 ------------------------------------------------------------------------**/
	public String getKey() {
		return key;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getDomain
	 * 
	 * @return			Domain
	 ------------------------------------------------------------------------**/
	public String getDomain() {
		return domain;
	}

	
	@Override
	public String toString() {
		return "Key [item=" + item + ", key=" + key + ", domain=" + domain + "]";
	}

}
