package ar.com.jgt.dto;

public class IpAddressDTO {
	
	String ipv4 = "";
	String ipv6 = "";
	
	public IpAddressDTO(){		
	}
	public IpAddressDTO(String ipv4, String ipv6){
		this.ipv4 = ipv4;
		this.ipv6 = ipv6;
	}
	public String getIpv4() {
		return ipv4;
	}
	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}
	public String getIpv6() {
		return ipv6;
	}
	public void setIpv6(String ipv6) {
		this.ipv6 = ipv6;
	}
}
